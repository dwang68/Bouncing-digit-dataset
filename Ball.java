/******************************************************************************
 *  Compilation:  javac Ball.java
 *  Execution:    java Ball
 *  Dependencies: StdDraw.java
 *
 *  Implementation of a 2-d Ball moving in square with coordinates
 *  between -1 and 1. Bounces off the walls upon collision.
 *
 *
 ******************************************************************************/


import java.io.File;

public class Ball {

    // instance variables
    private double rx, ry;        // position
    private double vx, vy;        // velocity
    private final double radius;  // radius
    private int int_ball;
    private String str_ball;

    // constructor
    public Ball() {

        int rmin = -32;
        int rmax = 32;


        rx = rmin + (int)(Math.random()*((rmax-rmin)+1));
        ry = rmin + (int)(Math.random()*((rmax-rmin)+1));
        //vx = StdRandom.uniform(-1, 1);
        //vy = StdRandom.uniform(-1, 1);
        
        int[] freqs = {1,1};
        vx=StdRandom.discrete(freqs);
        vy=StdRandom.discrete(freqs);
        
        if(vx==0)
            vx=-1;
        if(vy==0)
            vy=-1;

        int_ball=(int)(Math.random()*10);
        str_ball=Integer.toString(int_ball);

        //System.out.printf("vx -> %f, vy -> %f",vx,vy);  ball always goes diagonally!

        radius = StdRandom.uniform(0.025, 0.075);
    }

    // bounce of vertical wall by reflecting x-velocity
    private void bounceOffVerticalWall() {
        vx = -vx;
    }

    // bounce of horizontal wall by reflecting y-velocity
    private void bounceOffHorizontalWall() {
        vy = -vy;
    }

    // move the ball one step
    public void move() {
        if (Math.abs(rx + vx ) > 32.0) bounceOffVerticalWall();
        if (Math.abs(ry + vy ) + radius > 32.0) bounceOffHorizontalWall();
        rx = rx + vx;
        ry = ry + vy;
    }

    // draw the ball
    public void draw() {
        //StdDraw.filledCircle(rx, ry, radius);
    
        StdDraw.text(rx,ry,str_ball);
        //StdDraw.picture(rx,ry,"./numbers/"+str_ball+".jpeg");
    }



    // test client
    public static void main(String[] args) {

        for(int i=1;i<=1000;i++)
        {

            // create and initialize two balls
            Ball b1 = new Ball();
            Ball b2 = new Ball();
            Ball b3 = new Ball();

            // animate them
            StdDraw.setXscale(-32.0, +32.0);
            StdDraw.setYscale(-32.0, +32.0);
            StdDraw.enableDoubleBuffering();



            new File("./bouncing-digits-dataset/" + Integer.toString(i)).mkdirs();

            for(int seq=0;seq<20;seq++) 
            {
                StdDraw.clear(StdDraw.BLACK);
                StdDraw.setPenColor(StdDraw.WHITE);
                b1.move();
                b2.move();
                b3.move();

                b1.draw();
                b2.draw();
                b3.draw();

                StdDraw.show();
                StdDraw.save("./bouncing-digits-dataset/" + Integer.toString(i) +"/" + Integer.toString(seq+1) + ".png");
                StdDraw.pause(20);
            }
        }

        System.out.println("completed!");
    }
}