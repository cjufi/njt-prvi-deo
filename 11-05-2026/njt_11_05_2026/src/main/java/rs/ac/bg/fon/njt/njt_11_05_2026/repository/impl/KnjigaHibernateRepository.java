package rs.ac.bg.fon.njt.njt_11_05_2026.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
@Repository("hibernate-repository")
public class KnjigaHibernateRepository implements KnjigaRepository {

    private final SessionFactory sf;

    @Autowired
    public KnjigaHibernateRepository(@Qualifier("sf")SessionFactory sf) {
        this.sf = sf;
    }
    
    @Override
    public Knjiga save(Knjiga knjiga) {      
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();

        Pisac pisac = session.find(Pisac.class, knjiga.getPisac().getId());
        if (pisac == null) {
            session.persist(knjiga.getPisac());
        }
        Izdavac izdavac = session.find(Izdavac.class, knjiga.getIzdavac().getId());
        if (izdavac == null) {
            session.persist(knjiga.getIzdavac());
        }

        session.persist(knjiga);

        tr.commit();
        session.close();
        return knjiga;
    }

    @Override
    public void delete(Knjiga knjiga) {
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();
        
        Knjiga dbKnjiga = session.find(Knjiga.class, knjiga.getId());
        if(dbKnjiga == null) {
            return;
        }
        session.remove(dbKnjiga);

        tr.commit();
        session.close();
    }

    @Override
    public Knjiga update(Knjiga knjiga) {
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();

        session.merge(knjiga);

        tr.commit();
        session.close();

        return knjiga;
    }

    @Override
    public boolean existsById(Long id) {
        Session session = sf.openSession();
        Knjiga knjiga = session.find(Knjiga.class, id);

        if (knjiga != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean existsByName(String name) {
        Session session = sf.openSession();

        Long count = session.createQuery(
                "SELECT COUNT(k) FROM Knjiga k WHERE k.naziv = :name",
                Long.class
        )
                .setParameter("name", name)
                .getSingleResult();

        return count > 0;
    }
}
