import java.util.*;
/**
 * Esta clase define los atributos asociados a las actividades.
 * 
 * @author David Córdoba Segura C02390  ---  Yasmyn Chacón Hernández B41761 
 * @version 19/06/2021
 */
public class Actividad
{
    private int id;
    private int avance;
    private String nombre;
    private String tiempo;
    private String dinero;
    private String esfuerzo;
    private String inicio;
    private String fin;
    private String responsable;
    private String recurso;
    private ArrayList<Integer> asociadas;

    /**
     * Constructor de la clase Actividad, inicializa los atributos necesarios para la definición de una actividad.
     * 
     * 
     */
    public Actividad(int identificador, int avan, String nom, String resp)
    {
        
        id= identificador;
        avance=avan;
        nombre=nom;
        responsable=resp;
        asociadas = new ArrayList<Integer>();
    }

    /**
     * Guarda los índices del arraylist de actividades a las cuales está asociada.
     * 
     * @param  ind    Hace referencia al índice asociado
     * 
     */
    public void agregueAsociadas(int ind)
    {
        asociadas.add(ind);
    }
    
    public ArrayList<Integer> demeAsociadas()
    {
        return asociadas; 
    }

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

    public void cambieInicio(String nuevoInicio)
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

    public String demeRecurso()
    {
        return recurso;
    }

    public void cambieRecurso(String nuevoRecurso)
    {
        recurso = nuevoRecurso;
    }

    public void agregueRecurso(String nuevoRecurso)
    {
        recurso= recurso+", "+nuevoRecurso;
    }

    public String demeTodo()  //Cambia según el grado de avance dado
    {
        if(avance==1){
            return "ID: "+id+" Nombre actividad: "+nombre+" Responsable(s): "+responsable+"\n"+"Estimación: "+"Tiempo: "+tiempo+" Dinero: "+dinero+" Esfuerzo: "+esfuerzo+ " Recursos asignados: "+recurso+"\n" +"Grado de avance: Sin comenzar"+" Fecha de inicio: "+inicio+" Fecha de finalización: "+fin+"\n";
        } 
        if (avance==2){
            return "ID: "+id+" Nombre actividad: "+nombre+" Responsable(s): "+responsable+"\n"+"Estimación: "+"Tiempo: "+tiempo+" Dinero: "+dinero+" Esfuerzo: "+esfuerzo+ " Recursos asignados: "+recurso+"\n" +"Grado de avance: En proceso"+" Fecha de inicio: "+inicio+" Fecha de finalización: "+fin+"\n";
        } else {
            return "ID: "+id+" Nombre actividad: "+nombre+" Responsable(s): "+responsable+"\n"+"Estimación: "+"Tiempo: "+tiempo+" Dinero: "+dinero+" Esfuerzo: "+esfuerzo+ " Recursos asignados: "+recurso+"\n" +"Grado de avance: Finalizado"+" Fecha de inicio: "+inicio+" Fecha de finalización: "+fin+"\n";
        }
    }
}

