
/**
 * Write a description of class Actividad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Actividad
{
    // instance variables - replace the example below with your own
    private int id;
    private int avance;
    private String nombre;
    private String tiempo;
    private String dinero;
    private String esfuerzo;
    private String inicio;
    private String fin;
    private String responsable;

    /**
     * Constructor for objects of class Actividad
     */
    public Actividad(int identificador, int avan, String nom, String tiemp, String diner, String esf, String ini, String fi, String resp)
    {
        // initialise instance variables
        id= identificador;
        avance=avan;
        nombre=nom;
        tiempo=tiemp;
        dinero=diner;
        esfuerzo=esf;
        inicio=ini;
        fin=fi;
        responsable=resp;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String demeNombre()
    {
        return nombre;
    }

    public void cambieNombre(String nuevoNombre)
    {
        nombre = nuevoNombre;
    }

    public int demeId()
    {
        return id;
    }

    public void cambieId(int nuevoId)
    {
        id = nuevoId;
    }

    public int demeAvance()
    {
        return avance;
    }

    public void cambieAvance(int nuevoAvance)
    {
        avance = nuevoAvance;
    }

    public String demeTiempo()
    {
        return tiempo;
    }

    public void cambieTiempo(String nuevoTiempo)
    {
        tiempo = nuevoTiempo;
    }

    public String demeDinero()
    {
        return dinero;
    }

    public void cambieDinero(String nuevoDinero)
    {
        dinero = nuevoDinero;
    }

    public String demeEsfuerzo()
    {
        return esfuerzo;
    }

    public void cambieEsfuerzo(String nuevoEsfuerzo)
    {
        esfuerzo = nuevoEsfuerzo;
    }

    public String demeInicio()
    {
        return inicio;
    }

    public void cambieIncio(String nuevoInicio)
    {
        inicio = nuevoInicio;
    }

    public String demeFin()
    {
        return fin;
    }

    public void cambieFin(String nuevoFin)
    {
        fin = nuevoFin;
    }

    public String demeResponsable()
    {
        return responsable;
    }

    public void cambieResponsable(String nuevoResponsable)
    {
        responsable = nuevoResponsable;
    }

    public void agregueResponsable(String nuevoColaborador)
    {
        responsable= responsable+", "+nuevoColaborador;
    }

    public String demeTodo()
    {
        return "ID: "+id+" Nombre actividad: "+nombre+" Responsable(s): "+responsable+"\n"+"Estimación: "+tiempo+" "+dinero+" "+esfuerzo+ " Grado de avance: "+avance+"\n"+"Fecha de inicio: "+inicio+" Fecha de finalización: "+fin;
    }
}
