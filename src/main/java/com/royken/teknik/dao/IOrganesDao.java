package com.royken.teknik.dao;

import com.royken.generic.dao.DataAccessException;
import com.royken.generic.dao.IGenericDao;
import com.royken.teknik.entities.Organes;
import java.util.List;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
public interface IOrganesDao extends IGenericDao<Organes, Long>{
    
    public List<Organes> getAllActive() throws DataAccessException;
    
    public Long count() throws DataAccessException;
}
