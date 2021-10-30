package pl.mschielmann.tddkata.sudokusolver;

import java.util.ArrayList;
import java.util.stream.IntStream;

class SudokuPuzzle
{
    private final int dimension;
    private final String input;

    private final int[][] board;

    public SudokuPuzzle(int dimension, String input)
    {
        this.dimension = dimension;
        this.input = input;
        board = new int[dimension][dimension];
        createBoardFromInput(input);
    }

    boolean isSolved()
    {
        for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < board[rowIndex].length; columnIndex++) {
                if (board[rowIndex][columnIndex] == 0) {
                    return false;
                }
            }
        }
        return true;
    }


    String display()
    {
        String result = "";
        for (int[] columnsInOneRow : board)
        {
            for (int field : columnsInOneRow)
            {
                if (field == 0)
                {
                    result += " ";
                }
                else
                {
                    result += field;
                }
            }
        }
        return result;
    }

    void solve()
    {
        for (int columnIndex = 0; columnIndex < dimension; columnIndex++) {
            ArrayList<Integer> numbersInColumn = new ArrayList();
            for (int rowIndex = 0; rowIndex < dimension; rowIndex++)
            {
                if (board[rowIndex][columnIndex] != 0)
                {
                    numbersInColumn.add(board[rowIndex][columnIndex]);
                }
            }
            if (numbersInColumn.size() == dimension - 1) {
                for (int rowIndex = 0; rowIndex < dimension; rowIndex++)
                {
                    if (board[rowIndex][columnIndex] == 0)
                    {
                        board[rowIndex][columnIndex] = IntStream.range(1, dimension + 1).filter(possibleValue -> !numbersInColumn.contains(possibleValue)).findFirst().getAsInt();
                    }
                }
            }
        }
    }

    private void createBoardFromInput(String input)
    {
        String[] rows = input.split("\r\n");
        for (int rowIndex = 0; rowIndex < rows.length; rowIndex++)
        {
            String[] columns = rows[rowIndex].split(",");
            for (int columnIndex = 0; columnIndex < columns.length; columnIndex++)
            {
                if (!columns[columnIndex].equals(" "))
                {
                    board[rowIndex][columnIndex] = Integer.parseInt(columns[columnIndex]);
                }
            }
        }
    }
}
