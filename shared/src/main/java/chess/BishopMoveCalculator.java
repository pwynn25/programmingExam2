package chess;

import java.util.Collection;

public class BishopMoveCalculator extends PieceMovesCalculator{
    public Collection<ChessMove> pieceMoves(ChessBoard chessBoard, ChessPosition position) {


        return calculateDiagonalMoves(chessBoard,position);
    }
}
