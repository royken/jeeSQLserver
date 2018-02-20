package com.royken.teknik.dao;

import com.royken.generic.dao.DataAccessException;
import com.royken.generic.dao.IGenericDao;
import com.royken.teknik.entities.Elements;
import java.util.List;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
public interface IElementDao extends IGenericDao<Elements, Long>{
    
    public List<Elements> getAllActive() throws DataAccessException;
    
    public Long count() throws DataAccessException;
    
}
