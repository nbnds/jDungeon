package core;
/**
 * @author nbnds
 * 
 * BEschreibung der Klasse
 */
import java.util.*;
import java.text.*;
import java.io.*;

public class GameClient {
final String CL_VER = "1.0";  // Client version number
final String java_version   = System.getProperty("java.version");
final String os_name        = System.getProperty("os.name");
final String os_arch        = System.getProperty("os.arch");
/**
 * @todo benutzername darf nicht leer sein
 */
String user_name;

    private  String command; // aktueller befehl

     public GameClient()     //default constructor
    {
        //  this.start_mode=mode;  //start_modus setzen (release, debug etc. )
    }
    public void system_info()
    {
        System.out.println("Game Client Version: " + CL_VER);
        System.out.println("Java Version: " + java_version);
        System.out.println("Operating System: " + os_name);
        System.out.println("Architecture: " + os_arch);
        String time = DateFormat.getDateTimeInstance().format(new Date());
        System.out.println( time );
    }

    public void start()
    {
        //vorbereitungen
        //Console console = System.console();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CommandParser commandParser = new CommandParser();

        
        //print command Prompt:
        //initialisierung
        System.out.println("Wie ist Ihr Name? ");
        System.out.print(": ");
        try{
         
         user_name = br.readLine();
         if (user_name.equals("")){user_name="Dummy";}
        }
        catch(IOException ioe)
        {
         System.out.println("IO error trying to read your name!");
         System.exit(1);
        }
       Player p1 = new Player(user_name);
       System.out.println("Willkommen in der Welt von Java, "+user_name);
       System.out.println("Gebe 'info' ein um ein Statusbericht zu erhalten");
       System.out.println("Mit 'exit' beendest du das Programm");
       
       //solange commandParser.command_stack[0] != 'exit'
       command ="";
       while (true)
       {
        System.out.print(": ");
        
        try{
        command = br.readLine();
        }
        catch(IOException ioe)
        {
         System.out.println("IO error trying to read your command!");
         //System.exit(1);
        }
        commandParser.parse_command(command.toLowerCase());
        // commandParser hat jetzt die eingabe nach Wörtern aufgespalten und
        // jedes wort in eine array zelle gelegt
        // im command_stack[] array
        //beginne mit der verarbeitung des kommandos
        Integer commandcode=commandParser.vocabulary.get(commandParser.getCommandStackValueAt(0));
        if (commandcode!=null)
        {   System.out.println();
            switch (commandcode)
               {
                 case 0:
                    System.out.println("EXIT");
                    System.out.println("Speichere den Spielstand auf die Festplatte...");
                    System.out.println("Speichern...fertig!");
                    System.out.println("Aufwiedersehen!");
                    System.exit(0);
                    break;
                 case 1:
                    
                    System.out.println("HELP :Hilfe");
                    System.out.println("[exit]: beendet das Programm");
                    System.out.println("[info]: liefert Statusinformationen");
                    System.out.println("[whoami]: gibt ihren Benutzernamen aus");
                    System.out.println("[time]: gibt aktuelle Zeit aus");
                    System.out.println("[where]: gibt aktuelle Position zurück (d)");
                    System.out.println("[help]: zeigt die befehlsuebersicht an");
                    System.out.println("[pickup]: Gegenstand aufheben");
                    System.out.println("[drop]: Gegenstand fallen lassen");
                    System.out.println("[value]: Wert des Gegenstands ermitteln");
                    System.out.println("[n]: Nach Norden gehen");
                    System.out.println("[w]: Nach Westen gehen");
                    System.out.println("[e]: Nach Osten gehen");
                    System.out.println("[s]: Nach Süden gehen");
                    System.out.println("[l]: Sich umsehen");

                    break;
                 case 2:
                    System.out.println("WHOAMI :Benutzername");
                    System.out.println(p1.getPlayerName());
                    break;
                 case 3:
                    System.out.println("INFO :Statusinformation");
                    System.out.println("Ihr Inventar:");
                    p1.getInventory().list_inventory();
                    break;
                 case 4:
                    System.out.println("WHERE :Position");
                    System.out.println("Diese Funktion ist noch nicht implementiert");
                    break;
                 case 5:
                    System.out.println("TIME :Uhrzeit");
                    String time = DateFormat.getDateTimeInstance().format(new Date());
                    System.out.println( time );
                    break;
                 case 6:
                    System.out.println("PICKUP :Aufheben");
                    if(commandParser.getCommandStackSize()>1){
                        for(int i=1; i<=commandParser.getCommandStackSize()-1;i++){
                    p1.pickup_item(commandParser.getCommandStackValueAt(i));}
                    }else
                    {
                        System.out.println("Kein Argument angegeben.");
                    }
                    break;
                 case 7:
                    System.out.println("DROP :Fallen lassen");
                    if(commandParser.getCommandStackSize()>1){
                    p1.getInventory().drop_item(commandParser.getCommandStackValueAt(1));}
                    else
                    {System.out.println("Kein Argument angegeben");}
                    break;
                 case 8:
                    System.out.println("VALUE :Geldwert des Gegenstands");
                    if(commandParser.getCommandStackSize()>1){
                    System.out.println(p1.getInventory().getItemByName(commandParser.getCommandStackValueAt(1)).get_value());}
                    else
                    {System.out.println("Kein Gegenstand angegeben");}
                    break;
                 case 9:
                    p1.go_north();
                    break;
                 case 10:
                    p1.go_west();
                    break;
                 case 11:
                    p1.go_east();
                    break;
                 case 12:
                    p1.go_south();
                    break;
                 case 13:
                    p1.look_around();
                    break;
                 default:
                    System.out.println("Sie verlassen das Spiel");
               }
          }else 
            {
                System.out.println("Diese Anweisung wurde noch nicht implementiert oder existiert nicht.");
                System.out.println("Geben Sie 'help' ein um Liste gültiger Befehle zu erhalten.");
            }


        
       }
       
       
    }
}
