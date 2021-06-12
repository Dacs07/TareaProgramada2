import java.util.*;
/**
 * Write a description of class Controlador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controlador
{
    public static void main (String a[])
    {
        General g =new General();
        Scanner entr= new Scanner(System.in);
        int opcion;
        do{ 
            System.out.println("Presione 1 para agregar una categoría, 2 para agregar tarea, 4 para salir");
            opcion=entr.nextInt();

            switch (opcion){
                case 1:
                g.crearCategoria();
                break;

                case 2:
                g.imprimaCategorias();
                System.out.println("Seleccione la categoría a la que quiere agregar actividades");
                int cate = entr.nextInt();
                g.eligeCategoria(cate-1);
                g.imprimaCateEspecifica(cate-1);
                g.muestreActdeCat(cate-1);
                break;
                
                
            }

        }while (opcion!=4);

        g.imprimaCategorias();
        System.out.println("Seleccione la categoría a la que quiere agregar actividades");

        Categoria c = new Categoria (1, " ", " ");
        c.crearActividad();
    }
}
