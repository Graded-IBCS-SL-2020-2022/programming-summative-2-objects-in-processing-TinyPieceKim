/* YOU SHOULD COMPLETE AND UNDERSTAND THE Ball.java and Bubble.java parts first! */
/* DON'T FORGET TO RENAME THE FILE TO Snowflake.java WHEN READY TO TEST! */
import java.lang.Math;

class Snowflake {
    private Sketch s;
    private float diameter;
    public float x;
    public float y;
    private int col; 
    private int borderColor; 
    private float speedY;
    private float speedX;
    
    private float difX;
    private float difY;
    private float meanSpeed;
    private float tempSpeedX;
    private float tempSpeedY;


    /*
     * SUMMATIVE REQUIRED Implement this entire class. ONLY drawSnowflake() and
     * moveSnowflake() have been implemented for you! I recommend using your
     * Bubble.java as a template. Start by creating your instance variables and
     * constructors.
     */

    public Snowflake(Sketch sketch)
    {
      s = sketch;
      diameter = s.random(70, 100);
      x = s.random(diameter / 2, s.width - diameter / 2);
      y = s.random(diameter / 2, s.height - diameter / 2);
      col = s.color(235, 255);
      borderColor = s.color(255, 150);
      speedX = s.random(-3, 3);
      speedY = s.random(-3, 3);
    }

    public Snowflake (Sketch ss, float X, float Y, float sfDiam, int sfColor, int sfAlpha, int borderC, int borderA, float sx, float sy){
       s = ss;
       x = X;
       y = Y;
       diameter = sfDiam;
       col = s.color(sfColor, sfAlpha); 
       borderColor = s.color(borderC, borderA);
       speedX = sx;
       speedY = sy;
     }

     public float getRadius()
     {
       float f;
       f = diameter/2;
       return f;
     }

    /** Draws the flake. */
    public void drawSnowflake() {
        s.stroke(col);
        s.line(x - getRadius() / 2, y - getRadius() / 2, x + getRadius() / 2, y + getRadius() / 2);
        s.line(x - getRadius() / 2, y + getRadius() / 2, x + getRadius() / 2, y - getRadius() / 2);
        s.line(x - getRadius(), y, x + getRadius(), y);
        s.line(x, y - getRadius(), x, y + getRadius());
    }

    /** Moves the flake */
    public void moveSnowflake() {
        if (x > (s.width - getRadius()) || x < getRadius()) {
            speedX = -speedX;
        }
        if (y < (-getRadius())) {
            y = s.height + getRadius();
        }
        if (y > (s.height + getRadius())) {
            y = -getRadius();
        }
        x += speedX;
        y += speedY;

    }

    public void changeSpeed(float mx, float my)
    {
      difX = mx - x;
      difY = my - y;
      meanSpeed = (float)Math.sqrt(speedX*speedX + speedY*speedY);
      tempSpeedX = speedX;
      tempSpeedY = speedY;

      speedX = difX/(100/meanSpeed);
      speedY = difY/(100/meanSpeed);
    }

    public void SpeedToNormal()
    {
      speedX = tempSpeedX;
      speedY = tempSpeedY;
    }
}
