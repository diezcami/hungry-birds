import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
public class Bomb extends GameObject{
    public int x, y, width, height;
    
    public boolean isHealthy;    
    public Bomb(Ship ship) { // What exists when it's called
        this.x = ship.x -5;
        this.y = ship.y + 40;   
        this.width = 40;
        this.height = 40;    
        
        this.isHealthy = false;
    }
    
    public void draw (Graphics g) { 
        Graphics2D g2d = (Graphics2D) g;    
        
        g2d.setColor (new Color(0,0,0,0));
        g2d.fillRect (x, y, width, height);   
        
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("Egg.png"));
        } catch (IOException e) {}
        
        g.drawImage( image, x, y, null );   
    }
    
    public Rectangle getRectangle (){
        return new Rectangle (x, y, width, height);
    }    
}