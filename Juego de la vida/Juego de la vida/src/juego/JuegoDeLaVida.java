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
import java.awt.Component;
import java.awt.event.*;
import javax.swing.*;

public class JuegoDeLaVida extends JFrame implements ActionListener {



    Matriz panelCentral;
    JPanel panelDerecho;
    JPanel panelDerechaArriba;
    JPanel panelDerechaAbajo;
    JPanel panelEjecutar;
    JButton btnEjecutar;
    ButtonGroup btnGroup;
    Timer hilos;
    ImageIcon imagen;
    public JuegoDeLaVida() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelDerecho = new JPanel();
        panelDerechaArriba = new JPanel();
        panelDerechaAbajo = new JPanel();
        panelCentral = new Matriz();
        panelEjecutar = new JPanel();
        btnEjecutar = new JButton();
        imagen=new ImageIcon( System.getProperty("user.dir")+"/src/images/play.png");
        btnEjecutar.setIcon(imagen);
        btnGroup = new ButtonGroup();
        panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));
        panelDerechaArriba.setLayout(new BoxLayout(panelDerechaArriba, BoxLayout.Y_AXIS));
        panelDerechaAbajo.setLayout(new BoxLayout(panelDerechaAbajo, BoxLayout.Y_AXIS));
        panelDerechaAbajo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelDerechaArriba.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelDerecho.add(panelDerechaArriba);
        panelDerecho.add(panelDerechaAbajo);
        panelEjecutar.add(btnEjecutar);
        panelCentral.setBackground(Color.BLACK);
        this.add("North", panelEjecutar);
        this.add("East", panelDerecho);
        this.add("Center", panelCentral);
        btnEjecutar.addActionListener(this);
        hilos = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelCentral.repaint();
            }
        });
       
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnEjecutar) {
            hilos.start();
        }
    }
    public static void main(String[] args) {
        JuegoDeLaVida juego = new JuegoDeLaVida();
        juego.setSize(900, 650);
        juego.setVisible(true);
    }
}