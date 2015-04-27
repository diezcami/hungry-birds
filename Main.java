import javax.swing.*;
public class Main extends JFrame{    
       public static void main(String args[]){
           JFrame jframe = new JFrame();
           HungryBirds hungrybirds = new HungryBirds();
           jframe.add(hungrybirds);
           
           jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           jframe.setSize(600, 700);
           jframe.setTitle ("Hungry Birds");
           jframe.setVisible(true);
           jframe.setResizable(false);
          
           jframe.getContentPane();
           jframe.add(new HungryBirds());
        }       
}
