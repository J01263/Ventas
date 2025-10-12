public class LoginService {

    public boolean validar(String correo, String clave) {
        if (correo == null || clave == null || correo.isEmpty() || clave.isEmpty()) {
            return false;
        }

        // Simulación: usuario correcto es "admin", clave "1234"
        return correo.equals("admin") && clave.equals("1234");
    }
}
