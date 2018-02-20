package com.royken.teknik.web.beans;

import com.royken.teknik.entities.Bloc;
import com.royken.teknik.entities.Organes;
import com.royken.teknik.service.ITeknikService;
import com.royken.teknik.service.ServiceException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
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
@Named(value = "organeBean")
@RequestScoped
public class OrganeBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EJB
    private ITeknikService service;
    
    private List<Organes> organeses;
    
    private List<Bloc> blocs;
    
    private Organes organes = new Organes();
    
    private String id;

    /**
     * Creates a new instance of OrganeBean
     */
    public OrganeBean() {
    }

    public ITeknikService getService() {
        return service;
    }

    public void setService(ITeknikService service) {
        this.service = service;
    }

    public List<Organes> getOrganeses() {
        try {
            organeses = service.findAllOrganes();
            return organeses;
        } catch (Exception e) {
        }
        return Collections.EMPTY_LIST;
    }

    public void setOrganeses(List<Organes> organeses) {
        this.organeses = organeses;
    }

    public List<Bloc> getBlocs() {
        try {
            blocs = service.findAllBloc();
            return blocs;
        } catch (Exception e) {
        }
        return Collections.EMPTY_LIST;
    }

    public void setBlocs(List<Bloc> blocs) {
        this.blocs = blocs;
    }

    public Organes getOrganes() {
        return organes;
    }

    public void setOrganes(Organes organes) {
        this.organes = organes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void saveOrupdateOrgane(){
        if (organes != null && organes.getCode() != null) {
           
            
            try {
                organes.setBloc(service.findBlocById(Long.valueOf(id)));
                service.saveOrUpdateOrgane(organes);
                if (organes.getId() == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operation reussie", organes.getNom() + " a été mis à jour "));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operation reussie", organes.getNom()+ " a été enregistré"));
            }               
            } catch (NumberFormatException | ServiceException e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Echec de l'opération", "Veuillez reéssayer plus tard"));
            }
            
            organes = new Organes();
        }   
    }
    
    public void deleteOrgane() throws ServiceException{
        if (organes != null && organes.getId() != null) {
            try {
                service.deleteOrgane(organes.getId());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operation reussie", organes.getNom() + " a été supprimé"));
            } catch (Exception e) {
                
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Echec de l'opération", "Ene erreur est survenue"));
            }
            organes = new Organes();
        }
    }
    
     public void verifierEtUpdate(ActionEvent actionEvent) throws ServiceException {
        if (organes != null && organes.getId() != null) {
            RequestContext.getCurrentInstance().execute("PF('dlgUpdate').show()");
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Attention", "selectionner un bloc avant de modifier "));
        }
    }

    public void verifierEtSupprimer(ActionEvent actionEvent) throws ServiceException {
        if (organes != null && organes.getId() != null) {
            RequestContext.getCurrentInstance().execute("PF('confirmation').show()");
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Attention", "selectionner un bloc avant de supprimer "));
        }
    }
    
    
}
