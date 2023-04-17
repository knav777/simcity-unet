package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

class MenuPanel extends JPanel implements MouseListener, Observer {

    private String option;

    Observ _opt = new Observ();
    JLabel money;
    JLabel happiness;
    JLabel population;
    JLabel level;
    JLabel message;



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

        JLabel label6 = new JLabel("__________");

        JLabel label7 = new JLabel(Main.info);

        money = new JLabel("Dinero: " + Main.money.getValue()+"");
        level = new JLabel("Nivel: "+Main.level.getValue()+"");
        happiness = new JLabel("Felicidad: " + Main.happiness.getValue()+"");
        population = new JLabel("Poblacion: "+Main.population.getValue()+"");
        message = new JLabel(Main.message.getOptionOB());

        Main.money.addObserver(this);
        Main.level.addObserver(this);
        Main.happiness.addObserver(this);
        Main.population.addObserver(this);
        Main.message.addObserver(this);

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
        add(label6);
        add(level);
        add(money);
        add(population);
        add(happiness);
        add(label6);
        add(label7);
        add(message);

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

    @Override
    public void update(Observable o, Object arg) {
        money.setText("Dinero: "+Main.money.getValue()+"");
        population.setText("Poblacion: "+Main.population.getValue()+"");
        happiness.setText("Felicidad: "+Main.happiness.getValue()+"");
        level.setText("Nivel: "+Main.level.getValue()+"");
        message.setText(Main.message.getOptionOB());
        updateUI();
    }
}
