package com.royken.teknik.dao.impl;

import com.royken.generic.dao.DataAccessException;
import com.royken.generic.dao.impl.GenericDao;
import com.royken.teknik.entities.Utilisateurs;
import com.royken.teknik.dao.IUtilisateursDao;
import com.royken.teknik.entities.SousOrganes;
import com.royken.teknik.entities.SousOrganes_;
import com.royken.teknik.entities.Utilisateurs_;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
public class UtilisateursDaoImpl extends GenericDao<Utilisateurs, Long> implements IUtilisateursDao{

    @Override
    public List<Utilisateurs> getAllActive() throws DataAccessException {
        CriteriaBuilder cb = getManager().getCriteriaBuilder();
        CriteriaQuery<Utilisateurs> cq = cb.createQuery(Utilisateurs.class);
        Root<Utilisateurs> userRoot = cq.from(Utilisateurs.class);
        cq.where(cb.equal(userRoot.get(Utilisateurs_.active), 1));
        return getManager().createQuery(cq).getResultList();
    }

    @Override
    public Long count() throws DataAccessException {
        CriteriaBuilder cb = getManager().getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Utilisateurs> userRoot = cq.from(Utilisateurs.class);
        cq.where(cb.equal(userRoot.get(Utilisateurs_.active), 1));     
        cq.select(cb.count(userRoot));
        return getManager().createQuery(cq).getSingleResult();
    }
    
    
}
