
package modelo;

import java.util.Vector;

/**
 *
 * @author roy
 */
public class Ordenamiento {
    
  
    
    public static void intercambio(Vector<Persona> a, int i, int j)
    {
        Persona aux=a.get(i);
        a.setElementAt(a.get(j), i);
        a.setElementAt(aux, j);
        
    }
    
    public static Vector<Persona> ordenamientoMayorAMenor(Vector<Persona> a)
    {
        int i,j;
        for(i=0; i<a.size()-1;i++)
        {
            for(j=i+1;j<a.size();j++)
            {
                if(a.get(i).getEdad()<a.get(j).getEdad())
                {
                    intercambio(a, i, j);
                }
            }
        }
        return a;
    }
    public static Vector<Persona> ordenamientoMenorAMayor(Vector<Persona> a)
    {
        int i,j;
        for(i=0; i<a.size()-1;i++)
        {
            for(j=i+1;j<a.size();j++)
            {
                if(a.get(i).getEdad()>a.get(j).getEdad())
                {
                    intercambio(a, i, j);
                }
            }
        }
        return a;
    }
}
