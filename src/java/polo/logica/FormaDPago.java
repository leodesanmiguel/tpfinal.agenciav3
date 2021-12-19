
package polo.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import polo.logica.enumera.MediosDPago;

/**
 *
 * @author Leo Martinez
 */
@Entity
@Table(name = "formadpago")
public class FormaDPago implements Serializable {

    /**
     * Este Id se genera solo. Solo se puede recuperar el nro
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFormaDPago;

    @Enumerated(EnumType.ORDINAL)
    private MediosDPago medioDPago;

    public FormaDPago() {
    }

    public FormaDPago(int idFormaDPago, MediosDPago medioDPago) {
        this.idFormaDPago = idFormaDPago;
        this.medioDPago = medioDPago;
    }

    
    public FormaDPago(MediosDPago medioDPago) {
        //this.idFormaDPago = idFormaDPago;
        this.medioDPago = medioDPago;
    }

    public int getIdFormaDPago() {
        return idFormaDPago;
    }

    public MediosDPago getMedioDPago() {
        return medioDPago;
    }

    public void setMedioDPago(MediosDPago medioDPago) {
        this.medioDPago = medioDPago;
    }

    /**
     * TODO faltan los métodos que permite recuperar las comisiones entre otras
     * cosas.
     *
     * elegirFormaDPago:
     *
     * Elegir la forma de pago sirve para identificar el modo en que se realiza
     * un pago.<p>
     *
     * @Param idFormaDPago contine un entero qcorrespondiente al valor de la
     * forma de pago.
     * <p>
     *
     * public void elegirFormaDPago(int idFormaDPago) {
     *
     * switch (idFormaDPago) { case 0: { this.medioDPago = "Efectivo"; break; }
     * case 1: { this.medioDPago = "Débito"; break; } case 2: { this.medioDPago
     * = "Crédito"; break; } case 3: { this.medioDPago = "Monedero"; break; }
     * case 4: { this.medioDPago = "Transferencia"; break; }
     *
     * }
     *
     * }
     */
}
