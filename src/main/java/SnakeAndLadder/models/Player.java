package SnakeAndLadder.models;

import java.util.UUID;

public class Player {
    public String name;
    public String id;
    public int currPos;
    public Player(String name){
        this.name = name;
        this.currPos =0;
        this.id = UUID.randomUUID().toString();
    }
}
