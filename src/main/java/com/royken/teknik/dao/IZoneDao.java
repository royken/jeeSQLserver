package com.royken.teknik.dao;

import com.royken.generic.dao.DataAccessException;
import com.royken.generic.dao.IGenericDao;
import com.royken.teknik.entities.Zone;
import java.util.List;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
public interface IZoneDao extends IGenericDao<Zone, Long>{
    
    public List<Zone> findAllActive() throws DataAccessException;
    
    public Long count() throws DataAccessException;
    
}
