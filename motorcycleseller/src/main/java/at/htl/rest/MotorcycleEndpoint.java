package at.htl.rest;

import at.htl.business.MotorcycleFacade;
import at.htl.model.Motorcycle;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/motorcycle")
public class MotorcycleEndpoint {

    @Inject
    EntityManager em;

    @Inject
    MotorcycleFacade motorcycleFacade;

    @GET
    @Path("/getMotorcycles")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Motorcycle> getMotorcycles() {
        return motorcycleFacade.getAll();
    }

    @POST
    @Path("/insert")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertMotorcycle(Motorcycle motorcycle) {
        motorcycleFacade.safe(motorcycle);
        return Response.ok().entity(motorcycle).build();
    }

    @PUT
    @Path("/update/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateMotorcycle(@PathParam("id")long id, Motorcycle motorcycle) {
        if(motorcycle == null || em.find(Motorcycle.class, id) == null) {
            return Response.serverError().build();
        }
        else {
            motorcycle.hp = 100;
            motorcycleFacade.update(motorcycle);
            return Response.ok().entity(em.find(Motorcycle.class, id)).build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public void deleteMotorcycle(@PathParam("id")String id) {
        Motorcycle m = em.find(Motorcycle.class, id);
        if(m != null) {
            motorcycleFacade.delete(m);
        }
    }
}
