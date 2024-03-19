/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author hecto
 */
public class Player {
    String username;
    ArrayList <Card> currentPlayerHand;
    ImageIcon color;

    public Player(String username) {
        this.username = username;
        this.currentPlayerHand = new ArrayList<>();
        this.color = null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<Card> getCurrentPlayerHand() {
        return currentPlayerHand;
    }

    public void setCurrentPlayerHand(ArrayList<Card> currentPlayerHand) {
        this.currentPlayerHand = currentPlayerHand;
    }

    public ImageIcon getColor() {
        return color;
    }

    public void setColor(ImageIcon color) {
        this.color = color;
    }
    
    
}
