package rocks.zipcodewilmington.tictactoe;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    Character[][] matrix;

    public Board(Character[][] matrix) {
        this.matrix = matrix;

    }

    public Boolean isInFavorOfX() {
        return commonMethod('X');
    }

    public Boolean isInFavorOfO() {
        return commonMethod('O');
    }

    public Boolean isTie() {
        boolean x = isInFavorOfX();
        boolean o = isInFavorOfO();
        if (x == false && o == false) {
            return true;
        }

        return false;
    }

    public String getWinner() {
        boolean x = isInFavorOfX();
        boolean o = isInFavorOfO();
        if (x == true) {
            return "X";
        } else if (o == true) {
            return "O";
        }

        return "";
    }

    public boolean commonMethod(char ch) {
        int row = 0;
        int column = 0;
        int diagonalTopBottom = 0;
        int diagonalBottomTop = 0;

        for (int i = 0; i < matrix.length; i++) {
            row = 0;
            column = 0;
            //check for rows
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == ch) {
                    row++;
                    if (row == 3) {
                        return true;
                    }
                }
            }

            for (int l = 0; l < matrix[i].length; l++) {
                if (matrix[l][i] == ch) {
                    column++;
                    if (column == 3) {
                        return true;
                    }
                }
            }

            if (matrix[i][i] == ch) {
                diagonalTopBottom++;
                if (diagonalTopBottom == 3) {
                    return true;
                }
            }

            if (matrix[2 - i][i] == ch) {
                diagonalBottomTop++;
                if (diagonalBottomTop == 3) {
                    return true;
                }
            }

//            if(matrix[2][0]=='X'&&matrix[1][1]=='X'&&matrix[0][2]=='X'){
//                return true;
//            }

        }//outer loop

        return false;
    }
}


