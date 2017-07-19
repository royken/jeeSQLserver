package com.royken.teknik.service.impl;

import com.royken.generic.dao.DataAccessException;
import com.royken.teknik.entities.Bloc;
import com.royken.teknik.entities.Elements;
import com.royken.teknik.entities.Organes;
import com.royken.teknik.entities.SousOrganes;
import com.royken.teknik.entities.Utilisateurs;
import com.royken.teknik.entities.Zone;
import com.royken.teknik.dao.IBlocDao;
import com.royken.teknik.dao.IElementDao;
import com.royken.teknik.dao.IOrganesDao;
import com.royken.teknik.dao.IReponseDao;
import com.royken.teknik.dao.ISousOrganesDao;
import com.royken.teknik.dao.IUtilisateursDao;
import com.royken.teknik.dao.IZoneDao;
import com.royken.teknik.entities.Reponse;
import com.royken.teknik.entities.projections.BlocZ;
import com.royken.teknik.entities.projections.Element;
import com.royken.teknik.entities.projections.Organe;
import com.royken.teknik.entities.projections.SousOrgane;
import com.royken.teknik.entities.projections.ZoneP;
import com.royken.teknik.service.ITeknikService;
import com.royken.teknik.service.ServiceException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Stateless
public class TeknikServiceImpl implements ITeknikService{
    
    @Inject
    private IBlocDao blocDao;
    
    @Inject
    private IElementDao elementDao;
    
    @Inject
    private IOrganesDao organesDao;
    
    @Inject
    private ISousOrganesDao sousOrganesDao;
    
    @Inject
    private IUtilisateursDao utilisateursDao;
    
    @Inject
    private IZoneDao zoneDao;
    
    @Inject
    private IReponseDao reponseDao;

    public IBlocDao getBlocDao() {
        return blocDao;
    }

    public void setBlocDao(IBlocDao blocDao) {
        this.blocDao = blocDao;
    }

    public IElementDao getElementDao() {
        return elementDao;
    }

    public void setElementDao(IElementDao elementDao) {
        this.elementDao = elementDao;
    }

    public IOrganesDao getOrganesDao() {
        return organesDao;
    }

    public void setOrganesDao(IOrganesDao organesDao) {
        this.organesDao = organesDao;
    }

    public ISousOrganesDao getSousOrganesDao() {
        return sousOrganesDao;
    }

    public void setSousOrganesDao(ISousOrganesDao sousOrganesDao) {
        this.sousOrganesDao = sousOrganesDao;
    }

    public IUtilisateursDao getUtilisateursDao() {
        return utilisateursDao;
    }

    public void setUtilisateursDao(IUtilisateursDao utilisateursDao) {
        this.utilisateursDao = utilisateursDao;
    }

    public IZoneDao getZoneDao() {
        return zoneDao;
    }

    public void setZoneDao(IZoneDao zoneDao) {
        this.zoneDao = zoneDao;
    }

    public IReponseDao getReponseDao() {
        return reponseDao;
    }

    public void setReponseDao(IReponseDao reponseDao) {
        this.reponseDao = reponseDao;
    }
    
    
  

    @Override
    public List<Utilisateurs> findAllUtilisateurs() {
        try {
            return utilisateursDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(TeknikServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<Bloc> findAllBloc() {
        try {
            return blocDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(TeknikServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<ZoneP> findAllZone() {
        try {
            List<Zone> zones =  zoneDao.findAll();
            List<ZoneP> result = new ArrayList<>();
            for (Zone zone : zones) {
                ZoneP z = new ZoneP();
                z.setCahierCode(zone.getCahierCode());
                z.setCode(zone.getCode());
                z.setNom(zone.getNom());
                z.setId(zone.getId());
                result.add(z);
            }
            return result;
        } catch (DataAccessException ex) {
            Logger.getLogger(TeknikServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<Organes> findAllOrganes() {
        try {
            return organesDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(TeknikServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<SousOrganes> findAllSousOrganes() {
        try {
            return sousOrganesDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(TeknikServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<Elements> findAllElement() {
        try {
            return elementDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(TeknikServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<BlocZ> findAllBlocProjection() {
        try {
            List<Bloc> blocs = blocDao.findAll();
            List<BlocZ> result = new ArrayList();
            for (Bloc result1 : blocs) {
                BlocZ temp = new BlocZ();
                temp.setCode(result1.getCode());
                temp.setId(result1.getId());
                temp.setIdZone(result1.getZone().getId());
                temp.setNom(result1.getNom());
                result.add(temp);
            }
            return result;
        } catch (DataAccessException ex) {
            Logger.getLogger(TeknikServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.emptyList();
    }

    @Override
    public List<Element> findAllElementProjection() {
        try {
            List<Elements> list = elementDao.findAll();
            List<Element> result = new ArrayList<>();
            for (Elements result1 : list) {
                Element temp = new Element();
                temp.setCriteriaAlpha(result1.isCriteriaAlpha());
                temp.setGuideSaisie(result1.getGuideSaisie());
                temp.setHasBorn(result1.isHasBorns());
                temp.setId(result1.getId());
                temp.setNom(result1.getNom());
                System.out.println(result1);
                temp.setSousOrganeId(result1.getSousOrganes().getId());
                temp.setValMax(result1.getValMax());
                temp.setValMin(result1.getValMin());
                temp.setCode(result1.getCode());
                temp.setValeurNormale(result1.getValeurNormale());
                temp.setValeurType(result1.getValeurType());
                temp.setPeriode(result1.getPeriodeType().ordinal());
                temp.setUnite(result1.getUnite());
                result.add(temp);
            }
            return result;
        } catch (DataAccessException ex) {
            Logger.getLogger(TeknikServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.emptyList();
    }

    @Override
    public List<Organe> findAllOrganeProjection() {
        try {
            List<Organes> list = organesDao.findAll();
            List<Organe> result = new ArrayList<>();
            for (Organes result1 : list) {
                Organe organe = new Organe();
                organe.setId(result1.getId());
                organe.setCode(result1.getCode());
                organe.setIdBloc(result1.getBloc().getId());
                organe.setNom(result1.getNom());
                result.add(organe);
            }
            return result;
        } catch (DataAccessException ex) {
            Logger.getLogger(TeknikServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.emptyList();
    }

    @Override
    public List<SousOrgane> findAllSousOrganeProjection() {
        try {
            List<SousOrganes> list = sousOrganesDao.findAll();
            List<SousOrgane> result = new ArrayList<>();
            for (SousOrganes result1 : list) {
                SousOrgane temp = new SousOrgane();
                temp.setCode(result1.getCode());
                temp.setId(result1.getId());
                temp.setNom(result1.getNom());
                temp.setIdOrgane(result1.getOrganes().getId());
                result.add(temp);
            }
            return result;
        } catch (DataAccessException ex) {
            Logger.getLogger(TeknikServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.EMPTY_LIST;
    }

 /*   @Override
    public List<ZoneP> findAllZoneProjection() {
        try {
            List<Zone> zones = zoneDao.findAll();
            List<ZoneP> result = new ArrayList<ZoneP>();
            for (Zone result1 : zones) {
                ZoneP temp = new ZoneP();
                temp.setId(result1.getId());
                temp.setCode(result1.getCode());
                temp.setNom(result1.getNom());
                temp
            }
        } catch (DataAccessException ex) {
            Logger.getLogger(TeknikServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.EMPTY_LIST;
    }
    */

    @Override
    public Bloc saveOrUpdateBloc(Bloc bloc) throws ServiceException {
        try {
            if(bloc != null){
                if(bloc.getId() != null){
                    return blocDao.update(bloc);
                }
                else{
                    return blocDao.create(bloc);
                }
            }
            throw new ServiceException("Erreur lors de la sauvegarde");
        } catch (DataAccessException e) {
            throw new ServiceException("Erreur lors de l'accès à la base de données");
        } catch (ServiceException e) {
            throw new ServiceException("Erreur lors de la sauvegarde");
        }
    }

    @Override
    public Bloc findBlocById(Long id) throws ServiceException {
        try {
            if(id != null){
                return blocDao.findById(id);
            }
            else{
               throw new ServiceException("L'identifiant est nul"); 
            }
        } catch (DataAccessException | ServiceException e) {
            throw new ServiceException("Erreur lors de la sauvegarde");
        }
    }

    @Override
    public void deleteBloc(Long id) throws ServiceException {
        try {
            if(id != null){
                Bloc b = blocDao.findById(id);
                if(b != null){
                    b.setActive(0);
                    blocDao.update(b);
                }
            }
        } catch (Exception e) {
            throw new ServiceException("Erreur lors de la sauvegarde");
        }
    }

    @Override
    public Organes saveOrUpdateOrgane(Organes organes) throws ServiceException {
        try {
            if(organes != null){
                if(organes.getId() == null){
                    return organesDao.create(organes);
                }
                else{
                    return organesDao.update(organes);
                }
            }
            else{
                 throw new ServiceException("Erreur lors de la sauvegarde");
            }
        } catch (DataAccessException | ServiceException e) {
             throw new ServiceException("Erreur lors de la sauvegarde");
        }
    }

    @Override
    public Organes findOrganeById(Long id) throws ServiceException {
        try {
            if(id != null){
                return organesDao.findById(id);
            }
            else{
                throw new ServiceException("L'identifiant est nul");
            }
        } catch (DataAccessException | ServiceException e) {
            throw new ServiceException("Erreur lors de la sauvegarde");
        }
    }

    @Override
    public void deleteOrgane(Long id) throws ServiceException {
        try {
            if(id != null){
                Organes o = organesDao.findById(id);
                if(o != null){
                    o.setActive(0);
                    organesDao.update(o);
                }
            }
        } catch (Exception e) {
            throw new ServiceException("Erreur lors de la suppression");
        }
    }

    @Override
    public Zone saveOrUpdateZone(Zone zone) throws ServiceException {
        try {
            if(zone != null){
                if(zone.getId() != null){
                    return zoneDao.update(zone);
                }
                else{
                    return zoneDao.create(zone);
                }
            }
            else{
                throw new ServiceException("La valeur");
            }
        } catch (DataAccessException | ServiceException e) {
            throw new ServiceException("Erreur lors de la sauvegarde");
        }
    }

    @Override
    public Zone findZoneById(Long id) throws ServiceException {
        try {
            if(id != null){
                return  zoneDao.findById(id);
            }
            else{
                throw new ServiceException("L'identifiant est nul");
            }
        } catch (DataAccessException | ServiceException e) {
            throw new ServiceException("Erreur lors de la recherche");
        }
    }

    @Override
    public void deleteZone(Long id) throws ServiceException {
        try {
            if(id != null){
                Zone z = zoneDao.findById(id);
                if(z != null){
                    z.setActive(0);
                    zoneDao.update(z);
                }
            }
        } catch (Exception e) {
            throw new ServiceException("Erreur lors de la suppression");
        }
    }

    @Override
    public SousOrganes saveOrUpdateSousOrgane(SousOrganes sousOrganes) throws ServiceException {
        try {
            if(sousOrganes != null){
                if(sousOrganes.getId() == null){
                    return sousOrganesDao.create(sousOrganes);
                }
                else{
                    return sousOrganesDao.update(sousOrganes);
                }
            }
            else{
                throw new ServiceException("Erreur lors de la sauvegarde");
            }
        } catch (DataAccessException | ServiceException e) {
            throw new ServiceException("Erreur lors de la sauvegarde");
        }
    }

    @Override
    public SousOrganes findSousOrganeById(Long id) throws ServiceException {
        try {
            if(id != null){
                return sousOrganesDao.findById(id);
            }
            else{
                throw new ServiceException("L'identifiant est null");
            }
        } catch (DataAccessException | ServiceException e) {
            throw new ServiceException("Erreur lors de l'accès à la BD");
        }
    }

    @Override
    public void deleteSousOrgane(Long id) throws ServiceException {
        try {
            if(id != null){
                SousOrganes so = sousOrganesDao.findById(id);
                if(so != null){
                    so.setActive(0);
                    sousOrganesDao.update(so);
                }
            }
        } catch (Exception e) {
            throw new ServiceException("Erreur lors de l'accès à la BD");
        }
    }

    @Override
    public Elements saveOrUpdateElement(Elements elements) throws ServiceException {
        try {
            if(elements != null){
                if(elements.getId() != null){
                    return elementDao.create(elements);
                }
                else{
                    return elementDao.update(elements);
                }
            }
            else{
                throw new ServiceException("L'entité est nulle");
            }
        } catch (DataAccessException | ServiceException e) {
            throw new ServiceException("Erreur lors de l'accès à la BD");
        }
    }

    @Override
    public Elements findByElementById(Long id) throws ServiceException {
        try {
            if(id != null){
                return elementDao.findById(id);
            }
            else{
                throw new ServiceException("L'identifiant est null");
            }
        } catch (DataAccessException | ServiceException e) {
            throw new ServiceException("Erreur lors de l'accès à la BD");
        }
    }

    @Override
    public void deleteElements(Long id) throws ServiceException {
        try {
            if(id != null){
                Elements e = elementDao.findById(id);
                if(e != null){
                    e.setActive(0);
                    elementDao.update(e);
                }
            }
        } catch (Exception e) {
            throw new ServiceException("Erreur lors de l'accès à la BD");
        }
    }

    @Override
    public Reponse saveOrUpdateReponse(Reponse reponse) throws ServiceException {
        try {
            if(reponse != null){
                if(reponse.getId() == null){
                    return reponseDao.create(reponse);
                }
                else{
                    return reponseDao.update(reponse);
                }
            }
            else{
                throw new ServiceException("L'entité est nulle");
            }
        } catch (DataAccessException | ServiceException e) {
            throw new ServiceException("Erreur lors de l'accès à la BD");
        }
    }

    @Override
    public Reponse findReponseById(Long id) throws ServiceException {
        try {
            if(id != null){
                return reponseDao.findById(id);
            }
            throw new ServiceException("L'identifiant est nul");
        } catch (DataAccessException | ServiceException e) {
            throw new ServiceException("Erreur lors de l'accès à la BD");
        }
    }

    @Override
    public void deleteReponse(Long id) throws ServiceException {
        try {
            if(id != null){
                Reponse r = reponseDao.findById(id);
                if(r != null){
                    r.setActive(0);
                    reponseDao.update(r);
                }
            }
        } catch (Exception e) {
        }
    }

    @Override
    public List<Bloc> getAllBloc() throws ServiceException {
        try {
            return blocDao.findAll();
        } catch (Exception e) {
            throw new ServiceException("Erreur lors de l'accès à la BD");
        }
    }

    @Override
    public List<Organes> getAllOrganes() throws ServiceException {
        try {
            return organesDao.findAll();
        } catch (Exception e) {
            throw new ServiceException("Erreur lors de l'accès à la BD");
        }
    }

    @Override
    public List<Zone> getAllZones() throws ServiceException {
        try {
            List<Zone> result =  zoneDao.findAll();
            for (Zone result1 : result) {
                System.out.println(result1);
            }
            return result;
        } catch (Exception e) {
            throw new ServiceException("Erreur lors de l'accès à la BD");
        }
    }

    @Override
    public List<SousOrganes> getAllSousOrganes() throws ServiceException {
        try {
            return sousOrganesDao.findAll();
        } catch (Exception e) {
            throw new ServiceException("Erreur lors de l'accès à la BD");
        }
    }

    @Override
    public List<Elements> getAllElement() throws ServiceException {
        try {
            return elementDao.findAll();
        } catch (Exception e) {
            throw new ServiceException("Erreur lors de l'accès à la BD");
        }
    }

    @Override
    public List<Reponse> getAllReponse() throws ServiceException {
        try {
            return reponseDao.findAll();
        } catch (Exception e) {
            throw new ServiceException("Erreur lors de l'accès à la BD");
        }
    }

    @Override
    public Utilisateurs saveOrUpdateUtilisateur(Utilisateurs utilisateurs) throws ServiceException {
        try {
            if(utilisateurs != null){
                if(utilisateurs.getId() == null){
                    return utilisateursDao.create(utilisateurs);
                }
                else{
                    return utilisateursDao.update(utilisateurs);
                }
            }
            else{
                throw new ServiceException("L'objet est null");
            }
        } catch (DataAccessException | ServiceException e) {
            throw new ServiceException("Erreur lors de l'accès à la BD");
        }
    }

    @Override
    public Utilisateurs findUtilisateurById(Long id) throws ServiceException {
        try {
            if(id != null){
                return utilisateursDao.findById(id);
            }
            else{
                throw new ServiceException("L'identifiant est null");
            }
        } catch (DataAccessException | ServiceException e) {
            throw new ServiceException("Erreur lors de l'accès à la BD");
        }
    }

    @Override
    public void deleteUtilisateur(Long id) throws ServiceException {
        try {
            if(id != null){
                Utilisateurs u = utilisateursDao.findById(id);
                if(u != null){
                    u.setActive(0);
                    utilisateursDao.update(u);
                }
            }
        } catch (Exception e) {
            throw new ServiceException("Erreur lors de l'accès à la BD");
        }
    }

    @Override
    public List<Utilisateurs> getAllUtilisateurs() throws ServiceException {
        try {
            return utilisateursDao.findAll();
        } catch (Exception e) {
            throw new ServiceException("Erreur lors de l'accès à la BD");
        }
    }
}