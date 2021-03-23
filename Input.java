import java.util.Scanner;

public class Input extends Thread{
    public void run(){
        Scanner scan = new Scanner(System.in);

        while(Main.running){
            String command = scan.nextLine();

            if(command.equals("done")){
                System.out.println("Done");
                Main.running = false;
                Main.game.close();
                continue;
            }

            char[] movements = command.toCharArray();

            for(int i=0; i<movements.length; i++){
                char m = movements[i];
                
                if(m == 'w'){
                    System.out.println("Moved Up");
                    Main.game.getPlayer(0).updateVelocity(0, 10);
                } else if(m == 's'){
                    System.out.println("Moved Down");
                    Main.game.getPlayer(0).updateVelocity(0, -10);
                }
                if(m == 'a'){
                    System.out.println("Left");
                    Main.game.getPlayer(0).updateVelocity(-10, 0);
                } else if(m == 'd'){
                    System.out.println("Right");
                    Main.game.getPlayer(0).updateVelocity(10, 0);
                } 
            }
        }
        scan.close();
    }
    
}
