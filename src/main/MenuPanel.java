package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class MenuPanel extends JPanel implements MouseListener {

    private String option;

    Observ _opt = new Observ();
    JLabel label6;

    public MenuPanel() {

        setLayout(new GridLayout(18, 1, 10, 10));
        setBackground(new Color(100, 100, 100));

        setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel label1 = new JLabel("Opciones de construcción");

        JLabel label2 = new JLabel("Carreteras");
        Button street = new Button("", "Carretera");
        street.addMouseListener(this);

        JLabel label3 = new JLabel("Residencias");
        Button home = new Button("", "Residencia");
        home.addMouseListener(this);

        JLabel label4 = new JLabel("Fábricas de recursos");
        Button fabrica = new Button("", "Fábrica");
        fabrica.addMouseListener(this);

        JLabel label5 = new JLabel("Edificios de servicios");
        Button water = new Button("", "Agua");
        water.addMouseListener(this);

        Button electric = new Button("", "Electricidad");
        electric.addMouseListener(this);

        add(label1);
        add(label2);
        add(street);
        add(label3);
        add(home);
        add(label4);
        add(fabrica);
        add(label5);
        add(water);
        add(electric);

    }

    public String getOption() {
        return this.option;
    }

    public void mouseClicked(MouseEvent e) {
        this.option = e.getComponent().getName();
        this._opt.setOptionOB(this.option);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
