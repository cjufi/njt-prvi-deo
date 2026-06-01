package rs.ac.bg.fon.njt.njt_11_05_2026.exception;

/**
 *
 * @author Filip
 */
public class KnjigaDoesNotExistException extends RuntimeException {

    public KnjigaDoesNotExistException(String poruka) {
        super(poruka);
    }
}
