package org.academiadecodigo.sniperelite.GameObject;

public enum BarrelType {
    PLASTIC(1),
    WOOD(25),
    METAL(100);

    // Properties
    private int maxDamage;

    BarrelType(int maxDamage){
        this.maxDamage = maxDamage;
    }

    // Methods
    public int getMaxDamage(){
        return maxDamage;
    }
}
