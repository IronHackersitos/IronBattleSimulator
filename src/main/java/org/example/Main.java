package org.example;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("WELCOME TO BATTLE SIMULATOR BY IRONHACKERSITOS");
        //Creating both characters
        List<Character> players = characterCreation();
        System.out.println("These will be your players: \n" + players.toString());
        //Battle
        int rounds = 1;
        while(players.get(0).isAlive() && players.get(1).isAlive() || (players.get(0).isAlive() == false) && (players.get(1).isAlive() == false)){
            //Regenerating the players if both entered with 0 and consequently there was a tie.
            if((players.get(0).isAlive() == false) && (players.get(1).isAlive() == false)){
                System.out.println("Combat ended in tie. New combat is generated");
                players = characterCreation();
                rounds = 1;
            }
            //Start of battle
            System.out.println("Round " + rounds);
            players.get(0).attack(players.get(1));
            players.get(1).attack(players.get(0));

            //Printing stats of each player
            int count = 0;
            while (count < 2) {
                System.out.println(players.get(count).toString());
                count++;
            }
            rounds++;
        }

        //Dictating winner

        if(players.get(0).getHp() > 0){
            System.out.println(players.get(0).getName() + " is the WINNER!!! yei");
        } else if(players.get(1).getHp() > 0){
            System.out.println(players.get(1).getName() + " is the WINNER!!! yei");
        }
    }

    public static List characterCreation(){
        int i = 0;
        List<Character> players = new ArrayList<>();
        
        
        while(i < 2){
            Scanner input = new Scanner(System.in);
            //Creating the input menu
            if(i == 0) {
                System.out.println("CHOOSE YOUR FIRST FIGHTER'S FEATURES");}
            else  System.out.println("CHOOSE YOUR SECOND FIGHTER'S FEATURES");
            String playerName = null;
            while(playerName == null || playerName == ""){
                System.out.println("Enter a NAME");
                if(input.hasNextLine())
                    playerName = input.nextLine();
            }

            int playerType = -1;
            while(playerType < 1 || playerType > 2){
                System.out.println("Enter 1 for WIZARD or enter 2 for WARRIOR");
                try {
                    playerType = Integer.valueOf(input.nextLine());
                }catch (NumberFormatException e){
                    playerType = -1;
                }
                if(playerType < 1 || playerType > 2){
                    System.err.println("Enter a number between 1 and 2");
                }
            }

            //Creating the characters according to what was chosen above
            switch (playerType){
                case 1:
                    if(i == 0 ) {
                        Wizard wizard = new Wizard(playerName);
                        players.add(wizard);
                    }else {
                        Wizard wizard1= new Wizard(playerName);
                        players.add(wizard1);
                    }
                    break;
                case 2:
                    if(i == 0) {
                        Warrior warrior = new Warrior(playerName);
                        players.add(warrior);

                    } else {
                        Warrior warrior1 = new Warrior(playerName);
                        players.add(warrior1);}
                    break;
            }
            i++;
        }
        return players;
    }
}