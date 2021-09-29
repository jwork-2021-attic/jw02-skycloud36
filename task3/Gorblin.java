package task3;

import task3.Line.Position;

public class Gorblin extends Linable{
    private int r, g, b;
    private int rank;
    private String rankstring;

    public Gorblin(int r, int g, int b){
        this.r = r;
        this.g = g;
        this.b = b;
        // this.rank = r+g+b;
        // this.rankstring = String.format("%03d", r+g+b);
        this.rank = (r << 16) + (g << 8) + b;
        this.rankstring = String.format("%06x", rank);
    }

    public Gorblin(int color){
        this.r = (color & 0xff0000) >> 16;
        this.g = (color & 0x00ff00) >> 8;
        this.r = (color & 0x00ff);
        // this.rank = r+g+b;
        // this.rankstring = String.format("%03d", rank);
        this.rank = color;
        this.rankstring = String.format("%06x", rank);
        // this.rankstring = String.format("%03d", r+g+b);
    }

    // public int getRank(){
    //     return r << 16 + g << 8 + b;
    // }

    @Override
    public Position getPosition(){
        return getPosition();
    }

    @Override
    public void setPosition(Position position){
        this.position = position;
    }

    @Override
    public int getValue(){
        return rank;
    }
    
    public void swapPosition(Linable linable){
        Position temp = this.position;
        linable.position.setLinable(this);
        temp.setLinable(linable);
    }

    @Override
    public String toString() {
        return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m " + rankstring + " \033[0m";
    }
}
