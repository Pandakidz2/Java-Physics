import Objects.*;

class Main{
    public static Window game = new Window(500, 500);
    public static boolean running = true;
    public static void main(String[] args){
        Thread input = new Input();
        Thread movement = new Movement();

        game.addPlayer(new Player(250, 250, 20, 20));
        game.addPlatform(new Platform(200, 300, 50, 300));

        input.start();
        movement.start();
    }
}