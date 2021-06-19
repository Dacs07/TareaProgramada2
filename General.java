import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Write a description of class General here.
 * 
 * @author David Córdoba Segura C02390  ---  Yasmyn Chacón Hernández B41761 
 * @version 19/06/2021
 */
public class General
{
    
    private ArrayList<Categoria> categorias;
    BufferedWriter bw;
    BufferedWriter control;
    int contador;

    /**
     * Constructor de la clase General. Inicializa el ArrayList de las categorías
     */
    public General()
    {
        categorias = new ArrayList<Categoria>();

    }

    public void genereArchivo(String nombre)  //método tomado de material de clase. 
    {
        try{
            bw = new BufferedWriter(new FileWriter(nombre));
            contador =0;
            control = new BufferedWriter(new FileWriter("control.txt"));
        } catch(IOException e){
            System.out.println(nombre+" es inválido");
        }

    }

    public void cerrarArchivo(){ //método tomado de material de clase.
        try {
            bw.flush();
            bw.close(); 
            control.write(contador+"\n");
            control.close();
        } catch(IOException e){
            System.out.println(" es inválido");
        }
    }

    public void grabarDato(String dato) { //método tomado de material de clase
        try{
            bw.write(dato);
            bw.newLine();
            contador++;
        } catch(IOException e){
            System.out.println("Error al grabar");
        }
    }

    public void crearCategoria () // Recibe la información necesaria, genera la categoría y la agrega al Arraylist
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

    public void eligeCategoriaRemover(int cate) //Elimina una actividad dentro de la categoría seleccionada (int cate)
    {
        categorias.get(cate).removerActividad();
    }

    public void imprimaCategorias() //Imprime las categorías (no las actividades)
    {
        System.out.println("Lista de categorías: ");
        for(int i = 0; i < categorias.size(); i++) {
            System.out.println(categorias.get(i).demeTodo());
        }
    }

    public void imprimaCateEspecifica(int cate) //Imprime una categoría en específico (no sus actividades)
    {
        System.out.println(categorias.get(cate).demeTodo());
    }

    public void eligeCategoriaCrear(int cate) //Crea una actividad dentro de la categoría seleccionada (int cate)
    {
        categorias.get(cate).crearActividad();
    }

    public void eligeCategoriaModificar(int cate, int actividad) //Modifica atributos de una actividad dentro de la categoría seleccionada (int cate)
    {
        categorias.get(cate).modifiqueActividades(actividad);
    }

    public void eligeCategoriaEliminar(int cate, int actividad) ////Elimina atributos de una actividad dentro de la categoría seleccionada (int cate)
    {
        categorias.get(cate).elimineAtributos(actividad);
    }

    public void muestreActdeCat(int cate) // Muestra actividades de categoría específica (int cate)
    {
        categorias.get(cate).imprimaActividades();
    }

     /**
     * Todos los métodos eligeCategoriaFiltrar(Atributo) relizan una búsqueda dentro de las actividades existentes de la categoría específica. 
     *  
     * 
     * @param (atributo)busq   El contenido a comparar posteriormente
     * @param cate             Índice para seleccionar la categoría
     * 
     */
    
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

    public void muestreTodasActiv() //Muestra todas las actividades de todas las categorías
    {
        for (int i=0; i<categorias.size(); i++){
            categorias.get(i).imprimaActividades();
        }
    }

    public String guardeTodasActiv () //Retorna todas las actividades de todas las categorías
    {
        String activsguardada="";
        for (int i=0; i<categorias.size(); i++){
            activsguardada+="\n"+categorias.get(i).guardeActividades();
        }
        return activsguardada;
    }

    public void eligeCategoriaModificar(int cate) //Permite modificar atributos de la categoría.
    {
        Scanner entr= new Scanner(System.in);
        entr.useDelimiter("\n");
        int opcion;
        do{
            System.out.println("¿Qué desea cambiar de esta categoría? (1 para ID, 2 para Nombre, 3 para Descripcion, 4 para continuar)");
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
