package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char grid[][] = new char[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                grid[i][j] = ' ';
            }
        }
        printGrid(grid);
        int gameEnd = 0;
        char player = 'X';
        Scanner scan = new Scanner(System.in);
        while(gameEnd == 0){
            int flag = 0;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if(grid[i][j] == ' '){
                        flag = 1;
                        break;
                    }
                }
            }
            if(flag == 0){
                System.out.println("Game Drawn :|");
                break;
            }
            System.out.println("Player " + player + " : Enter Your move ");
            int row = scan.nextInt();
            int col = scan.nextInt();
            if(grid[row][col] == ' '){
                grid[row][col] = player;
                gameEnd = hasWon(row, col, grid);
                if(gameEnd == 1){
                    System.out.println("Player " + player + " Has won :)");
                    printGrid(grid);
                    break;
                }
                if(player == 'X'){
                    player = 'O';
                }
                else{
                    player = 'X';
                }
            }
            else{
                System.out.println("Invalid move made");
            }
            printGrid(grid);
        }

    }

    static void printGrid(char[][] grid) {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(grid[i][j] + " | ");
            }
            System.out.println();
        }
    }

    static int hasWon(int row, int col, char[][] grid){
        //Rows checking
        for(int i = 0; i < 3; i++){
            if(grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && (grid[i][1] == 'X' || grid[i][1] == 'Y')){
                return 1;
            }
        }
        for(int i = 0; i < 3; i++){
            if(grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && (grid[1][i] == 'X' || grid[1][i] == 'Y')){
                return 1;
            }
        }
        if(grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && (grid[0][0] == 'X' || grid[0][0] == 'Y' )){
            return 1;
        }
        if(grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && (grid[0][2] == 'X' || grid[0][2] == 'Y' )){
            return 1;
        }
        return 0;
    }
}