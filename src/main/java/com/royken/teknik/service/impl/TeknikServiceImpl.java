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
import com.royken.teknik.entities.projections.PostAnswer;
import com.royken.teknik.entities.projections.ReponseProjection;
import com.royken.teknik.entities.projections.SousOrgane;
import com.royken.teknik.entities.projections.ZoneP;
import com.royken.teknik.service.ITeknikService;
import com.royken.teknik.service.ServiceException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.hibernate.exception.DataException;

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
            return utilisateursDao.getAllActive();
        } catch (DataAccessException ex) {
            Logger.getLogger(TeknikServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<Bloc> findAllBloc() {
        try {
            return blocDao.getAllActive();
        } catch (DataAccessException ex) {
            Logger.getLogger(TeknikServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<ZoneP> findAllZone() {
        try {
            List<Zone> zones =  zoneDao.findAllActive();
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
            return organesDao.getAllActive();
        } catch (DataAccessException ex) {
            Logger.getLogger(TeknikServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<SousOrganes> findAllSousOrganes() {
        try {
            return sousOrganesDao.getAllActive();
        } catch (DataAccessException ex) {
            Logger.getLogger(TeknikServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<Elements> findAllElement() {
        try {
            return elementDao.getAllActive();
        } catch (DataAccessException ex) {
            Logger.getLogger(TeknikServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<BlocZ> findAllBlocProjection() {
        try {
            List<Bloc> blocs = blocDao.getAllActive();
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
            List<Elements> list = elementDao.getAllActive();
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
            List<Organes> list = organesDao.getAllActive();
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
            List<SousOrganes> list = sousOrganesDao.getAllActive();
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
                    bloc.setActive(1);
                    return blocDao.update(bloc);
                }
                else{
                    bloc.setActive(1);
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
        } catch (DataAccessException e) {
            throw new ServiceException("Erreur lors de la sauvegarde");
        }
    }

    @Override
    public Organes saveOrUpdateOrgane(Organes organes) throws ServiceException {
        try {
            if(organes != null){
                if(organes.getId() == null){
                    organes.setActive(1);
                    return organesDao.create(organes);
                }
                else{
                    organes.setActive(1);
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
        } catch (DataAccessException e) {
            throw new ServiceException("Erreur lors de la suppression");
        }
    }

    @Override
    public Zone saveOrUpdateZone(Zone zone) throws ServiceException {
        try {
            if(zone != null){
                if(zone.getId() != null){
                    zone.setActive(1);
                    return zoneDao.update(zone);
                }
                else{
                    System.out.println("JE SAVE ==================");
                    zone.setActive(1);
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
        } catch (DataAccessException e) {
            throw new ServiceException("Erreur lors de la suppression");
        }
    }

    @Override
    public SousOrganes saveOrUpdateSousOrgane(SousOrganes sousOrganes) throws ServiceException {
        try {
            if(sousOrganes != null){
                if(sousOrganes.getId() == null){
                    sousOrganes.setActive(1);
                    return sousOrganesDao.create(sousOrganes);
                }
                else{
                    sousOrganes.setActive(1);
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
        } catch (DataAccessException e) {
            throw new ServiceException("Erreur lors de l'accès à la BD");
        }
    }

    @Override
    public Elements saveOrUpdateElement(Elements elements) throws ServiceException {
        try {
            if(elements != null){
                if(elements.getId() == null){
                    elements.setActive(1);
                    return elementDao.create(elements);
                }
                else{
                    elements.setActive(1);
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
        } catch (DataAccessException e) {
            throw new ServiceException("Erreur lors de l'accès à la BD");
        }
    }

    @Override
    public Reponse saveOrUpdateReponse(Reponse reponse) throws ServiceException {
        try {
            if(reponse != null){
                if(reponse.getId() == null){
                    reponse.setActive(1);
                    return reponseDao.create(reponse);
                }
                else{
                    reponse.setActive(1);
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
        } catch (DataAccessException e) {
        }
    }

    @Override
    public List<Bloc> getAllBloc() throws ServiceException {
        try {
            return blocDao.getAllActive();
        } catch (DataAccessException e) {
            throw new ServiceException("Erreur lors de l'accès à la BD");
        }
    }

    @Override
    public List<Organes> getAllOrganes() throws ServiceException {
        try {
            return organesDao.getAllActive();
        } catch (DataAccessException e) {
            throw new ServiceException("Erreur lors de l'accès à la BD");
        }
    }

    @Override
    public List<Zone> getAllZones() throws ServiceException {
        try {
            List<Zone> result =  zoneDao.findAllActive();
            for (Zone result1 : result) {
                System.out.println(result1);
            }
            return result;
        } catch (DataAccessException e) {
            throw new ServiceException("Erreur lors de l'accès à la BD");
        }
    }

    @Override
    public List<SousOrganes> getAllSousOrganes() throws ServiceException {
        try {
            return sousOrganesDao.getAllActive();
        } catch (DataAccessException e) {
            throw new ServiceException("Erreur lors de l'accès à la BD");
        }
    }

    @Override
    public List<Elements> getAllElement() throws ServiceException {
        try {
            return elementDao.getAllActive();
        } catch (DataAccessException e) {
            throw new ServiceException("Erreur lors de l'accès à la BD");
        }
    }

    @Override
    public List<Reponse> getAllReponse() throws ServiceException {
        try {
            return reponseDao.findAll();
        } catch (DataAccessException e) {
            throw new ServiceException("Erreur lors de l'accès à la BD");
        }
    }

    @Override
    public Utilisateurs saveOrUpdateUtilisateur(Utilisateurs utilisateurs) throws ServiceException {
        try {
            if(utilisateurs != null){
                if(utilisateurs.getId() == null){
                    utilisateurs.setActive(1);
                    return utilisateursDao.create(utilisateurs);
                }
                else{
                    utilisateurs.setActive(1);
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
        } catch (DataAccessException e) {
            throw new ServiceException("Erreur lors de l'accès à la BD");
        }
    }

    @Override
    public List<Utilisateurs> getAllUtilisateurs() throws ServiceException {
        try {
            return utilisateursDao.getAllActive();
        } catch (DataAccessException e) {
            throw new ServiceException("Erreur lors de l'accès à la BD");
        }
    }

    @Override
    public PostAnswer saveReponseFromWeb(List<ReponseProjection> projections) throws ServiceException {
      /*  for (ReponseProjection projection : projections) {
            System.out.println(projection);
        }
        */
      PostAnswer answer = new PostAnswer();
        try {
            if (projections != null){
                for (ReponseProjection projection : projections) {
                    Elements e =  elementDao.findById(Long.valueOf(projection.getIdElement()));
                    Utilisateurs u = utilisateursDao.findById(Long.valueOf(projection.getIdUser()));
                    Reponse r = new Reponse();
                    r.setActive(1);
                    r.setDate(projection.getDate());
                    r.setElements(e);
                    r.setUtilisateurs(u);
                    r.setValeur(projection.getValeur());
                    r.setValeurCorrecte(projection.isValeurCorrecte());
                    reponseDao.create(r);
                }
                answer.setSuccess(true);
                return answer;
            }
        } catch (DataAccessException e) {
        }
        return answer;
    }

    @Override
    public List<Reponse> getReponseBetweenDates(Date debut, Date fin) throws ServiceException {
        try {
            if(debut != null && fin != null){
                return reponseDao.getBetweenDates(debut, fin);
            }
        } catch (DataException e) {
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public void importReponse(InputStream stream) throws ServiceException {
        try {
            Workbook workbook = WorkbookFactory.create(stream);
            final Sheet sheet = workbook.getSheetAt(0);
            int index = 1;
            Row row = sheet.getRow(index++);
            Long idElement;
            Long idUser;
            String valeur;
            boolean correct;
            Date date;
            while (row != null) {   
               Reponse r = new Reponse();
                if (row.getCell(1) != null) {
                    //row.getCell(1).setCellType(Cell.CELL_TYPE_NUMERIC);
                    idElement = Long.valueOf(row.getCell(1).getStringCellValue().trim());
                    Elements e = elementDao.findById(idElement);
                    r.setElements(e);
                    if(row.getCell(2) != null){
                        row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                        valeur = row.getCell(2).getStringCellValue().trim();
                        r.setValeur(valeur);
                        if(row.getCell(3) != null){
                            //correct = row.getCell(2).getBooleanCellValue();
                            String value = row.getCell(2).getStringCellValue().trim();
                            r.setValeurCorrecte(value.equalsIgnoreCase("true"));
                            if(row.getCell(4) != null){
                                //date = row.getCell(40).getDateCellValue();
                                String dates = row.getCell(4).getStringCellValue().trim();
                                r.setDate(new Date(Long.valueOf(dates)));
                                if(row.getCell(5) != null){
                                    //row.getCell(5).setCellType(Cell.CELL_TYPE_NUMERIC);
                                    idUser = Long.valueOf(row.getCell(5).getStringCellValue().trim());
                                    Utilisateurs u = utilisateursDao.findById(idUser);
                                    r.setUtilisateurs(u);
                                    r.setActive(1);
                                    reponseDao.create(r);
                                }
                            }
                        }
                    }                    
                }
                row = sheet.getRow(index++);
            }
        } catch (DataAccessException | IOException | NumberFormatException | EncryptedDocumentException | InvalidFormatException e) {
        }
    }

    @Override
    public Long countZone() throws ServiceException {
        try {
            return zoneDao.count();
        } catch (DataAccessException e) {
        }
        return 0L;
    }

    @Override
    public Long countBloc() throws ServiceException {
        try {
            return blocDao.count();
        } catch (DataAccessException e) {
        }
        return 0L;
    }

    @Override
    public Long countOrgane() throws ServiceException {
        try {
            return organesDao.count();
        } catch (DataAccessException e) {
        }
        return 0L;
    }

    @Override
    public Long countSousOrgane() throws ServiceException {
        try {
            return sousOrganesDao.count();
        } catch (DataAccessException e) {
        }
        return 0L;
    }

    @Override
    public Long countElement() throws ServiceException {
        try {
            return elementDao.count();
        } catch (DataAccessException e) {
        }
        return 0L;
    }

    @Override
    public Long countUtilisateur() throws ServiceException {
        try {
            return utilisateursDao.count();
        } catch (DataAccessException e) {
        }
        return 0L;
    }
}