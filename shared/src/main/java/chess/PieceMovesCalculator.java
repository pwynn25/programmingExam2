package chess;

import java.util.ArrayList;
import java.util.Collection;

public abstract class PieceMovesCalculator {
    public Collection<ChessMove> pieceMoves(ChessBoard chessBoard, ChessPosition position) {
        return null;
    }

    // is Empty
    public boolean isEmpty(ChessBoard chessBoard,ChessPosition position) {
        return chessBoard.getPiece(position) == null;
    }

    //isInRange
    public boolean isInRange(int i) {
        return i <= 8 && i > 0;
    }

    //isEnemyOccupied
    public boolean isEnemyOccupied(ChessBoard chessBoard,ChessPosition position,ChessPosition potPosition) {
        return chessBoard.getPiece(position).getTeamColor() != chessBoard.getPiece(potPosition).getTeamColor();
    }
    //calculateOrthogonalMoves
    public Collection calculateOrthogonalMoves(ChessBoard chessBoard,ChessPosition position) {
        Collection <ChessMove> possibleOrthogonalMoves = new ArrayList<>();

        int [] directionsColumn = {0,0,1,-1};
        int [] directionsRow = {1,-1,0,0};

        int potMoveColumn;
        int potMoveRow;
        for(int i = 0; i < directionsColumn.length; i ++) {
            potMoveColumn = position.getColumn() + directionsColumn[i];
            potMoveRow = position.getRow() + directionsRow[i];
            while(isInRange(potMoveColumn) && isInRange(potMoveRow)) {
                ChessPosition potPosition = new ChessPosition(potMoveRow,potMoveColumn);
                if(isEmpty(chessBoard,potPosition)) {
                    ChessMove move = new ChessMove(position,potPosition,null);
                    possibleOrthogonalMoves.add(move);
                }
                else if(isEnemyOccupied(chessBoard,position,potPosition)) {
                    ChessMove move = new ChessMove(position,potPosition,null);
                    possibleOrthogonalMoves.add(move);
                    break;
                }
                else {
                    break;
                }
                potMoveColumn += directionsColumn[i];
                potMoveRow += directionsRow[i];
            }
        }

        return possibleOrthogonalMoves;
    }
    //calculateDiagonalMoves
    public Collection calculateDiagonalMoves(ChessBoard chessBoard,ChessPosition position) {
        Collection <ChessMove> possibleDiagonalMoves = new ArrayList<>();

        int [] directionsColumn = {1,1,-1,-1};
        int [] directionsRow = {1,-1,1,-1};

        int potMoveColumn;
        int potMoveRow;
        for(int i = 0; i < directionsColumn.length; i ++) {
            potMoveColumn = position.getColumn() + directionsColumn[i];
            potMoveRow = position.getRow() + directionsRow[i];
            while(isInRange(potMoveColumn) && isInRange(potMoveRow)) {
                ChessPosition potPosition = new ChessPosition(potMoveRow,potMoveColumn);
                if(isEmpty(chessBoard,potPosition)) {
                    ChessMove move = new ChessMove(position,potPosition,null);
                    possibleDiagonalMoves.add(move);
                }
                else if(isEnemyOccupied(chessBoard,position,potPosition)) {
                    ChessMove move = new ChessMove(position,potPosition,null);
                    possibleDiagonalMoves.add(move);
                    break;
                }
                else {
                    break;
                }
                potMoveColumn += directionsColumn[i];
                potMoveRow += directionsRow[i];
            }
        }



        return possibleDiagonalMoves;
    }
}
