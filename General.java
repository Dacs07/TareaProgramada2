import java.util.*;
/**
 * Write a description of class General here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class General
{
    // instance variables - replace the example below with your own
    private ArrayList<Categoria> categorias;

    /**
     * Constructor for objects of class General
     */
    public General()
    {
        // initialise instance variables
        categorias = new ArrayList<Categoria>();
    }

    public void crearCategoria ()
    {
        Scanner entr= new Scanner(System.in);
        System.out.println("Agregue los detalles de la categoria. ID-Nombre-Descripcion");
        int id = entr.nextInt();
        String nombre= entr.next();
        String descripcion= entr.next();

        Categoria nuevaCategoria = new Categoria(id, nombre, descripcion);
        categorias.add(nuevaCategoria);
        
    }
    
}
