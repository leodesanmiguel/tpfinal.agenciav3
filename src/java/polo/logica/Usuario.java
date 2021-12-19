/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polo.logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Leo Martinez
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDUSUARIO")
    int idUser;

    String nombreUsr;
    String password;

    @Temporal(TemporalType.DATE)
    Date altaU;
    boolean activo;

    /**
     * El Empleado se asocia con Usuario y se asigna una columna de clave
     * externa
     *
     * ref: ejemplo1
     * https://docs.oracle.com/javaee/7/api/javax/persistence/OneToOne.html
     */
    
    @OneToOne
    Empleado empleado;

    /**
     * Cada Usuario tiene asignado una o mas ventas
     *
     * ref: Example 1: One-to-Many association using generics
     * https://docs.oracle.com/javaee/7/api/javax/persistence/OneToMany.html
     */
    @OneToMany(cascade = CascadeType.ALL)
    private List<Venta> ventas;
    
    public Usuario(){
        
    }

    public Usuario(int idUser, String nombreUsr, String password
            , Date altaU, boolean activo) {
        this.idUser = idUser;
        this.nombreUsr = nombreUsr;
        this.password = password;
        this.altaU = altaU;
        this.activo = activo;

    }
    
    

    public int getIdUser() {
        return idUser;
    }



    public String getNombreUsr() {
        return nombreUsr;
    }

    public void setNombreUsr(String nombreUsr) {
        this.nombreUsr = nombreUsr;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getAltaU() {
        return altaU;
    }

    public void setAltaU(Date altaU) {
        this.altaU = altaU;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUser=" + idUser + ", nombreUsr=" + nombreUsr + ", password=" + password + ", altaU=" + altaU + ", activo=" + activo + ", empleado=" + empleado + '}';
    }
    
    

}
