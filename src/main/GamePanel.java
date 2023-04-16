package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class GamePanel extends JPanel implements MouseListener {
    private String clicked;
    private String option = "";
    ImageIcon fondo;
    Label matriz[][] = new Label[5][5];

    public GamePanel() {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = new Label(i, j);
                matriz[i][j].addMouseListener(this);
                add(matriz[i][j]);
            }
        }

        setLayout(new GridLayout(5, 5, 2, 2));
        setBorder(new EmptyBorder(100, 300, 100, 300));
    }

    public void paint(Graphics g) {
        Dimension size = getSize();
        fondo = new ImageIcon(getClass().getResource("/assets/fondo1.jpg"));
        g.drawImage(fondo.getImage(), 0, 0, size.width, size.height, null);
        setOpaque(false);
        super.paint(g);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        this.clicked = e.getComponent().getName();

        if (this.option != "") {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {


                    if (matriz[i][j].getName() == this.clicked) {


                        //logic validation

                        Main.i = i;
                        Main.j = j;
                        Main main = new Main();
                        main.mouseClicked(this.option);
                        //Graph validation
                        if(Main.validated){
                            matriz[i][j].setBG("./src/assets/" + this.option + ".png");

                        }

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
