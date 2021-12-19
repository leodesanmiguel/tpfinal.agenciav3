/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polo.logica;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Leo Martinez
 */
@Entity
@Table(name = "empleado")
public class Empleado extends Persona implements Serializable {

    /**
     * Los datos de los Empleados son de las personas.
     *
     * Agregamos una fecha de ingreso suponiendo que eso influye en su sueldo
     * por la antiguedad.
     *
     */
    @Temporal(TemporalType.TIME)
    private Date fechaIngreso;

    /**
     * El puesto empleado es calculado se asigna al momento de cargar un nuevo
     * empleado. Este podria tener un sueldo base y agregarle otras
     * asignaciones. Por ejemplo que antiguedad. puesto. Para eso hay que
     * calcular la antiguedad, a base de la fecha de ingreso. Cada empleado
     * tiene uno solo puesto.
     * <p>
     * Si llegara a cambiar el puesto de un empleado, iniciaria nuevamente la
     * fecha de ingreso y su correspondiente antiguedad.
     *
     */
    @ManyToOne
    private Puesto suPuesto;

    /**
     * El sueldo del empleado es calculado a base del sueldo base segun su
     * puesto.
     *
     */
    private double sueldo;

    /**
     * El Empleado se asocia con Usuario y se asigna una columna de clave
     * externa
     *
     * ref: ejemplo1
     * https://docs.oracle.com/javaee/7/api/javax/persistence/OneToOne.html
     */
//    @OneToOne(optional = false)
//    @JoinColumn(
//            name = "IDUSUARIO", unique = true,
//            nullable = false, updatable = false)
    @OneToOne
    private Usuario usuario;

    public Empleado() {
    }

    public Empleado(Date fechaIngreso,
            Puesto suPuesto) {

        this.fechaIngreso = fechaIngreso;

        this.suPuesto = suPuesto;
        if (suPuesto != null) {
            this.sueldo = calcularSueldo(suPuesto);
        }

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    

    public Date getFechaIngreso() {
        return fechaIngreso;

    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
        if (suPuesto != null) {
            this.sueldo = calcularSueldo(suPuesto);
        }
    }

    public double getSueldo() {
        return sueldo;
    }

    public Puesto getSuPuesto() {
        return suPuesto;
    }

    public void setSuPuesto(Puesto suPuesto) {
        this.suPuesto = suPuesto;
    }

    ////////////////////////////////////////////
    //  F U N C I O N E S 
    ////////////////////////////////////////////
    /**
     * Suponemos que Calcular el sueldo del empleado es en base al puesto y su
     * antiguedad. En este caso particular como no esta definido. la antiguedad
     * desprende un factor que es un x%
     *
     * Ej. El facctor es para
     *
     * 1 año = 1/100 --> 1%
     *
     * 10 años = 10/100 --> 10%.
     *
     * Simbolicamente para poder diferenciasr entre el sueldo base y el sueldo
     * del empleado si su fecha
     */
    private double calcularSueldo(Puesto suPuesto) {

        LocalDateTime alta = ld2D(this.getFechaIngreso());

        return suPuesto.getSueldoBase()
                * ((int) ChronoUnit.YEARS.between(
                        alta,
                        LocalDate.now()) / 100);
    }

    // Convertir una fecha de LocalDate a Date usando ZoneId del sistema
    public LocalDateTime ld2D(Date dateToConvert) {

        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    @Override
    public String toString() {
        return "Empleado{" + "fechaIngreso=" + fechaIngreso + ", suPuesto=" + suPuesto + ", sueldo=" + sueldo + '}';
    }

}
