import Modelo.LoginDAO;
import Modelo.login;
import org.junit.Test;
import static org.junit.Assert.*;

public class NewEmptyJUnitTest {

    @Test
    public void testLoginCorrecto() {
        LoginDAO dao = new LoginDAO();
        login resultado = dao.log("123456@continental.edu.pe", "123"); // Usa credenciales válidas de tu BD
        assertNotNull(resultado);
        assertEquals("123456@continental.edu.pe", resultado.getCorreo());
    }

    @Test
    public void testLoginIncorrecto() {
        LoginDAO dao = new LoginDAO();
        login resultado = dao.log("123456@continental.edu.pe", "claveIncorrecta");
        assertNull(resultado.getCorreo()); // O ajusta según cómo manejes errores
    }
}
