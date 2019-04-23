package ru.job4j.chess.firuges.base;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static java.lang.Math.abs;

public abstract class Bishop implements Figure {
    private final Cell position;

    public Bishop(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (!isDiagonal(source, dest)) {
            throw new ImpossibleMoveException("Фигура Bishop так не может ходить.");
        }
        Cell[] steps = new Cell[abs(source.x - dest.x)];
        int deltaX = ((dest.x - source.x) > 0) ? 1 : -1;
        int deltaY = ((dest.y - source.y) > 0) ? 1 : -1;
        for (int i = 1; i <= steps.length; i++) {
            steps[i - 1] = Cell.values()[8 * (source.x + deltaX * i) + (source.y + deltaY * i)];
        }
        return steps;
    }
}
