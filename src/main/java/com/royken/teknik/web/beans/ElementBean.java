package com.royken.teknik.web.beans;

import com.royken.teknik.entities.Elements;
import com.royken.teknik.entities.PeriodeType;
import com.royken.teknik.entities.SousOrganes;
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
@Named(value = "elementBean")
@RequestScoped
public class ElementBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private ITeknikService teknikService;
    
    private List<Elements> elementses;
    
    private List<SousOrganes> sousOrganeses;
    
    private Elements elements = new Elements();
    
    private String id;
    /**
     * Creates a new instance of ElementBean
     */
    public ElementBean() {
    }

    public ITeknikService getTeknikService() {
        return teknikService;
    }

    public void setTeknikService(ITeknikService teknikService) {
        this.teknikService = teknikService;
    }

    public List<Elements> getElementses() {
        try {
            elementses = teknikService.findAllElement();
            return elementses;
        } catch (Exception e) {
        }
        return Collections.EMPTY_LIST;
    }

    public void setElementses(List<Elements> elementses) {
        this.elementses = elementses;
    }

    public List<SousOrganes> getSousOrganeses() {
        try {
            sousOrganeses = teknikService.findAllSousOrganes();
            return sousOrganeses;
        } catch (Exception e) {
        }
        return Collections.EMPTY_LIST;
    }

    public void setSousOrganeses(List<SousOrganes> sousOrganeses) {
        this.sousOrganeses = sousOrganeses;
    }

    public Elements getElements() {
        return elements;
    }

    public void setElements(Elements elements) {
        this.elements = elements;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void saveOrupdateElement(){
        if (elements != null && elements.getCode() != null) {
           
            
            try {
                System.out.println("    L'element : " + elements);
                elements.setSousOrganes(teknikService.findSousOrganeById(Long.valueOf(id)));
                teknikService.saveOrUpdateElement(elements);
                if (elements.getId() == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operation reussie", elements.getNom() + " a été mis à jour "));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operation reussie", elements.getNom()+ " a été enregistré"));
            }               
            } catch (NumberFormatException | ServiceException e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Echec de l'opération", "Veuillez reéssayer plus tard"));
            }
            
            elements = new Elements();
        }   
    }
    
    public void deleteElement() throws ServiceException{
        if (elements != null && elements.getId() != null) {
            try {
                teknikService.deleteElements(elements.getId());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operation reussie", elements.getNom() + " a été supprimé"));
            } catch (Exception e) {
                
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Echec de l'opération", "Ene erreur est survenue"));
            }
            elements = new Elements();
        }
    }
    
     public void verifierEtUpdate(ActionEvent actionEvent) throws ServiceException {
        if (elements != null && elements.getId() != null) {
            RequestContext.getCurrentInstance().execute("PF('dlgUpdate').show()");
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Attention", "selectionner un bloc avant de modifier "));
        }
    }

    public void verifierEtSupprimer(ActionEvent actionEvent) throws ServiceException {
        if (elements != null && elements.getId() != null) {
            RequestContext.getCurrentInstance().execute("PF('confirmation').show()");
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Attention", "selectionner un bloc avant de supprimer "));
        }
    }
    
    public PeriodeType[] getPeriodes() {
        return PeriodeType.values();
    }
    
}