package polo.logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;

/**
 *
 * @author Leo Martinez
 */
@Entity
@Table(name = "paquete")
public class Paquete implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPaquete;
    /**
     * El costo del paquete es igual a la suma de los costos de los servicios
     * que lo componen menos un 10% de descuento por contratarlos en forma de
     * paquete.
     *
     * En caso que el paquete contenga un solo servicio. Este porcentaje no se
     * aplica
     */
    private double costoPaquete;

    /**
     * El descuento está asignado inicialmente al 10%
     * <p>
     * Se podrá cambar este valor desde la administración.
     *
     */
    private double descuento;

    /**
     * Cada paquete contiene una lista de servicios que tiene cada uno un valor
     * del mismo.
     *
     * Como se pide que las ventas tengan un servicio o un paquete, puede un
     * paquete tener un solo servicio o puede tener una lista de servicios
     */
    
    @ManyToMany
    private List<Servicio> servicios;

    /**
     *
     *
     * Puede contener un solo servicio o mas de uno.
     *
     * @ManyToOne(optional = false)
     * @JoinColumn(name = "IDVENTA", nullable = false, updatable = false)
     * private List<Venta> pedidos;
     */
    public Paquete() {
    }

    public Paquete(double costoPaquete, double descuento,
            List<Servicio> servicios) {
        this.costoPaquete = costoPaquete;
        this.descuento = descuento;
        this.servicios = servicios;
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public double getCostoPaquete() {
        return costoPaquete;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public List<Servicio> getServicios() {

        return servicios;
    }

    /**
     * El paquete contiene unalista de servicios.Cuando se le asigna los
     * servicios se calcula el costo del paquete También se supone que todos los
     * paquetes que tengan mas de un servicio se asigna un descuento que no
     * indicarlo se le asigna un 10%
     *
     *
     * @param servicios
     */
    public void setServicios(List<Servicio> servicios) {
        // al asignar los servicios se debe consignar el costo del paquete

        double costo = 0;

        for (Servicio s : servicios) {
            costo += s.getCostoS();
            if (this.descuento == 0) {
                this.descuento = 10 / 100;
            }
            if (servicios.size() > 1) {
                costo *= this.descuento;
            }
        }
        this.costoPaquete = costo;
        this.servicios = servicios;
    }

    

}
