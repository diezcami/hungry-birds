import java.util.ConcurrentModificationException;

public class GenUpdater implements Runnable {
    HungryBirds hungrybirds;
    
    public GenUpdater (HungryBirds s){
        hungrybirds = s;
    }
    
    @Override
    public void run() throws ConcurrentModificationException {
        while (true) {
            hungrybirds.updateCollisions();            
            hungrybirds.updateAsteroids();            
            hungrybirds.updateBullets();
            hungrybirds.repaint();            
            
            try {
                Thread.sleep(33);
            } catch (InterruptedException e) {} 
        }
    }
}