package com.royken.teknik.dao.impl;

import com.royken.generic.dao.DataAccessException;
import com.royken.generic.dao.impl.GenericDao;
import com.royken.teknik.entities.SousOrganes;
import com.royken.teknik.dao.ISousOrganesDao;
import com.royken.teknik.entities.Organes;
import com.royken.teknik.entities.Organes_;
import com.royken.teknik.entities.SousOrganes_;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
public class SousOrganesDaoImpl extends GenericDao<SousOrganes, Long> implements ISousOrganesDao{

    @Override
    public List<SousOrganes> getAllActive() throws DataAccessException {
        CriteriaBuilder cb = getManager().getCriteriaBuilder();
        CriteriaQuery<SousOrganes> cq = cb.createQuery(SousOrganes.class);
        Root<SousOrganes> sousRoot = cq.from(SousOrganes.class);
        cq.where(cb.equal(sousRoot.get(SousOrganes_.active), 1));
        return getManager().createQuery(cq).getResultList();
    }

    @Override
    public Long count() throws DataAccessException {
        CriteriaBuilder cb = getManager().getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SousOrganes> sousRoot = cq.from(SousOrganes.class);
        cq.where(cb.equal(sousRoot.get(SousOrganes_.active), 1));     
        cq.select(cb.count(sousRoot));
        return getManager().createQuery(cq).getSingleResult();
    }
    
}
