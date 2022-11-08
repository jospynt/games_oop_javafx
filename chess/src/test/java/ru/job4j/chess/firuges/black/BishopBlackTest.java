package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {

    @Test
    public void whenPosition() {
        Figure bishop = new BishopBlack(Cell.A1);
        assertThat(bishop.position()).isEqualTo(Cell.A1);
    }

    @Test
    public void whenCopy() {
        Figure bishop = new BishopBlack(Cell.A1);
        Figure copiedBishop = bishop.copy(Cell.A7);
        assertThat(copiedBishop.position()).isEqualTo(Cell.A7);
    }

    @Test
    public void whenWay() {
        Figure bishop = new BishopBlack(Cell.C1);
        Cell[] expectedWay = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] way = bishop.way(Cell.G5);
        assertThat(way).containsExactly(expectedWay);
    }

    @Test
    public void whenNoWay() {
        Figure bishop = new BishopBlack(Cell.C1);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    bishop.way(Cell.G4);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from C1 to G4");
    }
}