package TicTacToe;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        sc.next();
        Player px = new Player(State.X, sc.nextLine().trim(), 5L);

        sc.next();
        Player po = new Player(State.O, sc.nextLine().trim(), 4L);

        Game game = new Game(3,3);

        game.addPlayer(px);
        game.addPlayer(po);

        String s = sc.nextLine().trim();
        while(!s.equals("exit")){
            String[] input = s.split(" ");
            game.play(Integer.parseInt(input[0])-1, Integer.parseInt(input[1])-1);
            s = sc.nextLine();
        }

    }
}
