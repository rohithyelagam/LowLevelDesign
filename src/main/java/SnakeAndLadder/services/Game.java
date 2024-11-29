package SnakeAndLadder.services;

import SnakeAndLadder.models.Board;
import SnakeAndLadder.models.Ladder;
import SnakeAndLadder.models.Player;
import SnakeAndLadder.models.Snake;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Game {

    Random random;
    int lowDice;
    int highDice;
    int capacity;
    Board board;
    Queue<Player> players;
    public boolean gameCompleted;

    public Game(int lowDice, int highDice, int capacity){
        random = new Random();
        this.lowDice = lowDice;
        this.highDice = highDice;
        this.capacity = capacity;
        board = new Board(capacity);
    }

    public void addSnake(List<Snake> snakeList){
        board.setSnakeList(snakeList);
    }

    public void addLadder(List<Ladder> ladderList){
        board.setLadderList(ladderList);
    }

    public void addPlayer(List<Player> playerList){
        this.players = new LinkedList<>();
        this.players.addAll(playerList);
    }

    public int rollDice(){
        return random.nextInt(highDice-lowDice+1)+lowDice;
    }

    public void makeTurn(Player p){
        int mov = 1000000000;
        boolean moveDone = false;
        int prevPos = p.currPos;

        while(p.currPos + mov > 100){
            mov = this.rollDice();
        }
        p.currPos += mov;

        while(!moveDone){
            boolean snakeBit = false;
            boolean ladderTaken = false;
            for(Snake s: board.getSnakeList()){
                if(s.head == p.currPos){
                    p.currPos = s.tail;
                    snakeBit = true;
                    break;
                }
            }

            for(Ladder l: board.getLadderList()){
                if(l.lowerEnd == p.currPos){
                    p.currPos = l.upperEnd;
                    ladderTaken = true;
                    break;
                }
            }
            if(!snakeBit || !ladderTaken)moveDone = true;
        }

        System.out.println(p.name+" rolled a "+mov+" and moved from "+prevPos+" to "+p.currPos);

        if(p.currPos == capacity){
            System.out.println(p.name+" wins the game");
            this.gameCompleted = true;
        }

    }

    public void start(){
        while(!this.gameCompleted){
            Player p = players.poll();
            makeTurn(p);
            players.add(p);
        }
    }

}
