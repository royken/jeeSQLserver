package com.royken.teknik.web.beans;

import com.royken.teknik.service.ITeknikService;
import com.royken.teknik.service.ServiceException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author vr.kenfack
 */
@Named(value = "countBean")
@SessionScoped
public class CountBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EJB
    private ITeknikService service;

    /**
     * Creates a new instance of CountBean
     */
    public CountBean() {
    }
    
    public long getUsers(){
        try {
            return service.countUtilisateur();
        } catch (ServiceException e) {
        }
        return 0L;
    }
    
    public long getZones(){
        try {
            return service.countZone();
        } catch (ServiceException e) {
        }
        return 0L;
    }
    
    public long getBlocs(){
        try {
            return service.countBloc();
        } catch (ServiceException e) {
        }
        return 0L;
    }
    
    public long getOrganes(){
        try {
            return service.countOrgane();
        } catch (ServiceException e) {
        }
        return 0L;
    }
    
    public long getSousOrganes(){
        try {
            return service.countSousOrgane();
        } catch (ServiceException e) {
        }
        return 0L;
    }
    
    public long getElements(){
        try {
            return service.countElement();
        } catch (ServiceException e) {
        }
        return 0L;
    }
    
}
