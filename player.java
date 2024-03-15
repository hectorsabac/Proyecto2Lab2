/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author hecto
 */
public class player {
    String username;
    ArrayList <File> mano;
    Color ficha;
    
    public player (String username){
        this.username = username;
        this.mano = new ArrayList<>();
        this.ficha = Color.BLACK;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public ArrayList <File> getMano(){
        return this.mano;
    }
    
    public void setMano (ArrayList <File> mano){
        this.mano = mano;
    }
    
    public Color getFicha(){
        return this.ficha;
    }
    
    public void setFicha (Color ficha){
        this.ficha = ficha;
    }
}
