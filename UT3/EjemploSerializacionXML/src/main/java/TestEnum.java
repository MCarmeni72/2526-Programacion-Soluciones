import model.CategoriaPersona;

public class TestEnum {
    static void main() {
        for (CategoriaPersona c : CategoriaPersona.values()) {
            System.out.println(c.name());
        }

        CategoriaPersona categoria = CategoriaPersona.valueOf("senior");
        System.out.println(categoria.ordinal());
    }
}
