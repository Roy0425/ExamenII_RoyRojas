/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador_FRM_Principal;
import modelo.Lista_Simple;
import modelo.Ordenamiento;

/**
 *
 * @author roy
 */
public class FRM_Principal extends javax.swing.JFrame {
    
    Lista_Simple lista_Simple;
    Ordenamiento ordenamiendo;
    Controlador_FRM_Principal controlador;
    String[] devolverInformacion;
    int fecha7600=2, fechaNormal=1;
    
    public FRM_Principal() {
        initComponents();
        setLocationRelativeTo(null);
        llenarComboPrioridad();
        manejoDeCursor();
        
        lista_Simple=new Lista_Simple();
        ordenamiendo=new Ordenamiento();
        devolverInformacion=new String[5];
        controlador=new Controlador_FRM_Principal(this, lista_Simple, ordenamiendo);
        agregarEventos(controlador);
    }
/***************************************/
    public void agregarEventos(Controlador_FRM_Principal controlador)
    {
        this.btn_GenerarFicha.addActionListener(controlador);
        this.btn_LlamarCliente.addActionListener(controlador);
        this.btn_MayorQue.addActionListener(controlador);
        this.btn_MenorQue.addActionListener(controlador);
        this.btn_Eliminar.addActionListener(controlador);
        this.btn_Modficar.addActionListener(controlador);
        this.btn_ReporteEdades.addActionListener(controlador);
        this.btn_ReporteGeneral.addActionListener(controlador);
        this.btn_PersonasCola.addActionListener(controlador);
    }
    
    public void llenarComboPrioridad()
    {
        this.jcb_Prioridad.removeAllItems();
        this.jcb_Prioridad.addItem("Prioridad");
        this.jcb_Prioridad.addItem("Normal");
        this.jcb_Prioridad.addItem("7600");
        
        
    }
    
    public String[] devolverInformacion()
    {
        devolverInformacion[0]=this.txt_Nombre.getText();
        devolverInformacion[1]=this.txt_Cedula.getText();
        devolverInformacion[2]=(String)this.jcb_Prioridad.getSelectedItem();
        devolverInformacion[3]=generarFicha();
        devolverInformacion[4]=String.valueOf(this.txt_Edad.getText());
        
        
        return devolverInformacion;
    }
    
    
    public String getTxtCedula()
    {
        return this.txt_Cedula.getText();
    }
    
    public String getTxtNombre()
    {
        return this.txt_Nombre.getText();
    }
    public String getTxtEdad()
    {
        return this.txt_Edad.getText();
    }
    
    
    public void setTxtCedula(String cedula)
    {
        this.txt_Cedula.setText(cedula);
    }
    
    public void setTxtNombre(String nombre)
    {
        this.txt_Nombre.setText(nombre);
    }
    
    public void setTxtEdad(String edad)
    {
        this.txt_Edad.setText(edad);
    }
    
    
    
    public boolean verificarEspacosVacios()
    {
        boolean existen=false;
        
        if((this.txt_Nombre.getText().equals("")) || (this.txt_Edad.getText().equals("")))
        {
            existen=true;
        }
        
        return existen;
    }
   
    public boolean verificacionDePrioridad()
    {
        boolean seleccionado=false;
        
        if(((String)this.jcb_Prioridad.getSelectedItem()).equals("Prioridad"))
        {
            seleccionado=true;
        }
        
        return seleccionado;
    }
    public String generarFicha()
    {
        String ficha;
        
        if(((String)this.jcb_Prioridad.getSelectedItem()).equals("7600"))
        {
           ficha="Enero-"+fecha7600;
           fecha7600++;
        }else{
           ficha="Febrero-"+fechaNormal;
           fechaNormal++;
        }
        
        return ficha;
    }
    public void llamarCliente()
    {
        lista_Simple.avanzarFila(this.txt_LlamarCliente);
    }
    public boolean agregarPersona()
    {
        boolean agregado=false;
        if(((String)this.jcb_Prioridad.getSelectedItem()).equals("7600"))
        {
            lista_Simple.insertarCabezaLista(devolverInformacion());
            agregado=true;
            System.out.println("agregado de primero");
            manejoDeCursor();
        }else{
            lista_Simple.insertarDeUltimo(devolverInformacion());
            agregado=true;
            System.out.println("agregado de ultimo");
            manejoDeCursor();
        }
        
        return agregado;
    }
    public void manejoDeCursor()
    {
        this.txt_Cedula.requestFocus();
        this.jcb_Prioridad.setSelectedIndex(0);
       
    }
    public void limpiarVentana()
    {
        this.txt_Nombre.setText("");
        this.txt_Cedula.setText("");
        this.txt_Edad.setText("");
        this.txt_LlamarCliente.setText("");
    }
    public void mostrarEnPantalla(String mensaje)
    {
        this.Area_Texto.setText(mensaje);
    }
    
    public void blanco()
    {
        this.Area_Texto.setText("");
        this.txt_LlamarCliente.setText("");
    }
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jl_Nombre = new javax.swing.JLabel();
        jl_Titulo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Area_Texto = new javax.swing.JTextArea();
        btn_MenorQue = new javax.swing.JButton();
        jcb_Prioridad = new javax.swing.JComboBox<>();
        txt_Nombre = new javax.swing.JTextField();
        txt_Edad = new javax.swing.JTextField();
        txt_LlamarCliente = new javax.swing.JTextField();
        btn_LlamarCliente = new javax.swing.JButton();
        btn_MayorQue = new javax.swing.JButton();
        btn_GenerarFicha = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_Cedula = new javax.swing.JTextField();
        btn_Eliminar = new javax.swing.JButton();
        btn_Modficar = new javax.swing.JButton();
        btn_ReporteGeneral = new javax.swing.JButton();
        btn_ReporteEdades = new javax.swing.JButton();
        btn_PersonasCola = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Edad:");

        jl_Nombre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jl_Nombre.setText("Nombre:");

        jl_Titulo.setBackground(new java.awt.Color(51, 102, 255));
        jl_Titulo.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jl_Titulo.setForeground(new java.awt.Color(0, 0, 0));
        jl_Titulo.setText("Migracion");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/linea.png"))); // NOI18N

        Area_Texto.setColumns(20);
        Area_Texto.setRows(5);
        jScrollPane1.setViewportView(Area_Texto);

        btn_MenorQue.setBackground(new java.awt.Color(255, 51, 51));
        btn_MenorQue.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        btn_MenorQue.setText("<");

        jcb_Prioridad.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jcb_Prioridad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcb_Prioridad.setSelectedItem("Prioridad");

        txt_LlamarCliente.setEditable(false);
        txt_LlamarCliente.setBackground(new java.awt.Color(255, 255, 255));
        txt_LlamarCliente.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txt_LlamarCliente.setForeground(new java.awt.Color(0, 0, 0));
        txt_LlamarCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btn_LlamarCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_LlamarCliente.setText("Atender Clientes");

        btn_MayorQue.setBackground(new java.awt.Color(0, 255, 204));
        btn_MayorQue.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        btn_MayorQue.setText(">");
        btn_MayorQue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MayorQueActionPerformed(evt);
            }
        });

        btn_GenerarFicha.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_GenerarFicha.setText("Generar Fecha De Cita");

        jLabel2.setText("Cedula:");

        btn_Eliminar.setText("Eliminar Cita");

        btn_Modficar.setText("Modificar Cita");

        btn_ReporteGeneral.setText("Reporte General");

        btn_ReporteEdades.setText("Reporte Edades");

        btn_PersonasCola.setText("Personas en Fila");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jl_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 49, Short.MAX_VALUE)
                                .addComponent(btn_GenerarFicha)
                                .addGap(51, 51, 51))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_Modficar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_ReporteEdades))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(btn_Eliminar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_ReporteGeneral))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jcb_Prioridad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jl_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(4, 4, 4)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt_Edad, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txt_Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                                        .addComponent(txt_Cedula)))))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(btn_PersonasCola)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addComponent(txt_LlamarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(btn_MenorQue, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96)
                                .addComponent(btn_MayorQue, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(btn_LlamarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jl_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_LlamarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_LlamarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_MenorQue, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_MayorQue, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(txt_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_Nombre)
                            .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_Edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(jcb_Prioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_GenerarFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Eliminar)
                            .addComponent(btn_ReporteGeneral))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Modficar)
                            .addComponent(btn_ReporteEdades))
                        .addGap(18, 18, 18)
                        .addComponent(btn_PersonasCola)))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_MayorQueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MayorQueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_MayorQueActionPerformed

    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FRM_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRM_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRM_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRM_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRM_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Area_Texto;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_GenerarFicha;
    private javax.swing.JButton btn_LlamarCliente;
    private javax.swing.JButton btn_MayorQue;
    private javax.swing.JButton btn_MenorQue;
    private javax.swing.JButton btn_Modficar;
    private javax.swing.JButton btn_PersonasCola;
    private javax.swing.JButton btn_ReporteEdades;
    private javax.swing.JButton btn_ReporteGeneral;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcb_Prioridad;
    private javax.swing.JLabel jl_Nombre;
    private javax.swing.JLabel jl_Titulo;
    private javax.swing.JTextField txt_Cedula;
    private javax.swing.JTextField txt_Edad;
    private javax.swing.JTextField txt_LlamarCliente;
    private javax.swing.JTextField txt_Nombre;
    // End of variables declaration//GEN-END:variables
}
