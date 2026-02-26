package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="agenda")
public class Agenda {
    @XmlElement(name="persona",type= Persona.class)
    List<Persona> miAgenda = new ArrayList<>();

    public Agenda(){}

    public Agenda(List<Persona> miAgenda) {
        this.miAgenda = miAgenda;
    }

    public boolean addPersona(Persona p){
        return miAgenda.add(p);
    }

    public List<Persona> getMiAgenda(){
        return miAgenda;
    }
}
