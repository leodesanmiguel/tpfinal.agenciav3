package polo.logica;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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

        System.out.println("\n------- Creando "+ admin +" ----------------");
        System.out.println("\n ----> Peresona  que viene..: " + pers);
        System.out.println("\n       Usuario que viene....: " + usua);

        
        
        Empleado emple = new Empleado();
        emple.setApellidoP(pers.getApellidoP());
        emple.setCelular(pers.getCelular());
        emple.setDireccionP(pers.getDireccionP());
        emple.setDni(pers.getDni());
        emple.setEmail(pers.getEmail());
        emple.setNacionalidad(pers.getNacionalidad());
        emple.setFechaIngreso(usua.getAltaU());
        emple.setNombreP(pers.getNombreP());
        
        Puesto suP = ctrlJPA.traerPuesto(admin);
        System.out.println("Encontrol este puesto: " + suP);
        emple.setSuPuesto(suP);
        
        // retorna el usuario completo
        System.out.println("\n --->  desde la Controladora:\n"
                + "empleado listo para crar:\n " + emple);

        return ctrlJPA.crearEmpleado(emple, usua);

    }

    public List<Usuario> traerJefes() {
        // En este caso trae los JEFES
        return ctrlJPA.traerUsuarios("JEFE");
    }

    public Empleado traeAdmin(Usuario usr) {
        
        return ctrlJPA.traerAdmin(usr.getEmpleado());
    }

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

}
