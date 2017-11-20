package ru.job4j.chess;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {
    @Test
    public void WhenAddFigureThenReturnIt() {
        Board board = new Board();
        int x = 3;
        int y = 1;
        Cell source = new Cell(x,y);
        Figure bishop = new Bishop(source);
        board.addFigure(bishop);
        assertThat(board.figures[x][y], is(bishop));
    }
    @Test
    public void WhenThereIsNoFigureThenTrowException(){ //expect FigureNotFoundException
        Board board = new Board();
        int sourceX = 2;
        int sourceY = 2;
        Cell source = new Cell(sourceX,sourceY);
        Figure bishop = new Bishop(source);
        board.addFigure(bishop);
        int distX = 5;
        int distY = 5;
        Cell dist = new Cell(distX, distY);
        board.move(dist, dist);

    }
    @Test
    public void WhenGiveWrongDistThenThrowException(){ //expect ImpossibleMoveException
      Board board = new Board();
        int sourceX = 3;
        int sourceY = 1;
        Cell source = new Cell(sourceX,sourceY);
        Figure bishop = new Bishop(source);
        board.addFigure(bishop);
        int distX = 5;
        int distY = 5;
        Cell dist = new Cell(distX, distY);
        board.move(source, dist);
    }

    @Test
    public void WhenThereIsAnotherFigureOnWayThenThrowException(){ //expect OccupiedWayException
        Board board = new Board();
        int sourceX = 3;
        int sourceY = 1;
        Cell source = new Cell(sourceX,sourceY);
        Figure bishop = new Bishop(source);
        board.addFigure(bishop);

        int occupiedX = 4;
        int occupiedY = 2;
        Cell occupiedCell = new Cell(occupiedX,occupiedY);
        Figure occupiedFigure = new Bishop(occupiedCell);
        board.addFigure(occupiedFigure);

        int distX = 5;
        int distY = 3;
        Cell dist = new Cell(distX, distY);
        board.move(source, dist);
    }

    @Test
    public void WhenProvideDistThenMoveFigure(){
        Board board = new Board();
        int sourceX = 3;
        int sourceY = 1;
        Cell source = new Cell(sourceX,sourceY);
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
