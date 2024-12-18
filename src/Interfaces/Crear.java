package Interfaces;

import militar.*;
import util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Crear extends javax.swing.JPanel {

    private ArrayList<TodosLosSoldados> todosLosSoldados;
    private ArrayList<SoldadoRaso> soldadosRasos;
    private ArrayList<Teniente> tenientes;
    private ArrayList<Capitan> capitanes;
    private ArrayList<Coronel> coroneles;
    ImprimirDatos imprimirDatos = new ImprimirDatos();

    public Crear() {

        todosLosSoldados = new ArrayList<TodosLosSoldados>();
        soldadosRasos = new ArrayList<SoldadoRaso>();
        tenientes = new ArrayList<Teniente>();
        capitanes = new ArrayList<Capitan>();
        coroneles = new ArrayList<Coronel>();

        initComponents();
    }

    private void initComponents() {

        radioRangos = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jRaso = new javax.swing.JRadioButton();
        jCapitan = new javax.swing.JRadioButton();
        jTeniente = new javax.swing.JRadioButton();
        jCoronel = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("CREACIÓN DE UN SOLDADO");

        jLabel2.setText("Nombre:");

        jLabel3.setText("ID:");

        jLabel4.setText("Rango:");

        radioRangos.add(jRaso);
        jRaso.setText("Soldado raso");

        radioRangos.add(jCapitan);
        jCapitan.setText("Capitan");

        radioRangos.add(jTeniente);
        jTeniente.setText("Teniente");

        radioRangos.add(jCoronel);
        jCoronel.setText("Coronel");

        jTextField3.setEditable(false);
        jTextField5.setEditable(false);
        jTextField6.setEditable(false);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(jRaso.isSelected()){
                    jTextField3.setEditable(false);
                    jTextField5.setEditable(false);
                    jTextField6.setEditable(false);
                } else if (jTeniente.isSelected()) {
                    jTextField3.setEditable(true);
                    jTextField5.setEditable(false);
                    jTextField6.setEditable(false);
                } else if (jCapitan.isSelected()) {
                    jTextField3.setEditable(false);
                    jTextField5.setEditable(false);
                    jTextField6.setEditable(true);
                }else if (jCoronel.isSelected()) {
                    jTextField3.setEditable(false);
                    jTextField5.setEditable(true);
                    jTextField6.setEditable(false);
                }
            }
        };

        jRaso.addActionListener(actionListener);
        jCapitan.addActionListener(actionListener);
        jTeniente.addActionListener(actionListener);
        jCoronel.addActionListener(actionListener);


        jButton1.setBackground(new java.awt.Color(0, 204, 0));
        jButton1.setText("AGREGAR");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
                if (!jRaso.isSelected() && !jTeniente.isSelected() && !jCapitan.isSelected() && !jCoronel.isSelected()) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Por favor seleccione un rango.");
                }else{
                    boolean encontrado = false;
                    if (jRaso.isSelected()) {
                        String nombre = jTextField1.getText();
                        String id = jTextField2.getText();
                        for(TodosLosSoldados todos : todosLosSoldados){
                            if(todos.getId().equals(id)){
                                javax.swing.JOptionPane.showMessageDialog(null, "Por favor escriba un 'ID' valido.");
                                return;
                            }
                        }
                        TodosLosSoldados todosLosSoldados = new TodosLosSoldados(id,1);
                        agregarTodosLosSoldados(todosLosSoldados);

                        SoldadoRaso soldadoRaso = new SoldadoRaso(nombre, id, "Soldado raso", 1);
                        agregarSoldado(soldadoRaso);
                        encontrado = true;


                    } else if (jTeniente.isSelected()) {
                        String nombre = jTextField1.getText();
                        String id = jTextField2.getText();
                        String unidad = jTextField3.getText();
                        for(TodosLosSoldados todos : todosLosSoldados){
                            if(todos.getId().equals(id)){
                                javax.swing.JOptionPane.showMessageDialog(null, "Please enter a valid number for 'ID'.");
                                return;
                            }
                        }
                        TodosLosSoldados todosLosSoldados = new TodosLosSoldados(id,2);
                        agregarTodosLosSoldados(todosLosSoldados);

                        Teniente teniente = new Teniente(nombre, id, "Teniente", 2, unidad);
                        agregarTeniente(teniente);


                        jTextField3.setText("");
                        encontrado = true;

                    } else if (jCapitan.isSelected()) {
                        String nombre = jTextField1.getText();
                        String id = jTextField2.getText();
                        String soldadosMandoStr = jTextField6.getText().trim();
                        System.out.println(soldadosMandoStr);
                        if (soldadosMandoStr.isEmpty() || !soldadosMandoStr.matches("\\d+")) {
                            javax.swing.JOptionPane.showMessageDialog(null, "Please enter a valid number for 'Soldados bajo el mando'.");
                            return;
                        }
                        int soldadosMando = Integer.parseInt(soldadosMandoStr);

                        for(TodosLosSoldados todos : todosLosSoldados){
                            if(todos.getId().equals(id)){
                                javax.swing.JOptionPane.showMessageDialog(null, "Please enter a valid number for 'ID'.");
                                return;
                            }
                        }
                        TodosLosSoldados todosLosSoldados = new TodosLosSoldados(id,3);
                        agregarTodosLosSoldados(todosLosSoldados);

                        Capitan capitan = new Capitan(nombre, id, "Capitan", 3,soldadosMando);
                        agregarCapitan(capitan);

                        jCapitan.setSelected(false);
                        jTextField6.setText("");
                        encontrado = true;

                    }else if (jCoronel.isSelected()) {
                        String nombre = jTextField1.getText();
                        String id = jTextField2.getText();
                        String estrategia = jTextField5.getText();

                        for(TodosLosSoldados todos : todosLosSoldados){
                            if(todos.getId().equals(id)){
                                javax.swing.JOptionPane.showMessageDialog(null, "Please enter a valid number for 'ID'.");
                                return;
                            }
                        }
                        TodosLosSoldados todosLosSoldados = new TodosLosSoldados(id,4);
                        agregarTodosLosSoldados(todosLosSoldados);

                        Coronel coronel = new Coronel(nombre, id, "Coronel", 4,estrategia);
                        agregarCoronel(coronel);


                        jTextField5.setText("");
                        encontrado = true;
                    }  
                    jTextField1.setText("");
                    jTextField2.setText("");

                    if (encontrado){
                        javax.swing.JOptionPane.showMessageDialog(null, "Soldado creado correctamente");
                    }else{
                    }
                }
        }});

        jLabel5.setText("Unidad");

        jLabel6.setText("Soldados bajo su mando:");

        jLabel7.setText("Estrategia:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextField1)
                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jCapitan)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jCoronel))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jRaso)
                                                                        .addGap(28, 28, 28)
                                                                        .addComponent(jTeniente))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(24, 24, 24))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jLabel5)
                                                                .addGap(51, 51, 51))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(25, 25, 25)))))
                                .addGap(35, 35, 35))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(115, 115, 115)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(86, 86, 86)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jTeniente)
                                                                        .addComponent(jRaso))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jCoronel)
                                                                        .addComponent(jCapitan)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(83, 83, 83)
                                                                .addComponent(jLabel4))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel3))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(53, 53, 53)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel6)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
        );
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jRasoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public ArrayList<TodosLosSoldados> getTodosLosSoldados() {
        return todosLosSoldados;
    }

    public void agregarTodosLosSoldados(TodosLosSoldados todos) {
        todosLosSoldados.add(todos);
    }

    public ArrayList<SoldadoRaso> getSoldadosRasos() {
        return soldadosRasos;
    }

    public void agregarSoldado(SoldadoRaso soldado) {
        soldadosRasos.add(soldado);
    }

    public ArrayList<Teniente> getTenientes() {
        return tenientes;
    }

    public void agregarTeniente(Teniente teniente) {
        tenientes.add(teniente);
    }

    public ArrayList<Capitan> getCapitanes() {
        return capitanes;
    }

    public void agregarCapitan(Capitan capitan) {
        capitanes.add(capitan);
    }

    public ArrayList<Coronel> getCoroneles() {
        return coroneles;
    }

    public void agregarCoronel(Coronel coronel) {
        coroneles.add(coronel);
    }


    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JRadioButton jCapitan;
    private javax.swing.JRadioButton jCoronel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRaso;
    private javax.swing.JRadioButton jTeniente;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.ButtonGroup radioRangos;

    public void setTodosLosSoldados(ArrayList<TodosLosSoldados> todosLosSoldados) {
        this.todosLosSoldados = todosLosSoldados;
    }

    public void setSoldadosRasos(ArrayList<SoldadoRaso> soldadosRasos) {
        this.soldadosRasos = soldadosRasos;
    }

    public void setTenientes(ArrayList<Teniente> tenientes) {
        this.tenientes = tenientes;
    }

    public void setCapitanes(ArrayList<Capitan> capitanes) {
        this.capitanes = capitanes;
    }

    public void setCoroneles(ArrayList<Coronel> coroneles) {
        this.coroneles = coroneles;
    }

    public void setImprimirDatos(ImprimirDatos imprimirDatos) {
        this.imprimirDatos = imprimirDatos;
    }

    public void setjButton1(javax.swing.JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public void setjCapitan(javax.swing.JRadioButton jCapitan) {
        this.jCapitan = jCapitan;
    }

    public void setjCoronel(javax.swing.JRadioButton jCoronel) {
        this.jCoronel = jCoronel;
    }

    public void setjLabel1(javax.swing.JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public void setjLabel2(javax.swing.JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public void setjLabel3(javax.swing.JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public void setjLabel4(javax.swing.JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public void setjLabel5(javax.swing.JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public void setjLabel6(javax.swing.JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public void setjLabel7(javax.swing.JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public void setjRaso(javax.swing.JRadioButton jRaso) {
        this.jRaso = jRaso;
    }

    public void setjTeniente(javax.swing.JRadioButton jTeniente) {
        this.jTeniente = jTeniente;
    }

    public void setjTextField1(javax.swing.JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }

    public void setjTextField2(javax.swing.JTextField jTextField2) {
        this.jTextField2 = jTextField2;
    }

    public void setjTextField3(javax.swing.JTextField jTextField3) {
        this.jTextField3 = jTextField3;
    }

    public void setjTextField5(javax.swing.JTextField jTextField5) {
        this.jTextField5 = jTextField5;
    }

    public void setjTextField6(javax.swing.JTextField jTextField6) {
        this.jTextField6 = jTextField6;
    }

    public void setRadioRangos(javax.swing.ButtonGroup radioRangos) {
        this.radioRangos = radioRangos;
    }

}
