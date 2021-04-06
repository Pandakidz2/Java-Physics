package Threads;

import Main.Window;
import Objects.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input extends Thread{
    private Window window;

    public Input(Window window){
        super();

        this.window = window;
    }
    
    public void run(){
        Player player = window.getPlayer(0);

        KeyListener keyW = new KeyListener(){
            public void keyPressed(KeyEvent event){
                String key = KeyEvent.getKeyText(event.getKeyCode()).toLowerCase();

                if(key.equals("w") && player.canJump()){
                    player.setVelocityY(7.5);
                    
                    player.lastMove('w');
                    player.jump(false);
                }
            }
            public void keyTyped(KeyEvent event){
                return;
            }
            public void keyReleased(KeyEvent event){
                return;
            }
        };
        KeyListener keyA = new KeyListener(){
            public void keyPressed(KeyEvent event){
                String key = KeyEvent.getKeyText(event.getKeyCode()).toLowerCase();

                if(key.equals("a")){
                    player.movingLeft(true);
                    player.setVelocityX(-7);

                    player.lastMove('a');
                }
            }
            public void keyTyped(KeyEvent event){
                return;
            }
            public void keyReleased(KeyEvent event){
                String key = KeyEvent.getKeyText(event.getKeyCode()).toLowerCase();

                if(key.equals("a")){
                    player.movingLeft(false);
                }
            }
        };
        KeyListener keyS = new KeyListener(){
            public void keyPressed(KeyEvent event){
                String key = KeyEvent.getKeyText(event.getKeyCode()).toLowerCase();
                
                if(key.equals("s")){
                    player.setVelocityY(-5);

                    player.lastMove('s');
                }
            }
            public void keyTyped(KeyEvent event){
                return;
            }
            public void keyReleased(KeyEvent event){
                return;
            }
        };
        KeyListener keyD = new KeyListener(){
            public void keyPressed(KeyEvent event){
                String key = KeyEvent.getKeyText(event.getKeyCode()).toLowerCase();

                if(key.equals("d")){
                    player.movingRight(true);
                    player.setVelocityX(7);

                    player.lastMove('d');
                } 
            }
            public void keyTyped(KeyEvent event){
                return;
            }
            public void keyReleased(KeyEvent event){
                String key = KeyEvent.getKeyText(event.getKeyCode()).toLowerCase();

                if(key.equals("d")){
                    player.movingRight(false);
                }
            }
        };
        KeyListener keyOther = new KeyListener(){
            public void keyPressed(KeyEvent event){
                String key = KeyEvent.getKeyText(event.getKeyCode()).toLowerCase();

                if(key.equals("p") && !window.isPaused()){
                    System.out.println("Pause");
                    window.pause();
                } else if(key.equals("p") && window.isPaused()){
                    System.out.println("Unpause");
                    window.unpause();
                }
            }
            public void keyTyped(KeyEvent event){
                return;
            }
            public void keyReleased(KeyEvent event){
                return;
            }
        };

        window.getDisplay().addKeyListener(keyW);
        window.getDisplay().addKeyListener(keyA);
        window.getDisplay().addKeyListener(keyS);
        window.getDisplay().addKeyListener(keyD);
        window.getDisplay().addKeyListener(keyOther);
    }
    
}
