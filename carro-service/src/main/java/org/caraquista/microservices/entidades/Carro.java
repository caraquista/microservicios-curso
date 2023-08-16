package org.caraquista.microservices.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// import java.util.Scanner;
@Entity
@Table(name="carros")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;
    @Setter @Getter
    private String marca;
    @Setter @Getter
    private String modelo;
    @Setter @Getter @Column(name = "usuario_id")
    private int usuarioId;



   /* public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       /* int inText = scanner.nextInt();

        System.out.println((inText/100) + (((inText - ((inText/100)*100)) )/ 10) + ((inText % 1000) % 10));
        int squirrels = scanner.nextInt();
        int nuts = scanner.nextInt();
        System.out.println(nuts % squirrels);* /

        // put your code here
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();
        boolean result1 = (K == N ) || (K == M);
        boolean result2 = (K < N*M) && ( ((N*M) - K  == N ) || ((N*M) - K == M));
        boolean result3 = (K < N*M) && ( (((N*M) - K) % N == 0 ) || (((N*M) - K) % M == 0));
        String result = (result2 || result1 || result3) ? "YES" : "NO";
        System.out.println(result);
    }*/

}
