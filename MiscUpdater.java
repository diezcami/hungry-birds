import java.util.ConcurrentModificationException;
public class MiscUpdater implements Runnable {
    HungryBirds hungrybirds;
    
    public MiscUpdater (HungryBirds s){
        hungrybirds = s;
    }
    
    @Override
    public void run() throws ConcurrentModificationException{
        while (true) {
            hungrybirds.updateBombs();
            hungrybirds.updateMisc();
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {}
        }
    }
}