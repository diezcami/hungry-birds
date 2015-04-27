import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
public class Ship extends GameObject{
    public int x, y, width, height;
    
    public int health;
    public double angle; // expressed in degrees
    public int pointerX, pointerY;
    
    public int wins, losses, score;
    public boolean isHealthy;   
    public Ship() { // What exists when it's called
        this.x = 200;
        this.y = 200;
        this.width = 20;
        this.height = 20;   
        
        this.pointerX = (this.x + 15) - (int)(12 * Math.cos (Math.toRadians(this.angle)) );
        this.pointerY = (this.y + 15) - (int)(12 * Math.sin (Math.toRadians(this.angle)) );  
        
        this.health = 5;
        this.angle = 90;

        this.score = 0;
        this.wins = 0;
        this.losses = 0;
        this.isHealthy = true;
    }
    
    public void draw (Graphics g) { 
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor (new Color(0,0,0,0));
        g2d.fillRect (x, y, width, height);  
        
        // g2d.setColor (Color.ORANGE);
        // g2d.fillRect (pointerX, pointerY, 8, 8);
        
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("Bird1.png"));
        } catch (IOException e) {}
        
        g.drawImage( image, x, y, null );   
        g2d.setColor(Color.WHITE);
        g2d.drawString("Health Remaining: " + health*20 + "%", 5, 15);
        g2d.drawString("Rounds Lost: " + losses, 5, 30);     
        g2d.drawString("Clouds Popped: " + score/50, 5, 45); 
    }
    
    public Rectangle getRectangle (){
        return new Rectangle (x, y, width, height);
    }
    
    public void loseRound (){
        losses+=1;
        health=5;
        x=200;
        y=250;
    }
}