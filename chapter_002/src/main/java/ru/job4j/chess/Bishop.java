package ru.job4j.chess;

/**
 * Class Bishop.
 * @author Tatyana Fukova (mailto:tatyanafukova@gmail.com)
 * @since 17.11
 */
public class Bishop extends Figure {

    /**
     * constructor.
     * @param position **initial figure's position**
     */
    protected Bishop(Cell position) {
        super(position);
    }

    Cell[] path = new Cell[1];

    /**
     * Method of the bishop's movements.
     * @param dist destination cell.
     * @return array of the passed cells or an exception.
     */
    @Override
    Cell[] way(Cell dist) {
        if( Math.abs(position.x-dist.x) == Math.abs(position.y-dist.y) ){
            if(dist.x < position.x && dist.y < position.y){
                Cell[] path = new Cell[position.x - dist.x + 1];
                int indexOfArray = path.length - 1;
                int currentPositionX = position.x - 1;
                int currentPositionY = position.y - 1;
                for (int i = position.x; i >= dist.x ; i--) {
                    path[indexOfArray] = new Cell(currentPositionX, currentPositionY);
                    currentPositionX--;
                    currentPositionY--;
                    indexOfArray--;
                }
                return path;
            }
            if(dist.x > position.x && dist.y < position.y){
                Cell[] path = new Cell[dist.x - position.x + 1];
                int indexOfArray = path.length - 1;
                int currentPositionX = position.x + 1;
                int currentPositionY = position.y - 1;
                for (int i = position.x; i <=dist.x ; i++) {
                    path[indexOfArray] = new Cell(currentPositionX, currentPositionY);
                    currentPositionX++;
                    currentPositionY--;
                    indexOfArray--;
                }
                return path;
            }
            if(dist.x < position.x && dist.y > position.y){
                Cell[] path = new Cell[position.x - dist.x + 1];
                int indexOfArray = path.length - 1;
                int currentPositionX = position.x - 1;
                int currentPositionY = position.y + 1;
                for (int i = position.x; i >= dist.x ; i--) {
                    path[indexOfArray] = new Cell(currentPositionX, currentPositionY);
                    currentPositionX--;
                    currentPositionY++;
                    indexOfArray--;
                }
                return path;
            }
            if(dist.x > position.x && dist.y > position.y){
                Cell[] path = new Cell[dist.x - position.x + 1];
                int indexOfArray = path.length - 1;
                int currentPositionX = position.x + 1;
                int currentPositionY = position.y + 1;
                for (int i = position.x; i <= dist.x ; i++) {
                    path[indexOfArray] = new Cell(currentPositionX, currentPositionY);
                    currentPositionX++;
                    currentPositionY++;
                    indexOfArray--;
                }
                return path;
            }
        }else {
            throw new ImpossibleMoveException("Impossible move");
        }
       return path;
    }
}
