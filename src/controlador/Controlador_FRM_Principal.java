/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Lista_Simple;
import modelo.Ordenamiento;
import vista.FRM_Principal;

/**
 *
 * @author roy
 */
public class Controlador_FRM_Principal implements ActionListener{
    
    FRM_Principal ventana;
    
    Lista_Simple lista;
    Ordenamiento ordenamiento;
    
    public Controlador_FRM_Principal(FRM_Principal ventana, Lista_Simple lista, Ordenamiento ordenamiento)
    {
        this.ventana=ventana;
        this.lista=lista;
        this.ordenamiento=ordenamiento;
    }
 /*************************************************/
    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Generar Fecha De Cita"))
        {
            if(!ventana.verificarEspacosVacios())
            {
               
                    if(!ventana.verificacionDePrioridad())
                    {
                        if(ventana.agregarPersona())
                        {
                            JOptionPane.showMessageDialog(null, "Se ha agregado con éxito");
                            ventana.limpiarVentana();
                        }else{
                            JOptionPane.showMessageDialog(null, "No se ha podido agregar con éxito, vuelvalo a intentar");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Usted debe de seleccionar una prioridad");
                    }
                
            }else{
                JOptionPane.showMessageDialog(null, "Existen espacios vacios");
            }
            
        }
      /************************************************************************/  
        if(e.getActionCommand().equals("Atender Clientes"))
        {
            ventana.mostrarEnPantalla(lista.imprimir(lista.getLista()));
            ventana.llamarCliente();
            
            System.out.println("Sirve");
        }
     /************************************************************************/
        if(e.getActionCommand().equals("<"))
        {
            ventana.mostrarEnPantalla(lista.imprimir(Ordenamiento.ordenamientoMenorAMayor(lista.getLista())));
        }
     /************************************************************************/
        if(e.getActionCommand().equals(">"))
        {
            ventana.mostrarEnPantalla(lista.imprimir(Ordenamiento.ordenamientoMayorAMenor(lista.getLista())));
        }
        if(e.getActionCommand().equals("Eliminar Cita"))
        {
           ventana.llamarCliente();
           JOptionPane.showMessageDialog(null,"Cliente eliminado");
           ventana.blanco();
           ventana.limpiarVentana();
        }
        if(e.getActionCommand().equals("Modificar Cita"))
        {
            System.err.println("ljg");
        }
        if(e.getActionCommand().equals("Reporte General"))
        {
             ventana.mostrarEnPantalla(lista.imprimir(Ordenamiento.ordenamientoMenorAMayor(lista.getLista())));
        }
        
    }
    
}
