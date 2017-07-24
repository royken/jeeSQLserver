package com.royken.teknik.web.beans;

import com.royken.teknik.entities.Bloc;
import com.royken.teknik.entities.Zone;
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
@Named(value = "blocBean")
@RequestScoped
public class BlocBean implements Serializable {
    
    @EJB
    private ITeknikService teknikService;
    
    private Bloc bloc = new Bloc();
    
    private List<Bloc> blocs;
    
    private List<Zone> zones;
    
    private String id;

    /**
     * Creates a new instance of BlocBean
     */
    public BlocBean() {
    }

    public ITeknikService getTeknikService() {
        return teknikService;
    }

    public void setTeknikService(ITeknikService teknikService) {
        this.teknikService = teknikService;
    }

    public Bloc getBloc() {
        return bloc;
    }

    public void setBloc(Bloc bloc) {
        this.bloc = bloc;
    }

    public List<Bloc> getBlocs() {
        try {
            blocs = teknikService.findAllBloc();
            return blocs;
        } catch (Exception e) {
        }
        return Collections.EMPTY_LIST;
    }

    public void setBlocs(List<Bloc> blocs) {
        this.blocs = blocs;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void saveOrupdateBloc(){
        if (bloc != null && bloc.getCode() != null) {
           
            
            try {
                bloc.setZone(teknikService.findZoneById(Long.valueOf(id)));
                teknikService.saveOrUpdateBloc(bloc);
                if (bloc.getId() == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operation reussie", bloc.getNom() + " a été mis à jour "));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operation reussie", bloc.getNom()+ " a été enregistré"));
            }               
            } catch (NumberFormatException | ServiceException e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Echec de l'opération", "Veuillez reéssayer plus tard"));
            }
            
            bloc = new Bloc();
        }   
    }
    
    public void deleteBloc() throws ServiceException{
        if (bloc != null && bloc.getId() != null) {
            try {
                teknikService.deleteBloc(bloc.getId());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operation reussie", bloc.getNom() + " a été supprimé"));
            } catch (Exception e) {
                
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Echec de l'opération", "Ene erreur est survenue"));
            }
            bloc = new Bloc();
        }
    }
    
     public void verifierEtUpdate(ActionEvent actionEvent) throws ServiceException {
        if (bloc != null && bloc.getId() != null) {
            RequestContext.getCurrentInstance().execute("PF('dlgUpdate').show()");
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Attention", "selectionner un bloc avant de modifier "));
        }
    }

    public void verifierEtSupprimer(ActionEvent actionEvent) throws ServiceException {
        if (bloc != null && bloc.getId() != null) {
            RequestContext.getCurrentInstance().execute("PF('confirmation').show()");
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Attention", "selectionner un bloc avant de supprimer "));
        }
    }
    
    
    
}
