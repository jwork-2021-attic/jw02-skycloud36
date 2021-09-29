package task3;

public class Matrix {
    private int row, col;
    private Line line;

    public Matrix(int row, int col){
        this.row = row;
        this.col = col;
        line = new Line(row*col);
    }

    
    public void put(Linable linable, int r, int c){
        line.put(linable, r * col + c);
    }

    public void put(Linable linable, int loc){
        line.put(linable, loc);
    }

    public Linable get(int loc){
        return line.get(loc);
    }
    
    @Override
    public String toString() {
        String matrixString = "";
        for(int i = 0; i < row; i++){
            matrixString+=line.arrByRange(i*row, i*row+col);
            matrixString+="\n";
        }
        return matrixString;
    }

    public Linable[] toArray() {
        return line.toArray();

    }
}
