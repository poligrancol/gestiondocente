
package edu.poli.prap.gd.data.service;

import edu.poli.prap.gd.data.Profesor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author julianolarte
 */
@Stateless
@Path("profesor")
@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
@Consumes(MediaType.APPLICATION_JSON)
public class ProfesorFacadeREST extends AbstractFacade<Profesor> {

    @PersistenceContext(unitName = "LogicaPU")
    private EntityManager em;

    public ProfesorFacadeREST() {
        super(Profesor.class);
    }

    @POST
    @Override
    public void create(Profesor entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
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
    @Path("buscar/{parametro}")
    public List<Profesor> search(@PathParam("parametro") String param
    ) {
        Query query = null;
        if (!param.equals("vacio")) {

            try {
                long parametro = Long.parseLong(param);

                query = em.createQuery(" SELECT p"
                        + "   FROM Profesor p"
                        + "  WHERE (p.celular) = :celular"
                        + "     OR (p.numeroDocumento) = :numeroDocumento"
                        + "     OR (p.telefonoFijo) = :telefonoFijo").setParameter("celular", parametro)
                        .setParameter("numeroDocumento", parametro).setParameter("telefonoFijo", parametro);
            } catch (Exception e) {
                query = em.createQuery(" SELECT p"
                        + "   FROM Profesor p"
                        + "  WHERE UPPER(p.nombre) like :nombre"
                        + "     OR UPPER(p.apellido) like :apellido"
                        + "     OR UPPER(p.genero) like :genero"
                        + "     OR UPPER(p.estadoCivil) like :estado"
                        + "     OR UPPER(p.emailPersonal) like :emailp"
                        + "     OR UPPER(p.emailInstitucional) like :emaili"
                        + "     OR UPPER(p.direccion) like :direccion").setParameter("nombre", "%" + param.toUpperCase() + "%")
                        .setParameter("apellido", "%" + param.toUpperCase() + "%").setParameter("genero", "%" + param.toUpperCase() + "%")
                        .setParameter("estado", "%" + param.toUpperCase() + "%").setParameter("emailp", "%" + param.toUpperCase() + "%")
                        .setParameter("emaili", "%" + param.toUpperCase() + "%").setParameter("direccion", "%" + param.toUpperCase() + "%");
            }
        } else {
            return super.findAll();
        }
        List<Profesor> lista = query.getResultList();
        return lista;
    }

    @GET
    @Path("{from}/{to}")
    public List<Profesor> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
