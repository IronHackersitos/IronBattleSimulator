package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Creating both characters
        List<Character> players = characterCreation();
        System.out.println(players.toString());
        //Battle
        int rounds = 1;
        //while(players.get(0).getHp() > 0 && players.get(1).getHp() > 0 || (players.get(0).getHp() <= 0 && players.get(1).getHp() <= 0)){
        while(players.get(0).isAlive() && players.get(1).isAlive() || (players.get(0).isAlive() == false) && (players.get(1).isAlive() == false)){
            //Regenerating the players if both entered with 0 and consequently there was a tie.
            //if( (players.get(0).getHp() <= 0 && players.get(1).getHp() <= 0 )){
            if((players.get(0).isAlive() == false) && (players.get(1).isAlive() == false)){
                System.out.println("Combat ended in tie. New combat is generated");
                players = characterCreation();
                rounds = 1;
            }
            //Start of battle
            System.out.println("Round" + rounds);
            players.get(0).attack(players.get(1));
            players.get(1).attack(players.get(0));

            //Printing stats of each player
            int count = 0;
            while (count < 2) {
                System.out.println(players.get(count).toString());
                /*if(players.get(count) instanceof Wizard)
                    System.out.println(players.get(count).getName() + "has the next stats:\n" + "Mana: " + players.get(count).getMana() + "\n" + "Intelligence: " + players.get(count).getIntelligence() + "\n" + "Health: " + players.get(count).super.getHp() + "\n");
                } else if (players.get(count) instanceof Warrior) {
                    /*System.out.println(players.get(count).getName() + "has the next stats:\n" + "Strength: " + players.get(count).getStrength() + "\n" + "Stamina: " + players.get(count).getStamina() + "\n" + "Health: " + players.get(count).super.getHp() + "\n");
                }*/
                count++;
            }
            rounds++;
        }

        //Dictating winner

        if(players.get(0).getHp() > 0){
            System.out.println(players.get(0).getName() + " is the WINNER");
        } else if(players.get(1).getHp() > 0){
            System.out.println(players.get(1).getName() + " is the WINNER");
        }
        

    }

    public static List characterCreation(){
        int i = 0;
        List<Character> players = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("he creado el scanner");
        while(i < 2){
            //Creating the input menu
            System.out.println("he entrado en el bucle");
            if(i == 0) {
                System.out.println("Choose your first fighter: Wizard or Warrior?");
            }else System.out.println("Choose your second fighter: Wizard or Warrior?");

            String playerType = input.nextLine();

            if(i == 0) {
                System.out.println("What's your first fighter's name?");
            }else System.out.println("What's your second fighter's name?");

            String playerName = input.nextLine();

            //Creating the characters according to what was chosen above
            switch (playerType){
                case "Wizard":
                    System.out.println("enrtro a crear player wizard");
                    if(i == 0 ) {
                        System.out.println("enrtro a crear player wizard");
                        Wizard wizard = new Wizard(playerName);
                        players.add(wizard);
                    }else {
                        Wizard wizard1= new Wizard(playerName);
                        players.add(wizard1);
                    }
                    break;
                case "Warrior":
                    System.out.println("enrtro a crear player warrior");
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