import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
public class Asteroid extends GameObject{
    public int x, y, width, height;

    public double angle;
    public boolean isHealthy;    
    public Asteroid(double angle, int size, int x, int y) { // What exists when it's called
        this.x = x;
        this.y = y;
        this.height = size;
        this.width = size;
        
        this.angle = angle;       
        this.isHealthy = true;
    }
    
    public void draw (Graphics g) { 
        Graphics2D g2d = (Graphics2D) g;     
        g2d.setColor (new Color(0,0,0,0));
        g2d.fillRect (x, y, width, height); 
        
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("Cloud.png"));
        } catch (IOException e) {}
        
        g.drawImage( image, x, y, null );                    
    }
    
    public Rectangle getRectangle (){
        return new Rectangle (x, y, width, height);
    }
}