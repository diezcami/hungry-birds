import java.io.Serializable;
public class Coordinate implements Serializable{
    public int x;
    public int y;
    
    // Constructor
    public Coordinate (int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    // Mutator Methods    
    public void setX (int x) {
        this.x = x;
    }
    
    public void setY (int y) {
        this.y = y;
    }
    
    public void setCoordinate (int x, int y) {
        this.x = x;
        this.y = y;
    }   
    
    // Accessor Methods
    public int getX () {
        return x;
    }
    
    public int getY () {
        return y;
    }
    
}
