package main;

import javax.swing.*;
import java.awt.*;

class Button extends JButton {
    public Button(String img, String title) {
        setText(title);
        setName(title);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
}
