package org.academiadecodigo.sniperelite.GameObject.Enemy;

public class ArmouredEnemy extends Enemy {
    // Properties
    private int armour;

    public ArmouredEnemy(){
        getMessage();
        this.armour = 100;
    }

    // Methods
    @Override
    public void hit(int damage){
        setHealth(damage);
    }

    @Override
    public void setHealth(int damage){
        if(armour >= 0){
            if(armour - damage < 0){
                System.out.println("Armoured: You broke my armour");
            }
            armour -= damage;
            System.out.println("Armoured: My current armour is: " + armour);
        } else {
            super.setHealth(-armour);
            System.out.println("Armoured: My current health is: " + getHealth());
            if(this.getHealth() + armour < 0){
                System.out.println("Armoured: My current health is: " + (getHealth() + armour));
                isDead();
                System.out.println("Armoured: I died!!");
            }
        }
    }

    @Override
    public String getMessage(){
        return "I am a brave Armoured Enemy!";
    }
}
