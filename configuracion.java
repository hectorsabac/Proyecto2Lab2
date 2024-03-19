/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author hecto
 */
public class configuracion extends javax.swing.JFrame {

    /**
     * Creates new form configuracion
     */
    public configuracion() {
        initComponents();
    }
    
    menuPrincipal mp = new menuPrincipal();
    static ArrayList <Player> team1 = new ArrayList<>();
    static ArrayList <Player> team2 = new ArrayList<>();
    static ArrayList <Player> team3 = new ArrayList<>();;
    static ImageIcon color1 = resize(new ImageIcon("src/proyecto/res/tokens/redToken.png"));
    static ImageIcon color2 = resize(new ImageIcon("src/proyecto/res/tokens/blueToken.png"));
    static ImageIcon color3 = resize(new ImageIcon("src/proyecto/res/tokens/greenToken.png"));

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
        jugadoresCantidad = new javax.swing.JButton();
        colorFicha = new javax.swing.JButton();
        regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Configuracion");

        jugadoresCantidad.setText("Cantidad de Jugadores");
        jugadoresCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugadoresCantidadActionPerformed(evt);
            }
        });

        colorFicha.setText("Color de Ficha");
        colorFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorFichaActionPerformed(evt);
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
                .addGap(122, 122, 122)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jugadoresCantidad)
                    .addComponent(colorFicha)
                    .addComponent(regresar))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jugadoresCantidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(colorFicha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(regresar)
                .addGap(80, 80, 80))
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
        
        mp.setVisible(true);
        mp.setLocationRelativeTo(null);
    }//GEN-LAST:event_regresarActionPerformed
    
    static ImageIcon resize(ImageIcon original){
        Image imageOriginal = original.getImage();
        Image nuevaImage = imageOriginal.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon nuevoIcono = new ImageIcon (nuevaImage);
        
        return nuevoIcono;
    }
    
    public static void makeTeams(int players){
        team1 = new ArrayList<>();
        team2 = new ArrayList<>();
        
        if (players % 3 == 0){
            team3 = new ArrayList<>();
            
            for (int i = 0; i < menuPrincipal.jugadores.size(); i++) {
                team1.add(menuPrincipal.jugadores.get(i));
                i++;
                team2.add(menuPrincipal.jugadores.get(i));
                i++;
                team3.add(menuPrincipal.jugadores.get(i));
            }
            
            for (Player current : team1){
                current.setColor(color1);
            }
            
            for (Player current : team2){
                current.setColor(color2);
            }
            
            for (Player current : team3){
                current.setColor(color3);
            }
        } else {
            for (int i = 0; i < menuPrincipal.jugadores.size(); i++) {
                team1.add(menuPrincipal.jugadores.get(i));
                i++;
                team2.add(menuPrincipal.jugadores.get(i));
            }
            
            for (Player current : team1){
                current.setColor(color1);
            }
            
            for (Player current : team2){
                current.setColor(color2);
            }
        }
    }
    
//    public static void makeTeams(int teams){
//        //Borra los teams anteriores para poblarlos ahora
//        team1 = new ArrayList<>();
//        team2 = new ArrayList<>();
//        
//        //Verifica si el numero de teams sera 2 o 3
//        if (teams == 2){
//            for (int i = 0; i < cPlayers; i++) {//Llena los teams
//                menuPrincipal.jugadores.get(i).setFicha(color1);
//                team1.add(menuPrincipal.jugadores.get(i));
//                i++;
//                menuPrincipal.jugadores.get(i).setFicha(Color.blue);
//                team2.add(menuPrincipal.jugadores.get(i));
//            }
//        } else {
//            //Borra team3 para poblarlo
//            team3 = new ArrayList<>();
//            for (int i = 0; i < cPlayers; i++) {//Llena los teams
//                menuPrincipal.jugadores.get(i).setFicha(Color.red);
//                team1.add(menuPrincipal.jugadores.get(i));
//                i++;
//                menuPrincipal.jugadores.get(i).setFicha(Color.blue);
//                team2.add(menuPrincipal.jugadores.get(i));
//                i++;
//                menuPrincipal.jugadores.get(i).setFicha(Color.green);
//                team3.add(menuPrincipal.jugadores.get(i));
//            }
//        }
//    }
    
    static int cPlayers = 4;
    static int cCards = 7;
    
    private void jugadoresCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugadoresCantidadActionPerformed
        try {
            cPlayers = Integer.parseInt(JOptionPane.showInputDialog("Jugadores configurados actualmente: " + cPlayers + "\nIngrese la cantidad de jugadores que van a jugar"
                    + "\n2 jugadores (7 cartas y 2 equipos)"
                    + "\n3 jugadores (6 cartas y 3 equipos)"
                    + "\n4 jugadores (7 cartas y 2 equipos)"
                    + "\n6 jugadores (5 cartas y 3 equipos)"
                    + "\n8 jugadores (4 cartas y 2 equipos) "));
            
            while (true){
                if (cPlayers == 2 || cPlayers == 3 || cPlayers == 4 || cPlayers == 6 || cPlayers == 8){
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Elija una de las opciones dadas");
                
                    cPlayers = Integer.parseInt(JOptionPane.showInputDialog("Jugadores configurados actualmente: " + cPlayers + "\nIngrese la cantidad de jugadores que van a jugar"
                            + "\n2 jugadores (7 cartas y 2 equipos)"
                            + "\n3 jugadores (6 cartas y 3 equipos)"
                            + "\n4 jugadores (7 cartas y 2 equipos)"
                            + "\n6 jugadores (5 cartas y 3 equipos)"
                            + "\n8 jugadores (4 cartas y 2 equipos) "));
                }
            }
            
            if (cPlayers > creacionDeUsuarios.users.size()){
                JOptionPane.showMessageDialog(null, "Solo hay " + creacionDeUsuarios.users.size() + " usuarios registrados.\n"
                        + "No se pueden tener " + cPlayers + "jugadores ya que no ajustan los usuarios.\n"
                                + "Intente de nuevo");
            } else {
                switch (cPlayers){
                    case 2:
                        cCards = 7;
                        break;
                    case 3:
                        cCards = 6;
                        break;
                    case 4:
                        cCards = 7;
                        break;
                    case 6:
                        cCards = 5;
                        break;
                    case 8:
                        cCards = 4;
                        break; 
                }

                JOptionPane.showMessageDialog(null, "Configuracion actualizada!");
            }
            
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Ingrese un numero valido");
        }
    }//GEN-LAST:event_jugadoresCantidadActionPerformed
        
    public static ArrayList <Player> teamOf(Player jugador){
        
        for (Player current : team1){
            if (current == jugador){
                return team1;
            }
        }
        
        for (Player current : team2){
            if (current == jugador){
                return team2;
            }
        }
        
        if (cPlayers % 3 == 0){
            for (Player current : team3){
                if (current == jugador){
                    return team3;
                }
            }
        }
        
        return null;
    }
    
    public static boolean colorExits(ImageIcon color){
        
        if (color == color1 || color == color2 || color == color3){
            return true;
        }
        
        return false;
    }
    
    static ImageIcon oldColor = null;
    
    private void colorFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorFichaActionPerformed
        try {     
            int opcion = Integer.parseInt(JOptionPane.showInputDialog("Que color desea que sea su ficha?\n"
                + "1. Rojo\n"
                + "2. Azul\n"
                + "3. Verde\n"
                + "4. Gris\n"
                + "5. Naranja\n"
                + "6. Rosaddo\n"
                + "7. Morado\n"
                + "8. Amarillo"));
            
            while (opcion < 1 || opcion > 6){
                opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion valida\nQue color desea que sea su ficha?\n"
                    + "1. Rojo\n"
                    + "2. Azul\n"
                    + "3. Verde\n"
                    + "4. Gris\n"
                    + "5. Naranja\n"
                    + "6. Rosaddo\n"
                    + "7. Morado\n"
                    + "8. Amarillo"));
            }
            
            oldColor = color1;
            
            switch (opcion){
                case 1:
                    cambiarFicha(new ImageIcon ("src/proyecto/res/tokens/redToken.png"));
                    break;
                case 2:
                    cambiarFicha(new ImageIcon ("src/proyecto/res/tokens/blueToken.png"));
                    break;
                case 3:
                    cambiarFicha(new ImageIcon ("src/proyecto/res/tokens/greenToken.png"));
                    break;
                case 4:
                    cambiarFicha(new ImageIcon ("src/proyecto/res/tokens/greyToken.png"));
                    break;
                case 5:
                    cambiarFicha(new ImageIcon ("src/proyecto/res/tokens/orangeToken.png"));
                    break;
                case 6:
                    cambiarFicha(new ImageIcon ("src/proyecto/res/tokens/pinkToken.png"));
                    break;
                case 7:
                    cambiarFicha(new ImageIcon ("src/proyecto/res/tokens/purpleToken.png"));
                    break;
                case 8:
                    cambiarFicha(new ImageIcon ("src/proyecto/res/tokens/yellowToken.png"));
                    break;
            }
            
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Ingrese un numero valido");
        }
        
        
    }//GEN-LAST:event_colorFichaActionPerformed

    
    public static void cambiarFicha(ImageIcon color){
        color = resize(color);
        
        if (!colorExits(color)){
            
            color1 = color;
            
            for (Player current : team1){
                current.setColor(color);
            }
            
            JOptionPane.showMessageDialog(null, "Color de ficha cambiado!");
        } else {
            color1 = oldColor;
            JOptionPane.showMessageDialog(null, "Ese color ya esta tomado");
        }
    }
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton colorFicha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jugadoresCantidad;
    private javax.swing.JButton regresar;
    // End of variables declaration//GEN-END:variables
}
