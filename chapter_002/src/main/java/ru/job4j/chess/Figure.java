package ru.job4j.chess;

/**
 * Abstract Class Figure.
 * @author Tatyana Fukova (mailto:tatyanafukova@gmail.com)
 * @since 17.11
 */
public abstract class Figure {

    final Cell position;

    /**
     * constructor.
     * @param position **initial figure's position**
     */
    protected Figure(Cell position) {
        this.position = position;
    }

    /**
     * Method for the figures' movements.
     * @param dist destination cell.
     * @return array of the passed cells or an exception.
     */
    abstract Cell[] way(Cell dist);
}
