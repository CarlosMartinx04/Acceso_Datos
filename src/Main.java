import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        File fichero1 = new File("/home/ejercicios/ejercicio1.txt");//Solo lo declaramos
        String directorio = "/home/ejercicios";
        File fichero2 = new File(directorio,"ejercicio2.txt");//Solo lo declaramos

        //Tercera forma para llamarlo
        File direc = new File("home/ejercicios");
        File fichero3 = new File(direc,"ejercicio3.txt");

    }
}