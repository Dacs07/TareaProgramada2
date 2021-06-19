import java.util.*;

/**
 * Esta clase define los atributos de las categorías y maneja el IMEC de las actividades. 
 * 
 * @author David Córdoba Segura C02390  ---  Yasmyn Chacón Hernández B41761 
 * @version 19/06/2021
 */
public class Categoria
{
    
    private int id;
    private String nombre;
    private String descripcion;
    private ArrayList<Actividad> actividades;
    
    /**
     * Constructor de la clase Categoría, inicializa todos los atributos de las categorías
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
    
    /**
     * Elimina de la categoría una actividad seleccionada por el usuario.
     * 
     * 
     */

    public void removerActividad() 
    {
        Scanner entr= new Scanner(System.in);
        entr.useDelimiter("\n");
        System.out.println("Ingrese la actividad a eliminar");
        int ind= entr.nextInt();

        actividades.remove(ind -1);  //(ind-1) es porque el usuario empieza su conteo en 1, miestras que el ArrayList lo empieza en 0

    }
    
    /**
     * Crea una actividad dentro de la categoría. Permite agregar datos adicionales sobre la actividad.
     * Permite la asociación de actividades. 
     * 
     */

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
        nuevaActividad.cambieRecurso("______");

        System.out.println("¿Desea agregar algunos de los siguientes datos a su actividad? (1-Sí , 2-No)");
        System.out.println("Estimación (Tiempo, Dinero o Esfuerzo) --- Fecha de inicio --- Fecha de finalización --- Recursos");
        int si = entr.nextInt();

        if(si == 1){
            int extra;
            do{
                System.out.println("1-Estimación (Tiempo, Dinero o Esfuerzo) --- 2-Fecha de inicio --- 3-Fecha de finalización --- 4-Recursos --- 5-Para continuar");
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

                    case 4:
                    System.out.println("Ingrese los Recursos a asignar");
                    String nuevoRecurso = entr.next();
                    nuevaActividad.cambieRecurso(nuevoRecurso);
                    break;
                }
            }while(extra != 5);
        }

        System.out.println("¿La actividad creada está asociada a alguna existente? (1-Sí ,  2-No)");
        int siono = entr.nextInt();
        //Ingresa solo sí el usuario decide asociarlo a una actividad ya creada
        if (siono == 1){ 
            System.out.println("Lista de actividades de la categoría "+nombre+": ");
            //Muestra todas las actividades creadas previamente
            for(int i = 0; i < actividades.size(); i++) {
                System.out.println(actividades.get(i).demeTodo());
            }

            int asocia; //Posición de la actividad a la que se desea asociar
            
            //Permite asociar la actividad a más de una
            do{
                System.out.println ("Seleccione a cuál actividad está asociada. Si no desea asociarla a más actividades, digite 0");
                asocia=entr.nextInt();
                if(asocia !=0){
                    nuevaActividad.agregueAsociadas(asocia -1);
                }

            }while(asocia!=0);
        }else{

            nuevaActividad.agregueAsociadas(-1); //Si no desea asociar, se le agrega un valor bandera
        }

        actividades.add(nuevaActividad);
    }
    
    /**
     * Permite seleccionar y modificar atributos de actividades específicas mediante el uso de un menú.
     * Verifica del grado de avance de las actividades asociadas, para determinar si se puede o no cambiar el grado de avance.
     * 
     * @param actividad   La posición de la actividad a modificar dentro del ArrayList 
     * 
     */

    public void modifiqueActividades(int actividad)
    {
        Scanner entr= new Scanner(System.in);
        entr.useDelimiter("\n");
        int opcion;
        do{
            System.out.println("¿Qué desea cambiar de esta actividad? \n 1 para ID, 2 para Nombre, 3 para Avance, 4 para Responsable, 5 para Tiempo, 6 para Dinero, 7 para Esfuerzo, 8 para Fecha de inicio, 9 para Fecha de finalización, 10 para Recursos, 11 para continuar");
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

                if (actividades.get(actividad).demeAsociadas().get(0)==-1){ // Ingresa si no tiene actividades asociadas y permite la modificación del grado de avance
                    System.out.println("Ingrese nuevo Grado de Avance (1-Sin comenzar, 2-En proceso, 3-Finalizado)");
                    int nuevoAvance=entr.nextInt();
                    actividades.get(actividad).cambieAvance(nuevoAvance);
                }else{  // Ingresa si tiene actividades asociadas
                    int contador=0;
                    for (int i=0; i< actividades.get(actividad).demeAsociadas().size() ; i++){ //Verifica el avance de las actividades asociadas
                        int indice= actividades.get(actividad).demeAsociadas().get(i);

                        if (actividades.get(indice).demeAvance() == 3){
                            contador+=contador;
                        }else{
                            contador=contador;
                        }

                    }

                    if (contador==actividades.get(actividad).demeAsociadas().size()){ //Si todas las actividades asociadas han sido terminadas permite el cambio de avance
                        System.out.println("Ingrese nuevo Grado de Avance (1-Sin comenzar, 2-En proceso, 3-Finalizado)");
                        int nuevoAvance=entr.nextInt();
                        actividades.get(actividad).cambieAvance(nuevoAvance);
                    }else{
                        System.out.println("Ingrese nuevo Grado de Avance (1-Sin comenzar, 2-En proceso, 3-Finalizado)");
                        int nuevoAvance=entr.nextInt();
                        switch(nuevoAvance){
                            case 1:
                            actividades.get(actividad).cambieAvance(nuevoAvance);
                            break;

                            case 2:
                            actividades.get(actividad).cambieAvance(nuevoAvance);
                            break;

                            case 3: // Bloquea si alguna de las actividades asociadas no ha sido finalizada
                            System.out.println("Tiene actividades asociadas sin terminar, no puede cambiar al grado 3 de avance");
                            break;
                        }
                    }
                }
                break;

                case 4:
                System.out.println("Desea agregar colaboradores (1) o cambiar los existentes (2)");
                int esc= entr.nextInt();
                if(esc==2){
                    System.out.println("Ingrese nuevo(s) Responsable(s)");
                    String nuevoResponsable=entr.next();
                    actividades.get(actividad).cambieResponsable(nuevoResponsable);
                }else{
                    System.out.println("Ingrese nuevo(s) Colaboradore(s)");
                    String nuevoColaborador=entr.next();
                    actividades.get(actividad).agregueResponsable(nuevoColaborador);
                }
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

                case 10:
                System.out.println("Desea agregar recursos adicionales (1) o cambiar los existentes (2)");
                int eli= entr.nextInt();
                if(eli==2){
                    System.out.println("Ingrese nuevos Recursos");
                    String nuevoRecurso=entr.next();
                    actividades.get(actividad).cambieRecurso(nuevoRecurso);
                }else{
                    System.out.println("Ingrese los Recursos adicionales");
                    String adicionalRecurso=entr.next();
                    actividades.get(actividad).agregueRecurso(adicionalRecurso);
                }
                break;

            }
        }while(opcion!=11);

    }

    /**
     * Elimina el contenido del atributo definido por el usuario, exceptuando a los atributos indispensables (ID, nombre y avance)
     * 
     * @param actividad   La posición de la actividad dentro del ArrayList a la cual se eliminan los contenidos de los atributos 
     * 
     */
    
    public void elimineAtributos(int actividad)
    {
        Scanner entr= new Scanner(System.in);
        entr.useDelimiter("\n");
        int opcion;
        do{
            System.out.println("¿Qué desea eliminar de esta actividad? \n 1 para Responsable, 2 para Tiempo, 3 para Dinero, 4 para Esfuerzo, 5 para Fecha de inicio, 6 para Fecha de finalización, 7 para Recursos , 8 para continuar");
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

                case 7:
                String nuevoRecurso="______";
                actividades.get(actividad).cambieRecurso(nuevoRecurso);
                break;

            }
        }while(opcion!=8);

    }

    public void imprimaActividades ()  //Imprime las actividades de la categoría
    {
        System.out.println("Lista de actividades de la categoría "+nombre+": ");
        for(int i = 0; i < actividades.size(); i++) {
            System.out.println(actividades.get(i).demeTodo());
        }
    }
    
     /**
     * Retorna las actividades dentro la categoría para su almacenamiento posterior
     * 
     * @return activguardar   El String que contiene todas las actividades (con sus atributos) definidos dentro de la categoría. 
     * 
     */
    
    public String guardeActividades ()  
    {
        String activguardar = "";
        activguardar+="\n Lista de actividades de la categoría: "+id+" "+nombre +" "+descripcion ;
        for(int i = 0; i < actividades.size(); i++) {
            activguardar+= "\n"+actividades.get(i).demeTodo();
        }
        return activguardar;
    }
    
     /**
     * Todos los métodos compare(Atributo) relizan una búsqueda dentro de las actividades existentes de la categoría. 
     * Compara el contenido del atributo, recuperando aquellos con el mismo contenido.  
     * 
     * @param (atributo)busq   El contenido a comparar
     * 
     */
    
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
