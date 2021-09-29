package task3;

import task3.Line.Position;

abstract class Linable {

    protected Position position;

    abstract void setPosition(Position position);

    abstract Position getPosition();

    abstract int getValue();

    abstract void swapPosition(Linable lineable);

}
