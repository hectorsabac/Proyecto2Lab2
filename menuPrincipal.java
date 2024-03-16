/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author hecto
 */
public class menuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form menuPrincipal
     */
    public menuPrincipal() {
        initComponents();
    }
    
    menu menu = new menu();
    static ArrayList <HumanSequencePlayer> jugadores;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jugar = new javax.swing.JButton();
        config = new javax.swing.JButton();
        reportes = new javax.swing.JButton();
        regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Menu Principal");

        jugar.setText("Jugar");
        jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarActionPerformed(evt);
            }
        });

        config.setText("Configuracion");
        config.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configActionPerformed(evt);
            }
        });

        reportes.setText("Reportes");
        reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportesActionPerformed(evt);
            }
        });

        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jugar)
                    .addComponent(config)
                    .addComponent(reportes)
                    .addComponent(regresar))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jugar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(config)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reportes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(regresar)
                .addGap(68, 68, 68))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        setVisible(false);
        
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
    }//GEN-LAST:event_regresarActionPerformed

    private boolean verificarUnico(String player, ArrayList <HumanSequencePlayer> lista){
        int contador = 0;
        
        try {
            creacionDeUsuarios.poblarUsers();

            for (HumanSequencePlayer current : lista){
                if (current.getUsername().equals(player)){
                    contador++;
                }
            }
        } catch (IOException e){
            
        }
        
        
        if (contador > 0){
            return false;
        }
        
        return true;
    }
    
    public static String usersToString(){
        //Inicializa un acumulador
        String accum = "";
        
        //Llena la lista deusuarios
        try {
            creacionDeUsuarios.poblarUsers();
        
            for (int i = 0; i < creacionDeUsuarios.users.size(); i++) {
                accum += creacionDeUsuarios.users.get(i).getUsername()+ "\n";
            }
            
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado");
        }
        
        return accum;
    }
    
    private String showTeams(){
        String accum = "Equipo 1:\n";
        
        for (HumanSequencePlayer current : configuracion.team1){
            accum += "-" + current.getUsername()+ "\n";
        }

        accum += "Equipo 2:\n";
        
        for (HumanSequencePlayer current : configuracion.team2){
            accum += "-" + current.getUsername()+ "\n";
        }
        
        if (configuracion.cPlayers % 3 == 0){
            accum += "Equipo3 :\n";
            
            for (HumanSequencePlayer current : configuracion.team3){
                accum += "-" + current.getUsername()+ "\n";
            }
        }
        
        return accum;
        
    }
    
    /*
    Formato de user.rep
    
    long horaComienzo
    long horaFinal
    */
    
    private void jugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugarActionPerformed
        
        try  {
            RandomAccessFile registro = new RandomAccessFile(login.logged.getUsername() + ".rep", "rw");
            
            registro.seek(registro.length());
            Calendar hoy = Calendar.getInstance();
            registro.writeLong(hoy.getTimeInMillis());
            
        } catch (IOException e){
            e.printStackTrace();
        }


        //Borra la lista anterior de jugadores
        jugadores = new ArrayList<>();
        
        //Incluye el usuario logged in como un jugador
        jugadores.add(login.logged);
        
        JOptionPane.showMessageDialog(null, "Se ha incluido " + login.logged.getUsername()+ " (usted) en la lista de jugadores para esta ronda");
        
        //For para la seleccion de la cantidad de jugadores configurados desde configuracion
        for (int i = 2; i <= configuracion.cPlayers; i++) {
            //Pide el jugador que este en la lista
            String player = JOptionPane.showInputDialog("Lista de usuarios:\n" + usersToString() + "\nSeleccione el jugador " + i + ":");
            
            while (!verificarUnico(player, jugadores) || !creacionDeUsuarios.exists(player)){
                player = JOptionPane.showInputDialog("Lista de usuarios:\n" + usersToString() + "\nSeleccione un jugador existente que no se haya repetido ya\nSeleccione el jugador " + i + ":");
            }
            
            try {
                jugadores.add(login.userWithUsername(player));
            } catch (IOException e){
                
            }
        }
        configuracion.makeTeams(configuracion.cPlayers);
        setVisible(false);
        
        JOptionPane.showMessageDialog(null, "Se han seleccionado los jugadores.\nTeams:\n\n" + showTeams() + "\nEmpieza el juego!");
        try {
            SequenceGame.main(new String [0]);
        } catch (InterruptedException ex) {
            Logger.getLogger(menuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jugarActionPerformed
        
    public static void printArrayList(ArrayList <player> lista){
        System.out.println("Lista:");
        for (player current : lista){
            System.out.println(current.getUsername());
        }
    }
    
    public ArrayList <ImageIcon> listaImagenes(player jugador){
        ArrayList <ImageIcon> imagenes = new ArrayList<>();
        
        for (File current : jugador.getMano()){
            imagenes.add(resizeImage(current));
        }
        
        return imagenes;
    }
    
    public ImageIcon resizeImage(File imagen){
        ImageIcon carta = new ImageIcon(imagen.getAbsolutePath());
        Image image = carta.getImage();
        Image newimg = image.getScaledInstance(63, 91,  java.awt.Image.SCALE_SMOOTH);
        carta = new ImageIcon(newimg);
        
        return carta;
    }
    
    private void configActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configActionPerformed
        configuracion c = new configuracion();
        setVisible(false);
        
        c.setVisible(true);
        c.setLocationRelativeTo(null);
    }//GEN-LAST:event_configActionPerformed

    private void reportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportesActionPerformed
        
        
        
        
        try {
            RandomAccessFile registro = new RandomAccessFile(login.logged.getUsername() + ".rep", "rw");
            
            if (registro.length() == 0){
                JOptionPane.showMessageDialog(null, login.logged.getUsername() + " no tiene registro de partidas creadas aun");
            } else {
                String accum = "Partidas de " + login.logged.getUsername() + ":\n";
                registro.seek(0);

                int cont = 1;
                System.out.println(registro.length());

                while (registro.getFilePointer() < registro.length()){

                    long inicio = (long)registro.readLong();
                    Calendar inicioCalendar = Calendar.getInstance();
                    inicioCalendar.setTimeInMillis(inicio);
                    
                    long fin = (long)registro.readLong();
                    Calendar finCalendar = Calendar.getInstance();
                    finCalendar.setTimeInMillis(fin);

                    accum += "Juego #" + cont + ":\nInicio: " + inicioCalendar.getTime() + "\n" + "\tFinal: " + finCalendar.getTime();
                    cont++;
                }

                JOptionPane.showMessageDialog(null, accum);
            }
        } catch (IOException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado");
        }
    }//GEN-LAST:event_reportesActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton config;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jugar;
    private javax.swing.JButton regresar;
    private javax.swing.JButton reportes;
    // End of variables declaration//GEN-END:variables
}
