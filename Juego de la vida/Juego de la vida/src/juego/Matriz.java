/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.de.la.vida;

/**
 *
 * @author SergioMurillo
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.Random;
public class Matriz extends JPanel {

    int fil, col;
    int[][] m = new int[110][110];
    int[][] mt = new int[110][110];
    Random rnd;
    public Matriz() {
        fil = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad de filas"));
        
        col = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad de columnas"));
        rnd=new Random();
          for (int i = 0; i < 220; i++) {
             m[(int)(rnd.nextDouble() * 40 + 0)][(int)(rnd.nextDouble() * 40 + 0)]=1; 
          
        }
   
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int mi = 0;
        int mj = 0;
        Color colorActual = new Color(255, 255, 255);
        for (int j = 1; j < this.getHeight(); j += this.getHeight() / fil) {

            for (int i = 1; i < this.getWidth(); i += this.getWidth() / col) {
                if (m[mj][mi] == 1) {
                    g.setColor(colorActual);
                    g.fillRect(i, j, this.getWidth() / col, this.getHeight() / fil);
                }
                mi++;
            }
            mj++;
            mi = 0;
        }
        this.drawLine(g2d, Color.gray);
        this.procesar();
    }

    public void drawLine(Graphics2D g2d, Color color) {
        g2d.setColor(color);
        for (int i = 0; i < getWidth(); i += this.getWidth() / col) {
            g2d.drawLine(i, 0, i, getHeight());
        }
        for (int i = 0; i < getHeight(); i += this.getHeight() / fil) {
            g2d.drawLine(0, i, getWidth(), i);
        }
    }

    public void procesar() {
        for (int i = 1; i < fil - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                int sum = m[i - 1][j - 1] + m[i][j - 1] + m[i + 1][j - 1] + m[i + 1][j] + m[i + 1][j + 1] + m[i][j + 1] + m[i - 1][j + 1] + m[i - 1][j];
                if (sum == 3) {
                    mt[i][j] = 1;
                } else if (sum != 2) {
                    mt[i][j] = 0;
                }
            }
        }
        this.copiaMatriz();
    }

    public void copiaMatriz() {
        for (int i = 1; i < fil - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                m[i][j] = mt[i][j];
            }
        }
    }
  
}
