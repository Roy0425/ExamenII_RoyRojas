/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author roy
 */
public class Lista_Simple {
    
    
    protected Persona primero;
    public Vector<Persona> lista;
    
    public Lista_Simple()
    {
        primero = null;
        lista=new Vector<Persona>();
    }//Fin del constructor.

    public void insertarCabezaLista(String datos[])
    {
        
        Persona nuevo; 
        nuevo = new Persona(datos[0], datos[1], datos[2], datos[3], Integer.parseInt(datos[4]));
        nuevo.enlace = primero;
        primero = nuevo;

        
    }//Fin del metodo insertarCabezaLista.
    public Persona ultimo()
    {
        Persona ultimo=primero;
        
        while(ultimo.enlace!=null)
        {
           ultimo=ultimo.enlace;
        }
        
        
        return ultimo;
    }
    public void insertarDeUltimo(String datos[]){
        if(primero!=null)
        {
            Persona nuevo=new Persona(datos[0], datos[1], datos[2], datos[3], Integer.parseInt(datos[4]));
            ultimo().enlace=nuevo;
        }else
        {
            Persona nuevo; 
            nuevo = new Persona(datos[0], datos[1], datos[2], datos[3], Integer.parseInt(datos[4]));
            nuevo.enlace = primero;
            primero = nuevo;
        }
    }
    
    public Vector<Persona> getLista()
    {
       Persona indice=primero;
       lista.clear();
       while(indice!=null)
       {
           
           lista.add(indice);
           indice=indice.enlace;
           
       }
       return lista;
    }
    
    public void visualizar()
    {
        Persona n;
        int k = 0;

        n = primero;
        while(n != null)
        {
            System.out.print(n.getNombre() + " ");
            n = n.enlace;
            k++;
            System.out.print((k%15 != 0 ? " " : "\n"));
        }//Fin del while
    }//Fin del metodo visualizar.
    
    public Persona buscarPosicion(int posicion)
    {
        Persona indice;
        
        int i;
        
        if(posicion < 0) //Posicion ha de ser mayor que cero.
        {
            return null;
        }//Fin del if.
        
        indice = primero;
        
        for(i=1; (i<posicion) && (indice!=null); i++)
        {
            indice = indice.enlace;
        }//Fin del for.
        
        return indice;
    }//Fin del metodo buscarPosicion.
    
    public void eliminar(String nombre)
    {
        Persona actual, anterior;
        boolean encontrado;
        //inicializa los apuntadores.
        actual = primero;
        anterior = null;
        encontrado = false;
        //busqueda del nodo y del anterior.
        while((actual!=null) && (!encontrado))
        {
            encontrado = (actual.getNombre().equals(nombre));
            //con objetos: actual.dato.equals(entrada)
            if(!encontrado)
            {
                anterior = actual;
                actual = actual.enlace;
            }//Fin del if.
        }//Fin del while.
        //Enlace del nodo anterior con el siguiente.
        if(actual != null)
        {
            //Distingue entre que el nodo sea el cabecera,
            //o del resto de la lista
            if(actual == primero)
            {
                primero = actual.enlace;
            }
            else
            {
                anterior.enlace = actual.enlace;
            }
            actual = null; //no es necesario al ser una variable local.
        }//Fin del if.
    }
    public void avanzarFila(JTextField campo)
    {
       if(primero!=null)
       {
            String ficha=primero.getFecha();
            campo.setText(ficha);
            eliminar(primero.getNombre());
       
       }else
       {
           JOptionPane.showMessageDialog(null, "La fila está vacia");
       }
       
    }
    public String imprimir(Vector<Persona> lista)
    {
        String mensaje="";
        
        for(int i=0;i<lista.size();i++)
        {
            mensaje+="" + lista.get(i).getNombre() + "--->" + lista.get(i).getEdad() + "años\n";
        }
        
        return mensaje;
    }
    
    public Persona devolverUltimoNodo()
    {
        Persona auxiliar=primero;
        while(auxiliar.enlace!=null)
        {
            auxiliar=auxiliar.enlace;
        }
        return auxiliar;
    }
    
    
    public Persona devolverAntepenultimoNodo()
    {
        Persona auxiliar=primero;
        while(auxiliar.enlace.enlace!=null)
        {
            auxiliar=auxiliar.enlace;
        }
        return auxiliar;
    }
    
    
    public Persona devolverNodoAnterior(String datoBuscar)
    {
        Persona auxiliar=primero;
        while(auxiliar.enlace.dato==datoBuscar)
        {
            auxiliar=auxiliar.enlace;
        }
        return auxiliar;
    }
    
    public void eliminarCliente(String datoEliminar)
    {
        Persona auxiliar=primero;
        boolean haEliminado=false;
        if(auxiliar.dato==datoEliminar)
        {
            primero=primero.enlace;
            haEliminado=true;
        }
        else
        {
            auxiliar=devolverUltimoNodo();
            if(auxiliar.dato==datoEliminar)
            {
                auxiliar=devolverAntepenultimoNodo();
                auxiliar.enlace=null;
                haEliminado=true;
            }
        }
        if(!haEliminado)
        {
            Persona temporal;
            auxiliar=devolverNodoAnterior(datoEliminar);
            temporal=auxiliar.enlace.enlace;
            auxiliar.enlace=temporal;
        }
    }
    
}
