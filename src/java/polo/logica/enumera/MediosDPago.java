
package polo.logica.enumera;

/**
 *
 * @author Leo Martinez
 */
public enum MediosDPago {

    /**
     * Los medios de pago determinan la forma de pago y una comisión.
     *
     */
    EFECTIVO("Efectivo", 0.0),
    DEBITO("Débito", 0.03),
    CREDITO("Crédito", 0.09),
    MONEDERO("Monedero", 0.0),
    TRANSFERENCIA("Transferencia", 2.45);

    private String medio;
    private double comision;

    private MediosDPago(String medio, double comision) {
        this.medio = medio;
        this.comision = comision;
    }

    public String getMedio() {
        return this.medio;

    }

    public double getComision() {
        return this.comision;
    }
}
