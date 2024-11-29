package TicTacToe;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Game {
    private Board board;
    private Queue<Player> players;
    private Map<State, Player> playerMap;
    private boolean isGameOver;

    public Game(int x,int y){
        board = new Board(x,y);
        players = new LinkedList<>();
        isGameOver = false;
        playerMap = new HashMap<>();
        board.printBoard();
    }

    public void addPlayer(Player player){
        players.add(player);
        playerMap.put(player.getType(),player);
    }

    public void play(int x,int y){

        if(isGameOver)return;

        if(!board.validateMove(x,y)) {
            System.out.println("Invalid Move");
            return;
        }

        Player currPlayer = players.peek();

        board.setCell(x,y,currPlayer);
        currPlayer.setCount();
        board.printBoard();
        decideWinner();
        players.poll();
        players.add(currPlayer);

        if(isGameOver)return;

        for(Map.Entry<State, Player> p : playerMap.entrySet()){
            if(p.getValue().getCount() != p.getValue().getMaxCount()){
                return;
            }
            this.isGameOver = true;
            System.out.println("Game Over");
            break;
        }

    }


    private void decideWinner(){

        State state = board.checkRow();
        if(state!=null){
            printWinner(state);
            isGameOver = true;
            return;
        }

        state = board.checkColumn();
        if(state!=null){
            printWinner(state);
            isGameOver = true;
            return;
        }

        state = board.checkDiagonal();
        if(state!=null){
            printWinner(state);
            isGameOver = true;
        }


    }

    private void printWinner(State state){
        System.out.println(playerMap.get(state).getName()+" won the game");
    }
}
