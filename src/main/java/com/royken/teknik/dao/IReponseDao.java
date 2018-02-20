package com.royken.teknik.dao;

import com.royken.generic.dao.DataAccessException;
import com.royken.generic.dao.IGenericDao;
import com.royken.teknik.entities.Reponse;
import java.util.Date;
import java.util.List;
import org.hibernate.exception.DataException;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
public interface IReponseDao extends IGenericDao<Reponse, Long>{
    
    public List<Reponse> getBetweenDates(Date debut, Date fin) throws DataException;
    
}
