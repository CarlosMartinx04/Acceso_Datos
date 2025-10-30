package Ejercicios;

import java.io.*;
import java.util.Scanner;

public class Borrar {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el ID del empleado a borrar: ");
        int idBorrar = sc.nextInt();

        File fichero = new File("Empleado.dat");

        if (!fichero.exists()) {
            System.out.println("El fichero no existe.");
            sc.close();
            return;
        }

        RandomAccessFile file = new RandomAccessFile(fichero, "rw");

        int id;
        char[] apellido = new char[10];
        boolean encontrado = false;

        long posicion = 0;

        while (file.getFilePointer() < file.length()) {
            file.seek(posicion);
            id = file.readInt();

            for (int i = 0; i < apellido.length; i++) {
                apellido[i] = file.readChar();
            }
            if (id == idBorrar) {
                encontrado = true;

                file.seek(posicion);
                file.writeInt(-1);

                StringBuffer buffer = new StringBuffer(String.valueOf(idBorrar));
                buffer.setLength(10);
                file.writeChars(buffer.toString());

                file.writeInt(0);
                file.writeDouble(0);

                System.out.println("\nEmpleado con ID " + idBorrar + " borrado lógicamente.");
                break;
            }

            posicion += 36;
        }

        if (!encontrado) {
            System.out.println("Empleado con ID " + idBorrar + " no existe.");
        }

        file.close();

        String respuesta = sc.nextLine().trim().toUpperCase();

        mostrarBorrados();

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static void mostrarBorrados() throws IOException {
        File fichero = new File("AleatorioEmple.dat");
        if (!fichero.exists()) {
            System.out.println("El fichero no existe.");
            return;
        }

        RandomAccessFile file = new RandomAccessFile(fichero, "r");

        int id;
        char[] apellido = new char[10];
        long posicion = 0;
        boolean hayBorrados = false;

        System.out.println("--------------------------------");

        while (file.getFilePointer() < file.length()) {
            file.seek(posicion);
            id = file.readInt();

            for (int i = 0; i < apellido.length; i++) {
                apellido[i] = file.readChar();
            }

            String apellidos = new String(apellido);

            if (id == -1) {
                System.out.println("Empleado borrado (ID original):"+apellidos.trim());
                hayBorrados = true;
            }

            posicion += 36;
        }

        if (!hayBorrados) {
            System.out.println("No hay empleados borrados.");
        }
        file.close();
    }
}
