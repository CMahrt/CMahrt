package de.cm.mandelproto.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DoubleTextField extends JPanel {

    private final JPanel panel;
    private final JLabel label;
    private final JTextField textField;

    public DoubleTextField(String label) {
        super();
        panel = new JPanel(new GridLayout(0, 2));
        this.label = new JLabel(label + " : ");
        this.label.setHorizontalAlignment(JLabel.CENTER);
        this.textField = new JTextField();
        this.textField.setHorizontalAlignment(JTextField.CENTER);
        panel.add(this.label);
        panel.add(textField);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
            }
        });
        add(panel);
    }

    public Double getDouble() {
        return Double.parseDouble(textField.getText());
    }

    public void setDouble(double x) {
        textField.setText(Double.toString(x));
    }
}
