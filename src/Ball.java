/** MAKE SURE TO READ THE README CAREFULLY BEFORE YOU BEGIN EDITING THIS CODE */
class Ball {
    private Sketch s;
    private float diameter;
    public float x;
    public float y;
    public int col;
    private int borderCol;
    private float speedY;
    private float speedX;
    private float tempSy; // temporary variable that
    private float tempSx; // stores speed data when it stop()s



    /**
     * The default constructor generates random values for most of the instance
     * variables.
     */
    public Ball(Sketch sketch) {
        s = sketch;
        diameter = s.random(100, 150); // random diameter between 50 and 150
        x = s.random(diameter / 2, s.width - diameter / 2);
        y = s.random(diameter / 2, s.height - diameter / 2);

        /*
         * SUMMATIVE REQUIRED use the randomColor() method in the sketch to set default
         * balls to a solid random color
         */
        col = s.randomColor(false); // randomly make it true or false **REWRITE**
        borderCol = s.color(235, 150);
        /*
         * SUMMATIVE REQUIRED Set speedX and speedY to reasonable defaults. Random
         * numbers could be nice, but are not required.
         */
         speedX = s.random(2, 5);
         speedY = s.random(2, 5);
    }

    /** This constructor lets you specify all of the ball instance variables */
    public Ball(Sketch ss, float X, float Y, float ballDiam, boolean tsl, float sx, float sy) {
        s = ss;
        x = X;
        y = Y;
        diameter = ballDiam;
        col = s.randomColor(tsl);
        borderCol = s.color(235, 150); 
        speedX = sx;
        speedY = sy;
    }

    /*
     * SUMMATIVE REQUIRED Add a method called `getRadius()` that returns a float
     * representing the radius of the ball
     */
    public float getRadius()
    {
      float f = diameter / 2;
      return f;
    }

    /*
     * SUMMATIVE OPTIONAL Add a method called `stop()` that sets the ball speed to
     * 0, and another one called `start()` that starts it moving again, either at
     * the same speed as before or a random speed.
     * 
     * If you create the methods, you'll need to think of a way to test them...
     */
     public void stop(){
       tempSx = speedX;
       tempSy = speedY;
       speedX = 0;
       speedY = 0;
     }
     public void start()
     {
       speedX = tempSx;
       speedY = tempSy;
     }

     

    /** Draws the ball. */
    public void drawBall() {
        /*
         * SUMMATIVE OPTIONAL Make it possible to change the border color of these balls
         * as well as the fill color. Change the `sketch.stroke(col)` line below to use
         * the border color to make it show up. You will need to make other changes too.
         */

        s.stroke(borderCol);
        s.fill(col);
        s.ellipse(x, y, diameter, diameter);
    }

    /** Moves the balls. */
    public void moveBall() {

        /* If the ball is on the edge, flip the direction. Bounce! */
        if (x > (s.width - getRadius()) || x < getRadius()) {
            speedX = -speedX;
        }
        if (y > (s.height - getRadius()) || y < getRadius()) {
            speedY = -speedY;
        }
        /* Add the speed in both directions to move the ball */
        x += speedX;
        y += speedY;
    }
}