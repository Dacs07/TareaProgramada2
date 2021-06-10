import java.util.*;
/**
 * Write a description of class Prueba here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Categoria
{
    // instance variables - replace the example below with your own
    private int id;
    private String nombre;
    private String descripcion;
    private ArrayList<Actividad> actividades;

    /**
     * Constructor for objects of class Prueba
     */
    public Categoria(int identi, String nom, String desc)
    {
        // initialise instance variables
        id=identi;
        nombre=nom;
        descripcion=desc;
        actividades = new ArrayList<Actividad>();
    }

    public void crearActividad ()
    {
        Scanner entr= new Scanner(System.in);
        System.out.println("Agregue los detalles de la actividad. ID-Avance-Nombre-Tiempo-Dinero-Esfuerzo-Inicio-Fin-Responsable");
        int id = entr.nextInt();
        int avance=entr.nextInt();
        String nombre= entr.next();
        String tiempo= entr.next();
        String dinero= entr.next();
        String esfuerzo= entr.next();
        String inicio= entr.next();
        String fin= entr.next();
        String responsable= entr.next();
        
        Actividad nuevaActividad = new Actividad(id, avance, nombre, tiempo, dinero, esfuerzo, inicio, fin, responsable);
        
        actividades.add(nuevaActividad);
        
        System.out.println(nuevaActividad.demeTodo());
    }
}
