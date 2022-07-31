package planeFight;



import javax.swing.*;
import java.awt.*;
public class MyPlane {
    private int x, y;
    private int vx, vy;
    private ImageIcon myicon = new ImageIcon(this.getClass().getResource("PaperPlane.png"));
    public MyPlane(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void drawPlane(Graphics g) {
        g.drawImage(myicon.getImage(), x, y, null);
        x += vx;
        y += vy;
    }
    public void setVx(int vx) {
        this.vx = vx;
    }
    public void setVy(int vy) {
        this.vy = vy;
    }
}