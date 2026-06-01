package rs.ac.bg.fon.njt.njt_11_05_2026.dto;

import java.time.LocalDate;
import rs.ac.bg.fon.njt.njt_11_05_2026.domain.Izdavac;
import rs.ac.bg.fon.njt.njt_11_05_2026.domain.Pisac;

/**
 *
 * @author Filip
 */
public class KnjigaDto {
    
    private Long id;
    private String naziv;
    private LocalDate datumIzdavanja;
    private int tiraz;
    private Izdavac izdavac;
    private Pisac pisac;

    public KnjigaDto() {
    }

    public KnjigaDto(Long id, String naziv, LocalDate datumIzdavanja, int tiraz, Izdavac izdavac, Pisac pisac) {
        this.id = id;
        this.naziv = naziv;
        this.datumIzdavanja = datumIzdavanja;
        this.tiraz = tiraz;
        this.izdavac = izdavac;
        this.pisac = pisac;
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
}
