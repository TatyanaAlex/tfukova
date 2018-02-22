package ru.job4j.chess;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {
    @Test
    public void whenAddFigureThenReturnIt() {
        Board board = new Board();
        int x = 3;
        int y = 1;
        Cell source = new Cell(x, y);
        Figure bishop = new Bishop(source);
        board.addFigure(bishop);
        assertThat(board.figures[x][y], is(bishop));
    }
    @Test
    public void whenThereIsNoFigureThenTrowException() { //expect FigureNotFoundException
        try {
            Board board = new Board();
            int sourceX = 2;
            int sourceY = 2;
            Cell source = new Cell(sourceX, sourceY);
            Figure bishop = new Bishop(source);
            board.addFigure(bishop);
            int distX = 5;
            int distY = 5;
            Cell dist = new Cell(distX, distY);
            board.move(dist, dist);
            Assert.fail("Failed! This method has to trow FigureNotFoundException.");
        } catch (FigureNotFoundException fnfe) {
            //expected
        }
    }
    @Test
    public void whenGiveWrongDistThenThrowException() { //expect ImpossibleMoveException
      try {
        Board board = new Board();
        int sourceX = 3;
        int sourceY = 1;
        Cell source = new Cell(sourceX, sourceY);
        Figure bishop = new Bishop(source);
        board.addFigure(bishop);
        int distX = 5;
        int distY = 5;
        Cell dist = new Cell(distX, distY);
        board.move(source, dist);
        Assert.fail("Failed! This method has to trow ImpossibleMoveException.");
      } catch (ImpossibleMoveException ime) {

      }

    }

    @Test
    public void whenThereIsAnotherFigureOnWayThenThrowException() { //expect OccupiedWayException
        try {
            Board board = new Board();
            int sourceX = 3;
            int sourceY = 1;
            Cell source = new Cell(sourceX, sourceY);
            Figure bishop = new Bishop(source);
            board.addFigure(bishop);

            int occupiedX = 4;
            int occupiedY = 2;
            Cell occupiedCell = new Cell(occupiedX, occupiedY);
            Figure occupiedFigure = new Bishop(occupiedCell);
            board.addFigure(occupiedFigure);

            int distX = 5;
            int distY = 3;
            Cell dist = new Cell(distX, distY);
            board.move(source, dist);
            Assert.fail("Failed! This method has to trow OccupiedWayException.");
        } catch (OccupiedWayException owe) {
            //expected
        }
    }

    @Test
    public void whenProvideDistThenMoveFigure() {
        Board board = new Board();
        int sourceX = 3;
        int sourceY = 1;
        Cell source = new Cell(sourceX, sourceY);
        Figure bishop = new Bishop(source);
        board.addFigure(bishop);
        int distX = 5;
        int distY = 3;
        Cell dist = new Cell(distX, distY);
        board.move(source, dist);
        assertThat(board.figures[distX][distY], is(bishop));
        assertTrue(board.figures[sourceX][sourceY] == null);
    }

}
