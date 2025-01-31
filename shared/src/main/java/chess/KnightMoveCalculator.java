package chess;

import java.util.ArrayList;
import java.util.Collection;

public class KnightMoveCalculator extends PieceMovesCalculator{
    public Collection<ChessMove> pieceMoves(ChessBoard chessBoard, ChessPosition position) {
        Collection <ChessMove> possibleKnightMoves = new ArrayList<>();

        int [] directionsColumn = {2,2,-1,1, -2,-2,1,-1};
        int [] directionsRow = {1,-1,2,2, 1,-1,-2,-2};

        int potMoveColumn;
        int potMoveRow;
        for(int i = 0; i < directionsColumn.length; i ++) {
            potMoveColumn = position.getColumn() + directionsColumn[i];
            potMoveRow = position.getRow() + directionsRow[i];
            if(isInRange(potMoveColumn) && isInRange(potMoveRow)) {
                ChessPosition potPosition = new ChessPosition(potMoveRow,potMoveColumn);
                if(isEmpty(chessBoard,potPosition)) {
                    ChessMove move = new ChessMove(position,potPosition,null);
                    possibleKnightMoves.add(move);
                }
                else if(isEnemyOccupied(chessBoard,position,potPosition)) {
                    ChessMove move = new ChessMove(position,potPosition,null);
                    possibleKnightMoves.add(move);
                }
            }
        }

        return possibleKnightMoves;

    }
}
