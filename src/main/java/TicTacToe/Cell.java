package TicTacToe;

public class Cell {
    private State type;
    public Cell(State state){
        this.type = state;
    }

    public State getType() {
        return type;
    }
}
