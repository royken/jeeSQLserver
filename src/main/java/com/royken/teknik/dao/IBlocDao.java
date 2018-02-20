package com.royken.teknik.dao;

import com.royken.generic.dao.DataAccessException;
import com.royken.generic.dao.IGenericDao;
import com.royken.teknik.entities.Bloc;
import java.util.List;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
public interface IBlocDao extends IGenericDao<Bloc, Long>{
    
    public List<Bloc> getAllActive() throws DataAccessException;
    
    public Long count() throws DataAccessException;
    
}
