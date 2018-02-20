package com.royken.teknik.dao;

import com.royken.generic.dao.DataAccessException;
import com.royken.generic.dao.IGenericDao;
import com.royken.teknik.entities.SousOrganes;
import java.util.List;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
public interface ISousOrganesDao extends IGenericDao<SousOrganes, Long>{
    
    public List<SousOrganes> getAllActive() throws DataAccessException;
    
    public Long count() throws DataAccessException;
}
