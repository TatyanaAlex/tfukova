package ru.job4j.chess;

/**
 * Class describing the chess' cell.
 * @author Tatyana Fukova (mailto:tatyanafukova@gmail.com)
  * @since 17.11
 */
public class Cell {

    public int x; //координаты ячейки
    public int y;

    /**
     * constructor.
     * @param x **horizontal cell's coordinate**
     * @param y ** vertical cell's coordinate**
     */
    public Cell (int x, int y){
        this.x = x;
        this.y = y;
    }

}
