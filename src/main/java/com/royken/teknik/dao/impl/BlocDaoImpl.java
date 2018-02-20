package com.royken.teknik.dao.impl;

import com.royken.generic.dao.DataAccessException;
import com.royken.generic.dao.impl.GenericDao;
import com.royken.teknik.entities.Bloc;
import com.royken.teknik.dao.IBlocDao;
import com.royken.teknik.entities.Bloc_;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
public class BlocDaoImpl extends GenericDao<Bloc, Long> implements IBlocDao{

    @Override
    public List<Bloc> getAllActive() throws DataAccessException {
        CriteriaBuilder cb = getManager().getCriteriaBuilder();
        CriteriaQuery<Bloc> cq = cb.createQuery(Bloc.class);
        Root<Bloc> blocRoot = cq.from(Bloc.class);
        cq.where(cb.equal(blocRoot.get(Bloc_.active), 1));
        return getManager().createQuery(cq).getResultList();
    }

    @Override
    public Long count() throws DataAccessException {
        CriteriaBuilder cb = getManager().getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Bloc> blocRoot = cq.from(Bloc.class);
        cq.where(cb.equal(blocRoot.get(Bloc_.active), 1));       
        cq.select(cb.count(blocRoot));
        return getManager().createQuery(cq).getSingleResult();
    }
    
}
