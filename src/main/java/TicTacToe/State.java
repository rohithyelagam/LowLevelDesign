package TicTacToe;

public enum State {
    X("X"),
    O("O");

    private String field;

    State(String field){
        this.field = field;
    }

    public String getValue(){
        return field;
    }
}
