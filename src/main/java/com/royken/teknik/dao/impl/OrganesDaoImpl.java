package com.royken.teknik.dao.impl;

import com.royken.generic.dao.DataAccessException;
import com.royken.generic.dao.impl.GenericDao;
import com.royken.teknik.entities.Organes;
import com.royken.teknik.dao.IOrganesDao;
import com.royken.teknik.entities.Organes_;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
public class OrganesDaoImpl extends GenericDao<Organes, Long> implements IOrganesDao{

    @Override
    public List<Organes> getAllActive() throws DataAccessException {
        CriteriaBuilder cb = getManager().getCriteriaBuilder();
        CriteriaQuery<Organes> cq = cb.createQuery(Organes.class);
        Root<Organes> orgRoot = cq.from(Organes.class);
        cq.where(cb.equal(orgRoot.get(Organes_.active), 1));
        return getManager().createQuery(cq).getResultList();
    }

    @Override
    public Long count() throws DataAccessException {
        CriteriaBuilder cb = getManager().getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Organes> orgRoot = cq.from(Organes.class);
        cq.where(cb.equal(orgRoot.get(Organes_.active), 1));       
        cq.select(cb.count(orgRoot));
        return getManager().createQuery(cq).getSingleResult();
    }
    
}
