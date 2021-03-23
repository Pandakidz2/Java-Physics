package Objects;

abstract public class Entity{
    final protected int gravity = 1;
    final protected int friction = 1;

    // -1-unknown, 0-Player, 1-Platform
    protected int type = -1;

    protected int xPos;
    protected int yPos;

    protected int width;
    protected int height;

    public Entity(int xPos, int yPos, int width, int height){
        this.xPos = xPos;
        this.yPos = xPos;
        this.width = width;
        this.height = height;
    }

    // Accessor methods
    public boolean isMoving(){
        return false;
    }
    public int getXPos(){
        return xPos;
    }
    public int getYPos(){
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
    public int getType(){
        return type;
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
