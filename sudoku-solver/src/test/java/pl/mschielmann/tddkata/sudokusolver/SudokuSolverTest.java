package pl.mschielmann.tddkata.sudokusolver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SudokuSolverTest
{
    @Test
    public void given_solved_1_dimension_puzzle_displays_the_result()
    {
        String input = "1";
        SudokuPuzzle puzzle = new SudokuPuzzle(1, input);

        assertTrue(puzzle.isSolved());
        assertEquals("1", puzzle.display());
    }

}
