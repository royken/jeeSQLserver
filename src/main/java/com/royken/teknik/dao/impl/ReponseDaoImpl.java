package com.royken.teknik.dao.impl;

import com.royken.generic.dao.DataAccessException;
import com.royken.generic.dao.impl.GenericDao;
import com.royken.teknik.dao.IReponseDao;
import com.royken.teknik.entities.Organes;
import com.royken.teknik.entities.Organes_;
import com.royken.teknik.entities.Reponse;
import com.royken.teknik.entities.Reponse_;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import org.hibernate.exception.DataException;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
public class ReponseDaoImpl extends GenericDao<Reponse, Long> implements IReponseDao{

    @Override
    public List<Reponse> getBetweenDates(Date debut, Date fin) throws DataException {
        try {
            CriteriaBuilder cb = getManager().getCriteriaBuilder();
            CriteriaQuery<Reponse> cq = cb.createQuery(Reponse.class);
            Root<Reponse> repRoot = cq.from(Reponse.class);
           
            cq.where(cb.and(cb.between(repRoot.get(Reponse_.date), debut, fin),cb.equal(repRoot.get(Reponse_.active), 1))).orderBy(cb.desc(repRoot.get(Reponse_.date)));
            return getManager().createQuery(cq).getResultList();
        } catch (DataAccessException ex) {
            Logger.getLogger(ReponseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }

    
}
