package TicTacToe;

public class Player {
    private State type;
    private String name;
    private Long count;
    private Long maxCount;

    public Player(State type, String name,Long maxCount){
        this.type = type;
        this.name = name;
        this.maxCount = maxCount;
        this.count = 0L;
    }

    public State getType() {
        return type;
    }

    public Long getCount(){
        return this.count;
    }

    public Long getMaxCount(){
        return this.maxCount;
    }

    public void setCount(){
        this.count++;
    }

    public String getName() {
        return name;
    }
}
