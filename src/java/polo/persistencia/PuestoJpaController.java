/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polo.persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import polo.logica.Empleado;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import polo.logica.Puesto;
import polo.persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author profl
 */
public class PuestoJpaController implements Serializable {

    public PuestoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
  
    public PuestoJpaController(){
        this.emf = Persistence.createEntityManagerFactory("TPFinalv2PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Puesto puesto) {
        if (puesto.getEmpleado() == null) {
            puesto.setEmpleado(new ArrayList<Empleado>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Empleado> attachedEmpleado = new ArrayList<Empleado>();
            for (Empleado empleadoEmpleadoToAttach : puesto.getEmpleado()) {
                empleadoEmpleadoToAttach = em.getReference(empleadoEmpleadoToAttach.getClass(), empleadoEmpleadoToAttach.getIdPersona());
                attachedEmpleado.add(empleadoEmpleadoToAttach);
            }
            puesto.setEmpleado(attachedEmpleado);
            em.persist(puesto);
            for (Empleado empleadoEmpleado : puesto.getEmpleado()) {
                Puesto oldSuPuestoOfEmpleadoEmpleado = empleadoEmpleado.getSuPuesto();
                empleadoEmpleado.setSuPuesto(puesto);
                empleadoEmpleado = em.merge(empleadoEmpleado);
                if (oldSuPuestoOfEmpleadoEmpleado != null) {
                    oldSuPuestoOfEmpleadoEmpleado.getEmpleado().remove(empleadoEmpleado);
                    oldSuPuestoOfEmpleadoEmpleado = em.merge(oldSuPuestoOfEmpleadoEmpleado);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Puesto puesto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Puesto persistentPuesto = em.find(Puesto.class, puesto.getIdPuesto());
            List<Empleado> empleadoOld = persistentPuesto.getEmpleado();
            List<Empleado> empleadoNew = puesto.getEmpleado();
            List<Empleado> attachedEmpleadoNew = new ArrayList<Empleado>();
            for (Empleado empleadoNewEmpleadoToAttach : empleadoNew) {
                empleadoNewEmpleadoToAttach = em.getReference(empleadoNewEmpleadoToAttach.getClass(), empleadoNewEmpleadoToAttach.getIdPersona());
                attachedEmpleadoNew.add(empleadoNewEmpleadoToAttach);
            }
            empleadoNew = attachedEmpleadoNew;
            puesto.setEmpleado(empleadoNew);
            puesto = em.merge(puesto);
            for (Empleado empleadoOldEmpleado : empleadoOld) {
                if (!empleadoNew.contains(empleadoOldEmpleado)) {
                    empleadoOldEmpleado.setSuPuesto(null);
                    empleadoOldEmpleado = em.merge(empleadoOldEmpleado);
                }
            }
            for (Empleado empleadoNewEmpleado : empleadoNew) {
                if (!empleadoOld.contains(empleadoNewEmpleado)) {
                    Puesto oldSuPuestoOfEmpleadoNewEmpleado = empleadoNewEmpleado.getSuPuesto();
                    empleadoNewEmpleado.setSuPuesto(puesto);
                    empleadoNewEmpleado = em.merge(empleadoNewEmpleado);
                    if (oldSuPuestoOfEmpleadoNewEmpleado != null && !oldSuPuestoOfEmpleadoNewEmpleado.equals(puesto)) {
                        oldSuPuestoOfEmpleadoNewEmpleado.getEmpleado().remove(empleadoNewEmpleado);
                        oldSuPuestoOfEmpleadoNewEmpleado = em.merge(oldSuPuestoOfEmpleadoNewEmpleado);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = puesto.getIdPuesto();
                if (findPuesto(id) == null) {
                    throw new NonexistentEntityException("The puesto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Puesto puesto;
            try {
                puesto = em.getReference(Puesto.class, id);
                puesto.getIdPuesto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The puesto with id " + id + " no longer exists.", enfe);
            }
            List<Empleado> empleado = puesto.getEmpleado();
            for (Empleado empleadoEmpleado : empleado) {
                empleadoEmpleado.setSuPuesto(null);
                empleadoEmpleado = em.merge(empleadoEmpleado);
            }
            em.remove(puesto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Puesto> findPuestoEntities() {
        return findPuestoEntities(true, -1, -1);
    }

    public List<Puesto> findPuestoEntities(int maxResults, int firstResult) {
        return findPuestoEntities(false, maxResults, firstResult);
    }

    private List<Puesto> findPuestoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Puesto.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Puesto findPuesto(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Puesto.class, id);
        } finally {
            em.close();
        }
    }

    public int getPuestoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Puesto> rt = cq.from(Puesto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
