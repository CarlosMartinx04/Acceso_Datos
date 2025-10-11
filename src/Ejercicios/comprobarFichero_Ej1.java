package Ejercicios;

import java.io.File;
import java.io.IOException;

public class comprobarFichero_Ej1 {
    public static void main(String[] args) {
        File d = new File("NUEVODIR"); //directorio a crear
        File f1 = new File(d, "FICHERO1.TXT");
        File f2 = new File(d, "FICHERO2.TXT");

        d.mkdir();// Crea el directorio

        try {
            if (f1.createNewFile()) {
                System.out.println("FICHERO1 creado correctamente...");
            }
            else{
                System.out.println("No se ha podido crear el FICHERO1");
            }
            if (f2.createNewFile()) {
                System.out.println("FICHERO2 creado correctamente...");
            }
            else{
                System.out.println("No se ha podido crear el FICHERO2");
            }


        } catch (IOException ioe) {ioe.printStackTrace();}
        f1.renameTo(new File(d,"FICHERO1NUEVO"));//renombro el fichero 1

        try {
            File f3 = new File("NUEVODIR/FICHERO3.TXT");
            f3.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(f2.delete()){
            System.out.println("Fichero borrado...");
        }
        else
            System.out.println("No se ha podido borrar el fichero...");


    }
}
