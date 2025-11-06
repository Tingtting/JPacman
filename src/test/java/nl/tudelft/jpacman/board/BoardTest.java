package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Test creating a valid board.
 */
class BoardTest {

    /**
     * A valid 1x1 board should return the BasicSquare
     * and not throw any assertion errors.
     */
    @Test
    void validBoard() {
        final Square[][] grid = {
            { new BasicSquare() }
        };

        final Board board = new Board(grid);

        assertThat(board.squareAt(0, 0)).isInstanceOf(BasicSquare.class);
    }

    @Test
    void boardWithNullSquare() {
        final Square[][] grid = {
            { null }
        };

        // Creating the board should throw an AssertionError because invariant() fails
        try {
            new Board(grid);
        } catch (AssertionError e) {
            return; // Test passes
        }
        throw new AssertionError("Expected AssertionError for null square board");
    }

}
