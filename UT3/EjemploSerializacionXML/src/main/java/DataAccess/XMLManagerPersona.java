package DataAccess;

import model.Persona;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLManagerPersona {
    public static boolean writeXML(Persona p, String fileName){
        boolean result= false;
        try {
            JAXBContext context = JAXBContext.newInstance(Persona.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(p,new File("persona.xml"));
           result = true;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static Persona readXML(Persona p, String fileName){
        Persona personaDeserializada = p;
        try {
            JAXBContext context = JAXBContext.newInstance(p.getClass());
            Unmarshaller unmarshaller = context.createUnmarshaller();
            personaDeserializada = (Persona)unmarshaller.unmarshal(new File("persona.xml"));


        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return personaDeserializada;
    }
}
