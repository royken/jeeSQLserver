package com.royken.teknik.dao.impl;

import com.royken.generic.dao.DataAccessException;
import com.royken.generic.dao.impl.GenericDao;
import com.royken.teknik.entities.Elements;
import com.royken.teknik.dao.IElementDao;
import com.royken.teknik.entities.Elements_;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
public class ElementDaoImpl extends GenericDao<Elements, Long> implements IElementDao{

    @Override
    public List<Elements> getAllActive() throws DataAccessException {
        CriteriaBuilder cb = getManager().getCriteriaBuilder();
        CriteriaQuery<Elements> cq = cb.createQuery(Elements.class);
        Root<Elements> elRoot = cq.from(Elements.class);
        cq.where(cb.equal(elRoot.get(Elements_.active), 1));
        return getManager().createQuery(cq).getResultList();
    }

    @Override
    public Long count() throws DataAccessException {
        CriteriaBuilder cb = getManager().getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Elements> elRoot = cq.from(Elements.class);
       cq.where(cb.equal(elRoot.get(Elements_.active), 1));       
        cq.select(cb.count(elRoot));
        return getManager().createQuery(cq).getSingleResult();
    }
    
}
