package rs.ac.bg.fon.njt.njt_11_05_2026.repository.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.njt.njt_11_05_2026.domain.Knjiga;
import rs.ac.bg.fon.njt.njt_11_05_2026.repository.KnjigaRepository;

/**
 *
 * @author Filip
 */
@Repository("jdbc-repository")
public class KnjigaJDBCRepository implements KnjigaRepository {
    
    private final Connection connection;

    @Autowired
    public KnjigaJDBCRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Knjiga save(Knjiga knjiga) {
        String query = "INSERT INTO knjiga VALUES(?,?,?,?,?)";
        PreparedStatement ps;
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, knjiga.getNaziv());
            ps.setDate(2, Date.valueOf(knjiga.getDatumIzdavanja()));
            ps.setInt(3, knjiga.getTiraz());
            ps.setLong(4, knjiga.getIzdavac().getId());
            ps.setLong(5, knjiga.getPisac().getId());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KnjigaJDBCRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return knjiga;
    }

    @Override
    public void delete(Knjiga knjiga) {
        String query = "DELETE FROM knjiga WHERE id = ?";
        PreparedStatement ps;
        
        try {
            ps = connection.prepareStatement(query);
            ps.setLong(1, knjiga.getId());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KnjigaJDBCRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean existsById(Long id) {
        String query = "SELECT * FROM knjiga WHERE id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(KnjigaJDBCRepository.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean existsByName(String name) {
        String query = "SELECT * FROM knjiga WHERE naziv = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(KnjigaJDBCRepository.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Knjiga update(Knjiga knjiga) {
        String query = """
                   UPDATE knjiga
                   SET naziv = ?,
                       datum_izdavanja = ?,
                       tiraz = ?,
                       izdavac_id = ?,
                       pisac_id = ?
                   WHERE id = ?
                   """;

        try {
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, knjiga.getNaziv());
            ps.setDate(2, Date.valueOf(knjiga.getDatumIzdavanja()));
            ps.setInt(3, knjiga.getTiraz());
            ps.setLong(4, knjiga.getIzdavac().getId());
            ps.setLong(5, knjiga.getPisac().getId());
            ps.setLong(6, knjiga.getId());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(KnjigaJDBCRepository.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

        return knjiga;
    }
}
