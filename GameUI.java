package planeFight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class GameUI implements KeyListener {
    private JFrame jf;
    private Graphics g;
    private MyPlane myPlane;
    private MyThread myThread;
    private ImageIcon bgicon = new ImageIcon(this.getClass().getResource("bg.jpeg"));
    private int speed = 5;
    public static void main(String arg[]) {
        GameUI gameUI = new GameUI();
        gameUI.showUI();
    }
    private void showUI() {
        jf = new JFrame();
        jf.setTitle("雷霆战机");
        jf.setSize(800, 800);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(3);
        jf.setVisible(true);
        g = jf.getGraphics();
        g.drawImage(bgicon.getImage(),0,0,null);
        jf.addKeyListener(this);
    }


    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                myPlane.setVx(-speed);
                break;
            case KeyEvent.VK_RIGHT:
                myPlane.setVx(speed);
                break;
            case KeyEvent.VK_UP:
                myPlane.setVy(-speed);
                break;
            case KeyEvent.VK_DOWN:
                myPlane.setVy(speed);
                break;
            case KeyEvent.VK_SPACE:

                if(myThread == null){
                    myPlane = new MyPlane((jf.getWidth() - 150) / 2,
                            jf.getHeight() - 150);
                    myThread = new MyThread(myPlane,g,jf);
                    new Thread(myThread).start();
                }
                break;
        }
    }


    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                myPlane.setVx(0);
                break;
            case KeyEvent.VK_RIGHT:
                myPlane.setVx(0);
                break;
            case KeyEvent.VK_UP:
                myPlane.setVy(0);
                break;
            case KeyEvent.VK_DOWN:
                myPlane.setVy(0);
                break;
        }
    }
}