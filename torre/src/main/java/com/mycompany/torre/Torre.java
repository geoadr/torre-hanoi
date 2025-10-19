/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.torre;

/**
 *
 * @author geo
 */
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;
public class Torre {

   public static long movimentos = 0;

    public static void hanoi(int n, char origem, char localDesejado, char auxiliar) {
        if (n == 1) {
            movimentos++;
            return;
        }

        hanoi(n - 1, origem, auxiliar, localDesejado);
        movimentos++;
        hanoi(n - 1, auxiliar, localDesejado, origem);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            int qtd;
            movimentos = 0; 
            LocalDateTime inicio = LocalDateTime.now();
            System.out.println("1-Informar a quantidade de discos");
            System.out.println("2-Para sair");
            int opcao = scanner.nextInt();
            if(opcao==1){
                System.out.println("Informe a quantidade de discos");
                qtd = scanner.nextInt();
            }else{
                break;
            }
            System.out.println("\nExecutando para N = " + qtd + " discos");
            hanoi(qtd, 'A', 'C', 'B'); 

            LocalDateTime fim = LocalDateTime.now();
            Duration duracaoTotal = Duration.between(inicio, fim);
            long horas = duracaoTotal.toHours();
            long minutos = duracaoTotal.toMinutesPart();
            long segundos = duracaoTotal.toSecondsPart();
            long milissegundos = duracaoTotal.toMillisPart();

            String tempoFormatado = String.format("%02d:%02d:%02d:%02d",
            horas, minutos, segundos, milissegundos);
            System.out.println("Tempo gasto: " + tempoFormatado);
            System.out.println("Quantidade de movimentos: " + movimentos);
    
        }
            
    
    }
}