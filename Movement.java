public class Movement extends Thread {
    public void run(){
        while(Main.running){
            Main.game.getPlayer(0).move();
            Main.game.refresh();
            try{
                Thread.sleep(25);
            } catch (Exception e){

            }
        }
    }

    public boolean collides(){
        return true;
    }

}
