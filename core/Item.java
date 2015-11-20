package core;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 

/**
 *
 * @author nbnds
 */
public class Item {
    /** Bezeichnung des Spielgegenstands */
    String item_name;
    /** Verkaufswert in Cent */
    int item_value; 
    /**
     * @return liefert die Bezeichnung des Gegenstands zurück
     */
    public String get_name()
    {
        return this.item_name;
    }
    /**
     * @return liefert Geldwert des Gegenstands
     * als Centbetrag zurück
     */
    public int get_value()
    {
        return item_value;
    }
    /** Der volle Konstruktor.Bezeichnung des Gegenstands
     *  und der Geldwert in Cent
     */
    public Item(String name, int value_cent)
    {
        item_name=name;
        item_value = value_cent;
        
    }
    /** Halbautomatik, der Geldwert des Gegenstands wird
     *  automatisch generiert, man muss nur den Namen
     *  des gegenstands angeben. Für testzwecke.
     */
    public Item(String name)
    {
        item_name=name;
        item_value=(new Double(Math.random()*10)).intValue();
    }
}
