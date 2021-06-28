package ma.ceft.giftBox_Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MConnection {
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tr;

    public MConnection() {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        tr = em.getTransaction();
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public EntityManager getEm() {
        return em;
    }

    public EntityTransaction getTr() {
        return tr;
    }
}
