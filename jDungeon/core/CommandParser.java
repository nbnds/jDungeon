package core;
/*
 * Diese Klasse ist verantwortlich für
 * primÃ¤re Eingabeverarbeitung.
 * Die Eingabe des Benutzers wird
 *  Auf Gültigkeit gefprüft
 *  Nach Worten zertrennt
 *  In einem Kommando-Speicher "command stack"
 *  abgelegt
 */

 

/**
 *
 * @author Alexei Simakov
 * @date    17 December 2009
 */
import java.util.*;
public class CommandParser {
    private ArrayList<String> command_stack;// = new ArrayList<String>();
    
    HashMap<String, Integer> vocabulary = new HashMap<String, Integer>();

/**
 * Im Konstruktor wird das "Wörterbuch" erstellt, den der Befehlsparser
 * versteht
 */
    public CommandParser()
    {
   
    vocabulary.put("exit", 0);
    vocabulary.put("help", 1);
    vocabulary.put("whoami", 2);
    vocabulary.put("info", 3);
    vocabulary.put("where", 4);
    vocabulary.put("time", 5);
    vocabulary.put("pickup",6);
    vocabulary.put("drop",7);
    vocabulary.put("value",8);
    vocabulary.put("n",9);
    vocabulary.put("w",10);
    vocabulary.put("e",11);
    vocabulary.put("s",12);
    vocabulary.put("l",13);
    }
    void parse_command(String command)
    {    
         command_stack = new ArrayList<String>(Arrays.asList(command.split("\\s+")));// splittert eingabe in einzelne woerter
         //und speicher diese als array ab
         printCommandStackTrace();//debugging
    }
    //returns value of the command stack at specific position
    String getCommandStackValueAt(int pos){
        return command_stack.get(pos);
    }
    void printCommandStackTrace()
    {
        System.out.println("current command_stack contents:");
        for(int i=0;i<=command_stack.size()-1;i++)
        {
            System.out.print(i+")");
            System.out.println(command_stack.get(i));
        }
    }
    int getCommandStackSize(){
        return command_stack.size();
    }
}
