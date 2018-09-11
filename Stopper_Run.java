

  import java.awt.Color;

  import javax.swing.JButton;
  import javax.swing.JFrame;
  import javax.swing.JLabel;
  import javax.swing.JTextArea;
  public class Stopper_Run {


    public static void main(String args[]){
      
      JFrame f = new JFrame("Stopper");
      Stopper s = new Stopper();
      f.setSize(800, 600);
      f.add(s);
      f.setVisible(true);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JTextArea text = new JTextArea("\t\t\t           Stopper: The Game");
      JLabel lab1 = new JLabel("Try to get the lowest score possible by hitting space to stop/continue the ball movement" , JLabel.CENTER);
      JFrame intro = new JFrame("Welcome!");
      JButton b1 = new JButton("X");
      text.setSize(800,100);
      intro.setSize(800,600);
      b1.setSize(50,50);
      lab1.setSize(60,60);
      intro.add(text);
      intro.add(b1);
      intro.add(lab1);
      intro.setVisible(true);

      
      
    }
  }

