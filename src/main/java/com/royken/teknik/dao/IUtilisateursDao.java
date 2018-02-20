package com.royken.teknik.dao;

import com.royken.generic.dao.DataAccessException;
import com.royken.generic.dao.IGenericDao;
import com.royken.teknik.entities.Utilisateurs;
import java.util.List;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
public interface IUtilisateursDao extends IGenericDao<Utilisateurs, Long>{
    
    public List<Utilisateurs> getAllActive() throws DataAccessException;
    
    public Long count() throws DataAccessException;
    
}
