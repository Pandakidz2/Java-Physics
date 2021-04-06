package Threads;

import Main.Window;

public class View extends Thread {
    private Window window;
    private int update;

    public View(Window window){
        super();

        this.window = window;

        this.update = 25;
    }

    public void run(){
        while(window.isRunning()){
            window.refresh();
            try{
                Thread.sleep(update);
            } catch(Exception e){
                System.out.println("View thread crashed");
            }
        }
    }
}
