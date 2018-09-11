import  javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.Random;

  public class Stopper extends JPanel implements ActionListener, KeyListener {
    Timer t = new Timer (5,this);
    double x = 0, y = 0, velx = 0, vely = -5, count = 0, width = 0.0 , length = 0.0, total = 0.0, highscore = 0.0, replays = 0, difficulty = 5, draw1 = 570, draw2 = 385, dcount = 0;
      boolean check = false, calc = false;
    
    public Stopper(){
      t.start();
      addKeyListener(this);
      setFocusable(true);
      setFocusTraversalKeysEnabled(false);

    }
    
  
    
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.fill(new Rectangle2D.Double(0,0,780,10));
      g2.fill(new Ellipse2D.Double(x+10, y+10, 60, 60));
      g2.fill(new Rectangle2D.Double(0,0,10,562));
      g2.fill(new Rectangle2D.Double(0,552,780,10));
      g2.fill(new Rectangle2D.Double(774,0,10,562));
      
      if (dcount == 0)
      g2.draw(new Ellipse2D.Double(570,385,60,60));
      
      else
        g2.draw(new Ellipse2D.Double(draw1, draw2, 60,60));
      
      
      g2.fill(new Rectangle2D.Double(150,0,10,562));
      
      
      
      if(velx == 0 && vely == 0)
      {
        width = this.x;
        length = this.y;
        if(count == 3)
        {calculate();
        count = 4;
        }
      }
      
      g2.setColor(Color.RED);
      
      g2.drawString("Try to get the lowest score possible! (Click 'R' to restart)" , 320, 40);
      g2.drawString("Hint: Click '1' , '2' or '3' to change the difficulty", 320, 550);
      
      if (count == 4) 
        g2.drawString("Your Score: " + total , 650, 520);
      

      g2.drawString("Best Score: " + highscore, 650, 500);


    }
    

    
    public void actionPerformed(ActionEvent e){
      repaint();
      
      if(x < 0 || x > 705)
        velx = -velx;
      if(y < 0 || y > 475)
        vely = -vely;
        
      x += velx;
      y += vely;
      
    }
    
    
    public void right(){
      velx = difficulty;
      vely = 0;
    }
    public void stop(){
      velx = 0; 
      vely = 0;
    }
    
    public void calculate(){ 
      
      total =  Math.abs((draw1 - 10 - width)) +  Math.abs((draw2 - 10 - length));

      if (highscore > total || replays == 0)
        highscore = total;
    
    }

  

    public void Random(){
      count = 0;
      x = 10;
      y = 10;
      vely = -difficulty;
      velx = 0;
      replays++;
      
      Random rGen = new Random();
      draw2 = (rGen.nextInt(300)+140);
      draw1 = (rGen.nextInt(350)+200);
      
      while (draw2 % difficulty != 0)
        draw2 = rGen.nextInt(300)+140;
      
      while (draw1 % difficulty != 0)
        draw1 = rGen.nextInt(350)+200;
        
      dcount++;
    }
    
    public void keyPressed(KeyEvent e){
      int code = e.getKeyCode();
      if (code == KeyEvent.VK_SPACE)
        
      {if (count == 0)
        stop();
      else if (count == 1)
        right();
      else if (count == 2)
        stop();
      
      count++;
      }
      
      if(code == KeyEvent.VK_1)
        {difficulty = 5;
          vely = difficulty;
          velx = 0;
        count = 0;
        x = 10;
        y = 10;
        Random();
        }
      
      if(code == KeyEvent.VK_2)
        {difficulty = 10;
          vely = difficulty;
          velx = 0;
        count = 0;
        x = 10;
        y = 10;
        Random();
        
        }
      
      if(code == KeyEvent.VK_3)
        {difficulty = 25;
          vely = difficulty;
          velx = 0;
        count = 0;
        x = 10;
        y = 10;
        Random();
        }
      
      
      if (code == KeyEvent.VK_R)
        {count = 0;
        x = 10;
        y = 10;
        vely = -difficulty;
        velx = 0;
        replays++;
        
        Random rGen = new Random();
        draw2 = (rGen.nextInt(300)+140);
        draw1 = (rGen.nextInt(350)+200);
        
        while (draw2 % difficulty != 0)
          draw2 = rGen.nextInt(300)+140;
        
        while (draw1 % difficulty != 0)
          draw1 = rGen.nextInt(350)+200;
          
        dcount++;
        }
      
       
      if(code == KeyEvent.VK_E)
      {
        difficulty = 1;
          vely = difficulty;
          velx = 0;
        count = 0;
        x = 10;
        y = 10;
      }

    }
    
    public void keyTyped(KeyEvent e){};
    public void keyReleased(KeyEvent e){};

}