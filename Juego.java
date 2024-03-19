/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto;

import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author hecto
 */
public class Juego extends javax.swing.JFrame {

    /**
     * Creates new form Juego
     */
    public Juego() {
        initComponents();
        setLocationRelativeTo(null);
        setDeck();
        generarTablero();
        repartir();
        generateHand(menuPrincipal.jugadores.get(0));
    }
    
    int currentPlayerIndex = 0;
    Player currentPlayer = menuPrincipal.jugadores.get(0);
    ArrayList <Card> deck;
    Card [][] board;
    JButton[][] boardButtons;
    ArrayList <Card> discard = new ArrayList<>();
    boolean twoEyedPlayed = false;
    boolean oneEyedPlayed = false;
    Card lastTwoEyedPlayed;
    Card lastOneEyedPlayed;
    
    void setDeck (){
        deck = new ArrayList<>();
        
        for (int i = 2; i < 11; i++) {
            String rank = String.valueOf(i);
            String path = "res/handCards/" + rank + "C.png";
            
            deck.add(new Card (rank, "C", path));
        }
        
        for (int i = 2; i < 11; i++) {
            String rank = String.valueOf(i);
            String path = "res/handCards/" + rank + "H.png";
            
            deck.add(new Card (rank, "H", path));
        }
        
        for (int i = 2; i < 11; i++) {
            String rank = String.valueOf(i);
            String path = "res/handCards/" + rank + "S.png";
            
            deck.add(new Card (rank, "S", path));
        }
        
        for (int i = 2; i < 11; i++) {
            String rank = String.valueOf(i);
            String path = "res/handCards/" + rank + "D.png";
            
            deck.add(new Card (rank, "D", path));
        }
        
        deck.add(new Card ("K", "C", "res/handCards/KC.png"));
        deck.add(new Card ("K", "H", "res/handCards/KH.png"));
        deck.add(new Card ("K", "D", "res/handCards/KD.png"));
        deck.add(new Card ("K", "S", "res/handCards/KS.png"));
        deck.add(new Card ("Q", "C", "res/handCards/QC.png"));
        deck.add(new Card ("Q", "H", "res/handCards/QH.png"));
        deck.add(new Card ("Q", "D", "res/handCards/QD.png"));
        deck.add(new Card ("Q", "S", "res/handCards/QS.png"));
        deck.add(new Card ("J", "C", "res/handCards/JC.png"));
        deck.add(new Card ("J", "H", "res/handCards/JH.png"));
        deck.add(new Card ("J", "D", "res/handCards/JD.png"));
        deck.add(new Card ("J", "S", "res/handCards/JS.png"));
        deck.add(new Card ("A", "C", "res/handCards/AC.png"));
        deck.add(new Card ("A", "H", "res/handCards/AH.png"));
        deck.add(new Card ("A", "D", "res/handCards/AD.png"));
        deck.add(new Card ("A", "S", "res/handCards/AS.png"));
        
        for (int i = 2; i < 11; i++) {
            String rank = String.valueOf(i);
            String path = "res/handCards/" + rank + "C.png";
            
            deck.add(new Card (rank, "C", path));
        }
        
        for (int i = 2; i < 11; i++) {
            String rank = String.valueOf(i);
            String path = "res/handCards/" + rank + "H.png";
            
            deck.add(new Card (rank, "H", path));
        }
        
        for (int i = 2; i < 11; i++) {
            String rank = String.valueOf(i);
            String path = "res/handCards/" + rank + "S.png";
            
            deck.add(new Card (rank, "S", path));
        }
        
        for (int i = 2; i < 11; i++) {
            String rank = String.valueOf(i);
            String path = "res/handCards/" + rank + "D.png";
            
            deck.add(new Card (rank, "D", path));
        }
        
        deck.add(new Card ("K", "C", "res/handCards/KC.png"));
        deck.add(new Card ("K", "H", "res/handCards/KH.png"));
        deck.add(new Card ("K", "D", "res/handCards/KD.png"));
        deck.add(new Card ("K", "S", "res/handCards/KS.png"));
        deck.add(new Card ("Q", "C", "res/handCards/QC.png"));
        deck.add(new Card ("Q", "H", "res/handCards/QH.png"));
        deck.add(new Card ("Q", "D", "res/handCards/QD.png"));
        deck.add(new Card ("Q", "S", "res/handCards/QS.png"));
        deck.add(new Card ("J", "C", "res/handCards/JC.png"));
        deck.add(new Card ("J", "H", "res/handCards/JH.png"));
        deck.add(new Card ("J", "D", "res/handCards/JD.png"));
        deck.add(new Card ("J", "S", "res/handCards/JS.png"));
        deck.add(new Card ("A", "C", "res/handCards/AC.png"));
        deck.add(new Card ("A", "H", "res/handCards/AH.png"));
        deck.add(new Card ("A", "D", "res/handCards/AD.png"));
        deck.add(new Card ("A", "S", "res/handCards/AS.png"));
        
    }
    
    void generarTablero(){
        board = new Card [10][10];
        
        board [0][0] = new Card (null, null, "res/normalCards/corner.png");
        board [0][0].setImagePath("src/proyecto/res/normalCards/corner.png");
        board [0][1] = new Card ("2", "S", "res/handCards/2S.png");
        board [0][2] = new Card ("3", "S", "res/handCards/3S.png");
        board [0][3] = new Card ("4", "S", "res/handCards/4S.png");
        board [0][4] = new Card ("5", "S", "res/handCards/5S.png");
        board [0][5] = new Card ("6", "S", "res/handCards/6S.png");
        board [0][6] = new Card ("7", "S", "res/handCards/7S.png");
        board [0][7] = new Card ("8", "S", "res/handCards/8S.png");
        board [0][8] = new Card ("9", "S", "res/handCards/9S.png");
        board [0][9] = new Card (null, null, "res/normalCards/corner.png");
        board [0][9].setImagePath("src/proyecto/res/normalCards/corner.png");
        
        board [1][0] = new Card ("6", "C", "res/handCards/6C.png");
        board [1][1] = new Card ("5", "C", "res/handCards/5C.png");
        board [1][2] = new Card ("4", "C", "res/handCards/4C.png");
        board [1][3] = new Card ("3", "C", "res/handCards/3C.png");
        board [1][4] = new Card ("2", "C", "res/handCards/2C.png");
        board [1][5] = new Card ("A", "H", "res/handCards/AH.png");
        board [1][6] = new Card ("K", "H", "res/handCards/KH.png");
        board [1][7] = new Card ("Q", "H", "res/handCards/QH.png");
        board [1][8] = new Card ("10", "H", "res/handCards/10H.png");
        board [1][9] = new Card ("10", "S", "res/handCards/10S.png");
        
        board [2][0] = new Card ("7", "C", "res/handCards/7C.png");
        board [2][1] = new Card ("A", "S", "res/handCards/AS.png");
        board [2][2] = new Card ("2", "D", "res/handCards/2C.png");
        board [2][3] = new Card ("3", "D", "res/handCards/3C.png");
        board [2][4] = new Card ("4", "D", "res/handCards/4C.png");
        board [2][5] = new Card ("5", "D", "res/handCards/5C.png");
        board [2][6] = new Card ("6", "D", "res/handCards/6C.png");
        board [2][7] = new Card ("7", "D", "res/handCards/7C.png");
        board [2][8] = new Card ("9", "H", "res/handCards/9H.png");
        board [2][9] = new Card ("Q", "S", "res/handCards/QS.png");
        
        board [3][0] = new Card ("8", "C", "res/handCards/8C.png");
        board [3][1] = new Card ("K", "S", "res/handCards/KS.png");
        board [3][2] = new Card ("6", "C", "res/handCards/6C.png");
        board [3][3] = new Card ("5", "C", "res/handCards/5C.png");
        board [3][4] = new Card ("4", "C", "res/handCards/4C.png");
        board [3][5] = new Card ("3", "C", "res/handCards/3C.png");
        board [3][6] = new Card ("2", "C", "res/handCards/2C.png");
        board [3][7] = new Card ("8", "D", "res/handCards/8D.png");
        board [3][8] = new Card ("8", "H", "res/handCards/8H.png");
        board [3][9] = new Card ("K", "S", "res/handCards/KS.png");
        
        board [4][0] = new Card ("9", "C", "res/handCards/9C.png");
        board [4][1] = new Card ("Q", "S", "res/handCards/QS.png");
        board [4][2] = new Card ("7", "C", "res/handCards/7C.png");
        board [4][3] = new Card ("6", "H", "res/handCards/6H.png");
        board [4][4] = new Card ("5", "H", "res/handCards/5H.png");
        board [4][5] = new Card ("4", "H", "res/handCards/4H.png");
        board [4][6] = new Card ("A", "H", "res/handCards/AH.png");
        board [4][7] = new Card ("9", "D", "res/handCards/9D.png");
        board [4][8] = new Card ("7", "H", "res/handCards/7H.png");
        board [4][9] = new Card ("A", "S", "res/handCards/AS.png");
        
        board [5][0] = new Card ("10", "C", "res/handCards/10C.png");
        board [5][1] = new Card ("10", "S", "res/handCards/10S.png");
        board [5][2] = new Card ("8", "C", "res/handCards/8C.png");
        board [5][3] = new Card ("7", "H", "res/handCards/7H.png");
        board [5][4] = new Card ("2", "H", "res/handCards/2H.png");
        board [5][5] = new Card ("3", "H", "res/handCards/3H.png");
        board [5][6] = new Card ("K", "H", "res/handCards/KH.png");
        board [5][7] = new Card ("10", "D", "res/handCards/10D.png");
        board [5][8] = new Card ("6", "H", "res/handCards/6H.png");
        board [5][9] = new Card ("2", "D", "res/handCards/2D.png");
        
        board [6][0] = new Card ("Q", "C", "res/handCards/QC.png");
        board [6][1] = new Card ("9", "S", "res/handCards/9S.png");
        board [6][2] = new Card ("9", "C", "res/handCards/9C.png");
        board [6][3] = new Card ("8", "H", "res/handCards/8H.png");
        board [6][4] = new Card ("9", "H", "res/handCards/9H.png");
        board [6][5] = new Card ("10", "H", "res/handCards/10H.png");
        board [6][6] = new Card ("Q", "H", "res/handCards/QH.png");
        board [6][7] = new Card ("Q", "D", "res/handCards/QD.png");
        board [6][8] = new Card ("5", "H", "res/handCards/5H.png");
        board [6][9] = new Card ("3", "D", "res/handCards/3D.png");
        
        board [7][0] = new Card ("K", "C", "res/handCards/KC.png");
        board [7][1] = new Card ("8", "S", "res/handCards/8S.png");
        board [7][2] = new Card ("10", "C", "res/handCards/10C.png");
        board [7][3] = new Card ("Q", "C", "res/handCards/QC.png");
        board [7][4] = new Card ("K", "C", "res/handCards/KC.png");
        board [7][5] = new Card ("A", "C", "res/handCards/AC.png");
        board [7][6] = new Card ("A", "D", "res/handCards/AD.png");
        board [7][7] = new Card ("K", "D", "res/handCards/KD.png");
        board [7][8] = new Card ("4", "H", "res/handCards/4H.png");
        board [7][9] = new Card ("4", "D", "res/handCards/4D.png");
        
        board [8][0] = new Card ("A", "C", "res/handCards/AC.png");
        board [8][1] = new Card ("7", "S", "res/handCards/7S.png");
        board [8][2] = new Card ("6", "S", "res/handCards/6S.png");
        board [8][3] = new Card ("5", "S", "res/handCards/5S.png");
        board [8][4] = new Card ("4", "S", "res/handCards/4S.png");
        board [8][5] = new Card ("3", "S", "res/handCards/3S.png");
        board [8][6] = new Card ("2", "S", "res/handCards/2S.png");
        board [8][7] = new Card ("2", "H", "res/handCards/2H.png");
        board [8][8] = new Card ("3", "H", "res/handCards/3H.png");
        board [8][9] = new Card ("5", "D", "res/handCards/5D.png");
        
        board [9][0] = new Card (null, null, "res/normalCards/corner.png");
        board [9][0].setImagePath("src/proyecto/res/normalCards/corner.png");
        board [9][1] = new Card ("A", "D", "res/handCards/AD.png");
        board [9][2] = new Card ("K", "D", "res/handCards/KD.png");
        board [9][3] = new Card ("Q", "D", "res/handCards/QD.png");
        board [9][4] = new Card ("10", "D", "res/handCards/10.png");
        board [9][5] = new Card ("9", "D", "res/handCards/9D.png");
        board [9][6] = new Card ("8", "D", "res/handCards/8D.png");
        board [9][7] = new Card ("7", "D", "res/handCards/7D.png");
        board [9][8] = new Card ("6", "D", "res/handCards/6D.png");
        board [9][9] = new Card (null, null, "res/normalCads/corner.png");
        board [9][9].setImagePath("src/proyecto/res/normalCards/corner.png");
        
        board[0][0].setMarked(true);
        board[9][0].setMarked(true);
        board[0][9].setMarked(true);
        board[9][9].setMarked(true);
        
        generarBotonesTablero();
    }
    
    void generarBotonesTablero(){
        boardButtons = new JButton [10][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                
                String path = board[i][j].getImagePath();
                
                if (!path.contains("corner")){
                    String [] split = path.split("handCards");
                    path = split[0] + "normalCards" + split[1];
                    board[i][j].setImagePath(path);
                }
                
                ImageIcon originalIcon = new ImageIcon(path);
                Image originalImage = originalIcon.getImage();
                Image resizedImage = originalImage.getScaledInstance(60, 40, Image.SCALE_SMOOTH);
                ImageIcon resizedIcon = new ImageIcon(resizedImage);
                
                boardButtons [i][j] = new JButton(resizedIcon);
                boardButtons [i][j].setEnabled(false);
            }
        }
        
        tablero.setLayout(new GridLayout(10,10,0,0));
        
        for (int i = 0; i < boardButtons.length; i++) {
            for (int j = 0; j < boardButtons[i].length; j++) {
                
                final int fi = i;
                final int fj = j;
                
                boardButtons[i][j].addActionListener(e -> {
                        playCard(board [fi][fj], fi, fj, currentPlayer);
                });
                
                tablero.add(boardButtons[i][j]);
                
            }
        }
        
        repaint();
        revalidate();
    }
    
    
    
    Random random = new Random();
    
    void repartir(){
        for (Player current : menuPrincipal.jugadores){
            for (int i = 0; i < configuracion.cCards; i++) {
                int cardIndex = random.nextInt(deck.size());
                Card card = deck.get(cardIndex);
                
                current.getCurrentPlayerHand().add(card);
                deck.remove(cardIndex);
            }
        }
    }
    
    void generateHand(Player player){
        mano.setLayout(new GridLayout (4, 2, 10, 10));
        
        for (Card card : player.getCurrentPlayerHand()) {
            
            ImageIcon originalIcon = new ImageIcon(card.getImagePath());
            Image originalImage = originalIcon.getImage();
            Image resizedImage = originalImage.getScaledInstance(50, 75, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            
            JButton cardButton = new JButton(resizedIcon);

            cardButton.addActionListener(e -> {
                if (card.getImagePath().contains("JC") || card.getImagePath().contains("JD")){
                    twoEyedPlayed = true;
                    lastTwoEyedPlayed = card;
                    enableAll();
                } else if (card.getImagePath().contains("JS") || card.getImagePath().contains("JH")){
                    oneEyedPlayed = true;
                    lastOneEyedPlayed = card;
                    enableFichas();
                } else {
                    twoEyedPlayed = false;
                    oneEyedPlayed = false;
                    disableAll();
                    enableBoardPositionsForCard(card);
                }
            });
            mano.add(cardButton);
        }
        
        manoDe.setText("Mano de " + player.getUsername() + " de " + teamOf());
        repaint();
        revalidate();

    }
    
    void disableAll(){
        for (int i = 0; i < boardButtons.length; i++) {
            for (int j = 0; j < boardButtons[i].length; j++) {
                boardButtons[i][j].setEnabled(false);
            }
        }
    }
    
    void enableBoardPositionsForCard(Card selectedCard) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                String cardName = selectedCard.getImagePath().substring(selectedCard.getImagePath().lastIndexOf("/") + 1);
                String refName = board[i][j].getImagePath().substring(board[i][j].getImagePath().lastIndexOf("/") + 1);
                
                if (cardName.equals(refName) && !board[i][j].getMarked()) {
                    JButton button = boardButtons[i][j];
                    button.setEnabled(true);
                }
            }
        }
    }
    
    void enableAll(){
        for (int i = 0; i < boardButtons.length; i++) {
            for (int j = 0; j < boardButtons[i].length; j++) {
                if (!board[i][j].getMarked()){
                    boardButtons[i][j].setEnabled(true);
                }
            }
        }
    }
    
    ImageIcon sinFichaIcon;
    
    void enableFichas(){
        disableAll();
        for (int i = 0; i < boardButtons.length; i++) {
            for (int j = 0; j < boardButtons[i].length; j++) {
                if (!(i == 0 && j == 0) && !(i == 0 && j == 9) && !(i == 9 && j == 0) &&  !(i == 9 && j ==9)){
                    if (board[i][j].getMarked()){
                        ImageIcon imagen = (ImageIcon) boardButtons[i][j].getDisabledIcon();
                        sinFichaIcon = (ImageIcon) boardButtons[i][j].getIcon();
                        boardButtons[i][j].setEnabled(true);
                        boardButtons[i][j].setIcon(imagen);
                    }
                }
            }
        }
    }
    
    void playCard(Card cardPlayed, int fi, int fj, Player player){
        disableAll();
        
        boolean found = false;
        
        if (oneEyedPlayed){
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    String cardName = cardPlayed.getImagePath().substring(cardPlayed.getImagePath().lastIndexOf("/") + 1);
                    String refName = board[i][j].getImagePath().substring(board[i][j].getImagePath().lastIndexOf("/") + 1);
                    
                    String greyPath = "src/proyecto/res/greyCards/" + cardName;
                    
                    if (cardName.equals(refName)){
                        boardButtons[i][j].setDisabledIcon(resize(new ImageIcon(greyPath), 60, 40));
                        board[i][j].setMarked(false);
                        board[i][j].setTeamWhoMarked(null);
                        boardButtons[i][j].setEnabled(false);
                        boardButtons[i][j].setIcon(sinFichaIcon);
                    }
                }
            }
            
            cardPlayed.setMarked(false);
        } else {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    String cardName = cardPlayed.getImagePath().substring(cardPlayed.getImagePath().lastIndexOf("/") + 1);
                    String refName = board[i][j].getImagePath().substring(board[i][j].getImagePath().lastIndexOf("/") + 1);

                    if (cardName.equals(refName) && !cardPlayed.getMarked() && i == fi && j == fj) {
                        board[i][j].setMarked(true);
                        board[i][j].setTeamWhoMarked(currentPlayer.getColor());
                        boardButtons[i][j].setEnabled(false);
                        ImageIcon actual = (ImageIcon) boardButtons[i][j].getIcon();
                        boardButtons[i][j].setDisabledIcon(combinarImagenes(actual, player.getColor()));
                        found = true;
                        break;
                    }
                }

                if (found){
                    break;
                }
            }
        }
        
        
        
        if (twoEyedPlayed){
            currentPlayer.getCurrentPlayerHand().remove(indexOfCard(lastTwoEyedPlayed));
            twoEyedPlayed = false;
            lastCard.setIcon(resize(new ImageIcon (lastTwoEyedPlayed.getImagePath()), 150, 221));
            discard.add(lastTwoEyedPlayed);
        } else if  (oneEyedPlayed){
            currentPlayer.getCurrentPlayerHand().remove(indexOfCard(lastOneEyedPlayed));
            oneEyedPlayed = false;
            lastCard.setIcon(resize(new ImageIcon(lastOneEyedPlayed.getImagePath()), 150, 221));
            discard.add(lastOneEyedPlayed);
        } else {
            currentPlayer.getCurrentPlayerHand().remove(indexOfCard(cardPlayed));
            
            String path = cardPlayed.getImagePath();
            String [] split = path.split("normalCards");

            String fixedPath = split[0] + "handCards" + split[1];

            lastCard.setIcon(resize(new ImageIcon (fixedPath), 150, 221));
            discard.add(cardPlayed);
        }
        
        
        if (checkWin(currentPlayer.getColor())){
            JOptionPane.showMessageDialog(null, "El equipo " + teamOf() + " ha ganado sequence!");
            
            try {
                RandomAccessFile reporte = new RandomAccessFile (login.logged.getUsername() + ".rep", "rw");
                reporte.seek(reporte.length());

                Calendar now = Calendar.getInstance();
                long nowInMillis = now.getTimeInMillis();

                reporte.writeLong(nowInMillis);
            } catch (IOException e){
                e.printStackTrace();
            }
            
            setVisible(false);
            menuPrincipal menu = new menuPrincipal();
            menu.setVisible(true);
            menu.setLocationRelativeTo(null);
        }
        
        grabCard();
        currentPlayerIndex++;
        
        if (currentPlayerIndex > configuracion.cPlayers - 1){
            currentPlayerIndex = 0;
        }
        
        currentPlayer = menuPrincipal.jugadores.get(currentPlayerIndex);
        mano.removeAll();
        generateHand(currentPlayer);
        
        if (deck.isEmpty()){
            reshuffle();
        }
    }
    
    ImageIcon combinarImagenes(ImageIcon fondo, ImageIcon overlay){
        Image fondoImagen = fondo.getImage();
        Image overlayImagen = overlay.getImage();
        
        int w = fondoImagen.getWidth(null);
        int h = fondoImagen.getHeight(null);
        
        BufferedImage combinada = new BufferedImage (w, h, BufferedImage.TYPE_INT_ARGB);
        
        Graphics2D g2 = (Graphics2D) combinada.getGraphics();
        
        g2.drawImage(fondoImagen, 0, 0, null);
        
        int x = (w - overlayImagen.getWidth(null))/2;
        int y = (h - overlayImagen.getHeight(null))/2;
        g2.drawImage(overlayImagen, x, y, null);
        
        g2.dispose();
        
        ImageIcon combinedIcon = new ImageIcon(combinada);
        
        return combinedIcon;
    }
    
    void reshuffle(){
        deck = discard;
        discard.clear();
    }
    
    void grabCard(){
        int index = random.nextInt(deck.size());
        currentPlayer.getCurrentPlayerHand().add(deck.get(index));
        deck.remove(index);
        
        
        
        msg.setText(currentPlayer.getUsername() + " ha robado una carta! Quedan " + deck.size() + " cartas en el mazo.");
    }
    
    int indexOfCard(Card cardPlayed){
        for (int i = 0; i < currentPlayer.getCurrentPlayerHand().size(); i++) {
            
            String pathReference = currentPlayer.currentPlayerHand.get(i).getImagePath();
            String comparePath = cardPlayed.getImagePath();
            
            String name1 = pathReference.substring(pathReference.lastIndexOf("/") + 1);
            String name2 = comparePath.substring(comparePath.lastIndexOf("/") + 1);
            
            if (name1.equals(name2)){
                return i;
            }
        }
        
        return -1;
    }
    
    ImageIcon resize (ImageIcon originalIcon, int w, int h){
        Image originalImage = originalIcon.getImage();
        Image newImage = originalImage.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return new ImageIcon (newImage);
    }
    
    boolean checkWin(ImageIcon teamWhoMarked){
        int sequences = 0 ;
        int linedSets = 0;
        
        board[0][0].setTeamWhoMarked(teamWhoMarked);
        board[9][0].setTeamWhoMarked(teamWhoMarked);
        board[0][9].setTeamWhoMarked(teamWhoMarked);
        board[9][9].setTeamWhoMarked(teamWhoMarked);
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i < 6 && board[i][j].getMarked() &&
                        board[i + 1][j].getMarked() &&
                        board[i + 2][j].getMarked() &&
                        board[i + 3][j].getMarked() &&
                        board[i + 4][j].getMarked() && board [i][j].getTeamWhoMarked() == teamWhoMarked){
                    
                    if (board[i][j].getTeamWhoMarked() == board[i + 1][j].getTeamWhoMarked() &&
                            board[i][j].getTeamWhoMarked() == board[i + 2][j].getTeamWhoMarked() &&
                            board[i][j].getTeamWhoMarked() == board[i + 3][j].getTeamWhoMarked() &&
                            board[i][j].getTeamWhoMarked() == board[i + 4][j].getTeamWhoMarked()){
                        linedSets++;
                    }
                }
                
                if (linedSets > 0){
                    sequences++;
                }
                
                linedSets = 0;
                
                if (j < 6 && board[i][j].getMarked() &&
                        board[i][j + 1].getMarked() &&
                        board[i][j + 2].getMarked() &&
                        board[i][j + 3].getMarked() &&
                        board[i][j + 4].getMarked() && board [i][j].getTeamWhoMarked() == teamWhoMarked){
                    if (board[i][j].getTeamWhoMarked() == board[i][j + 1].getTeamWhoMarked() &&
                            board[i][j].getTeamWhoMarked() == board[i][j + 2].getTeamWhoMarked() &&
                            board[i][j].getTeamWhoMarked() == board[i][j + 3].getTeamWhoMarked() &&
                            board[i][j].getTeamWhoMarked() == board[i][j + 4].getTeamWhoMarked()){
                        linedSets++;
                    }
                }
                
                if (linedSets > 0){
                    sequences++;
                }
                
                linedSets = 0;
                
                if (i < 6 && j < 6 && board[i][j].getMarked() &&
                        board[i + 1][j + 1].getMarked() &&
                        board[i + 2][j + 2].getMarked() &&
                        board[i + 2][j + 3].getMarked() &&
                        board[i + 2][j + 4].getMarked() && board [i][j].getTeamWhoMarked() == teamWhoMarked){
                    if (board[i][j].getTeamWhoMarked() == board[i + 1][j + 1].getTeamWhoMarked() &&
                            board[i][j].getTeamWhoMarked() == board[i + 2][j + 2].getTeamWhoMarked() &&
                            board[i][j].getTeamWhoMarked() == board[i + 3][j + 3].getTeamWhoMarked() &&
                            board[i][j].getTeamWhoMarked() == board[i + 4][j + 4].getTeamWhoMarked()){
                        linedSets++;
                    }
                }
                
                if (linedSets > 0){
                    sequences++;
                }
                
                linedSets = 0;
                
                if (i > 3 && j < 6 && board[i][j].getMarked() &&
                        board[i - 1][j + 1].getMarked() &&
                        board[i - 2][j + 2].getMarked() &&
                        board[i - 3][j + 3].getMarked() &&
                        board[i - 4][j + 4].getMarked() && board [i][j].getTeamWhoMarked() == teamWhoMarked){
                    
                    if (board[i][j].getTeamWhoMarked() == board[i - 1][j + 1].getTeamWhoMarked() &&
                            board[i][j].getTeamWhoMarked() == board[i - 2][j + 2].getTeamWhoMarked() &&
                            board[i][j].getTeamWhoMarked() == board[i - 3][j + 3].getTeamWhoMarked() &&
                            board[i][j].getTeamWhoMarked() == board[i - 4][j + 4].getTeamWhoMarked()){
                        linedSets++;
                    }
                }
                
                if (linedSets > 0){
                    sequences++;
                }
                
                linedSets = 0;
            }
        }
        
        board[0][0].setTeamWhoMarked(null);
        board[9][0].setTeamWhoMarked(null);
        board[0][9].setTeamWhoMarked(null);
        board[9][9].setTeamWhoMarked(null);
        
        if (sequences >= 2){
            return true;
        }
        
        return false;
    }
    
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JLayeredPane();
        mano = new javax.swing.JPanel();
        manoDe = new javax.swing.JLabel();
        tablero = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        msg = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lastCard = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mano.setBackground(new java.awt.Color(153, 153, 153));
        mano.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout manoLayout = new javax.swing.GroupLayout(mano);
        mano.setLayout(manoLayout);
        manoLayout.setHorizontalGroup(
            manoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 351, Short.MAX_VALUE)
        );
        manoLayout.setVerticalGroup(
            manoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
        );

        manoDe.setForeground(new java.awt.Color(0, 0, 0));
        manoDe.setText("Label:");

        tablero.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout tableroLayout = new javax.swing.GroupLayout(tablero);
        tablero.setLayout(tableroLayout);
        tableroLayout.setHorizontalGroup(
            tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
        );
        tableroLayout.setVerticalGroup(
            tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Tablero");

        jButton1.setText("Quit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Ultima Carta Jugada:");

        fondo.setLayer(mano, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fondo.setLayer(manoDe, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fondo.setLayer(tablero, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fondo.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fondo.setLayer(msg, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fondo.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fondo.setLayer(lastCard, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fondo.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fondoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(manoDe)
                                    .addComponent(mano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(fondoLayout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(jLabel1))
                            .addGroup(fondoLayout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(lastCard, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(fondoLayout.createSequentialGroup()
                                .addComponent(tablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))))
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, fondoLayout.createSequentialGroup()
                        .addGap(773, 773, 773)
                        .addComponent(jLabel2)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(fondoLayout.createSequentialGroup()
                .addComponent(manoDe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastCard, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            RandomAccessFile log = new RandomAccessFile(login.logged.getUsername() + ".rep", "rw");
            
            log.seek(log.length());
            
            Calendar now = Calendar.getInstance();
            long nowLong = now.getTimeInMillis();
            
            log.writeLong(nowLong);
            
            JOptionPane.showMessageDialog(null, "Gracias por jugar\n(Aunque no terminaste) >:(");
            
            setVisible(false);
            menuPrincipal menu = new menuPrincipal();
            
            menu.setVisible(true);
            menu.setLocationRelativeTo(null);
        } catch (IOException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    String teamOf(){
        for (int i = 0; i < configuracion.team1.size(); i++) {
            if (configuracion.team1.get(i).getUsername().equals(currentPlayer.getUsername())){
                return "Equipo 1";
            }
        }
        
        for (Player current : configuracion.team2){
            if (current.getUsername().equals(currentPlayer.getUsername())){
                return "Equipo 2";
            }
        }
        
        if (configuracion.cPlayers % 3 == 0){
            for (Player current : configuracion.team3){
                if (current.getUsername().equals(currentPlayer.getUsername())){
                    return "Equipo 3";
                }
            }
        }
        
        return null;
    }
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton lastCard;
    private javax.swing.JPanel mano;
    private javax.swing.JLabel manoDe;
    private javax.swing.JLabel msg;
    private javax.swing.JPanel tablero;
    // End of variables declaration//GEN-END:variables
}
