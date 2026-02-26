import DataAccess.XMLManager;
import model.Agenda;
import model.Persona;

public class Test2SerializarColeccion {
    public static void main() {
        Persona p1 = new Persona("Juan",30);
        Persona p2 = new Persona("Maria",25);
        Persona p3 = new Persona("Andrea",18);

        Agenda a = new Agenda();
        a.addPersona(p1);
        a.addPersona(p2);
        a.addPersona(p3);

        XMLManager.writeXML(a,"agenda.xml");
    }
}
