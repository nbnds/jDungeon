/*
 * Main Klasse soll dafuer sorgen dass Game Client nur einmal aufgerufen wird
 */

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {

    GameClient gc = new GameClient();

    gc.system_info();
        // TODO code application logic here
    gc.start();
    }

}
