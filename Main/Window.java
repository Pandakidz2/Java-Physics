package Main;

import javax.swing.JFrame;

import java.util.ArrayList;

import Objects.Player;
import Objects.Platform;
import Threads.*;

public class Window extends JFrame{
    private Display display;
    private boolean running;
    private ArrayList<Thread> threads;

    private boolean paused;

    // Constructor
    public Window(int width, int height){
        // Setting boolean values
        this.paused = false;
        this.running = true;

        // Setting dimensions of the JFrame
        this.setSize(width, height);
        display = new Display(width, height);
        display.setVisible(true);
        this.setResizable(false);

        // Setting the close operation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Attaching canvas to display
        this.add(display);

        // Making it visible
        this.setVisible(true);
        
        this.threads = new ArrayList<Thread>();
        Thread view = new View(this);
        this.threads.add(view);

        Thread input = new Input(this);
        this.threads.add(input);

        Thread movement = new Movement(this);
        this.threads.add(movement);
    }    

    // Accessor methods
    public Display getDisplay(){
        return display;
    }
    public Player getPlayer(int index){
        return display.players.get(index);
    }
    public ArrayList<Platform> getPlatforms(){
        return display.platforms;
    }
    public boolean isRunning(){
        return this.running;
    }
    public boolean isPaused(){
        return paused;
    }

    // Add a given object to both the frame and memory
    public void addPlayer(Player p){
        display.addPlayer(p);
    }
    public void addThread(Thread t){
        threads.add(t);
    }
    public void addPlatform(Platform p){
        display.addPlatform(p);
    }

    // Refreshes all of the objects in the JFrame
    public void refresh(){        
        display.repaint();
        this.revalidate();
    }

    // Pausing
    public void start(){
        for(Thread t: threads){
            try{
                t.start();
            } catch(Exception e){

            }
        }
        paused = false;
    }
    public void pause(){
        for(Thread t: threads){
            try{
                Thread.sleep(5000);
            } catch(Exception e){

            }
        }
        paused = true;
    }
    public void unpause(){
        for(Thread t: threads){
            try{
                t.notify();
            } catch(Exception e){

            }
        }
        paused = false;
    }


    public void stopRunning(){
        this.running = false;
    }

    // Closes the program
    public void close(){
        this.setVisible(false);
        this.dispose();
    }
}