package Objects;

public class Platform extends Entity {
    private int xPos2;
    private int yPos2;

    public Platform(int xPos, int yPos, int xPos2, int yPos2){
        super(xPos, yPos, 0, 0);

        this.xPos2 = xPos2;
        this.yPos2 = yPos2;
        this.type = 1;
    }

    public int getXPos2(){
        return xPos2;
    }
    public int getYPos2(){
        return yPos2;
    }
}
