package Objects;

import Main.*;

public class Platform extends Entity {
    private int xPos2;
    private int yPos2;

    public Platform(int xPos, int yPos, int xPos2, int yPos2, Window window){
        super(xPos, yPos, 0, 0, window);

        this.xPos2 = xPos2;
        this.yPos2 = yPos2;

        this.type = 1;
        this.window.addPlatform(this);
    }

    public int getXPos2(){
        return xPos2;
    }
    public int getYPos2(){
        return yPos2;
    }
}
