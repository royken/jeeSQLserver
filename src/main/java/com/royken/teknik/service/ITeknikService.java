package com.royken.teknik.service;

import com.royken.teknik.entities.Bloc;
import com.royken.teknik.entities.Elements;
import com.royken.teknik.entities.Organes;
import com.royken.teknik.entities.Reponse;
import com.royken.teknik.entities.SousOrganes;
import com.royken.teknik.entities.Utilisateurs;
import com.royken.teknik.entities.Zone;
import com.royken.teknik.entities.projections.BlocZ;
import com.royken.teknik.entities.projections.Element;
import com.royken.teknik.entities.projections.Organe;
import com.royken.teknik.entities.projections.ReponseProjection;
import com.royken.teknik.entities.projections.SousOrgane;
import com.royken.teknik.entities.projections.ZoneP;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Local
public interface ITeknikService {
    
    public List<Utilisateurs> findAllUtilisateurs();
    
    public List<Bloc> findAllBloc();
    
    public List<ZoneP> findAllZone();
    
    public List<Organes> findAllOrganes();
    
    public List<SousOrganes> findAllSousOrganes();
    
    public List<Elements> findAllElement();
    
    public List<BlocZ> findAllBlocProjection();
    
    public List<Element> findAllElementProjection();
    
    public List<Organe> findAllOrganeProjection();
    
    public List<SousOrgane> findAllSousOrganeProjection();
    
    public void saveReponseFromWeb(List<ReponseProjection> projections) throws ServiceException;
    
    //public List<ZoneP> findAllZoneProjection();
    
    public Bloc saveOrUpdateBloc(Bloc bloc) throws ServiceException;
    
    public Bloc findBlocById(Long id) throws ServiceException;
    
    public void deleteBloc(Long id) throws ServiceException;
    
    public List<Bloc> getAllBloc() throws ServiceException;
    
    
    public Organes saveOrUpdateOrgane(Organes organes) throws ServiceException;
    
    public Organes findOrganeById(Long id) throws ServiceException;
    
    public void deleteOrgane(Long id) throws ServiceException;
    
    public List<Organes> getAllOrganes() throws ServiceException;
    
    
    public Zone saveOrUpdateZone(Zone zone) throws ServiceException;
    
    public Zone findZoneById(Long id) throws ServiceException;
    
    public void deleteZone(Long id) throws ServiceException;
    
    public List<Zone> getAllZones() throws ServiceException;
    
    
    public SousOrganes saveOrUpdateSousOrgane(SousOrganes sousOrganes) throws ServiceException;
    
    public SousOrganes findSousOrganeById(Long id) throws ServiceException;
    
    public void deleteSousOrgane(Long id) throws ServiceException;
    
    public List<SousOrganes> getAllSousOrganes() throws ServiceException;
    
    
    public Elements saveOrUpdateElement(Elements elements) throws ServiceException;
    
    public Elements findByElementById(Long id) throws ServiceException;
    
    public void deleteElements(Long idElement) throws ServiceException;
    
    public List<Elements> getAllElement() throws ServiceException;
    
    
    public Reponse saveOrUpdateReponse(Reponse reponse) throws ServiceException;
    
    public Reponse findReponseById(Long id) throws ServiceException;
    
    public void deleteReponse(Long idReponse) throws ServiceException;
    
    public List<Reponse> getAllReponse() throws ServiceException;
    
    
    public Utilisateurs saveOrUpdateUtilisateur(Utilisateurs utilisateurs) throws ServiceException;
    
    public Utilisateurs findUtilisateurById(Long id) throws ServiceException;
    
    public void deleteUtilisateur(Long id) throws ServiceException;
    
    public List<Utilisateurs> getAllUtilisateurs() throws ServiceException;
    
}
