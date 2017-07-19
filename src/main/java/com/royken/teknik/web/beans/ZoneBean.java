package com.royken.teknik.web.beans;

import com.royken.teknik.entities.Zone;
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
@Named(value = "zoneBean")
@SessionScoped
public class ZoneBean implements Serializable {

    @EJB
    private ITeknikService teknikService;

    private List<Zone> zones;

    private Zone zone = new Zone();

    /**
     * Creates a new instance of ZoneBean
     */
    public ZoneBean() {
    }

    public ITeknikService getTeknikService() {
        return teknikService;
    }

    public void setTeknikService(ITeknikService teknikService) {
        this.teknikService = teknikService;
    }

    public List<Zone> getZones() {
        try {
            zones = teknikService.getAllZones();
            return zones;
        } catch (Exception e) {
        }
        return Collections.EMPTY_LIST;
    }

    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public void saveOrUpdate() throws ServiceException{
        System.out.println("'Le secteur");
        System.out.println(zone);
        if (zone != null && zone.getCode() != null) {
            try {
                teknikService.saveOrUpdateZone(zone);
                if (zone.getId() == null) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operation reussie", zone.getNom() + " a été enregistré "));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Operation reussie", zone.getNom() + " a été mis à jour"));
                }
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Echec de l'opération",  "Veuillez reéssayer plus tard"));
            }

            zone = new Zone();
        }
    }
    
    public void deleteZOne() throws ServiceException {
        if (zone != null && zone.getId() != null) {
            try {
                teknikService.deleteZone(zone.getId());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Operation reussie", zone.getCode() + " a été supprimé"));
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Echec de l'opération",  " Veuillez reéssayer plus tard"));
            }
            
           zone = new Zone();
        }
    }
    
    public void verifierEtUpdate(ActionEvent actionEvent) throws ServiceException {
        if (zone != null && zone.getId() != null) {
            RequestContext.getCurrentInstance().execute("PF('dlgUpdate').show()");
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Attention", "selectionner un secteur avant de modifier "));
        }
    }

    public void verifierEtSupprimer(ActionEvent actionEvent) throws ServiceException {
        if (zone != null && zone.getId() != null) {
            RequestContext.getCurrentInstance().execute("PF('confirmation').show()");
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Attention", "selectionner un secteur avant de supprimer "));
        }
    }

}
