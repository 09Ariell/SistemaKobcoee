/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import logica.Ropa;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author tobar
 */
public class RopaJpaController implements Serializable {

    public RopaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public RopaJpaController(){
        emf=Persistence.createEntityManagerFactory("persistencia");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ropa ropa) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ropa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ropa ropa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ropa = em.merge(ropa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = ropa.getId();
                if (findRopa(id) == null) {
                    throw new NonexistentEntityException("The ropa with id " + id + " no longer exists.");
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
            Ropa ropa;
            try {
                ropa = em.getReference(Ropa.class, id);
                ropa.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ropa with id " + id + " no longer exists.", enfe);
            }
            em.remove(ropa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ropa> findRopaEntities() {
        return findRopaEntities(true, -1, -1);
    }

    public List<Ropa> findRopaEntities(int maxResults, int firstResult) {
        return findRopaEntities(false, maxResults, firstResult);
    }

    private List<Ropa> findRopaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ropa.class));
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

    public Ropa findRopa(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ropa.class, id);
        } finally {
            em.close();
        }
    }

    public int getRopaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ropa> rt = cq.from(Ropa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
