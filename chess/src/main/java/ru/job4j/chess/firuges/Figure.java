package ru.job4j.chess.firuges;

import ru.job4j.chess.ImpossibleMoveException;

import static java.lang.Math.abs;

public interface Figure {
    Cell position();

    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }

    Figure copy(Cell dest);

    default boolean isDiagonal(Cell source, Cell dest) {
        boolean rst = false;
        if (abs(dest.x - source.x) == abs(dest.y - source.y)) {
            rst = true;
        }
        return rst;
    }
}
