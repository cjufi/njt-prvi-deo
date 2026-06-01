package rs.ac.bg.fon.njt.njt_11_05_2026.domain;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 *
 * @author Filip
 */
@Entity
@Table(name = "izdavac")
@NamedQueries({
    @NamedQuery(name = "Izdavac.findAll", query = "SELECT i FROM Izdavac i")})
public class Izdavac implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "naziv")
    private String naziv;
    @Column(name = "pib")
    private String pib;
    @Column(name = "maticniBroj")
    private String maticniBroj;
    @Column(name = "sedisteFirme")
    private String sedisteFirme;
    
    public Izdavac() {
    }

    public Izdavac(Long id, String naziv, String pib, String maticniBroj, String sedisteFirme) {
        this.id = id;
        this.naziv = naziv;
        this.pib = pib;
        this.maticniBroj = maticniBroj;
        this.sedisteFirme = sedisteFirme;
    }

    public Izdavac(Long id) {
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

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getMaticniBroj() {
        return maticniBroj;
    }

    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }

    public String getSedisteFirme() {
        return sedisteFirme;
    }

    public void setSedisteFirme(String sedisteFirme) {
        this.sedisteFirme = sedisteFirme;
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
        if (!(object instanceof Izdavac)) {
            return false;
        }
        Izdavac other = (Izdavac) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.njt.njt_11_05_2026.domain.Izdavac[ id=" + id + " ]";
    }
    
}
