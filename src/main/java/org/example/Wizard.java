package org.example;

import java.util.Random;

public class Wizard extends Character {


    private int mana;
    private int intelligence;
    
    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        setMana(mana);
        setIntelligence(intelligence);
    }
    
    public Wizard(String name) {
        super(name);
        super.setHp((int) (Math.random()*(201-100))+100);
        setMana((int) (Math.random()*(51-10))+10);
        setIntelligence((int) (Math.random()*(51-1))+1);
    }

    public Wizard(String name, int hp) {
        super(name, hp);
        setMana((int) (Math.random()*(51-10))+10);
        setIntelligence((int) (Math.random()*(51-1))+1);
    }
    
    //Getters and setters

    public int getMana(){
        return mana;
    }


    public void setMana(int mana){
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public String toString(){
        return "Player " + getName() + " Stats:\n|Type: Wizard |HP: " +
                getHp() + " |Intelligence: " + getIntelligence() +" |Mana: " + getMana() +" |Alive: " + isAlive();
    }
    
    // method attack.

    public void attack(Character character) {
        //randomly choosing which attack type
        String[] attacks = {"Fireball", "Staff hit"}; 
        Random random = new Random();
        int R = random.nextInt(attacks.length);
        String attack = attacks[R];
        System.out.println(super.getName() + " used " + attack);

        switch (attack) {
            case "Fireball":
                if (this.mana < 5) {
                    attack = "Staff hit";
                    System.out.println(super.getName() + " doesn't have enough mana and so it will use: " + attack);
                }
                else if (this.mana >= 5){
                    character.setHp(character.getHp() - this.intelligence);
                    this.mana -= 5;
                    break;
                }
            case "Staff hit":
                if (this.mana <= 0) {
                    mana += 2;
                    break;
                }
                character.setHp(character.getHp() - 2);
                this.mana++;
                break;
        }
    }
    }
