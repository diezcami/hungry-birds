import java.util.ConcurrentModificationException;
public class TeleportSpawner implements Runnable {
    HungryBirds hungrybirds;
    
    public TeleportSpawner (HungryBirds s){
        hungrybirds = s;
    }
    
    @Override
    public void run() throws ConcurrentModificationException{
        while (true) {
            hungrybirds.createTeleport();
            try {
                Thread.sleep(40000);
            } catch (InterruptedException e) {}
        }
    }
}