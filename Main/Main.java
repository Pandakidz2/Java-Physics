package Main;

import Objects.*;

public class Main{
    public static void main(String[] args){
        Window game = new Window(500, 500);

        new Player(250, 250, 20, 20, game);
        new Platform(0, 350, 100, 250, game);
        new Platform(200, 400, 300, 450, game);
        new Platform(0, 450, 500, 450, game);

        game.start();
    }
}