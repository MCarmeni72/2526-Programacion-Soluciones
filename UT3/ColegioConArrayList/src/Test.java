import controller.CursoControlador;
import model.Curso;

public class Test {
    public static void main(String[] args) {
        Curso c = new Curso ("1ºDAM");
        CursoControlador cursoControlador = new CursoControlador(c);
        cursoControlador.iniciar();
    }
}
