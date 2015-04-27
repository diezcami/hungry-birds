import java.awt.*;
import java.lang.Math.*;
public class Bullet extends GameObject {
    public int x, y;

    public double angle;
    public boolean isHealthy;
    public Bullet(Ship ship) { // What exists when it's called
        this.x = (ship.x + 10) - (int)(15 * Math.cos (Math.toRadians(ship.angle)) );
        this.y = (ship.y + 10) - (int)(15 * Math.sin (Math.toRadians(ship.angle)) );
    
        this.angle = ship.angle;    
        this.isHealthy = false;
    }
    
    public void draw (Graphics g) { 
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor (Color.ORANGE);
        g2d.fillRect (x, y, 3, 3);        
    }
    
    public Rectangle getRectangle (){
        return new Rectangle (x, y, 3, 3);
    }    
}