import java.awt.*;
public class Spawn extends GameObject{
    public int x, y, width, height;
    public Spawn() { // What exists when it's called
        x=200;
        y=250;
        width=15;
        height=15;
    }
    
    public void draw (Graphics g) { 
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor (Color.ORANGE);
        g2d.fillRect (x, y, width, height);        
    }
    
    public Rectangle getRectangle (){
        return new Rectangle (x, y, width, height);
    }
}