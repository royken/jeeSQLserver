package com.royken.teknik.dao.impl;

import com.royken.generic.dao.DataAccessException;
import com.royken.generic.dao.impl.GenericDao;
import com.royken.teknik.entities.Zone;
import com.royken.teknik.dao.IZoneDao;
import com.royken.teknik.entities.Utilisateurs;
import com.royken.teknik.entities.Utilisateurs_;
import com.royken.teknik.entities.Zone_;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
public class ZoneDaoImpl extends GenericDao<Zone, Long> implements IZoneDao{

    @Override
    public List<Zone> findAllActive() throws DataAccessException {
        CriteriaBuilder cb = getManager().getCriteriaBuilder();
        CriteriaQuery<Zone> cq = cb.createQuery(Zone.class);
        Root<Zone> zoneRoot = cq.from(Zone.class);
        cq.where(cb.equal(zoneRoot.get(Zone_.active), 1));
        return getManager().createQuery(cq).getResultList();
    }

    @Override
    public Long count() throws DataAccessException {
        CriteriaBuilder cb = getManager().getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Zone> zoneRoot = cq.from(Zone.class);
        cq.where(cb.equal(zoneRoot.get(Zone_.active), 1));   
        cq.select(cb.count(zoneRoot));
        return getManager().createQuery(cq).getSingleResult();
    }
    
}
