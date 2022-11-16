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



    // method attack.

    public abstract void attack (Character character) {

        String [] attacks = {"Fireball", "Staff hit"}; //generamos de manera random el ataque que se utilizara
        Random random = new Random();
        int R = random.nextInt(1, attacks.length);
        String attack = attacks [R];
        System.out.println("Player used: " + attack);

        switch (attack){
            case "Fireball":

                if(this.mana<5){
                    attack="Staff hit";
                    break;
                }

                super.setHp(character) = super.getHp(character) - this.intelligence;
                this.mana -= 5;
                break;
            case "Staff hit":

                if(this.mana<=0){
                    mana+=2;
                    break;
                }

                super.setHp(character) = super.getHp(character) -2;
                this.mana++;
                break;
        }

        //Getters and setters

        public int getMana() {
            return mana;
        }

        public void setMana(int mana) {
            this.mana = mana;
        }

        public int getIntelligence() {
            return intelligence;
        }

        public void setIntelligence(int intelligence) {
            this.intelligence = intelligence;
        }

        public String toString(){
            return "Name: " +getName()  + " |Type: Wizard |HP: " +
                    getHp() + " |Intelligence: " + getIntelligence() +" |Mana: " + getMana();
        }

        // public String toCSV(){
        //    return getName() + "," + getHp() + "," + getMana() + "," + getIntelligence() + "," + 1;
        //}

    }