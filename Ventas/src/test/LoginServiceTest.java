import org.junit.Test;
import static org.junit.Assert.*;

public class LoginServiceTest {

    @Test
    public void pruebaLoginCorrecto() {
        LoginService servicio = new LoginService();
        boolean resultado = servicio.validar("admin", "1234");
        assertTrue(resultado);
    }

    @Test
    public void pruebaLoginIncorrecto() {
        LoginService servicio = new LoginService();
        boolean resultado = servicio.validar("admin", "claveIncorrecta");
        assertFalse(resultado);
    }
}
