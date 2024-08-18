package de.cm.mandelproto.gui;

import de.cm.mandelproto.math.ComplexNumber;
import de.cm.mandelproto.math.MandelbrotPointMap;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

    public static final String CREATE_MANDELBROT_TREE = "Create Mandelbrot Tree";

    MandelbrotPointMap currentMandelBrotMap;

    private final Panel_Mandelbrot panelMandelbrot;

    public final static MandelbrotPointMap STARTINGMAP =
            new MandelbrotPointMap(
                    new ComplexNumber(-.5d,0d),
                    16*0.24d,
                    9*0.24d,
                    1280,
                    250
            );

    public MainFrame() {
        super();

        createMenu();

        setSize(480, 240);
        setAlwaysOnTop(true);

        panelMandelbrot = new Panel_Mandelbrot(this);
        getContentPane().add(panelMandelbrot);

        setVisible(true);
        createMandelBrotImage(STARTINGMAP);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setVisible(true);

        JMenu menuCreate = new JMenu("Create");
        menuBar.add(menuCreate);

        JMenuItem menuItem = new JMenuItem(CREATE_MANDELBROT_TREE);
        menuItem.addActionListener(this);
        menuCreate.add(menuItem);

        setJMenuBar(menuBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("start actionPerformed : Thread " + Thread.currentThread().getName());
        //createDialog(this).setVisible(true);
    }

    public void createMandelBrotImage(MandelbrotPointMap mandelbrotPointMap) {
        new Thread(() -> {
            System.out.println("new Thread : Thread " + Thread.currentThread().getName());
            new ImageFrame(mandelbrotPointMap,this).draw();
        }).start();
    }

    public void initNewMandelbrotMap(ComplexNumber center, Double width){
        panelMandelbrot.init(center,width);
    }

}
