package org.academiadecodigo.sniperelite;

import org.academiadecodigo.sniperelite.GameObject.Barrel;
import org.academiadecodigo.sniperelite.GameObject.Enemy.ArmouredEnemy;
import org.academiadecodigo.sniperelite.GameObject.Enemy.SoldierEnemy;
import org.academiadecodigo.sniperelite.GameObject.GameObject;
import org.academiadecodigo.sniperelite.GameObject.Tree;

public class Game {
    // Properties
    private GameObject[] gameObjects;
    private SniperRifle sniperRifle;

    // Methods
    public void start(int objectsNumber){
        // Spawning the beautiful Lorraine AKA Open Season Hunter
        int sniperRifleDamage = (int) (Math.random() * (70 - 60 + 1)) + 60;
        sniperRifle = new SniperRifle(sniperRifleDamage);

        // Creates game objects
        createGameObjects(objectsNumber);

        // Starts the action scene
        System.out.println("");
        System.out.println("--- LET'S BEGIN THE GAME ---");
        System.out.println("");
        startTheShooting();
    }

    private GameObject[] createGameObjects(int objectsNumber) {
        // Always have more than 7 objects
        if(objectsNumber < 7){
            objectsNumber = 7;
        }

        // Object probability to create a new object
        gameObjects = new GameObject[objectsNumber];
        int numberOfTrees = (int) Math.ceil(objectsNumber * 0.1);
        int numberOfBarrels = (int) Math.ceil(objectsNumber * 0.1);
        int numberOfSoldierEnemies = (int) Math.floor(objectsNumber * 0.5);

        // Looping over the gameObject array and creating new objects
        for (int i = 0; i < objectsNumber; i++) {
            if(i < numberOfTrees){
                gameObjects[i] = new Tree();
            } else if(i < numberOfBarrels + numberOfTrees){
                gameObjects[i] = new Barrel();
            } else if(i < numberOfBarrels + numberOfTrees + numberOfSoldierEnemies){
                gameObjects[i] = new SoldierEnemy();
            } else {
                gameObjects[i] = new ArmouredEnemy();
            }
        }

        // Returning the objects array
        return gameObjects;
    }


    private void startTheShooting(){
        // Looping over the gameObjects array
        for (int i = 0; i < gameObjects.length; i++) {
            // Checking if the object is from a Destroyable instance
            if(gameObjects[i] instanceof  Destroyable){
                // While objects are not destroyed, shoot again
                while(!((Destroyable) gameObjects[i]).isDestroyed()){
                    sniperRifle.shoot((Destroyable) gameObjects[i]);
                }
            } else {
                System.out.println(gameObjects[i].getMessage());
            }
        }
        // Logging shots report
        System.out.println("");
        System.out.println("--- BATTLE REPORT ---");
        System.out.println("Shots fired: " + sniperRifle.getShotsFired());
        System.out.println("Shots hit: " + (sniperRifle.getShotsFired() - sniperRifle.getHeadShots() - sniperRifle.getShotsMissed()));
        System.out.println("Headshots: " + sniperRifle.getHeadShots());
        System.out.println("Shots missed: " + sniperRifle.getShotsMissed());
        System.out.println("");
        System.out.println("--- THANK YOU FOR PLAYING! ---");
    }
}
