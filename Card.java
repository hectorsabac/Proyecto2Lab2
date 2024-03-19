/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import javax.swing.ImageIcon;

/**
 *
 * @author hecto
 */
public class Card {
    private final String rank; 
    private final String suit;
    private String imagePath;
    private boolean marked;
    ImageIcon teamWhoMarked;

    public Card(String rank, String suit, String imagePath) {
        this.rank = rank;
        this.suit = suit;
        this.imagePath = "src/proyecto/res/handCards/" + rank + suit + ".png";
        this.marked = false;
        teamWhoMarked = null;
    }
    
    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getImagePath() {
        return imagePath;
    }

    public boolean isPlayable() {
        return marked;
    }
    
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public boolean getMarked(){
        return this.marked;
    }
    
    public void setMarked(boolean isPlayable) {
        this.marked = isPlayable;
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank='" + rank + '\'' +
                ", suit='" + suit + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", isPlayable=" + marked +
                '}';
    }

    public ImageIcon getTeamWhoMarked() {
        return teamWhoMarked;
    }

    public void setTeamWhoMarked(ImageIcon teamWhoMarked) {
        this.teamWhoMarked = teamWhoMarked;
    }
    
    
}
