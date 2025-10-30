package Ejercicios;

import java.io.*;
import java.util.Scanner;

public class InsertaEmpleado {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el ID del empleado: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Introduce el apellido: ");
        String apellido = sc.nextLine();

        System.out.print("Introduce el departamento: ");
        int dep = sc.nextInt();

        System.out.print("Introduce el salario: ");
        double salario = sc.nextDouble();

        File fichero = new File("Empleados.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");

        char[] apellidoLeido = new char[10];
        boolean existe = false;
        long posicion = (id-1)* 36L;

        while (file.getFilePointer() < file.length()) {

            for (int i = 0; i < apellidoLeido.length; i++) {
                apellidoLeido[i] = file.readChar();
            }

            if (posicion == id) {
                file.seek(posicion);
                existe = true;
                break;
            }
        }

        if (existe) {
            System.out.println("El empleado con ID " + id + " ya existe.");
        } else {
            file.length();
            file.writeInt(id);
            StringBuffer buffer = new StringBuffer(apellido);
            buffer.setLength(10);
            file.writeChars(buffer.toString());

            file.writeInt(dep);
            file.writeDouble(salario);

            System.out.println("Empleado insertado correctamente:");
            System.out.println("ID= "+id+"\nApellido= "+apellido+"\nDepartamento= "+dep+"\nSalario= "+salario);
        }

    }
}
