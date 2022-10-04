package org.academiadecodigo.sniperelite.GameObject;

import org.academiadecodigo.sniperelite.Destroyable;

public class Barrel extends GameObject implements Destroyable {
    // Properties
    private BarrelType barrelType;
    private int currentDamage;
    private boolean destroyed;

    public Barrel(){
        barrelType = BarrelType.values()[(int) (Math.random() * BarrelType.values().length)];
        getMessage();
        currentDamage = 0;
    }

    // Methods
    @Override
    public String getMessage(){
        return "I am a barrel from the type: " + barrelType;
    }

    @Override
    public void hit(int damage) {
        if(barrelType.getMaxDamage() - currentDamage < 0){
            destroyed = true;
            System.out.println(barrelType + " barrel: I got destroyed");
        } else{
            currentDamage +=  damage;
            System.out.println(barrelType + " barrel: My current health is " + (barrelType.getMaxDamage() - currentDamage));
        }
    }

    public boolean isDestroyed() {
        return destroyed;
    }
}
