package Threads;

import Main.Window;
import Objects.*;

public class Movement extends Thread {
    private Window window;
    private int update;

    public Movement(Window window){
        super();
        
        this.window = window;
        this.update = 25;
    }

    public void run(){
        while(window.isRunning()){
            Player player = window.getPlayer(0);

            if(player.getVelocityY() < 0){
                if(player.onPlatform() != -1){
                    player.setVelocityY(0);
                    player.jump(true);
                    continue;
                }
            }

            player.move();
            
            try{
                Thread.sleep(update);
            } catch (Exception e){
                System.out.println("Movement thread crashed");
            }
        }
    }

    public boolean collides(){
        return true;
    }

}
