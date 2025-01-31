package chess;


import java.util.Collection;

public class RookMoveCalculator extends PieceMovesCalculator{
    public Collection<ChessMove> pieceMoves(ChessBoard chessBoard, ChessPosition position) {


        return calculateOrthogonalMoves(chessBoard,position);
    }

}
