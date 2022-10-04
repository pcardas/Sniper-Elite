package org.academiadecodigo.sniperelite;

import org.academiadecodigo.sniperelite.GameObject.Enemy.Enemy;

public class SniperRifle {
    // Properties
    private int bulletDamage;
    private int shotsFired;
    private int headShots;
    private int shotsMissed;
    private final float HIT_PROB = 0.3f;
    private final float HS_PROB = 0.7f;


    public SniperRifle(int bulletDamage){
        this.bulletDamage = bulletDamage;
        shotsFired = 0;
    }


    // Methods
    public void shoot(Destroyable target){
        if(Math.random() < HIT_PROB) {
            if(Math.random() > HS_PROB){
                System.out.println("BOOM, HEADSHOT!");
                System.out.println("Damage Given: " + ((int)Math.round(bulletDamage * 0.95)));
                target.hit((int)Math.round(bulletDamage * 0.95));
                headShots++;
                shotsFired++;
            } else{
                System.out.println("BOOM!! It's a hit!");
                System.out.println("Damage Given: " + ((int)Math.round(bulletDamage * 0.45)));
                target.hit((int)Math.round(bulletDamage * 0.45));
                shotsFired++;
            }
        } else {
            System.out.println("F#%K!! It's a miss!");
            shotsMissed++;
            shotsFired++;
        }
    }

    public int getShotsFired(){
        return shotsFired;
    }

    public int getShotsMissed(){
        return shotsMissed;
    }

    public int getHeadShots(){
        return headShots;
    }
}
