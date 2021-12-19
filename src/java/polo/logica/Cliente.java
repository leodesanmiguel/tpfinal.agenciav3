
package polo.logica;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Leo Martinez
 */
@Entity
@Table(name = "cliente")
public class Cliente extends Persona implements Serializable {

    /**
     * Este Id se genera solo. Solo se puede recuperar el nro
     *
     * @Id
     * @GeneratedValue(strategy = GenerationType.IDENTITY) private int
     * idCliente;
     *
     */
    private String tipoCliente;

    /**
     * Cada Cliente tiene una mas formas de Pago. deberán asignarle a cada
     * cliente la forma de pagar.
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FormaDPago> formasDPago;

    /**
     * Los clientes realizan compras puede haber una o varias Las compras son
     * las ventas de la AGENCIA
     *
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Venta> compras;

    @Temporal(TemporalType.DATE)
    private Date fechaAlta;

    public Cliente() {
    }

    public Cliente(List<FormaDPago> formasDPago,
            List<Venta> compras, String tipoCliente,
            String nombreP, String apellidoP, String direccionP, int dni,
            Date fechaNacio, String nacionalidad, String celular,
            String email) {
        super(nombreP, apellidoP, direccionP, dni, fechaNacio, nacionalidad,
                celular, email);
        this.formasDPago = formasDPago;

        LocalDate fe = LocalDate.now();
        ZoneId dZ = ZoneId.systemDefault();
        this.fechaAlta = Date.from(fe.atStartOfDay(dZ).toInstant());
        this.tipoCliente = tipoCliente;
        this.compras = compras;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public List<FormaDPago> getFormasDPago() {
        return formasDPago;
    }

    public void setFormasDPago(List<FormaDPago> formasDPago) {
        this.formasDPago = formasDPago;
    }

    public List<Venta> getCompras() {
        return compras;
    }

    public void setCompras(List<Venta> compras) {
        this.compras = compras;
    }

}
