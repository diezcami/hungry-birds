import java.util.ConcurrentModificationException;
public class HealerSpawner implements Runnable {
    HungryBirds hungrybirds;
    
    public HealerSpawner (HungryBirds s){
        hungrybirds = s;
    }
    
    @Override
    public void run() throws ConcurrentModificationException{
        while (true) {
            hungrybirds.createHealer();
            try {
                Thread.sleep(25000);
            } catch (InterruptedException e) {}
        }
    }
}