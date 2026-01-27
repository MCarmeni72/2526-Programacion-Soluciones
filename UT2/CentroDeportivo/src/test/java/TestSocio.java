import model.Actividad;
import model.Socio;

public class TestSocio {
    public static void main(String[] args) {
        Actividad actividad = new Actividad("pilates",30,"Basico",25,15);
        Actividad actividad2 = new Actividad("pilates",50,"Basico",50,15);
        Actividad actividad3 = new Actividad("yoga",50,"Intermedio",35,10);

        Socio socio1 = new Socio("Ana","1234R",30);



        System.out.println(socio1.addActividad(actividad));
        System.out.println(socio1.addActividad(actividad2));
        System.out.println(socio1.addActividad(actividad3));

        for(Actividad a: socio1.getActividadesInscritas()){
            System.out.println(a);
        }

        socio1.recalcularCoutasDesdeMesActual();



    }
}
