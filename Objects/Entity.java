package Objects;

import Main.*;

abstract public class Entity{
    final protected double gravity = 0.4;
    final protected double friction = 0.7;

    //final protected double terminalVelocity = 0;

    protected Window window;

    protected double xPos;
    protected double yPos;

    // -1: NA, 0: Player, 1: Platform
    protected int type = -1;

    protected int width;
    protected int height;

    public Entity(int xPos, int yPos, int width, int height, Window window){
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        
        this.window = window;
    }

    // Accessor methods
    public boolean isMoving(){
        return false;
    }
    public double getXPos(){
        return xPos;
    }
    public double getYPos(){
        return yPos;
    }
    public int getXPos2(){
        return -1;
    }
    public int getYPos2(){
        return -1;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    // Mutator methods
    public void setPosition(int x, int y){
        this.xPos = x;
        this.yPos = y;
    }
    public void updateVelocity(int xVelocity, int yVelocity){
        return;
    }
    public void move(){
        return;
    }
}
