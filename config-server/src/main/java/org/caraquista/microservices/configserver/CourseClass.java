package org.caraquista.microservices.configserver;
import java.util.Scanner;
public class CourseClass {
    public static void main(String[] args) {
        int a = 010;
        int b = 07;
        System.out.println(a);
        System.out.println(b);
        /*Scanner scanner = new Scanner(System.in);
        // start coding here
        String house = scanner.next();
        switch (house) {
            case "gryffindor" -> System.out .println("bravery");
            case "hufflepuffhufflepuff" -> System.out .println("loyalty");
            case "slytherin" -> System.out .println("cunning");
            case "ravenclaw" -> System.out .println("intellect");
            default -> System.out.println("not a valid house");
        }*/

        /*String template = "You have chosen a ";
        System.out.println("1 – square, 2 – circle, 3 – triangle, 4 – rhombus");
        int respuesta = scanner.nextInt();
        switch (respuesta) {
            case 1 -> System.out.println(template + "square");
            case 2 -> System.out.println(template + "circle");
            case 3 -> System.out.println(template + "triangle");
            case 4 -> System.out.println(template + "rhombus");
            default -> System.out.println("There is no such shape!");
        }*/

        /*
        int respuesta = scanner.nextInt();
        switch (respuesta) {
            case 1 -> System.out.println("Yes!");
            case 2, 3, 4 -> System.out.println("No!");
            default -> System.out.println("Unknown number");
        }*/

        /* int acum = 0;
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        for (int i = a; i <= b; i++) {
            if (i % n == 0) {
                acum++;
            }
        }
        System.out.println(acum);*/

        /*int acum = 1;
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        for (int i = a; i < b; i++){
            System.out.println(acum + " "+i);
            acum *= i;
        }
        System.out.println(acum + "");*/

        /*int n = 100; // n gets assigned a positive integer number

        int magic = 0;
        while (n > 0) {
            n /= 10;
            magic++;
        }
        System.out.println(magic);*/


        /*int number = scanner.nextInt();
        boolean flagContinue = true;
        while(flagContinue) {
            System.out.print(number + " ");
            if (number != 1) {
                if (number % 2 == 0) {
                    number /= 2;
                } else {
                    number = (number * 3) +1 ;
                }
            } else {
                flagContinue = false;
            }
        }*/
    }
}

interface inter {
    void a();
}

abstract class classAb implements inter{}

class otherCls extends classAb{
    public void a(){;}
}
class clas12 extends otherCls{
    void a (int a){;}
}