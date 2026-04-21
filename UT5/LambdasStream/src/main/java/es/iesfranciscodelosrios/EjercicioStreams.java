package es.iesfranciscodelosrios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EjercicioStreams {
    static void main() {

        // Crear una lista de objetos Persona
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Citroen C3", 220, 45, 2005));
        vehiculos.add(new Vehiculo("Bicicleta BH", 40, 0, 1998));
        vehiculos.add(new Vehiculo("Tesla Model 3", 220, 0, 2019));
        vehiculos.add(new Vehiculo("Peugeot Partner", 200, 60, 2018));
        vehiculos.add(new Vehiculo("Renault Twingo", 180, 30, 2012));

//        Filtrar: Filtra los vehículos cuya velocidad máxima sea superior a 150 km/h.
        System.out.println("Filtra los vehículos cuya velocidad máxima sea superior a 150 km/h");
          vehiculos.stream().filter(vehiculo -> vehiculo.getVelocidadMaxima() > 150).forEach(System.out::println);
//        Transformar: Transforma el modelo de los vehículos filtrados a mayúsculas.
        System.out.println("Transforma el modelo de los vehículos filtrados a mayúsculas.");
          vehiculos.stream().map(vehiculo -> vehiculo.getModelo().toUpperCase()).forEach(System.out::println);
//        Sumar: Suma la capacidad total de los depósitos de combustible de todos los vehículos.
        System.out.println("Suma la capacidad total de los depósitos de combustible de todos los vehículos.");
          Integer capacidadTotal = vehiculos.stream().map(vehiculo -> vehiculo.getCapacidadDeposito()).reduce(0, (resultado,capacidad) -> resultado+capacidad);
          System.out.println("Capacidad total: " + capacidadTotal);
//        Ordenar: Ordena los vehículos por su año de fabricación de manera ascendente.
        System.out.println("Ordena los vehículos por su año de fabricación de manera ascendente.");
          vehiculos.stream().sorted(Comparator.comparingInt(Vehiculo::getAnioFabricacion)).forEach(System.out::println);
//        Recoger: Recoge los modelos de los vehículos en una lista.
        System.out.println("Recoge los modelos de los vehículos en una lista.");
        List<String> modelos = vehiculos.stream().map(vehiculo -> vehiculo.getModelo()).collect(Collectors.toList());
        // List<String> modelos = vehiculos.stream().map(Vehiculo::getModelo).toList(); Versión compacta
        System.out.println(modelos);
//        Combinación de operaciones: Filtra los vehículos con una velocidad máxima superior a 120 km/h, ordénalos por año de fabricación de forma descendente y recoge los vehículos en una lista.
        System.out.println("Filtra los vehículos con una velocidad máxima superior a 120 km/h, ordénalos por año de fabricación de forma descendente y recoge los vehículos en una lista.");
        List<Vehiculo> vehiculosCombinados = vehiculos.stream()
                                                      .filter(vehiculo -> vehiculo.getVelocidadMaxima() > 120)
                                                      .sorted((v1, v2) -> Integer.compare(v2.getAnioFabricacion(), v1.getAnioFabricacion()))
                                                      .toList();
        System.out.println(vehiculosCombinados);
//        Desafío adicional: Filtra los vehículos cuyo modelo contiene la letra "a", ordénalos por capacidad del depósito de combustible de manera ascendente y muestra solo los primeros 3 vehículos.
        System.out.println("Filtra los vehículos cuyo modelo contiene la letra \"a\", ordénalos por capacidad del depósito de combustible de manera ascendente y muestra solo los primeros 3 vehículos.");
        vehiculos.stream().filter(vehiculo -> vehiculo.getModelo().contains("a"))
                          .sorted((v1, v2) ->  Integer.compare(v1.getCapacidadDeposito(), v2.getCapacidadDeposito()))
                          .limit(3)
                          .forEach(System.out::println);

    }
}