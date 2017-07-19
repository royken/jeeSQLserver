package com.royken.teknik.web.beans;

import com.royken.teknik.entities.Organes;
import com.royken.teknik.entities.SousOrganes;
import com.royken.teknik.service.ITeknikService;
import com.royken.teknik.service.ServiceException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Named(value = "sousOrganesBean")
@SessionScoped
public class SousOrganesBean implements Serializable {

    @EJB
    private ITeknikService service;
    
    private List<SousOrganes> sousOrganeses;
    
    private List<Organes> organeses;
    
    private SousOrganes sousOrganes = new SousOrganes();
    
    private String id;
    /**
     * Creates a new instance of SousOrganesBean
     */
    public SousOrganesBean() {
    }

    public ITeknikService getService() {
        return service;
    }

    public void setService(ITeknikService service) {
        this.service = service;
    }

    public List<SousOrganes> getSousOrganeses() {
        try {
            sousOrganeses = service.getAllSousOrganes();
            return sousOrganeses;
        } catch (Exception e) {
        }
        return Collections.EMPTY_LIST;
    }

    public void setSousOrganeses(List<SousOrganes> sousOrganeses) {
        this.sousOrganeses = sousOrganeses;
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

    public SousOrganes getSousOrganes() {
        return sousOrganes;
    }

    public void setSousOrganes(SousOrganes sousOrganes) {
        this.sousOrganes = sousOrganes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void saveOrupdateSousOrgane(){
        if (sousOrganes != null && sousOrganes.getCode() != null) {
           
            
            try {
                sousOrganes.setOrganes(service.findOrganeById(Long.valueOf(id)));
                service.saveOrUpdateSousOrgane(sousOrganes);
                if (sousOrganes.getId() == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operation reussie", sousOrganes.getNom() + " a été mis à jour "));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operation reussie", sousOrganes.getNom()+ " a été enregistré"));
            }               
            } catch (NumberFormatException | ServiceException e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Echec de l'opération", "Veuillez reéssayer plus tard"));
            }
            
            sousOrganes = new SousOrganes();
        }   
    }
    
    public void deleteSousOrgane() throws ServiceException{
        if (sousOrganes != null && sousOrganes.getId() != null) {
            try {
                service.deleteSousOrgane(sousOrganes.getId());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operation reussie", sousOrganes.getNom() + " a été supprimé"));
            } catch (Exception e) {
                
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Echec de l'opération", "Ene erreur est survenue"));
            }
            sousOrganes = new SousOrganes();
        }
    }
    
     public void verifierEtUpdate(ActionEvent actionEvent) throws ServiceException {
        if (sousOrganes != null && sousOrganes.getId() != null) {
            RequestContext.getCurrentInstance().execute("PF('dlgUpdate').show()");
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Attention", "selectionner un bloc avant de modifier "));
        }
    }

    public void verifierEtSupprimer(ActionEvent actionEvent) throws ServiceException {
        if (sousOrganes != null && sousOrganes.getId() != null) {
            RequestContext.getCurrentInstance().execute("PF('confirmation').show()");
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Attention", "selectionner un bloc avant de supprimer "));
        }
    }
    
    
    
}
