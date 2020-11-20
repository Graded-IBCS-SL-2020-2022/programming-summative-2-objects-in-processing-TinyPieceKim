
/** MAKE SURE TO READ THE README CAREFULLY BEFORE YOU BEGIN EDITING THIS CODE */
//hi
import processing.core.PApplet;
import java.lang.Math;

public class Sketch extends PApplet {

    /*
     * SUMMATIVE REQUIRED Declare at least four balls, four bubbles, and four
     * snowflakes as instance variables. I have made the first ball for you.
     * 
     * SUMMATIVE OPTIONAL Use *arrays* to store the elements, rather than individual
     * variables.
     */

    Ball b1;
    Ball b2;
    Ball b3;
    Ball b4;

    Bubble bb1;
    Bubble bb2;
    Bubble bb3;
    Bubble bb4;

    Snowflake sf1;
    Snowflake sf2;
    Snowflake sf3;
    Snowflake sf4;

    boolean b1stopped = false;
    boolean b2stopped = false;
    boolean b3stopped = false;
    boolean b4stopped = false;


    private int count;
    private boolean reset = false;
    //private boolean countset = false;
    private float pointX;
    private float pointY;
    private boolean onlyOnce = true;

    private boolean blue = true;
    private boolean green;
    private boolean red;
    private boolean yellow;

    int tempColor = 0;


    public void settings() {
        size(500, 500);
    }

    /*
     * SUMMATIVE REQUIRED Initialize the balls, bubbles, and snowflakes using your
     * constructors inside of setup(). You must use a non-default-constructor at
     * least once and a default constructor at least once for each type.
     * 
     * I have done the first ball for you.
     */
    public void setup() {
        frameRate(30);
        b1 = new Ball(this);
        b2 = new Ball(this);
        b3 = new Ball(this, 150, 250, 100, true, 4, 7);
        b4 = new Ball(this, 350, 250, 110, true, 7, 4);

        bb1 = new Bubble(this);
        bb2 = new Bubble(this);
        bb3 = new Bubble(this, 150, 100, 65, 255, 150, 10, 150, 1, -3);
        bb4 = new Bubble(this, 350, 100, 80, 255, 150, 10, 150, 1, -3);

        sf1 = new Snowflake(this);
        sf2 = new Snowflake(this);
        sf3 = new Snowflake(this, 150, 100, 100, 255, 150, 255, 50, -2, 2);
        sf4 = new Snowflake(this, 350, 100, 100, 255, 150, 255, 50, 1, 3);
    }

    public void draw() {
          background(45);

        /* SUMMATIVE REQUIRED Draw and move all balls, snowflakes, and bubbles */
        b1.drawBall();
        b1.moveBall();
        b2.drawBall();
        b2.moveBall();
        b3.drawBall();
        b3.moveBall();
        b4.drawBall();
        b4.moveBall();

        bb1.drawBubble();
        bb1.moveBubble();
        bb2.drawBubble();
        bb2.moveBubble();
        bb3.drawBubble();
        bb3.moveBubble();
        bb4.drawBubble();
        bb4.moveBubble();

        sf1.drawSnowflake();
        sf1.moveSnowflake();
        sf2.drawSnowflake();
        sf2.moveSnowflake();
        sf3.drawSnowflake();
        sf3.moveSnowflake();
        sf4.drawSnowflake();
        sf4.moveSnowflake();

        /*if(reset)
        {
          countset = true;
          reset = false;
        }
        if(countset){
          count++;
          if(count >= 150){
            sf1.SpeedToNormal();
            sf2.SpeedToNormal();
            sf3.SpeedToNormal();
            sf4.SpeedToNormal();
            count = 0;
            countset = false;
          }*/
        if(reset && sf1.x <= pointX+20 && sf1.x >= pointX-20 && sf1.y <= pointY+20 && sf1.y >= pointY-20){
        sf1.SpeedToNormal();
        sf2.SpeedToNormal();
        sf3.SpeedToNormal();
        sf4.SpeedToNormal();
        onlyOnce = true;
        reset = false;
      }
        
    }

    /**
     * Convenience method to return a random color
     * 
     * @param transluscent if true, make the color transluscent, otherwise solid
     */
    public int randomColor(boolean transluscent) {
        int alpha;
        if (transluscent) {
            alpha = 125;
        } else {
            alpha = 255;
        }

        if(blue)
        {
          tempColor = color(random(55, 159), random(142, 202), 255, alpha);
        }
        else if(green)
        {
          tempColor = color(random(66, 158), random(247, 255), random(90, 164), alpha);
        }
        else if(red)
        {
          tempColor = color(255, random(34,92), random(50, 92), alpha);
        }
        else if(yellow)
        {
          tempColor = color(255, random(231, 255), random(108, 127), alpha);
        }

        return tempColor;
        
    }

    /*
     * SUMMATIVE OPTIONAL Add a void method called mousePressed() that stops some or
     * all of the balls from moving when you click the mouse. (it will run
     * automatically when you click if the name is correct)
     * 
     * EXTRA CHALLENGE - can you make it so that only the ball you actually CLICKED
     * stops? (this is a major challenge - you can use the variables mouseX and
     * mouseY to see where the mouse was clicked.)
     */
    public void mousePressed()
    {
      if(Math.sqrt((mouseX-b1.x)*(mouseX-b1.x)+(mouseY-b1.y)*(mouseY-b1.y)) <= b1.getRadius() && !b1stopped)
      {
        b1stopped = true;
        b1.stop();
        
        blue = true;
        green = false;
        red = false;
        yellow = false;

        b1.col = randomColor(true);
        b2.col = randomColor(true);
        b3.col = randomColor(true);
        b4.col = randomColor(true);

      }
      else if(Math.sqrt((mouseX-b1.x)*(mouseX-b1.x)+(mouseY-b1.y)*(mouseY-b1.y)) <= b1.getRadius() && b1stopped)
      {
        b1stopped = false;
        b1.start();
      }
      if(Math.sqrt((mouseX-b2.x)*(mouseX-b2.x)+(mouseY-b2.y)*(mouseY-b2.y)) <= b2.getRadius() && !b2stopped)
      {
        b2stopped = true;
        b2.stop();

        blue = false;
        green = true;
        red = false;
        yellow = false;

        b1.col = randomColor(true);
        b2.col = randomColor(true);
        b3.col = randomColor(true);
        b4.col = randomColor(true);
      }
      else if(Math.sqrt((mouseX-b2.x)*(mouseX-b2.x)+(mouseY-b2.y)*(mouseY-b2.y)) <= b2.getRadius() && b2stopped)
      {
        b2stopped = false;
        b2.start();
      }
      if(Math.sqrt((mouseX-b3.x)*(mouseX-b3.x)+(mouseY-b3.y)*(mouseY-b3.y)) <= b3.getRadius() && !b3stopped)
      {
        b3stopped = true;
        b3.stop();

        blue = false;
        green = false;
        red = true;
        yellow = false;

        b1.col = randomColor(true);
        b2.col = randomColor(true);
        b3.col = randomColor(true);
        b4.col = randomColor(true);
      }
      else if(Math.sqrt((mouseX-b3.x)*(mouseX-b3.x)+(mouseY-b3.y)*(mouseY-b3.y)) <= b3.getRadius() && b3stopped)
      {
        b3stopped = false;
        b3.start();
      }
      if(Math.sqrt((mouseX-b4.x)*(mouseX-b4.x)+(mouseY-b4.y)*(mouseY-b4.y)) <= b4.getRadius() && !b4stopped)
      {
        b4stopped = true;
        b4.stop();

        blue = false;
        green = false;
        red = false;
        yellow = true;

        b1.col = randomColor(true);
        b2.col = randomColor(true);
        b3.col = randomColor(true);
        b4.col = randomColor(true);
      }
      else if(Math.sqrt((mouseX-b4.x)*(mouseX-b4.x)+(mouseY-b4.y)*(mouseY-b4.y)) <= b4.getRadius() && b4stopped)
      {
        b4stopped = false;
        b4.start();
      }
      

      
      if(onlyOnce){
        sf1.changeSpeed(mouseX, mouseY);
        sf2.changeSpeed(mouseX, mouseY);
        sf3.changeSpeed(mouseX, mouseY);
        sf4.changeSpeed(mouseX, mouseY);
        reset = true;
        
        pointX = mouseX;
        pointY = mouseY;
        onlyOnce = false;

        
      }// fix the bug that only the first click works and other clicks dont work... 
      
    }


    public static void main(String[] args) {
        PApplet.main("Sketch");
    }
}
