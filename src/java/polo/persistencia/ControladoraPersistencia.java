package polo.persistencia;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import polo.logica.Empleado;
import polo.logica.FormaDPago;
import polo.logica.Puesto;
import polo.logica.Servicio;
import polo.logica.Usuario;
import polo.logica.enumera.Cargo;
import polo.logica.enumera.MediosDPago;
import polo.logica.enumera.TipoDServicios;
import polo.persistencia.exceptions.IllegalOrphanException;

/**
 *
 * @author Leo Martinez
 */
public class ControladoraPersistencia {

    //////////////////////////////////////////////////////////////
    //  CONTROL DE PERSISTENCIA
    //////////////////////////////////////////////////////////////
    // personas clientes --> Podria estar Package Clientes
    PersonaJpaController persJPA = new PersonaJpaController();
    FormaDPagoJpaController forpJPA = new FormaDPagoJpaController();
    ClienteJpaController clieJPA = new ClienteJpaController();
    // Empleados y usuarios --> Podria estar Package Empleados
    PuestoJpaController puestJPA = new PuestoJpaController();
    EmpleadoJpaController empleJPA = new EmpleadoJpaController();
    UsuarioJpaController userJPA = new UsuarioJpaController();
    // Productos y Servicios --> Podria estar Package Productos
    ServicioJpaController serviJPA = new ServicioJpaController();
    PaqueteJpaController paqueJPA = new PaqueteJpaController();
    VentaJpaController ventaJPA = new VentaJpaController();
    //////////////////////////////////////////////////////////////

    /**
     * INICIANDO
     * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     * Esto tiene tres niveles de seguridad solo para este trabajo
     * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     *
     * ADMIN: puede crear a los JEFEs
     *
     * esAdmin: Si está creado admin, verifica su contraseña.Sino Crear un admin
     * con nombre y apellido y datos de la persona
     *
     * @param usuario
     * @param password
     * @return
     */
    public boolean esAdmin(String usuario, String password) {

        boolean seCreoAdmin = false;
        List<Usuario> users = userJPA.findUsuarioEntities();
        for (Usuario u : users) {
            if (u.getNombreUsr().equals(usuario) || u.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    /**
     * CREANDO BASES INICIALES
     * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     * PERMITE CREAR DATOS DEL SISTEMA EN FORMA AUTOMÁTICA
     * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     *
     */
    public void crearBases() {

        //  Crear FORMAS DE PAGO
        crearFormasDPago();
        //  Crear PUESTOS DE TRABAJO básicos  y fijos
        crearPuestos();
        //  Crear SERVICIOS pautados en el PDF
        crearServicios();
    }

    /**
     * Formas de Pago
     *
     * Recorre cada Medio de pago y genera un registro. Esto lo hace por unica
     * vez
     *
     */
    private void crearFormasDPago() {
        try {
            MediosDPago[] medios = MediosDPago.values();

            for (MediosDPago medio : medios) {
                List<FormaDPago> formas = forpJPA.findFormaDPagoEntities();
                boolean cc = false;

                for (FormaDPago f : formas) {

//                    BigDecimal comis = BigDecimal.valueOf(medio.getComision() * 10000);
//                    comis = comis.divide(BigDecimal.valueOf(100));
                    if (f.getMedioDPago() == medio) {
                        cc = true;
                        break;
                    }
                }
                if (!cc) {
                    FormaDPago forma = new FormaDPago(medio);
                    forpJPA.create(forma);
                }
            }

        } catch (Exception e) {
            System.out.println("\n****"
                    + "********  No se Creo la forma de Pago .....\n");
        }
    }

    /**
     * Puesto de Empleo
     *
     * Recorre cada Puesto y genera un registro. Esto lo hace por unica vez
     *
     */
    private void crearPuestos() {
        try {
            Cargo[] cargos = Cargo.values();

            for (Cargo cargo : cargos) {
                List<Puesto> puestos = puestJPA.findPuestoEntities();
                boolean cc = false;

                for (Puesto f : puestos) {

                    if (f.getCargo() == cargo) {
                        cc = true;
                        break;
                    }
                }
                if (!cc) {
                    Puesto puesto = new Puesto();
                    puesto.setCargo(cargo);
                    puesto.setSueldoBase(10);
                    puesto.setTarea("completar");
                    puestJPA.create(puesto);
                }
            }

        } catch (Exception e) {
            System.out.println("\n****"
                    + "********  No se Creo la forma de Pago .....\n");
        }
    }

    /**
     * Servicios
     *
     * Recorre cada Seervicio y genera un registro. Esto lo hace por unica vez
     *
     */
    private void crearServicios() {
        try {
            TipoDServicios[] tservicios = TipoDServicios.values();

            for (TipoDServicios t : tservicios) {
                List<Servicio> servicios = serviJPA.findServicioEntities();
                boolean cc = false;

                for (Servicio f : servicios) {

                    if (f.getNombreServ() == t) {
                        cc = true;
                        break;
                    }
                }
                if (!cc) {
                    Servicio servi = new Servicio();
                    servi.setCostoS(20);
                    servi.setDescripcionServ("poner descripción");
                    servi.setDestinoS("poner destino");
                    servi.setNombreServ(t);
                    serviJPA.create(servi);
                }
            }

        } catch (Exception e) {
            System.out.println("\n****"
                    + "********  No se Creo la forma de Pago .....\n");
        }
    }

    //////////////////////////////////////////////////////////////
    //  EMPLEADOS
    //////////////////////////////////////////////////////////////
    /**
     * Crear Empleado
     *
     *
     * @param emple
     * @param usua
     * @return 
     */
    public Usuario crearEmpleado(Empleado emple, Usuario usua) {
        Usuario usr = new Usuario();
        try {
            System.out.println("\n++++++ Creando Empleado +++++++++++++++");
            System.out.println("\n ----> Empleado  que viene..: " + emple);
            System.out.println("\n       Usuario que viene....: " + usua);

            List<Empleado> xxs = empleJPA.findEmpleadoEntities();
            boolean cc = false;

            for (Empleado x : xxs) {

                if (x.getDni() == emple.getDni()) {
                    cc = true;
                    break;
                }
            }
            if (!cc) {
                System.out.println("No encontré Empleado");
                Empleado em = new Empleado();

                double sueldo = 0;
                List<Puesto> puestos = puestJPA.findPuestoEntities();
                for (Puesto pu : puestos) {
                    System.out.println("Puesto: " + pu
                            + "cargo: " + emple.getSuPuesto());
                    if (pu.equals(emple.getSuPuesto())) {
                        em.setSuPuesto(pu);
                        sueldo = pu.getSueldoBase() * 1.1;
                        System.out.println("\n Empleado con puesto: " + em);
                        break;
                    }
                }
                if (!existeUsuario(usua)) {
                    userJPA.create(usua);
                }
                em.setUsuario(usua);
                System.out.println("\n Empleado con USUARIO: " + em);
                empleJPA.create(em);

                List<Usuario> uss = userJPA.findUsuarioEntities();
                for (Usuario u : uss) {
                    if (usua.equals(u)) {
                        usr = u;
                    }
                }
                return usr;

            }

        } catch (IllegalOrphanException e) {
            System.out.println("\n****"
                    + "********  No se Creo el empleado con usuario .....\n");
        }
        return null;

    }

    public boolean existeUsuario(Usuario usua) {
        boolean existe = false;
        List<Usuario> uss = userJPA.findUsuarioEntities();

        for (Usuario u : uss) {
            if (u.getNombreUsr().equals(usua.getNombreUsr()) || u.getPassword().equals(usua.getPassword())) {
                System.out.println("El usuario EXISTE !!" + u);
                existe = true;
                break;
            }
        }
        return existe;
    }

    /**
     * Trae Usuarios: solo los indicados por usr
     *
     * supuestamente no pueden ver todos los usuarios Admin ve solo Jefes Jefes
     * ve solo Vendedores
     *
     * @param usr
     * @return
     */
    public List<Usuario> traerUsuarios(String usr) {
        List<Usuario> jefes = new ArrayList<>();
        List<Usuario> uss = userJPA.findUsuarioEntities();
        uss.forEach(u -> {
            Empleado em = u.getEmpleado();
            Puesto pu = em.getSuPuesto();
            if (pu.getCargo().equals(usr)) {
                jefes.add(u);
            }
        });
        return jefes;
    }

}
