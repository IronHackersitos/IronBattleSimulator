package org.example;
import java.nio.charset.Charset;
import java.util.Random;

public abstract class Character {

    private final String id;
    private String name;
    private int hp;
    private boolean isAlive;

    public Character(String name) {
        //generating random string of length  7
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        this.id = new String(array, Charset.forName("UTF-8"));
        this.isAlive = true;
        setName(name);
        //hp is to be set depending on the class Wizard or Warrior
    }

    public Character(String name, int hp) {
        //generating random string of length  7
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        this.id = new String(array, Charset.forName("UTF-8"));
        this.isAlive = true;
        setName(name);
        //We overload the constructor to be able to set whatever Hp we want;
        setHp(hp);
    }

    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }


    //getters

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    abstract void attack(Character character);

}