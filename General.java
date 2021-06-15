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

    public void removerCategoria ()
    {
        Scanner entr= new Scanner(System.in);
        entr.useDelimiter("\n");
        System.out.println("Ingrese la categoría a eliminar");
        int ind= entr.nextInt();

        categorias.remove(ind -1);

    }

    public void eligeCategoriaRemover(int cate)
    {
        categorias.get(cate).removerActividad();
    }

    public void imprimaCategorias()
    {
        System.out.println("Lista de categorías: ");
        for(int i = 0; i < categorias.size(); i++) {
            System.out.println(categorias.get(i).demeTodo());
        }
    }

    public void imprimaCateEspecifica(int cate)
    {
        System.out.println(categorias.get(cate).demeTodo());
    }

    public void eligeCategoriaCrear(int cate)
    {
        categorias.get(cate).crearActividad();
    }

    public void eligeCategoriaModificar(int cate, int actividad)
    {
        categorias.get(cate).modifiqueActividades(actividad);
    }

    public void eligeCategoriaEliminar(int cate, int actividad)
    {
        categorias.get(cate).elimineAtributos(actividad);
    }

    public void muestreActdeCat(int cate)
    {
        categorias.get(cate).imprimaActividades();
    }

    public void eligeCategoriaFiltrarNombre(int cate, String nombrebusq)
    {
        categorias.get(cate).compareNombre(nombrebusq);
    }

    public void eligeCategoriaFiltrarResponsable(int cate, String responsablebusq)
    {
        categorias.get(cate).compareResponsable(responsablebusq);
    }

    public void eligeCategoriaFiltrarAvance(int cate, int avancebusq)
    {
        categorias.get(cate).compareAvance(avancebusq);
    }

    public void eligeCategoriaFiltrarTiempo(int cate, String tiempobusq)
    {
        categorias.get(cate).compareTiempo(tiempobusq);
    }

    public void eligeCategoriaFiltrarDinero(int cate, String dinerobusq)
    {
        categorias.get(cate).compareDinero(dinerobusq);
    }

    public void eligeCategoriaFiltrarEsfuerzo(int cate, String esfuerzobusq)
    {
        categorias.get(cate).compareEsfuerzo(esfuerzobusq);
    }

    public void eligeCategoriaFiltrarInicio(int cate, String iniciobusq)
    {
        categorias.get(cate).compareInicio(iniciobusq);
    }

    public void eligeCategoriaFiltrarFin(int cate, String finbusq)
    {
        categorias.get(cate).compareFin(finbusq);
    }

    public void muestreTodasActiv()
    {
        for (int i=0; i<categorias.size(); i++){
            categorias.get(i).imprimaActividades();
        }
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
