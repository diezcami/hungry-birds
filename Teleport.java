import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
public class Teleport extends GameObject {
    public int x, y, width, height;

    public int type;
    public boolean isHealthy;   
    public Teleport(int type, int x, int y) { // What exists when it's called
        this.x = x;
        this.y = y;
        this.width = 15;
        this.height = 15;

        this.type = type;        
        this.isHealthy = false;
    }
    
    public void draw (Graphics g) { 
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor (new Color(0,0,0,0));
        g2d.fillRect (x, y, width, height);  
        
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("images/Heart.png"));
        } catch (IOException e) {}        
        g.drawImage( image, x, y, null );          
    }
    
    public Rectangle getRectangle (){
        return new Rectangle (x, y, width, height);
    }
    
    
}