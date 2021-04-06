package Main;

import java.util.ArrayList;
import java.awt.*;
import java.util.HashMap;

import Objects.Entity;
import Objects.Player;
import Objects.Platform;

public class Display extends Canvas{
    protected HashMap<String, ArrayList<? extends Entity>> entities;
    protected ArrayList<Player> players;
    protected ArrayList<Platform> platforms;

    public Display(int width, int height){
        entities = new HashMap<String, ArrayList<? extends Entity>>();

        players = new ArrayList<Player>();
        platforms = new ArrayList<Platform>();

        entities.put("Players", players);
        entities.put("Platforms", platforms);

        this.setSize(width, height);
    }

    protected void addPlatform(Platform p){
        platforms.add(p);
    }
    protected void addPlayer(Player p){
        players.add(p);
    }

    public void paint(Graphics g){
        for(String key: entities.keySet()){
            for(Entity e: entities.get(key)){
                if(key.equals("Players")){
                    int xPos = (int) e.getXPos();
                    int yPos = (int) e.getYPos();

                    g.drawOval(xPos, yPos, 2, 2);
                    g.drawOval(xPos, yPos, e.getWidth(), e.getHeight());
                } else if(key.equals("Platforms")){
                    int xPos = (int) e.getXPos();
                    int yPos = (int) e.getYPos();
                    
                    int xPos2 = (int) e.getXPos2();
                    int yPos2 = (int) e.getYPos2();
                    g.drawLine(xPos, yPos, xPos2, yPos2);
                }
            }
        }
    }

}
