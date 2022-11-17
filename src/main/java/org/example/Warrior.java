package org.example;

import java.util.Random;

public class Warrior extends Character {
    private int stamina;
    private int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        setStamina(stamina);
        setStrength(strength);
    }

    public Warrior(String name) {
        super(name);
        super.setHp((int) (Math.random()*(201-100))+100);
        setStamina((int) (Math.random()*(51-10))+10);
        setStrength((int) (Math.random()*(11-1))+1);
    }

    public Warrior(String name, int hp) {
        super(name, hp);
        setStamina((int) (Math.random()*(51-10))+10);
        setStrength((int) (Math.random()*(11-1))+1);
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Player " + getName() + " Stats:\n|Type: Warrior |HP: " +
                getHp() + " |Strength: " + getStrength() +" |Stamina: " + getStamina() +" |Alive: " + isAlive();
    }

    public void attack (Character character){
        //randomly choosing which attack type
        String [] attacks = {"Heavy Attack", "Weak Attack"};
        Random random = new Random();
        int R = random.nextInt(attacks.length);
        String attack = attacks [R];
        System.out.println(super.getName() + " used " + attack);
        
        switch (attack){
            case "Heavy Attack":
                if (this.stamina<5){
                    attack = "Weak Attack";
                    System.out.println(super.getName() + " doesn't have enough stamina and so it will use " + attack);
                }
                else if(this.stamina>=5){
                    character.setHp(character.getHp() - this.strength);
                    this.stamina -= 5;
                    break;
                }
            case "Weak Attack":
                if (this.stamina <= 0){
                    stamina += 2;
                    break;
                }
                character.setHp(character.getHp() - this.strength/2);
                this.stamina++;
                break;
        }
    }
}