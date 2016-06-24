
package modelo;

/**
 *
 * @author roy
 */
public class Persona {
    
    private String nombre;
    private String cedula;
    private String prioridad;
    private String fecha;
    private int edad;
     String dato;
    Persona enlace;
    
    
    public Persona(String nombre, String cedula, String prioridad, String fecha, int edad)
    {
        this.nombre=nombre;
        this.cedula=cedula;
        this.prioridad=prioridad;
        this.fecha=fecha;
        this.edad=edad;
        enlace=null;
    }

    
    public String getNombre() {
        return nombre;
    }

   
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
    public String getCedula() {
        return cedula;
    }

   
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

   
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the ficha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param ficha the ficha to set
     */
    public void setFicha(String fecha) {
        this.fecha = fecha;
    }
}
