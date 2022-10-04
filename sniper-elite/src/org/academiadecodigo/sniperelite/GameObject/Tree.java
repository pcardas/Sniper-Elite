package org.academiadecodigo.sniperelite.GameObject;

public class Tree extends GameObject {
    // Properties
    private String msg;

    public Tree(){
        getMessage();
    }

    //Methods
    @Override
    public String getMessage(){
        String msg = "ÁÁÁÁÁÁÁ ÁRVORE!! DONT'T SHOOT ME 🥵";
        return msg;
    }
}
