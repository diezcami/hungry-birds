import java.awt.*;
public class GameObject {
    private int x, y, width, height;
    private Coordinate center;
    private boolean real;
    private double angle;
    
    public GameObject() {
        this.real = false;
    }
    
    public void setX (int x) {
        this.x=x;
    }    
    public void setY (int y) {
        this.y=y;
    }    
    public void setWidth (int width) {
        this.width=width;
    }
    public void setHeight (int height) {
        this.height = height;
    }
    
    public void setCenter (int x, int y){
        this.center.x = x;
        this.center.y = y;
    }
    public void setReal (boolean real){
        this.real = real;
    }
    public void setAngle (double angle){
        this.angle = angle;
    }
    
    public int getX () {
        return x;
    }
    public int getY(){
        return y;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    
    public int getCenterX(){
        return center.x;
    }
    public int getCenterY(){
        return center.y;
    }
    public boolean isReal(){
        return real;
    }
    public double getAngle(){
        return angle;
    }
}
    
        
    