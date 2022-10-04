package org.academiadecodigo.sniperelite.GameObject.Enemy;

import org.academiadecodigo.sniperelite.Destroyable;
import org.academiadecodigo.sniperelite.GameObject.GameObject;

abstract public class Enemy extends GameObject implements Destroyable {
    // Properties
    private int health;
    private boolean isDead;

    // Methods
    public Enemy(){
        getMessage();
        health = 100;
    }
    public boolean isDead(){
        return isDead = true;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int damage){
        this.health -= damage;
    }

    public void hit(int damage){
        System.out.println("Got hit with " + damage);
    }

    public boolean isDestroyed(){
        return isDead;
    }

    @Override
    public String getMessage(){
        return "I am a brave enemy!";
    }
}
