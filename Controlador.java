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
        entr.useDelimiter("\n");

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
                        g.muestreActdeCat(cate2-1);
                        System.out.println("Elija la actividad a modificar");
                        int actividad= entr.nextInt();
                        g.eligeCategoriaModificar(cate2-1 , actividad-1);
                        break;

                    }
                }while (opcion2!=3);
                break;

                case 3:
                int opcion3;
                do{
                    System.out.println("Presione 1 para eliminar una categoría, 2 para eliminar tarea,  3 para eliminar atributo de la tarea, 4 para continuar");
                    opcion3=entr.nextInt();

                    switch(opcion3){

                        case 1:
                        g.imprimaCategorias();
                        g.removerCategoria();
                        break;

                        case 2:
                        g.imprimaCategorias();
                        System.out.println("Seleccione la categoría de la que quiere eliminar actividades");
                        int cate = entr.nextInt();
                        g.muestreActdeCat(cate-1);
                        g.eligeCategoriaRemover(cate-1);
                        break;

                        case 3:
                        g.imprimaCategorias();
                        System.out.println("Elija la categoría");
                        int cate2=entr.nextInt();
                        g.muestreActdeCat(cate2-1);
                        System.out.println("Elija la actividad");
                        int actividad= entr.nextInt();
                        g.eligeCategoriaEliminar(cate2-1 , actividad-1);
                        break;

                    }

                }while(opcion3 != 4);
                break;

                case 4: 
                int opcion4;
                do{
                    System.out.println("Presione 1 para consulta sin filtros, 2 para consulta con filtros,  3 para continuar");
                    opcion4=entr.nextInt();
                    switch(opcion4){
                        case 1:
                        g.muestreTodasActiv();
                        break;

                        case 2:
                        g.imprimaCategorias();
                        System.out.println("Elija la categoría donde desea realizar la consulta");
                        int categoria=entr.nextInt();
                        System.out.println("¿Por cuál(es) dato(s) desea filtrar la consulta? \n 1 para Nombre, 2 para Avance, 3 para Responsable, 4 para Tiempo, 5 para Dinero, 6 para Esfuerzo, 7 para Fecha de inicio, 8 para Fecha de finalización");
                        int dato=entr.nextInt();
                        switch(dato){

                            case 1:
                            System.out.println("Ingrese el nombre a buscar");
                            String nombrebusq= entr.next();
                            g.eligeCategoriaFiltrarNombre(categoria-1, nombrebusq);
                            break;

                            case 2:
                            System.out.println("Ingrese el Grado de avance (1 - 2 - 3 ) a buscar");
                            int avancebusq= entr.nextInt();
                            g.eligeCategoriaFiltrarAvance(categoria-1, avancebusq);
                            break;

                            case 3:
                            System.out.println("Ingrese el responsable a buscar");
                            String responsablebusq= entr.next();
                            g.eligeCategoriaFiltrarResponsable(categoria-1, responsablebusq);
                            break;

                            case 4:
                            System.out.println("Ingrese el tiempo a buscar");
                            String tiempobusq= entr.next();
                            g.eligeCategoriaFiltrarTiempo(categoria-1, tiempobusq);
                            break;

                            case 5:
                            System.out.println("Ingrese el dinero a buscar");
                            String dinerobusq= entr.next();
                            g.eligeCategoriaFiltrarDinero(categoria-1, dinerobusq);
                            break;

                            case 6:
                            System.out.println("Ingrese el esfuerzo a buscar");
                            String esfuerzobusq= entr.next();
                            g.eligeCategoriaFiltrarEsfuerzo(categoria-1, esfuerzobusq);
                            break;

                            case 7:
                            System.out.println("Ingrese la fecha de inicio a buscar");
                            String iniciobusq= entr.next();
                            g.eligeCategoriaFiltrarInicio(categoria-1, iniciobusq);
                            break;
                            
                            case 8:
                            System.out.println("Ingrese la fecha de finalización a buscar");
                            String finbusq= entr.next();
                            g.eligeCategoriaFiltrarFin(categoria-1, finbusq);
                            break;
                        }

                        break;

                    }

                }while(opcion4!=3);
                break;
            }
        }while(grande != 5);
    }
}
