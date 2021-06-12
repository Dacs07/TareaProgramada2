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

    public int demeID()
    {
        return id;
    }

    public String demeNombre()
    {
        return nombre;
    }

    public String demeDescripcion()
    {
        return descripcion;
    }

    public String demeTodo()
    {
        return id+" "+nombre+" "+descripcion;
    }

    public void crearActividad ()
    {
        Scanner entr= new Scanner(System.in);
        entr.useDelimiter("\n");
        System.out.println("Agregue los detalles de la actividad. ID-Avance-Nombre-Responsable");
        int id = entr.nextInt();
        int avance=entr.nextInt();
        String nombre= entr.next();
        String responsable= entr.next();

        Actividad nuevaActividad = new Actividad(id, avance, nombre, responsable);

        actividades.add(nuevaActividad);

    }
    
    public void imprimaActividades ()
    {
        for(int i = 0; i < actividades.size(); i++) {
            System.out.println(actividades.get(i).demeTodo());
        }
    }
}
