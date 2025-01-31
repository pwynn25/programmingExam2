package chess;

import java.util.ArrayList;
import java.util.Collection;

public class KingMoveCalculator extends PieceMovesCalculator{
    public Collection<ChessMove> pieceMoves(ChessBoard chessBoard, ChessPosition position) {
        Collection <ChessMove> possibleKingMoves = new ArrayList<>();

        int [] directionsColumn = {0,0,1,-1, 1,1,-1,-1};
        int [] directionsRow = {1,-1,0,0, 1,-1,1,-1};

        int potMoveColumn;
        int potMoveRow;
        for(int i = 0; i < directionsColumn.length; i ++) {
            potMoveColumn = position.getColumn() + directionsColumn[i];
            potMoveRow = position.getRow() + directionsRow[i];
            if(isInRange(potMoveColumn) && isInRange(potMoveRow)) {
                ChessPosition potPosition = new ChessPosition(potMoveRow,potMoveColumn);
                if(isEmpty(chessBoard,potPosition)) {
                    ChessMove move = new ChessMove(position,potPosition,null);
                    possibleKingMoves.add(move);
                }
                else if(isEnemyOccupied(chessBoard,position,potPosition)) {
                    ChessMove move = new ChessMove(position,potPosition,null);
                    possibleKingMoves.add(move);
                }
            }
        }

        return possibleKingMoves;


    }
}
