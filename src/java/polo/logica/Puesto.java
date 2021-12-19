
package polo.logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import polo.logica.enumera.Cargo;

/**
 *
 * @author Leo Martinez
 */
@Entity
@Table(name = "puesto")
public class Puesto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPuesto;

    /**
     * Cada puesto tiene un nombre. Se supone que cada puesto tiene un cargo
     */
    @Enumerated(EnumType.ORDINAL)
    private Cargo cargo;

    /**
     * Cada puesto tiene una tarea. Puede revivar en una lista de tareas.
     */
    private String tarea;

    /**
     * El sueldo base es la base de cada puesto. En este caso se asignará como
     * sueldo base al momento de asignar un nuevo puesto.
     */
    private double sueldoBase;

    /**
     * Se podria revisar los emleados que estan en este puesto.
     */
    @OneToMany
    private List<Empleado> empleado;

    public Puesto() {
    }

    public Puesto(Cargo cargo, String tarea, double sueldoBase) {

        this.cargo = cargo;
        this.tarea = tarea;
        this.sueldoBase = sueldoBase;

    }
    
    

    public int getIdPuesto() {
        return idPuesto;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public List<Empleado> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(List<Empleado> empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Puesto{" + "idPuesto=" + idPuesto + ", cargo=" + cargo + ", sueldoBase=" + sueldoBase + '}';
    }

}
