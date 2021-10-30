package pl.mschielmann.tddkata.sudokusolver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

    @Test
    public void given_1_dimension_puzzle_with_empty_input_displays_empty_puzzle()
    {
        String input = " ";
        SudokuPuzzle puzzle = new SudokuPuzzle(1, input);

        assertFalse(puzzle.isSolved());
        assertEquals(" ", puzzle.display());
    }

    @Test
    public void given_1_dimension_puzzle_with_empty_input_can_solve_it()
    {
        String input = " ";
        SudokuPuzzle puzzle = new SudokuPuzzle(1, input);

        puzzle.solve();

        assertTrue(puzzle.isSolved());
        assertEquals("1", puzzle.display());
    }
}
