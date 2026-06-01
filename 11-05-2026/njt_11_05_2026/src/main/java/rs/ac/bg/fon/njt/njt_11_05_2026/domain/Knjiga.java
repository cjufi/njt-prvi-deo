package rs.ac.bg.fon.njt.njt_11_05_2026.domain;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 *
 * @author Filip
 */
@Entity
@Table(name = "knjiga")
@NamedQueries({
    @NamedQuery(name = "Knjiga.findAll", query = "SELECT k FROM Knjiga k")})
public class Knjiga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "naziv")
    private String naziv;
    @Column(name = "datumIzdavanja")
//    @Temporal(TemporalType.DATE) --> ovo mora da se zakomentarise, i iz Date u LocalDate obavezno
    private LocalDate datumIzdavanja;
    @Column(name = "tiraz")
    private int tiraz;
    @JoinColumn(name = "izdavac", referencedColumnName = "id")
    @ManyToOne
    private Izdavac izdavac;
    @JoinColumn(name = "pisac", referencedColumnName = "id")
    @ManyToOne
    private Pisac pisac;

    public Knjiga() {
    }

    public Knjiga(Long id, String naziv, LocalDate datumIzdavanja, int tiraz, Izdavac izdavac, Pisac pisac) {
        this.id = id;
        this.naziv = naziv;
        this.datumIzdavanja = datumIzdavanja;
        this.tiraz = tiraz;
        this.izdavac = izdavac;
        this.pisac = pisac;
    }

    public Knjiga(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public LocalDate getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(LocalDate datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public int getTiraz() {
        return tiraz;
    }

    public void setTiraz(int tiraz) {
        this.tiraz = tiraz;
    }

    public Izdavac getIzdavac() {
        return izdavac;
    }

    public void setIzdavac(Izdavac izdavac) {
        this.izdavac = izdavac;
    }

    public Pisac getPisac() {
        return pisac;
    }

    public void setPisac(Pisac pisac) {
        this.pisac = pisac;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Knjiga)) {
            return false;
        }
        Knjiga other = (Knjiga) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.njt.njt_11_05_2026.domain.Knjiga[ id=" + id + " ]";
    }
    
}
