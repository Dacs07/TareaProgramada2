import java.util.*;
/**
 * Write a description of class Controlador here.
 * 
 * @author David Córdoba Segura C02390  ---  Yasmyn Chacón Hernández B41761 
 * @version (a version number or a date)
 */
public class Controlador
{
    
    public static void main (String a[])
    {
        General g =new General();
        Scanner entr= new Scanner(System.in);
        
        int grande;

        do{
            System.out.println("Presione 1 para agregar, 2 para modificar, 3 para eliminar, 4 para mostrar, 5 para salir");
            grande=entr.nextInt();

            switch(grande){

                case 1:
                int opcion;
                do{ 
                    System.out.println("Presione 1 para agregar una categoría, 2 para agregar tarea,  3 para continuar");
                    opcion=entr.nextInt();

                    switch (opcion){
                        case 1:

                        g.crearCategoria();
                        break;

                        case 2:

                        g.imprimaCategorias();
                        System.out.println("Seleccione la categoría a la que quiere agregar actividades");
                        int cate = entr.nextInt();
                        g.eligeCategoriaCrear(cate-1);
                        g.imprimaCateEspecifica(cate-1);
                        g.muestreActdeCat(cate-1);
                        break;

                    }
                }while (opcion!=3);
                break;

                case 2:
                int opcion2;
                do{ 
                    System.out.println("Presione 1 para modificar una categoría, 2 para modificar tarea,  3 para continuar");
                    opcion2=entr.nextInt();

                    switch (opcion2){
                        case 1:
                        g.imprimaCategorias();
                        System.out.println("Seleccione la categoría que desea modificar");
                        int cate1= entr.nextInt();
                        g.eligeCategoriaModificar(cate1 -1);
                        break;

                        case 2:
                        g.imprimaCategorias();
                        System.out.println("Seleccione la categoría en donde se encuentra la tarea a modificar");
                        int cate2=entr.nextInt();
                        g.imprimaActivCateEspecifica(cate2-1);
                        System.out.println("Elija la actividad a modificar");
                        int actividad= entr.nextInt();
                        g.eligeCategoria(cate2-1 , actividad-1);
                        break;

                    }
                }while (opcion2!=3);
                break;

            }
        }while(grande != 5);
    }
}
