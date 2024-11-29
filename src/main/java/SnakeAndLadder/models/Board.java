package SnakeAndLadder.models;

import java.util.List;

public class Board {
    int capacity;
    List<Snake> snakeList;
    List<Ladder> ladderList;

    public Board(int cap){
        this.capacity = cap;
    }

    public void setSnakeList(List<Snake> ss){
        this.snakeList = ss;
    }
    public void setLadderList(List<Ladder> ll){
        this.ladderList = ll;
    }
    public List<Snake> getSnakeList(){return snakeList;}
    public List<Ladder> getLadderList(){return ladderList;}

}
