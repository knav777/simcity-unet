package main;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

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
        setSize(w, h);
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
