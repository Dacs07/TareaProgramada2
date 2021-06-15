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

    public void cambieID(int nuevoID)
    {
        id=nuevoID;

    }

    public String demeNombre()
    {
        return nombre;
    }

    public void cambieNombre(String nuevoNombre)
    {
        nombre=nuevoNombre;

    }

    public String demeDescripcion()
    {
        return descripcion;
    }

    public void cambieDescripcion(String nuevaDescripcion)
    {
        descripcion=nuevaDescripcion;

    }

    public String demeTodo()
    {
        return id+" "+nombre+" "+descripcion;
    }

    public void removerActividad()
    {
        Scanner entr= new Scanner(System.in);
        entr.useDelimiter("\n");
        System.out.println("Ingrese la actividad a eliminar");
        int ind= entr.nextInt();

        actividades.remove(ind -1);

    }

    public void crearActividad ()
    {
        Scanner entr= new Scanner(System.in);
        entr.useDelimiter("\n");
        System.out.println("Agregue los detalles de la actividad. ID-Avance (1-Sin comenzar, 2-En proceso, 3-Finalizado) -Nombre-Responsable");
        int id = entr.nextInt();
        int avance=entr.nextInt();
        String nombre= entr.next();
        String responsable= entr.next();

        Actividad nuevaActividad = new Actividad(id, avance, nombre, responsable);
        nuevaActividad.cambieTiempo("______");
        nuevaActividad.cambieDinero("______");
        nuevaActividad.cambieEsfuerzo("______");
        nuevaActividad.cambieInicio("______");
        nuevaActividad.cambieFin("______");

        System.out.println("¿Desea agregar algunos de los siguientes datos a su actividad? (1-Sí , 2-No)");
        System.out.println("Estimación (Tiempo, Dinero o Esfuerzo) --- Fecha de inicio --- Fecha de finalización");
        int si = entr.nextInt();

        if(si == 1){
            int extra;
            do{
                System.out.println("1-Estimación (Tiempo, Dinero o Esfuerzo) --- 2-Fecha de inicio --- 3-Fecha de finalización --- 4-Para continuar");
                extra = entr.nextInt();
                switch(extra){
                    case 1:
                    int opcion;
                    do{
                        System.out.println("Digite 1 para agregar tiempo, 2 para dinero, 3 para esfuerzo, 4 para continuar");
                        opcion=entr.nextInt();

                        switch(opcion){
                            case 1:
                            System.out.println("Ingrese el tiempo estimado");
                            String nuevoTiempo = entr.next();
                            nuevaActividad.cambieTiempo(nuevoTiempo);
                            break;

                            case 2:
                            System.out.println("Ingrese el monto estimado");
                            String nuevoDinero = entr.next();
                            nuevaActividad.cambieDinero(nuevoDinero);
                            break;

                            case 3:
                            System.out.println("Ingrese el esfuerzo estimado");
                            String nuevoEsfuerzo = entr.next();
                            nuevaActividad.cambieEsfuerzo(nuevoEsfuerzo);
                            break;
                        }
                    }while(opcion!=4);
                    break;

                    case 2:
                    System.out.println("Ingrese la fecha de inicio");
                    String nuevoInicio = entr.next();
                    nuevaActividad.cambieInicio(nuevoInicio);
                    break;

                    case 3:
                    System.out.println("Ingrese la fecha de finalización");
                    String nuevoFin = entr.next();
                    nuevaActividad.cambieFin(nuevoFin);
                    break;
                }
            }while(extra != 4);
        }
        actividades.add(nuevaActividad);
    }

    public void modifiqueActividades(int actividad)
    {
        Scanner entr= new Scanner(System.in);
        entr.useDelimiter("\n");
        int opcion;
        do{
            System.out.println("¿Qué desea cambiar de esta actividad? \n 1 para ID, 2 para Nombre, 3 para Avance, 4 para Responsable, 5 para Tiempo, 6 para Dinero, 7 para Esfuerzo, 8 para Fecha de inicio, 9 para Fecha de finalización, 10 para continuar");
            opcion=entr.nextInt();

            switch(opcion){
                case 1:
                System.out.println("Ingrese nuevo ID");
                int nuevoID=entr.nextInt();
                actividades.get(actividad).cambieId(nuevoID);
                break;

                case 2:
                System.out.println("Ingrese nuevo Nombre");
                String nuevoNombre=entr.next();
                actividades.get(actividad).cambieNombre(nuevoNombre);
                break;

                case 3:
                System.out.println("Ingrese nuevo Grado de Avance (1-Sin comenzar, 2-En proceso, 3-Finalizado)");
                int nuevoAvance=entr.nextInt();
                actividades.get(actividad).cambieAvance(nuevoAvance);
                break;

                case 4:
                System.out.println("Ingrese nuevo(s) Responsable(s)");
                String nuevoResponsable=entr.next();
                actividades.get(actividad).cambieResponsable(nuevoResponsable);
                break;

                case 5:
                System.out.println("Ingrese nuevo Tiempo estimado");
                String nuevoTiempo=entr.next();
                actividades.get(actividad).cambieTiempo(nuevoTiempo);
                break;

                case 6:
                System.out.println("Ingrese nuevo Dinero estimado");
                String nuevoDinero=entr.next();
                actividades.get(actividad).cambieDinero(nuevoDinero);
                break;

                case 7:
                System.out.println("Ingrese nuevo Esfuerzo estimado");
                String nuevoEsfuerzo=entr.next();
                actividades.get(actividad).cambieEsfuerzo(nuevoEsfuerzo);
                break;

                case 8:
                System.out.println("Ingrese nueva Fecha de inicio");
                String nuevoInicio=entr.next();
                actividades.get(actividad).cambieInicio(nuevoInicio);
                break;

                case 9:
                System.out.println("Ingrese nueva Fecha de finalización");
                String nuevoFin=entr.next();
                actividades.get(actividad).cambieFin(nuevoFin);
                break;

            }
        }while(opcion!=10);

    }

    public void elimineAtributos(int actividad)
    {
        Scanner entr= new Scanner(System.in);
        entr.useDelimiter("\n");
        int opcion;
        do{
            System.out.println("¿Qué desea eliminar de esta actividad? \n 1 para Responsable, 2 para Tiempo, 3 para Dinero, 4 para Esfuerzo, 5 para Fecha de inicio, 6 para Fecha de finalización, 7 para continuar");
            opcion=entr.nextInt();

            switch(opcion){
                case 1:
                String nuevoResponsable="______";
                actividades.get(actividad).cambieResponsable(nuevoResponsable);
                break;

                case 2:
                String nuevoTiempo="______";
                actividades.get(actividad).cambieTiempo(nuevoTiempo);
                break;

                case 3:
                String nuevoDinero= "______";
                actividades.get(actividad).cambieDinero(nuevoDinero);
                break;

                case 4:
                String nuevoEsfuerzo= "______";
                actividades.get(actividad).cambieEsfuerzo(nuevoEsfuerzo);
                break;

                case 5:
                String nuevoInicio= "______";
                actividades.get(actividad).cambieInicio(nuevoInicio);
                break;

                case 6:
                String nuevoFin= "______";
                actividades.get(actividad).cambieFin(nuevoFin);
                break;

            }
        }while(opcion!=7);

    }

    public void imprimaActividades ()
    {
        System.out.println("Lista de actividades de la categoría "+nombre+": ");
        for(int i = 0; i < actividades.size(); i++) {
            System.out.println(actividades.get(i).demeTodo());
        }
    }

    public void compareNombre(String nombrebusq)
    {
        for(int i=0; i<actividades.size(); i++){
            String nombretmp= actividades.get(i).demeNombre();

            if (nombretmp.equalsIgnoreCase(nombrebusq)){
                System.out.println(actividades.get(i).demeTodo());
            }
        }
    }
    
    public void compareResponsable(String responsablebusq)
    {
        for(int i=0; i<actividades.size(); i++){
            String responsabletmp= actividades.get(i).demeResponsable();
            
            if (responsabletmp.equalsIgnoreCase(responsablebusq)){
                System.out.println(actividades.get(i).demeTodo());
            }
        }
    }

    public void compareAvance(int avancebusq)
    {
        for(int i=0; i<actividades.size(); i++){
            int avancetmp= actividades.get(i).demeAvance();

            if (avancetmp==avancebusq){
                System.out.println(actividades.get(i).demeTodo());
            }
        }
    }
    
    public void compareTiempo(String tiempobusq)
    {
        for(int i=0; i<actividades.size(); i++){
            String tiempotmp= actividades.get(i).demeTiempo();
            
            if (tiempotmp.equalsIgnoreCase(tiempobusq)){
                System.out.println(actividades.get(i).demeTodo());
            }
        }
    }
    
    public void compareDinero(String dinerobusq)
    {
        for(int i=0; i<actividades.size(); i++){
            String dinerotmp= actividades.get(i).demeDinero();
            
            if (dinerotmp.equalsIgnoreCase(dinerobusq)){
                System.out.println(actividades.get(i).demeTodo());
            }
        }
    }
    
    public void compareEsfuerzo(String esfuerzobusq)
    {
        for(int i=0; i<actividades.size(); i++){
            String esfuerzotmp= actividades.get(i).demeEsfuerzo();
            
            if (esfuerzotmp.equalsIgnoreCase(esfuerzobusq)){
                System.out.println(actividades.get(i).demeTodo());
            }
        }
    }
    
    public void compareInicio(String iniciobusq)
    {
        for(int i=0; i<actividades.size(); i++){
            String iniciotmp= actividades.get(i).demeInicio();
            
            if (iniciotmp.equalsIgnoreCase(iniciobusq)){
                System.out.println(actividades.get(i).demeTodo());
            }
        }
    }
    
    public void compareFin(String finbusq)
    {
        for(int i=0; i<actividades.size(); i++){
            String fintmp= actividades.get(i).demeFin();
            
            if (fintmp.equalsIgnoreCase(finbusq)){
                System.out.println(actividades.get(i).demeTodo());
            }
        }
    }
}
