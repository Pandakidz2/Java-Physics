import javax.swing.JFrame;

import java.util.ArrayList;
import java.awt.*;
import java.util.HashMap;

import Objects.Entity;
import Objects.Player;
import Objects.Platform;

public class Window extends JFrame{
    private Display display;

    // Constructor
    public Window(int width, int height){
        // Setting dimensions of the JFrame
        this.setSize(width, height);
        display = new Display(width, height);
        this.setResizable(false);

        // Setting the close operation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Attaching canvas to display
        this.add(display);

        // Making it visible
        this.setVisible(true);
    }    

    // Accessor methods
    public Player getPlayer(int index){
        return display.players.get(index);
    }
    // Add a given object to both the frame and memory
    public void addPlayer(Player p){
        display.addPlayer(p);
    }
    public void addPlatform(Platform p){
        display.addPlatform(p);
    }

    // Refreshes all of the objects in the JFrame
    public void refresh(){        
        display.repaint();
        this.revalidate();
    }

    // Closes the program
    public void close(){
        this.setVisible(false);
        this.dispose();
    }
}

class Display extends Canvas{
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
                    g.drawOval(e.getXPos(), e.getYPos(), e.getWidth(), e.getHeight());
                } else if(key.equals("Platforms")){
                    g.drawLine(e.getXPos(), e.getYPos(), e.getXPos2(), e.getXPos2());
                }
            }
        }
    }
}