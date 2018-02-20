package com.royken.teknik.resource.impl;

import com.royken.teknik.entities.Utilisateurs;
import com.royken.teknik.entities.projections.BlocZ;
import com.royken.teknik.entities.projections.Element;
import com.royken.teknik.entities.projections.Organe;
import com.royken.teknik.entities.projections.PostAnswer;
import com.royken.teknik.entities.projections.ReponseProjection;
import com.royken.teknik.entities.projections.SousOrgane;
import com.royken.teknik.entities.projections.ZoneP;
import com.royken.teknik.resource.ITeknikResource;
import com.royken.teknik.service.ITeknikService;
import com.royken.teknik.service.ServiceException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Path("/teknik")
public class TeknikResource implements ITeknikResource{
    
    @EJB
    private ITeknikService service;

    public ITeknikService getService() {
        return service;
    }

    public void setService(ITeknikService service) {
        this.service = service;
    }

    @Override
    public List<Utilisateurs> getAllUsers() {
        return service.findAllUtilisateurs();
    }

    @Override
    public List<ZoneP> getAllZone() {
        return service.findAllZone();
    }

    @Override
    public List<BlocZ> getAllBlocs() {
        return service.findAllBlocProjection();
    }

    @Override
    public List<Organe> getAllOrganes() {
        return service.findAllOrganeProjection();
    }

    @Override
    public List<SousOrgane> getAllSousOrgans() {
        return service.findAllSousOrganeProjection();
    }

    @Override
    public List<Element> getAllElement() {
        return service.findAllElementProjection();
    }

    @Override
    public PostAnswer saveReponses(List<ReponseProjection> projections) {
        try {
            return service.saveReponseFromWeb(projections);
        } catch (ServiceException ex) {
            Logger.getLogger(TeknikResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}