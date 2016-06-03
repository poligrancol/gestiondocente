/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.poli.prap.gd.data.service;

import edu.poli.prap.gd.data.Profesor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author julianolarte
 */
@Stateless
@Path("profesor")
@Produces({"application/xml", "application/json"})
public class ProfesorFacadeREST extends AbstractFacade<Profesor> {
    @PersistenceContext(unitName = "LogicaPU")
    private EntityManager em;

    public ProfesorFacadeREST() {
        super(Profesor.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Profesor entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Long id, Profesor entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    public Profesor find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    public List<Profesor> findAll() {
        return super.findAll();
    }

    /**
     * Find a list of teachers given certain parameters.
     *
     * <code>
     *
     *      /profesor/buscar?first_name=John&last_name=Doe&document_number=576944&gender=masculino
     *
     * </code>
     *
     * @return Procesor list
     */
    @GET
    @Path("buscar")
    public List<Profesor> search(
        @DefaultValue("") @QueryParam("first_name") String first_name,
        @DefaultValue("") @QueryParam("last_name") String last_name,
        @DefaultValue("") @QueryParam("document_number") String document_number,
        @DefaultValue("") @QueryParam("email") String email
    ) {
        // Returns a list of teacher filterd by GET parameters.
        return em.createNamedQuery("Profesor.findByParams")
            .setParameter("first_name", "%" + first_name + "%")
            .setParameter("last_name", "%" + last_name + "%")
            .setParameter("document_number", "%" + document_number + "%")
            // .setParameter("email", "%" + email + "%")
            .getResultList();
    }

    @GET
    @Path("{from}/{to}")
    public List<Profesor> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
