
package polo.logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Leo Martinez
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Persona implements Serializable {

    /**
     * Cada persona tien un ID y su correspondiente DNI Luego se requerirá que
     * evalue si no se habla de la misma persona. Con esto se permite que se
     * carguen los DNI como atributo nullable
     *
     * Este Id se genera solo. Solo se puede recuperar el nro
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersona;

    private String nombreP;
    private String apellidoP;
    private String direccionP;
    private int dni;

    @Temporal(TemporalType.DATE)
    private Date fechaNacio;

    private String nacionalidad;
    private String celular;
    private String email;

    public Persona() {

    }

    public Persona(String nombreP, String apellidoP
            , String direccionP, int dni, Date fechaNacio
            , String nacionalidad, String celular, String email) {
        //this.idCliente = idCliente;
        this.nombreP = nombreP;
        this.apellidoP = apellidoP;
        this.direccionP = direccionP;
        this.dni = dni;
        this.fechaNacio = fechaNacio;
        this.nacionalidad = nacionalidad;
        this.celular = celular;
        this.email = email;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    
    public int getIdCliente() {
        return idPersona;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getDireccionP() {
        return direccionP;
    }

    public void setDireccionP(String direccionP) {
        this.direccionP = direccionP;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Date getFechaNacio() {
        return fechaNacio;
    }

    public void setFechaNacio(Date fechaNacio) {
        this.fechaNacio = fechaNacio;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombreP=" + nombreP + ", apellidoP=" + apellidoP 
                + "\n direccionP=" + direccionP + ", dni=" + dni 
                + ", fechaNacio=" + fechaNacio + ", nacionalidad=" + nacionalidad 
                + ", celular=" + celular + ", email=" + email + '}';
    }

}
