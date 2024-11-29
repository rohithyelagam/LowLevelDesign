package TicTacToe;

public class Board {
    private Cell[][] cells;
    private final int x;
    private final int y;

    public Board(int x,int y){
        this.x = x;
        this.y = y;
        cells = new Cell[x][y];
    }

    public void printBoard(){
        for(int i=0;i<x;i++){
            for (int j = 0; j < y; j++) {
                Cell curr = cells[i][j];
                System.out.print(((curr==null)?"-":curr.getType().getValue())+" ");
            }
            System.out.println();
        }
    }

    public void setCell(int x,int y,Player player){
        State state = player.getType();
        this.cells[x][y] = new Cell(state);
    }

    public boolean validateMove(int x,int y){
        return cells[x][y] == null;
    }

    public State checkRow(){
        for(int row=0;row<x;row++){
            if(cells[row][0]==null)continue;
            boolean desc = true;
            for(int col=1;col<y;col++){
                if(cells[row][col]==null || cells[row][col].getType()!=cells[row][0].getType()){
                    desc = false;
                    break;
                }
            }
            if(desc){
                return cells[row][0].getType();
            }
        }
        return null;
    }

    public State checkColumn(){
        for(int col=0;col<y;col++){
            if(cells[0][col]==null)continue;
            boolean desc = true;
            for(int row=1;row<x;row++){
                if(cells[row][col]==null || cells[row][col].getType()!=cells[0][col].getType()){
                    desc = false;
                    break;
                }
            }
            if(desc){
                return cells[0][col].getType();
            }
        }
        return null;
    }

    public State checkDiagonal(){

        if(cells[0][0]!=null){
            int row = 1;
            int col = 1;
            boolean desc = true;
            while(row<x && col<y){
                if(cells[row][col]==null || cells[row][col].getType() != cells[0][0].getType()){
                    desc = false;
                    break;
                }
                row++;
                col++;
            }
            if(desc)return cells[0][0].getType();
        }

        if(cells[0][y-1]!=null){
            int row = 1;
            int col = y-2;
            boolean desc = true;
            while(row<x && col>=0){
                if(cells[row][col]==null || cells[row][col].getType() != cells[0][y-1].getType()){
                    desc = false;
                    break;
                }
                row++;
                col--;
            }
            if(desc)return cells[0][y-1].getType();
        }
        return null;
    }


}

