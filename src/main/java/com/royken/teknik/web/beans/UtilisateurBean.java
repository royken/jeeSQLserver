package com.royken.teknik.web.beans;

import com.royken.teknik.entities.Utilisateurs;
import com.royken.teknik.service.ITeknikService;
import com.royken.teknik.service.ServiceException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Named(value = "utilisateurBean")
@RequestScoped
public class UtilisateurBean implements Serializable {

    @EJB
    private ITeknikService service;

    private List<Utilisateurs> utilisateurses;

    private Utilisateurs utilisateurs = new Utilisateurs();

    /**
     * Creates a new instance of UtilisateurBean
     */
    public UtilisateurBean() {
    }

    @PostConstruct
    public void init() {
        utilisateurs = new Utilisateurs();
    }

    public ITeknikService getService() {
        return service;
    }

    public void setService(ITeknikService service) {
        this.service = service;
    }

    public List<Utilisateurs> getUtilisateurses() {
        try {
            utilisateurses = service.getAllUtilisateurs();
            return utilisateurses;
        } catch (Exception e) {
        }
        return Collections.EMPTY_LIST;
    }

    public void setUtilisateurses(List<Utilisateurs> utilisateurses) {
        this.utilisateurses = utilisateurses;
    }

    public Utilisateurs getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(Utilisateurs utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public void saveOrUpdateUtilisateur() throws ServiceException {

        if (utilisateurs != null && utilisateurs.getLogin() != null) {
            try {
                service.saveOrUpdateUtilisateur(utilisateurs);
                if (utilisateurs.getId() == null) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operation reussie", utilisateurs.getNom() + " a été enregistré "));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Operation reussie", utilisateurs.getNom() + " a été mis à jour"));
                }
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Echec de l'opération", "Veuillez reéssayer plus tard"));
            }
            utilisateurs = new Utilisateurs();
        }
    }

    public void deleteUtilisateur() throws ServiceException {
        if (utilisateurs != null && utilisateurs.getId() != null) {
            try {
                service.deleteUtilisateur(utilisateurs.getId());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operation reussie", utilisateurs.getNom() + " a été supprimé"));
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Echec de l'opération", " Veuillez reéssayer plus tard"));
            }
            utilisateurs = new Utilisateurs();
        }
    }

    public void verifierEtUpdate(ActionEvent actionEvent) throws ServiceException {
        if (utilisateurs != null && utilisateurs.getId() != null) {
            RequestContext.getCurrentInstance().execute("PF('dlgUpdate').show()");
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Attention", "selectionner un secteur avant de modifier "));
        }
    }

    public void verifierEtSupprimer(ActionEvent actionEvent) throws ServiceException {
        if (utilisateurs != null && utilisateurs.getId() != null) {
            RequestContext.getCurrentInstance().execute("PF('confirmation').show()");
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Attention", "selectionner un secteur avant de supprimer "));
        }
    }

}
