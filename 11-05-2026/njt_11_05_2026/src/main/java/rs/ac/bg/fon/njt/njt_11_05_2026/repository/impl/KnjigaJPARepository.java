package rs.ac.bg.fon.njt.njt_11_05_2026.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.njt.njt_11_05_2026.domain.Izdavac;
import rs.ac.bg.fon.njt.njt_11_05_2026.domain.Knjiga;
import rs.ac.bg.fon.njt.njt_11_05_2026.domain.Pisac;
import rs.ac.bg.fon.njt.njt_11_05_2026.repository.KnjigaRepository;

/**
 *
 * @author Filip
 */
@Repository("jpa-repository")
public class KnjigaJPARepository implements KnjigaRepository {

    private final EntityManagerFactory emf;
    
    @Autowired
    public KnjigaJPARepository(@Qualifier("emf")EntityManagerFactory emf) {
        this.emf = emf;
    }
    
//    PERSIST
    @Override
    public Knjiga save(Knjiga knjiga) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Pisac pisac = em.find(Pisac.class, knjiga.getPisac().getId());
        if (pisac == null) {
            em.persist(knjiga.getPisac());
        }
        Izdavac izdavac = em.find(Izdavac.class, knjiga.getIzdavac().getId());
        if (izdavac == null) {
            em.persist(knjiga.getIzdavac());
        }
        
        em.persist(knjiga);
        em.getTransaction().commit();
        em.close();
        return knjiga;
    }

//    REMOVE
    @Override
    public void delete(Knjiga knjiga) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Knjiga dbKnjiga = em.find(Knjiga.class, knjiga.getId());
        if(dbKnjiga == null) {
            return;
        }
        em.remove(dbKnjiga);

        em.getTransaction().commit();
        em.close();
    }

//    MERGE
    @Override
    public Knjiga update(Knjiga knjiga) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(knjiga);
        
        em.getTransaction().commit();
        em.close();

        return knjiga;
    }

    @Override
    public boolean existsById(Long id) {
        EntityManager em = emf.createEntityManager();

        Knjiga knjiga = em.find(Knjiga.class, id);

        if (knjiga != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean existsByName(String name) {
        EntityManager em = emf.createEntityManager();

        Long count = em.createQuery(
                "SELECT COUNT(k) FROM Knjiga k WHERE k.naziv = :name",
                Long.class
        )
                .setParameter("name", name)
                .getSingleResult();

        return count > 0;
    }
    
}
