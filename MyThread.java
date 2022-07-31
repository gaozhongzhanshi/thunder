package planeFight;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MyThread implements Runnable{

    private MyPlane myPlane;
    private Graphics g;
    private JFrame jf;
    private ImageIcon bgicon = new ImageIcon(this.getClass().getResource("bg.jpeg"));

    public MyThread(MyPlane myPlane, Graphics g,JFrame jf){
        this.myPlane = myPlane;
        this.g = g;
        this.jf = jf;
    }

    public void run() {

        while(true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            BufferedImage bufferedImage = new BufferedImage(jf.getWidth(),jf.getHeight(),BufferedImage.TYPE_INT_BGR);
            Graphics bg = bufferedImage.createGraphics();
            bg.drawImage(bgicon.getImage(),0,0,null);
            myPlane.drawPlane(bg);
            g.drawImage(bufferedImage,0,0,null);
        }
    }
}