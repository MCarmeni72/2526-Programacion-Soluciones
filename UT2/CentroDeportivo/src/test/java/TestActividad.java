import model.Actividad;
import model.Socio;

public class TestActividad {
    public static void main(String[] args) {
        Actividad actividad = new Actividad("pilates",30,"Basico",25,15);
        System.out.println(actividad);

        Socio socio1 = new Socio("Ana","1234R",30);
        Socio socio2 = new Socio("Juan","369Q",33);
        Socio socio3 = new Socio("Juan","369Q",34);

        System.out.println(actividad.numSociosActividad());

        System.out.println(actividad.addSocio(socio1));
        System.out.println(actividad.addSocio(socio2));
        System.out.println(actividad.addSocio(socio3));

        System.out.println(actividad.numSociosActividad());

        actividad.removeSocio(socio1);

        for(Socio s: actividad.getSociosActividad()){
            if(s!=null) System.out.println(s);
        }
    }
}
