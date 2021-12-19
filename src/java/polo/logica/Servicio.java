
package polo.logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import polo.logica.enumera.TipoDServicios;

/** 
 *
 * @author Leo Martinez
 */
@Entity
@Table(name = "servicio")
public class Servicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServicio;
    
    @Enumerated(EnumType.ORDINAL)
    private TipoDServicios nombreServ;
    
    private String descripcionServ;
    private String destinoS;

    @Temporal(TemporalType.DATE)
    private Date fechaServicio;

    private double costoS;

    /**
     * Cada Servicio puede estar en uno o mas paquetes.
     */
    
    @ManyToMany
     private List<Paquete> paquetes;

    public Servicio() {
    }

    public Servicio(TipoDServicios nombreServ,
            String descripcionServ, String destinoS, 
            Date fechaServicio, double costoS) {
        this.nombreServ = nombreServ;
        this.descripcionServ = descripcionServ;
        this.destinoS = destinoS;
        this.fechaServicio = fechaServicio;
        this.costoS = costoS;
    }

    
    
    public int getIdServicio() {
        return idServicio;
    }

    

    public TipoDServicios getNombreServ() {
        return nombreServ;
    }

    public void setNombreServ(TipoDServicios nombreServ) {
        this.nombreServ = nombreServ;
    }

    public String getDescripcionServ() {
        return descripcionServ;
    }

    public void setDescripcionServ(String descripcionServ) {
        this.descripcionServ = descripcionServ;
    }

    public String getDestinoS() {
        return destinoS;
    }

    public void setDestinoS(String destinoS) {
        this.destinoS = destinoS;
    }

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public double getCostoS() {
        return costoS;
    }

    public void setCostoS(double costoS) {
        this.costoS = costoS;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

   

   

}
