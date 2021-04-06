package Objects;

import Main.*;

public class Player extends Entity {
    private double xVelocity;
    private double yVelocity;

    private boolean canJump;

    private boolean movingLeft;
    private boolean movingRight;

    private char lastMove;

    public Player(int xPos, int yPos, int width, int height, Window window){
        super(xPos, yPos, width, height, window);
        
        this.xVelocity = 0;
        this.yVelocity = 0;

        this.type = 0;

        this.canJump = false;

        this.movingLeft = false;
        this.movingRight = false;
        
        this.window.addPlayer(this);
    }

    // Accessor methods
    public boolean isMoving(){
        if(xVelocity != 0 || yVelocity != 0) return true;
        else return false;
    }
    public boolean canJump(){
        return canJump;
    }
    public double getVelocityY(){
        return yVelocity;
    }
    public double getVelocityX(){
        return xVelocity;
    }  

    // Mutator methods
    public void lastMove(char c){
        this.lastMove = c;
    }
    public void jump(boolean b){
        this.canJump = b;
    }
    public void movingLeft(boolean b){
        this.movingLeft = b;
    }
    public void movingRight(boolean b){
        this.movingRight = b;
    }
    public void setVelocityY(double yVelocity){
        this.yVelocity = yVelocity;
    }
    public void setVelocityX(double xVelocity){
        this.xVelocity = xVelocity;
    }
    public void move(){
        // Change position
        int platformIndex = onPlatform();
        
        if(platformIndex != -1 && (lastMove == 'a' || lastMove == 'd')){
            Platform platform = window.getPlatforms().get(platformIndex);

            double slope = (platform.getYPos() - platform.getYPos2()) / (platform.getXPos2() - platform.getXPos());
            
            double deltaHeight = (0-slope) * xVelocity;

            this.xPos += xVelocity;
            this.yPos += deltaHeight;
        } else {
            this.xPos += xVelocity;
            this.yPos -= yVelocity;
        }        

        // Updating velocity
        if(!movingLeft && !movingRight){
            xVelocity = xVelocity/1.2;
        }

        yVelocity -= gravity;
    }

    // Collision detection
    public int onPlatform(){
        for(Platform p: window.getPlatforms()){
            if(isOn(p)) return window.getPlatforms().indexOf(p);
        }
        return -1;
    }
    private boolean isOn(Platform platform){
        double xPos = this.getXPos() + (this.width/2);
        if(xPos > platform.getXPos() && xPos < platform.getXPos2()){
            double top = yPos;
            double bot = yPos + height;

            double slope = (platform.getYPos() - platform.getYPos2()) / (platform.getXPos2() - platform.getXPos());
            
            double yPosition = (slope * (platform.getXPos() - this.getXPos())) + platform.getYPos();
            if(yPosition >= top && yPosition <= bot){
                return true;
            }
        }
        return false;
    }
}
