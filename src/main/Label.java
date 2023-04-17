package main;

import javax.swing.*;
import java.awt.*;

class Label extends JLabel {

    private int i;
    private int j;
    private boolean empty = true;

    private ImageIcon icon;

    public Label(int i, int j) {
        this.i = i;
        this.j = j;
        setName("" + this.i + this.j);
        setBackground(new Color(117, 117, 117));
        setOpaque(true);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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

        Image imagen = icon.getImage();
        Image imagenEscalada = imagen.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);

        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
        this.setIcon(iconoEscalado);
    }
}
