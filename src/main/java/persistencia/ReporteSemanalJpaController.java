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
import logica.ReporteSemanal;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author tobar
 */
public class ReporteSemanalJpaController implements Serializable {

    public ReporteSemanalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public ReporteSemanalJpaController(){
        emf=Persistence.createEntityManagerFactory("persistencia");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ReporteSemanal reporteSemanal) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(reporteSemanal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ReporteSemanal reporteSemanal) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            reporteSemanal = em.merge(reporteSemanal);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = reporteSemanal.getId();
                if (findReporteSemanal(id) == null) {
                    throw new NonexistentEntityException("The reporteSemanal with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ReporteSemanal reporteSemanal;
            try {
                reporteSemanal = em.getReference(ReporteSemanal.class, id);
                reporteSemanal.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reporteSemanal with id " + id + " no longer exists.", enfe);
            }
            em.remove(reporteSemanal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ReporteSemanal> findReporteSemanalEntities() {
        return findReporteSemanalEntities(true, -1, -1);
    }

    public List<ReporteSemanal> findReporteSemanalEntities(int maxResults, int firstResult) {
        return findReporteSemanalEntities(false, maxResults, firstResult);
    }

    private List<ReporteSemanal> findReporteSemanalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ReporteSemanal.class));
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

    public ReporteSemanal findReporteSemanal(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ReporteSemanal.class, id);
        } finally {
            em.close();
        }
    }

    public int getReporteSemanalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ReporteSemanal> rt = cq.from(ReporteSemanal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
