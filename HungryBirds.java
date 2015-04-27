import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Math.*;


public class HungryBirds extends Canvas implements KeyListener {
    Graphics2D g2d;    
    Graphics backg;
    Image backbuffer;
    
    Random random = new Random();
    
    ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
    ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    ArrayList<Bomb> bombs = new ArrayList<Bomb>();
    ArrayList<Teleport> teleports = new ArrayList<Teleport>();
    ArrayList<Healer> healers = new ArrayList<Healer>();
    Ship ship = new Ship();       
    Spawn spawn = new Spawn();
    
    public HungryBirds () {
        setBackground ( new Color(0x00, 0xA2, 0xE8) );
        createAsteroids(15);        
        addKeyListener (this);   
        
        Thread t = new Thread(new GenUpdater(this));
        t.start();
        Thread u = new Thread(new TeleportSpawner(this));
        u.start();
        Thread v = new Thread(new MiscUpdater(this));
        v.start();
        Thread w = new Thread(new HealerSpawner(this));
        w.start();
    }
    
    
    public void paint(Graphics g) {
        backbuffer = createImage(600, 700);
        backg = backbuffer.getGraphics();
        spawn.draw(backg);
        ship.draw(backg);
        for (Bullet b : bullets){
            if (b.isHealthy) {            
                b.draw(backg);
            }
        }
        for (Asteroid a: asteroids){
            if (a.isHealthy) {
                a.draw(backg);
            }
        }       
        for (Bomb b: bombs){
            if (b.isHealthy) {
                b.draw(backg);
            }
        }        
        for (Teleport s: teleports){
            if (s.isHealthy) {
                s.draw(backg);
            }
        }
        for (Healer h: healers){
            if (h.isHealthy) {
                h.draw(backg);
            }
        }        
        
        g.drawImage(backbuffer, 0, 0, this);
    }

    public void updateShip() {
        ship.x-= (int)(12 * Math.cos (Math.toRadians(ship.angle)) );
            if (ship.x > 600) {
                ship.x = 0;
            }
            else if (ship.x < 0) {
                ship.x = 585;
            }
        ship.y-= (int)(12 * Math.sin (Math.toRadians(ship.angle)) );  
            if (ship.y > 700) {
                ship.y = 0;
            }
            else if (ship.y < 0){
                ship.y = 685;
            }
        ship.pointerX = (ship.x + 12) - (int)(12 * Math.cos (Math.toRadians(ship.angle)) );
            if (ship.x > 600) {
                ship.x = 0;
            }
            else if (ship.x < 0) {
                ship.x = 585;
            }        
        ship.pointerY = (ship.y + 12) - (int)(12 * Math.sin (Math.toRadians(ship.angle)) );   
            if (ship.y > 700) {
                ship.y = 0;
            }
            else if (ship.y < 0){
                ship.y = 685;
            }        
    } 
    
    public void updateBullets(){
        for (Bullet b : bullets){
            if (b.isHealthy) {
                b.x-= (int)(8 * Math.cos (Math.toRadians(b.angle)) );
                    if (b.x > 600) {
                        b.isHealthy = false;
                    }
                    else if (b.x < 0) {
                        b.isHealthy = false;
                    }                
                b.y-= (int)(8 * Math.sin (Math.toRadians(b.angle)) );
                    if (b.y > 700) {
                        b.isHealthy = false;
                    }
                    else if (b.y < 0){
                        b.isHealthy = false;
                    }                
            }
        }
    }
    
    public void updateAsteroids(){
        for (Asteroid a : asteroids){
            if (a.isHealthy){
                a.x+= (int)(4 * Math.cos (Math.toRadians(a.angle)) );
                if (a.x > 600) {
                    a.x = a.width/2;
                }
                else if (a.x < 0){
                    a.x = 600 - a.width/2;
                }
                a.y+= (int)(4 * Math.sin (Math.toRadians(a.angle)) );   
                
                if (a.y > 700) {
                    a.y = a.height/2;
                }
                else if (a.y < 0) {
                    a.y = 700 - a.height/2;
                }
            }
        }      
    }
    
   public void updateBombs(){
        for (Bomb b : bombs){
            if (b.isHealthy){
                for (int i=0;i<10;i++) {
                    b.y+=2;
                }
            }
        }
   }
    
    public void updateMisc(){
        for (Teleport s : teleports){
            if (s.isHealthy){
                s.width+=6;
                s.x-=3;
                if (s.width > 31) {
                    s.width = 15;
                    s.x+=6;
                }
                s.height+=6; 
                s.y-=3;
                if (s.height > 31) {
                    s.height = 15;
                    s.y+=6;
                }
            }
        }
        
        for (Healer h : healers){
            if (h.isHealthy){
                h.width+=6;
                h.x-=3;
                if (h.width > 31) {
                    h.width = 15;
                    h.x+=6;
                }
                h.height+=6; 
                h.y-=3;
                if (h.height > 31) {
                    h.height = 15;
                    h.y+=6;
                }
            }
        }   
        
        
    }
    
    public void createTeleport() { 
        Teleport s = new Teleport((random.nextInt(3)), (random.nextInt(390)), (random.nextInt(490)));
        teleports.add(s);
        s.isHealthy = true;
    }    

    public void createHealer() {
        Healer h = new Healer((random.nextInt(3)), (random.nextInt(390)), (random.nextInt(490)));
        healers.add(h);
        h.isHealthy = true;        
    }
    
    public void createAsteroids(int i){
        for (int j=0; j<i; j++) {
            Asteroid asteroid = new Asteroid((random.nextInt(359)), 40,
                        (random.nextInt(600)), (random.nextInt(700)) );
            asteroids.add(asteroid);
        }    
    }        
    
    public void updateCollisions(){
        for (Asteroid a:asteroids){
            if (a.isHealthy){
                if (a.getRectangle().intersects(ship.getRectangle())){
                    if (ship.health==1){
                        ship.loseRound();
                        restart();
                    }
                    else if (ship.getRectangle().intersects(spawn.getRectangle())){
                        ship.health = ship.health;
                    }
                    else {
                        ship.health-=1;
                        restart();
                    }
                }
                
                for (Bullet b:bullets){
                    if (b.isHealthy){
                        if (a.getRectangle().intersects(b.getRectangle())){
                            a.isHealthy = false;
                            b.isHealthy = false;
                            ship.score+=1;
                        }
                        /*
                        if (b.getRectangle().intersects(ship.getRectangle())){
                            ship.health-=1; // Not seen yet
                                if (ship.health==0){                          
                                    ship.reset();
                                }*/
                    }
                    }
                }
            }
                        
        for (Bomb b:bombs){
            if (b.isHealthy){
                if (b.getRectangle().intersects(ship.getRectangle())){
                    if (ship.health==1){
                        ship.loseRound();
                        restart();
                    }
                    else if (ship.getRectangle().intersects(spawn.getRectangle())){
                        ship.health = ship.health;
                    }
                    else {
                        ship.health-=1;
                        restart();
                    }
                }
            }
        }
        
        for (Teleport s:teleports){
            if (s.isHealthy){
                if (s.getRectangle().intersects(ship.getRectangle())){
                    s.isHealthy = false;
                    createAsteroids(15);                    
                    ship.x=200;
                    ship.y=250;
                }
            }
        }
        
        for (Healer h:healers){
            if (h.isHealthy){
                if (h.getRectangle().intersects(ship.getRectangle())){
                    h.isHealthy = false;
                    createAsteroids(3);                    
                    ship.health+=1;
                }
            }
        }             
    }

    public void restart(){
        ship.x=200;
        ship.y=250;                    
    }
    
    
    // Key Listeners
    public void keyReleased(KeyEvent e) {};
    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {
        int i = e.getKeyCode();
        switch (i) {   
            case KeyEvent.VK_LEFT: // Rotates the ship to the left
                ship.angle = ship.angle - 15; 
                updateShip();
                break;
    
            case KeyEvent.VK_RIGHT: // Rotates the ship to the right
                ship.angle = ship.angle + 15;   
                updateShip();
                break;
    
            case KeyEvent.VK_UP: // Moves the ship forward
                updateShip();
                break;

            case KeyEvent.VK_SPACE: // Creates Bullets
                for (int j = 0; j<50; j++) {
                    Bullet b = new Bullet(ship);
                    bullets.add(b);
                    b.isHealthy = true;
                }    
                break;

            case KeyEvent.VK_DOWN: // Creates bombs
                for (int j = 0; j<4; j++) {
                    Bomb b = new Bomb(ship);
                    bombs.add(b);
                    b.isHealthy = true;
                }
                break; 
        }            
        }
    }        
