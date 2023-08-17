package org.caraquista.microservices.configserver;
import java.util.Scanner;
public class CourseClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int acum = 0;
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        for (int i = a; i <= b; i++) {
            if (i % n == 0) {
                acum++;
            }
        }
        System.out.println(acum);

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
