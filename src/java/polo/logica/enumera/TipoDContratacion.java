
package polo.logica.enumera;

/**
 *
 * @author Leo Martinez
 */
public enum TipoDContratacion {
    IND("individual"),
    PAQ("paquete");
    
    private String tipo;
    
    private TipoDContratacion(String tipo){
        this.tipo = tipo;
    }
    
    public String getTipoContratacion(){
        return this.tipo;
        
    }
    
}
