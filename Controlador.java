
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
        g.crearCategoria();
        
        Categoria c = new Categoria (1, " ", " ");
        c.crearActividad();
    }
}
