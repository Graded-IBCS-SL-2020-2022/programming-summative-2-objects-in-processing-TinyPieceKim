/** MAKE SURE TO READ THE README CAREFULLY BEFORE YOU BEGIN EDITING THIS CODE */
import processing.core.PApplet;

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
        sf4 = new Snowflake(this, 350, 100, 100, 255, 150, 255, 50, 1, 2);
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
        return color(random(55, 159), random(142, 202), 255, alpha);
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

    public static void main(String[] args) {
        PApplet.main("Sketch");
    }
}
