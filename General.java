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

    public void imprimaActivCateEspecifica(int cate)
    {
        categorias.get(cate).imprimaActividades();
    }

    public void eligeCategoriaCrear(int cate)
    {
        categorias.get(cate).crearActividad();
    }
    
     public void eligeCategoria(int cate, int actividad)
    {
        categorias.get(cate).modifiqueActividades(actividad);
    }

    public void muestreActdeCat(int cate)
    {
        categorias.get(cate).imprimaActividades();
    }

    public void eligeCategoriaModificar(int cate)
    {
        Scanner entr= new Scanner(System.in);
        entr.useDelimiter("\n");
        int opcion;
        do{
            System.out.println("¿Qué desea cambiar de esta categoría? (1 para ID, 2 para Nombre, 3 para Desccripcion, 4 para continuar)");
            opcion=entr.nextInt();

            switch(opcion){
                case 1:
                System.out.println("Ingrese nuevo ID");
                int nuevoID=entr.nextInt();
                categorias.get(cate).cambieID(nuevoID);
                break;

                case 2: 
                System.out.println("Ingrese nuevo Nombre");
                String nuevoNombre=entr.next();
                categorias.get(cate).cambieNombre(nuevoNombre);
                break;

                case 3:
                System.out.println("Ingrese nueva Descripción");
                String nuevaDescripcion=entr.next();
                categorias.get(cate).cambieDescripcion(nuevaDescripcion);
                break;
            }
        }while(opcion!=4);
    }

}
