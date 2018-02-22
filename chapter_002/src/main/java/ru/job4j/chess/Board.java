package ru.job4j.chess;

/**
 * Class Board.
 * @author Tatyana Fukova (mailto:tatyanafukova@gmail.com)
 * @since 20.11
 */
public class Board {

     Figure[][] figures = new Figure[8][8];


     void initializeBoard() {
         for (int i = 0; i < this.figures.length; i++) {
             figures[i][i] = null;
         }
     }
     void addFigure(Figure figure) {
         this.figures[figure.position.x][figure.position.y] = figure;
     }

    /**
     * Method to check if the figure can move to the set position.
     * @param source initial cell
     * @param dist destination cell
     * @return result if the figure is able to move to the set position
     */
    boolean move(Cell source, Cell dist) {

        if (figures[source.x][source.y] == null) {

            throw new FigureNotFoundException("Figure is not found");
        }
        Cell[] pathFigure = figures[source.x][source.y].way(dist);
        for (int i = 1; i < pathFigure.length; i++) {
            if (figures[pathFigure[i].x][pathFigure[i].y] != null) {

                throw new OccupiedWayException("Occupied position.");
            }
        }

        figures[dist.x][dist.y] = figures[source.x][source.y];
        figures[source.x][source.y] = null;

        return true;
    }
}
