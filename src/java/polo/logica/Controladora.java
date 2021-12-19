package polo.logica;

import java.util.List;
import polo.persistencia.ControladoraPersistencia;

/**
 *
 * @author Leo Martinez
 */
public class Controladora {

    ControladoraPersistencia ctrlJPA = new ControladoraPersistencia();

    //////////////////////////////////////////////////////////////
    //  CONTROL DE LA LÓGICA
    //////////////////////////////////////////////////////////////
    public boolean verificarAdmin(String usuario, String password) {
        ctrlJPA.crearBases();
        return ctrlJPA.esAdmin(usuario, password);

    }

    public boolean verificarJefe(String usuario, String password) {

        return false;
    }

    public boolean verificarVendedor(String usuario, String password) {

        return false;
    }

    public boolean verificarUsuario(String usuario, String password) {

        return false;
    }

    public Usuario crearAdmin(Persona pers, String admin, Usuario usua) {

        System.out.println("\n++++++ Creando ADMIN +++++++++++++++");
        System.out.println("\n ----> Peresona  que viene..: " + pers);
        System.out.println("\n       Usuario que viene....: " + usua);

        Empleado emple = new Empleado();
        emple.setApellidoP(pers.getApellidoP());
        emple.setCelular(pers.getCelular());
        emple.setDireccionP(pers.getDireccionP());
        emple.setDni(pers.getDni());
        emple.setEmail(pers.getEmail());
        emple.setNacionalidad(pers.getNacionalidad());
        emple.setFechaIngreso(pers.getFechaNacio());
        emple.setNombreP(pers.getNombreP());
        // returno el id del usuario
        return ctrlJPA.crearEmpleado(emple, usua);

    }

    public List<Usuario> traerJefes() {
        // En este caso trae los JEFES
        return ctrlJPA.traerUsuarios("Jefe");
    }

    public Empleado traeAdmin(Usuario usr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
