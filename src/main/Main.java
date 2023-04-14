package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Main extends JFrame{

    public static void main(String[] args) {

        GameWindow window = new GameWindow();
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class GameWindow extends  JFrame {
    public GameWindow() {

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
        MenuPanel menu = new MenuPanel();
        GamePanel game = new GamePanel();
        add(menu, BorderLayout.WEST);
        add(game, BorderLayout.CENTER);
    }
}

class GamePanel extends JPanel {

    ImageIcon fondo;
    Label [] matriz = new Label[100];
    public GamePanel(){

        for(int i=0; i<100; i++) {
            matriz[i] = new Label(""+i);
            add(matriz[i]);
        }

        setLayout(new GridLayout(10,10,10,10));
        setBorder(new EmptyBorder(50,150,50,150));
    }

    public void paint(Graphics g){
        Dimension size = getSize();
        fondo = new ImageIcon(getClass().getResource("/assets/fondo1.jpg"));
        g.drawImage(fondo.getImage(), 0, 0, size.width, size.height, null);
        setOpaque(false);
        super.paint(g);
    }
}



class MenuPanel extends JPanel {
    public MenuPanel(){

        setLayout(new GridLayout(18,1,10,10));
        setBackground(new Color(117,117,117,100));

        setBorder(new EmptyBorder(10,10,10,10));

        JLabel label1 = new JLabel("Opciones de construcción");
        JLabel label2 = new JLabel("Carreteras");
        Button street = new Button("","Carretera");
        JLabel label3 = new JLabel("Residencias");
        Button home = new Button("","Residencia");
        JLabel label4 = new JLabel("Fábricas de recursos");
        Button fabrica = new Button("","Fábrica");
        JLabel label5 = new JLabel("Edificios de servicios");
        Button water = new Button("","Agua");
        Button electric = new Button("","Electricidad");

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
}

class Button extends JButton {
    public Button(String img, String title){
        setText(title);
    }
}

class Label extends JLabel{
    public Label(String text) {
        setText(text);
        setBackground(new Color(117,117,117,100));
        setOpaque(true);
    }
}