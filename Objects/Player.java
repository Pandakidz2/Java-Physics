package Objects;

public class Player extends Entity {    
    private int xVelocity;
    private int yVelocity;

    public Player(int xPos, int yPos, int width, int height){
        super(xPos, yPos, width, height);
        
        this.xVelocity = 0;
        this.yVelocity = 0;
        this.type = 0;
    }

    // Accessor methods
    public boolean isMoving(){
        if(xVelocity != 0 || yVelocity != 0) return true;
        else return false;
    }

    // Mutator methods
    public void updateVelocity(int xVelocity, int yVelocity){
        this.xVelocity += xVelocity;
        this.yVelocity += yVelocity;
    }
    public void move(){
        // Change position
        this.xPos += xVelocity;
        this.yPos -= yVelocity;

        // Update velocity
        if(xVelocity < 0){
            xVelocity += friction;
        } else if(xVelocity > 0){
            xVelocity -= friction;
        }

        if(yVelocity > 0){
            yVelocity -= gravity;
        } else if(yVelocity < 0){
            yVelocity += gravity;
        }
    }
}
