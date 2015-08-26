/**
 * Die karte ist zZt als 2D Array implementiert. 
 * Kapselung in eigener Klasse w�nschenswert.
 */
 

/**
 *
 * @author nbnds
 */
public class World { 
private int[][] map;
public World()
{ 
 map = new int[][]{{0,0,0,1},{0,1,0,0},{0,1,1,0},{0,0,0,0},{0,1,1,1}};
}
public int[][] getmap()
{
return this.map;
}

public void descr(int x,int y)
{//beschrreibe umgebung der koordinate
int k=0; 
//sollte keine der bedingungen zutreffen bleibt k=0
//jede bedingung wird gepr�ft, wenn die zutrifft
//so wird k vergr��ert, die zahl k l�sst so am ende
//auf die zutreffenden F�lle r�ckschl�sse ziehen
if ((y-1 >= 0)&&this.map[y-1][x] !=1)
{
k=k+1; //north
}
if ((x+1<=this.map[0].length-1)&&this.map[y][x+1] !=1)
{
k=k+2; //east
}
if ((y+1 <= this.map[0].length)&&this.map[y+1][x] !=1)
{
k=k+4;//south
}
if ((x-1>=0)&&this.map[y][x-1] !=1)
{
k=k+8;//west
}

//System.out.println(k);
switch(k)
    {
        case 0: 
            System.out.println("Sie koennen nirgendswohin gehen");
            break;
        case 1:
            System.out.println("Norden ist frei. (n)");
            System.out.println("^");
        break;
        case 2:
            System.out.println("Osten ist frei. (e)");
            System.out.println("<");
        break;
        case 3:
            System.out.println("Norden ist frei. (n)");
            System.out.println("Osten ist frei. (e)");
            System.out.println("^");
            System.out.println(" >");
        break;
        case 4:
            System.out.println("Sueden ist frei. (s)");
            System.out.println("V");
        break;
        case 5:
            System.out.println("Norden ist frei. (n)");
            System.out.println("Sueden ist frei. (s)");
            System.out.println("^");
            System.out.println("V");
        break;
        case 6:
            System.out.println("Osten ist frei. (e)");
            System.out.println("Sueden ist frei. (s)");
            System.out.println(" >");
            System.out.println("V");
        break;
        case 7:
            System.out.println("Norden ist frei. (n)");
            System.out.println("Osten ist frei. (e)");
            System.out.println("Sueden ist frei. (s)");
            System.out.println("^");
            System.out.println(" >");
            System.out.println("V");
            
        break;
        case 8:
            System.out.println("Westen ist frei. (w)");
            System.out.println("<");
            
        break;
        case 9:
            System.out.println("Norden ist frei. (n)");
            System.out.println("Westen ist frei. (w)");
            System.out.println(" ^");
            System.out.println("< ");
            
        break;
        case 10:
            System.out.println("Osten ist frei. (e)");
            System.out.println("Westen ist frei. (w)");
            System.out.println("< >");
        break;
        case 11:
            System.out.println("Norden ist frei. (n)");
            System.out.println("Osten ist frei. (e)");
            System.out.println("Westen ist frei. (w)");
            System.out.println(" ^");
            System.out.println("< >");            
        break;
        case 12:
            System.out.println("Sueden ist frei. (s)");
            System.out.println("Westen ist frei. (w)");
            System.out.println("<");
            System.out.println(" V");
        break;
        case 13:
            System.out.println("Norden ist frei. (n)");
            System.out.println("Sueden ist frei. (s)");
            System.out.println("Westen ist frei. (w)");
            System.out.println(" ^");
            System.out.println("<");
            System.out.println(" V");
        break;
        case 14:
            System.out.println("Osten ist frei. (e)");
            System.out.println("Sueden ist frei. (s)");
            System.out.println("Westen ist frei. (w)");
            System.out.println("< >");
            System.out.println(" V");
        break;
        case 15:
            System.out.println("Norden ist frei. (n)");
            System.out.println("Osten ist frei. (o)");
            System.out.println("Sueden ist frei. (s)");
            System.out.println("Westen ist frei. (w)");
            System.out.println(" ^");
            System.out.println("< >");
            System.out.println(" V");

        break;
        default:
            System.out.println("Ich sehe mich um, und sehe nichts");
    }
}
// getArrayHeight -- testmethode, kann entfernt werden
private int getArrayHeight()
{
return this.map.length;
}
// getArrayLength -- testmethode, kann entfernt werden
private int getArrayLength()
{
return this.map[0].length;
}
}
