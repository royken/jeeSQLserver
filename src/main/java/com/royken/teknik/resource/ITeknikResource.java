package com.royken.teknik.resource;

import com.royken.teknik.entities.Utilisateurs;
import com.royken.teknik.entities.projections.BlocZ;
import com.royken.teknik.entities.projections.Element;
import com.royken.teknik.entities.projections.Organe;
import com.royken.teknik.entities.projections.SousOrgane;
import com.royken.teknik.entities.projections.ZoneP;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Path("teknik")
public interface ITeknikResource {
    
    @GET
    @Produces(value = "application/json")
    @Path(value = "users")
    List<Utilisateurs> getAllUsers();
    
    @GET
    @Produces(value = "application/json")
    @Path(value = "zones")
    List<ZoneP> getAllZone();
    
    @GET
    @Produces(value = "application/json")
    @Path(value = "blocs")
    List<BlocZ> getAllBlocs();
    
    @GET
    @Produces(value = "application/json")
    @Path(value = "organes")
    List<Organe> getAllOrganes();
    
    @GET
    @Produces(value = "application/json")
    @Path(value = "sousOrganes")
    List<SousOrgane> getAllSousOrgans();
    
    @GET
    @Produces(value = "application/json")
    @Path(value = "elements")
    List<Element> getAllElement();
}