package com.company;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Scanner reader = new Scanner(System.in);
        int sticks = (int) (Math.random() * 10) + 21;
        System.out.println("There are " + sticks + " sticks.");
        System.out.println("Select 1 to go first, and select 2 to go second.");

        // turn true means player turn, false means computer turn
        boolean turn;
        if (reader.nextInt() == 1) {
            turn = true;
        } else {
            turn = false;
        }


        while (sticks > 0) {
            if (turn == true) {
                sticks = playerMove(sticks, reader);
            } else {
                sticks = computerMove(sticks);
            }

            System.out.println("There are " + sticks + " sticks left.");

        if (turn && sticks == 0) {
            System.out.println("You won!");
        } else if (!turn && sticks == 0) {
            System.out.println("You lost.");
        }

        turn = !turn;
        }

    }

    // must return int
    // two input parameters, sticks and reader
    public static int playerMove(int sticks, Scanner reader) {
        System.out.println("Select how many sticks to take:");
        int sticksTaken;
        sticksTaken = reader.nextInt();
        if (sticksTaken < 1) {
            sticksTaken = 1;
        } else if (sticksTaken > 3) {
            sticksTaken = 3;
        } else if (sticksTaken == 2) {
           sticksTaken = 2;
        } else if (sticks < sticksTaken) {
            sticksTaken = sticks;
        }
        System.out.println("You took " + sticksTaken + " sticks.");
        sticks = sticks - sticksTaken;
        return sticks;
    }

    public static int computerMove(int sticks) {
        int computerSticksTaken;
        //if sticks is not multiple of 4
        if(sticks % 4 != 0) {
            computerSticksTaken = sticks % 4;
        } else {
            computerSticksTaken = (int)(Math.random()*3) + 1;
        }
        System.out.println("The computer took " + computerSticksTaken + " sticks.");
        sticks = sticks - computerSticksTaken;
        return sticks;
    }

}
