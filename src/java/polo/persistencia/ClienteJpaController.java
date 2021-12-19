
package polo.persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import polo.logica.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import polo.logica.Cliente;
import polo.persistencia.exceptions.IllegalOrphanException;
import polo.persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Leo Martinez
 */
public class ClienteJpaController implements Serializable {

    public ClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public ClienteJpaController(){
        this.emf = Persistence.createEntityManagerFactory("TPFinalv2PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cliente cliente) {
        if (cliente.getCompras() == null) {
            cliente.setCompras(new ArrayList<Venta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Venta> attachedCompras = new ArrayList<Venta>();
            for (Venta comprasVentaToAttach : cliente.getCompras()) {
                comprasVentaToAttach = em.getReference(comprasVentaToAttach.getClass(), comprasVentaToAttach.getIdVenta());
                attachedCompras.add(comprasVentaToAttach);
            }
            cliente.setCompras(attachedCompras);
            em.persist(cliente);
            for (Venta comprasVenta : cliente.getCompras()) {
                Cliente oldCompradorOfComprasVenta = comprasVenta.getComprador();
                comprasVenta.setComprador(cliente);
                comprasVenta = em.merge(comprasVenta);
                if (oldCompradorOfComprasVenta != null) {
                    oldCompradorOfComprasVenta.getCompras().remove(comprasVenta);
                    oldCompradorOfComprasVenta = em.merge(oldCompradorOfComprasVenta);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cliente cliente) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente persistentCliente = em.find(Cliente.class, cliente.getIdPersona());
            List<Venta> comprasOld = persistentCliente.getCompras();
            List<Venta> comprasNew = cliente.getCompras();
            List<String> illegalOrphanMessages = null;
            for (Venta comprasOldVenta : comprasOld) {
                if (!comprasNew.contains(comprasOldVenta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Venta " + comprasOldVenta + " since its comprador field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Venta> attachedComprasNew = new ArrayList<Venta>();
            for (Venta comprasNewVentaToAttach : comprasNew) {
                comprasNewVentaToAttach = em.getReference(comprasNewVentaToAttach.getClass(), comprasNewVentaToAttach.getIdVenta());
                attachedComprasNew.add(comprasNewVentaToAttach);
            }
            comprasNew = attachedComprasNew;
            cliente.setCompras(comprasNew);
            cliente = em.merge(cliente);
            for (Venta comprasNewVenta : comprasNew) {
                if (!comprasOld.contains(comprasNewVenta)) {
                    Cliente oldCompradorOfComprasNewVenta = comprasNewVenta.getComprador();
                    comprasNewVenta.setComprador(cliente);
                    comprasNewVenta = em.merge(comprasNewVenta);
                    if (oldCompradorOfComprasNewVenta != null && !oldCompradorOfComprasNewVenta.equals(cliente)) {
                        oldCompradorOfComprasNewVenta.getCompras().remove(comprasNewVenta);
                        oldCompradorOfComprasNewVenta = em.merge(oldCompradorOfComprasNewVenta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = cliente.getIdPersona();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getIdPersona();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Venta> comprasOrphanCheck = cliente.getCompras();
            for (Venta comprasOrphanCheckVenta : comprasOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cliente (" + cliente + ") cannot be destroyed since the Venta " + comprasOrphanCheckVenta + " in its compras field has a non-nullable comprador field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
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

    public Cliente findCliente(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
