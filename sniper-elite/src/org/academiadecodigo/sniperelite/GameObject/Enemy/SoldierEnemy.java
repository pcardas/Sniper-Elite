package org.academiadecodigo.sniperelite.GameObject.Enemy;

public class SoldierEnemy extends Enemy{
    public SoldierEnemy(){
        getMessage();
    }
    // Methods
    @Override
    public void hit(int damage){
        setHealth(damage);
    }

    @Override
    public void setHealth(int damage){
        if(this.getHealth() - damage < 0){
            isDead();
            System.out.println("Soldier: My current health is: " + (getHealth() - damage));
            System.out.println("Soldier: I am dead");
        } else {
            super.setHealth(damage);
            System.out.println("Soldier: My current health is: " + getHealth());
        }
    }

    @Override
    public String getMessage(){
        return "I am a brave Soldier enemy!";
    }
}
