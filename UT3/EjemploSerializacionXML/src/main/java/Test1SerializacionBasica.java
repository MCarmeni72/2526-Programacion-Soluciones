import DataAccess.XMLManager;
import DataAccess.XMLManagerPersona;
import model.CategoriaPersona;
import model.Persona;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Test1SerializacionBasica {
    public static void main(String[] args) {

        Persona p = new Persona("Juan",30);
        p.setCategoria(CategoriaPersona.SENIOR);
        //proceso de serializar
      /*  if(XMLManagerPersona.writeXML(p,"persona.xml"))
            System.out.println("guardado correctamente");
        else
            System.out.println("problema al guardar, no se ha conseguido");
*/

        //proceso de Deserialización UnMarshal
        Persona p2 = new Persona();
        p2.setCategoria(CategoriaPersona.JUVENIL);

        p2 = XMLManager.readXML(p2,"persona.xml");
        System.out.println(p2.getNombre());
        System.out.println(p2.getEdad());

    }
}
