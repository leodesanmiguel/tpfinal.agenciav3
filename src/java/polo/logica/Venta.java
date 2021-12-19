package polo.logica;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;


import javax.persistence.OneToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import polo.logica.enumera.TipoDContratacion;

/**
 *
 * @author Leo Martinez
 */
@Entity
@Table(name = "venta")
public class Venta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IDVENTA")
    private int idVenta;

    @Temporal(TemporalType.DATE)
    private Date fechaVenta;

    @Temporal(TemporalType.TIME)
    private Date horaVenta;

    private double importe;
    private boolean estaPago;

    /**
     * Cada venta tiene un cliente como comprador
     */
    @ManyToOne
    @JoinColumn(name = "IDPERSONA", nullable = false)
    private Cliente comprador;

    /**
     * Cada venta tiene un usuario que es empleado y tiene la funcion de
     * vendedor
     *
     */
    @ManyToOne
    @JoinColumn(name = "IDUSUARIO", nullable = false)
    private Usuario usuario;

    /**
     * Cada venta se realiza en forma individual o de forma de paquete.
     */
    @Enumerated(EnumType.ORDINAL)
    private TipoDContratacion tipoContratacion;

    /**
     * Un paquete puede tener un solo servicio o puede tener varios servicios
     * juntos. De forma que todas las ventas tienen un paquete.<p>
     * Todas las ventas tienen un solo paquete
     */
    @ManyToOne(targetEntity = Paquete.class)
    @JoinColumn(name = "IDPAQUETE")
    private Paquete paquete;

    public Venta() {
    }

    public Venta(Date fechaVenta, Date horaVenta,
            Cliente comprador, Usuario usuario,
            Paquete paquete) {

        this.fechaVenta = fechaVenta;
        this.horaVenta = horaVenta;
        this.comprador = comprador;
        this.usuario = usuario;
        this.paquete = paquete;
    }

    
    public int getIdVenta() {
        return idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Date getHoraVenta() {
        return horaVenta;
    }

    public void setHoraVenta(Date horaVenta) {
        this.horaVenta = horaVenta;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public boolean isEstaPago() {
        return estaPago;
    }

    public void setEstaPago(boolean estaPago) {
        this.estaPago = estaPago;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoDContratacion getTipoContratacion() {
        return tipoContratacion;
    }

    /**
     * Un paquete tiene un tipo de contratacion dependiendo de cada servicio
     * puede ser contratado de dos maneras posibles: De forma individual. En un
     * paquete turístico (con otros servicios)
     *
     * @param tipoContratacion
     */
    public void setTipoContratacion(TipoDContratacion tipoContratacion) {
        
        this.tipoContratacion = tipoContratacion;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", fechaVenta=" + fechaVenta
                + ", horaVenta=" + horaVenta + ", comprador=" + comprador
                + ", Usuario=" + usuario
                + ", tipoContratacion=" + tipoContratacion
                + ", paquete=" + paquete + "}";
    }

    /**
     * TODO Falta carlular el importe del paquete y determinar si está pago
     * Enter otras cosas
     *
     */
}
