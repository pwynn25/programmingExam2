package chess;

import java.util.ArrayList;
import java.util.Collection;

public class QueenMoveCalculator extends PieceMovesCalculator{
    public Collection <ChessMove> pieceMoves(ChessBoard chessBoard,ChessPosition position) {
        Collection<ChessMove> possibleQueenMoves = new ArrayList<>();

        possibleQueenMoves.addAll(calculateOrthogonalMoves(chessBoard,position));
        possibleQueenMoves.addAll(calculateDiagonalMoves(chessBoard,position));

        return possibleQueenMoves;

    }
}
