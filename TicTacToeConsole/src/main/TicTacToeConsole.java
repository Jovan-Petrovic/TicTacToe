/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Bron Zilar
 */
public class TicTacToeConsole {
    
    static char[][] matrix = {{' ','|',' ','|',' '},
                              {'-','+','-','+','-'},
                              {' ','|',' ','|',' '},
                              {'-','+','-','+','-'},
                              {' ','|',' ','|',' '}};
    static int field = 0;
    static ArrayList<Integer> takenFields = new ArrayList<>();
    static boolean end = false;
    static int counter = 0;

    public static void main(String[] args) {
        
        while(true) {            
            draw();     
            playPlayer();
            counter++;
            if(end) break;
            draw();
            playComputer();
            counter++;
            if(end) break;
        }
        draw();
     
    }

    private static void playPlayer() {
        System.out.println("Enter the number of field (1-9): ");
        boolean flag = false;
        while(!flag) {
            Scanner in = new Scanner(System.in);
            try {
                field = in.nextInt();
                if(!takenFields.contains(field)) {
                    takenFields.add(field);
                    flag = true;
                } else {
                    System.out.println("Field number " + field + " is taken. Please, try again.");
                }
            } catch(InputMismatchException ex) {
                System.out.println("You must enter a value from 1 to 9. Please, try again.");
            }
        }
        
        putXorO('X');
        if(counter>=5) {
            checkStatusOfGame();
        }
    }

    private static void putXorO(char value) {
        switch(field) {
            case 1:
                matrix[0][0] = value;
                break;
            case 2:
                matrix[0][2] = value;
                break;
            case 3:
                matrix[0][4] = value;
                break;
            case 4:
                matrix[2][0] = value;
                break;
            case 5:
                matrix[2][2] = value;
                break;
            case 6:
                matrix[2][4] = value;
                break;
            case 7:
                matrix[4][0] = value;
                break;
            case 8:
                matrix[4][2] = value;
                break;
            case 9:
                matrix[4][4] = value;
                break;
        }
    }

    private static void draw() {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    private static void playComputer() {
        boolean flag = false;
        while(!flag) {
            Random random = new Random();
            field = 1 + random.nextInt(9);
            if(!takenFields.contains(field)) {
                takenFields.add(field);
                flag = true;
            }
        }       
        putXorO('O');
        if(counter >= 5) {
            checkStatusOfGame();
        }
    }

    private static void checkStatusOfGame() {
        if(takenFields.size() == 9) {
            end = true;
            System.out.println("End of the game! There are no winner.");
            return;
        }
        if(matrix[0][0] == 'X' && matrix[0][2] == 'X' && matrix[0][4] == 'X') {
            end = true;
            System.out.println("End of the game! You won!");
            return;
        }
        if(matrix[0][0] == 'O' && matrix[0][2] == 'O' && matrix[0][4] == 'O') {
            end = true;
            System.out.println("End of the game! Computer won!");
            return;
        }
        if(matrix[2][0] == 'X' && matrix[2][2] == 'X' && matrix[2][4] == 'X') {
            end = true;
            System.out.println("End of the game! You won!");
            return;
        }
        if(matrix[2][0] == 'O' && matrix[2][2] == 'O' && matrix[2][4] == 'O') {
            end = true;
            System.out.println("End of the game! Computer won!");
            return;
        }
        if(matrix[4][0] == 'X' && matrix[4][2] == 'X' && matrix[4][4] == 'X') {
            end = true;
            System.out.println("End of the game! You won!");
            return;
        }
        if(matrix[4][0] == 'O' && matrix[4][2] == 'O' && matrix[4][4] == 'O') {
            end = true;
            System.out.println("End of the game! Computer won!");
            return;
        }
        if(matrix[0][0] == 'X' && matrix[2][0] == 'X' && matrix[4][0] == 'X') {
            end = true;
            System.out.println("End of the game! You won!");
            return;
        }
        if(matrix[0][0] == 'O' && matrix[2][0] == 'O' && matrix[4][0] == 'O') {
            end = true;
            System.out.println("End of the game! Computer won!");
            return;
        }
        if(matrix[0][2] == 'X' && matrix[2][2] == 'X' && matrix[4][2] == 'X') {
            end = true;
            System.out.println("End of the game! You won!");
            return;
        }
        if(matrix[0][2] == 'O' && matrix[2][2] == 'O' && matrix[4][2] == 'O') {
            end = true;
            System.out.println("End of the game! Computer won!");
            return;
        }
        if(matrix[0][4] == 'X' && matrix[2][4] == 'X' && matrix[4][4] == 'X') {
            end = true;
            System.out.println("End of the game! You won!");
            return;
        }
        if(matrix[0][4] == 'O' && matrix[2][4] == 'O' && matrix[4][4] == 'O') {
            end = true;
            System.out.println("End of the game! Computer won!");
            return;
        }
        if(matrix[0][0] == 'X' && matrix[2][2] == 'X' && matrix[4][4] == 'X') {
            end = true;
            System.out.println("End of the game! You won!");
            return;
        }
        if(matrix[0][0] == 'O' && matrix[2][2] == 'O' && matrix[4][4] == 'O') {
            end = true;
            System.out.println("End of the game! Computer won!");
            return;
        }
        if(matrix[0][4] == 'X' && matrix[2][2] == 'X' && matrix[4][0] == 'X') {
            end = true;
            System.out.println("End of the game! You won!");
            return;
        }
        if(matrix[0][4] == 'O' && matrix[2][2] == 'O' && matrix[4][0] == 'O') {
            end = true;
            System.out.println("End of the game! Computer won!");
            return;
        }
    }
    
}
