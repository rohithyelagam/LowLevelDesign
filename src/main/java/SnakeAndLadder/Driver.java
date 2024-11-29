package SnakeAndLadder;

import SnakeAndLadder.models.Ladder;
import SnakeAndLadder.models.Player;
import SnakeAndLadder.models.Snake;
import SnakeAndLadder.services.Game;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args){

            List<Snake> snakeList = new ArrayList<>();
            List<Ladder> ladderList = new ArrayList<>();
            List<Player> playerList = new ArrayList<>();

            Scanner sc = new Scanner(System.in);

            int snakes = sc.nextInt();
            for(int i=0;i<snakes;i++)
                snakeList.add(new Snake(sc.nextInt(), sc.nextInt()));

            int ladders = sc.nextInt();
            for(int i=0;i<ladders;i++)ladderList.add(new Ladder(sc.nextInt(), sc.nextInt()));

            int players = sc.nextInt();
            for(int i=0;i<players;i++)playerList.add(new Player(sc.next()));

            Game game = new Game(1,6, 100);

            game.addSnake(snakeList);
            game.addLadder(ladderList);
            game.addPlayer(playerList);

            game.start();
    }

}
