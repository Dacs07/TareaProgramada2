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
        entr.useDelimiter("\n");
        System.out.println("Agregue los detalles de la categoria. ID-Nombre-Descripcion");
        int id = entr.nextInt();
        String nombre= entr.next();
        String descripcion= entr.next();

        Categoria nuevaCategoria = new Categoria(id, nombre, descripcion);
        categorias.add(nuevaCategoria);

    }

    public void imprimaCategorias()
    {
        for(int i = 0; i < categorias.size(); i++) {
            System.out.println(categorias.get(i).demeTodo());
        }
    }

    public void imprimaCateEspecifica(int cate)
    {
        System.out.println(categorias.get(cate).demeTodo());
    }

    public void eligeCategoria(int cate)
    {
        categorias.get(cate).crearActividad();
    }

    public void muestreActdeCat(int cat)
    {
        categorias.get(cat).imprimaActividades();
    }

}
