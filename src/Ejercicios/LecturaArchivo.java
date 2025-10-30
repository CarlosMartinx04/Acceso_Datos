package Ejercicios;

import java.io.*;
import java.util.Scanner;

public class LecturaArchivo {
    public static void main(String[] args){

        File fichero= new File("Empleados.txt");
        String contenido = "Hola, este es un texto de ejemplo para el archivo.";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichero))) {
            writer.write(contenido);
            System.out.println("Archivo creado y contenido escrito.");
        } catch (IOException e) {
            e.getMessage();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fichero))) {
            String linea;
            System.out.println("Contenido del archivo:");
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.getMessage();
        }

    }
}
