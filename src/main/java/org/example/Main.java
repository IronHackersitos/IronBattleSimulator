package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Creating both characters
        List<Character> players = characterCreation();

        //Battle
        int counter = 1;
        while(players.get(0).getHp() > 0 && players.get(1).getHp() > 0 || (players.get(0).getHp() == 0 && players.get(1).getHp() == 0)){
            //Regenerating the players if both entered with 0 and consequently there was a tie.
            if( (players.get(0).getHp() == 0 && players.get(1).getHp() == 0 )){
                System.out.println("Combat ended in tie. New combat is generated");
                players = characterCreation();
                counter = 1;
            }
            //Start of battle
            System.out.println("Round" + counter);
            players.get(0).attack(players.get(1));
            players.get(1).attack(players.get(0));

            int count = 0;
            while (count < 2) {

                if (players.get(count) instanceof Wizard) {
                    System.out.println(players.get(count).getName() + "has the next stats:\n" + "Mana: " + players.get(count).getMana() + "\n" + "Intelligence: " + players.get(count).getIntelligence() + "\n" + "Health: " + players.get(count).super.getHp() + "\n");
                } else if (players.get(count) instanceof Warrior) {
                    System.out.println(players.get(count).getName() + "has the next stats:\n" + "Strength: " + players.get(count).getStrength() + "\n" + "Stamina: " + players.get(count).getStamina() + "\n" + "Health: " + players.get(count).super.getHp() + "\n");
                }
                count++;
            }
            counter++;
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

        while(i < 2){
            //Creating the input menu
            Scanner input = new Scanner(System.in);

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
                    if(i == 0 ) {
                        Wizard wizard = new Wizard(playerName);
                        players.add(wizard);
                    }else {
                        Wizard wizard1= new Wizard(playerName);
                        players.add(wizard1);
                    }
                    break;
                case "Warrior":
                    if(i == 0) {
                        Warrior warrior = new Warrior(playerName);
                        players.add(warrior);

                    }else if(i == 1 && wizard){
                        Warrior warrior = new Warrior(playerName);
                        players.add(warrior);
                    }else {
                        Warrior warrior1 = new Warrior(playerName);
                        players.add(warrior1);}
                    break;
            }

            input.close();
            i++;
        }
        return players;
    }
}