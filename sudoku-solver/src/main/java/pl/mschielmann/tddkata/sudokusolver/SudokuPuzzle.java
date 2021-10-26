package pl.mschielmann.tddkata.sudokusolver;

class SudokuPuzzle
{
    private final int dimension;
    private final String input;

    public SudokuPuzzle(int dimension, String input)
    {
        this.dimension = dimension;
        this.input = input;
    }

    boolean isSolved()
    {
        return input.equals("1");
    }


    String display()
    {
        return input;
    }
}
