package Ejercicios;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class ConsultaEmpleado {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        File fichero = new File("Empleados.dat");
        int id, dep;
        double salario;
        char[] apellido = new char[10];
        boolean encontrado = false;


        if (!fichero.exists()) {
            System.out.println("El fichero no existe.");
            sc.close();
            return;
        }

        System.out.print("Introduce el ID del empleado a consultar: ");
        int idBuscado = sc.nextInt();

        RandomAccessFile file = new RandomAccessFile(fichero, "r");

        while (file.getFilePointer() < file.length()) {
            id = file.readInt();
            for (int i = 0; i < apellido.length; i++) {
                apellido[i] = file.readChar();
            }

            dep = file.readInt();
            salario = file.readDouble();

            if (id == idBuscado) {
                System.out.println("Empleado encontrado:");
                System.out.println("ID= "+id+"\nApellido= "+ Arrays.toString(apellido) +"\nDepartamento= "+dep+"\nSalario= "+salario);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Empleado con ID " + idBuscado + " no existe.");
        }
    }
}
