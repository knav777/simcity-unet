package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

public class Main extends JFrame{

    public static void main(String[] args) {

        GameWindow window = new GameWindow();
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class GameWindow extends JFrame implements Observer {

    MenuPanel menu;
    GamePanel game;
    public GameWindow() {

        menu = new MenuPanel();
        game = new GamePanel();

        setLayout(new BorderLayout());
        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension sizeScreen = screen.getScreenSize();
        int h = sizeScreen.height;
        int w = sizeScreen.width;
        setSize(w-150, h-100);
        setLocation(75, 30);
        setTitle("SimCity - Proyecto simulación");
        Image icon = screen.getImage("./src/assets/icon.png");
        setIconImage(icon);

        menu._opt.addObserver(this);

        add(menu, BorderLayout.WEST);
        add(game, BorderLayout.CENTER);
    }
    @Override
    public void update(Observable o, Object arg) {
        game.setOption(menu.getOption());
        menu.updateUI();
    }
}

class GamePanel extends JPanel implements MouseListener{
    private String clicked;
    private String option = "";
    ImageIcon fondo;
    Label matriz[][] = new Label[10][10];
    public GamePanel(){

        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                matriz[i][j]=new Label(i,j);
                matriz[i][j].addMouseListener(this);
                add(matriz[i][j]);
            }
        }

        setLayout(new GridLayout(10,10,2,2));
        setBorder(new EmptyBorder(50,150,50,150));
    }

    public void paint(Graphics g){
        Dimension size = getSize();
        fondo = new ImageIcon(getClass().getResource("/assets/fondo1.jpg"));
        g.drawImage(fondo.getImage(), 0, 0, size.width, size.height, null);
        setOpaque(false);
        super.paint(g);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        this.clicked = e.getComponent().getName();

        if(this.option != ""){
            for(int i=0; i<10; i++) {
                for(int j=0; j<10; j++) {
                    if(matriz[i][j].getName() == this.clicked) {
                        matriz[i][j].setBG("./src/assets/"+this.option+".png");
                    }
                }
            }
        }

        this.updateUI();
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

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}

class Observ extends Observable {
    private String optionOB;

    public void setOptionOB(String value) {
        this.optionOB = value;
        setChanged();
        notifyObservers(value);
    }
}


class MenuPanel extends JPanel implements MouseListener {

    private String option;

    Observ _opt = new Observ();
    JLabel label6;
    public MenuPanel(){

        setLayout(new GridLayout(18,1,10,10));
        setBackground(new Color(100,100,100));

        setBorder(new EmptyBorder(10,10,10,10));

        JLabel label1 = new JLabel("Opciones de construcción");

        JLabel label2 = new JLabel("Carreteras");
        Button street = new Button("","Carretera");
        street.addMouseListener(this);

        JLabel label3 = new JLabel("Residencias");
        Button home = new Button("","Residencia");
        home.addMouseListener(this);

        JLabel label4 = new JLabel("Fábricas de recursos");
        Button fabrica = new Button("","Fábrica");
        fabrica.addMouseListener(this);

        JLabel label5 = new JLabel("Edificios de servicios");
        Button water = new Button("","Agua");
        water.addMouseListener(this);

        Button electric = new Button("","Electricidad");
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

    public String getOption () {
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

class Button extends JButton {
    public Button(String img, String title){
        setText(title);
        setName(title);
    }
}

class Label extends JLabel{

    private int i;
    private int j;
    private boolean empty = true;

    private ImageIcon icon;
    public Label(int i, int j) {
        this.i = i;
        this.j = j;
        setName(""+this.i+this.j);
        setBackground(new Color(117,117,117));
        setOpaque(true);
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public int getI() {
        return this.i;
    }

    public int getJ() {
        return this.j;
    }

    public void setBG(String path) {
        this.icon = new ImageIcon(path);
        this.setIcon(this.icon);
    }
}