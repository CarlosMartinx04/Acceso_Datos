package Ejercicios;

import java.io.*;
import java.util.Scanner;

public class ModificarEmpleado {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        File fichero = new File("Empleados.dat");

        if (!fichero.exists()) {
            System.out.println("El fichero no existe.");
            sc.close();
            return;
        }

        System.out.print("Introduce el ID del empleado a modificar: ");
        int idBuscado = sc.nextInt();

        System.out.print("Introduce el importe a sumar al salario: ");
        double importe = sc.nextDouble();

        RandomAccessFile file = new RandomAccessFile(fichero, "rw");

        int id;
        double salario;
        char[] apellido = new char[10];
        boolean encontrado = false;

        long posicion = (idBuscado-1)*36L;

        while (file.getFilePointer() < file.length()) {
            file.seek(posicion);
            id = file.readInt();

            for (int i = 0; i < apellido.length; i++) {
                apellido[i] = file.readChar();
            }

            String apellidos = new String(apellido);
            salario = file.readDouble();

            if (id == idBuscado) {
                encontrado = true;
                double salarioNuevo = salario + importe;

                file.seek(posicion + 4 + 20 + 4);
                file.writeDouble(salarioNuevo);

                System.out.println("Empleado modificad");
                System.out.println("Apellido= "+apellidos.trim()+"\nSalario antiguo= "+salario+"\nNuevo salario: "+salarioNuevo);
                break;
            }
            posicion += 36;
        }

        if (!encontrado) {
            System.out.println("Empleado con ID " + idBuscado + " no existe.");
        }
    }
}
