package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
    private ChessMatch chessMatch;
    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString() { return "P"; }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] possibleMoves = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        if (getColor() == Color.WHITE) {
            p.setValues(position.getRow() -1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                possibleMoves[p.getRow()][p.getColumn()] = true;
            }

            //first can move 2 forward
            p.setValues(position.getRow() - 2, position.getColumn());
            Position p2 = new Position(position.getRow() - 1, position.getColumn());
            if (    getBoard().positionExists(p)
                    && !getBoard().thereIsAPiece(p)
                    && getMoveCount() == 0
                    && !getBoard().thereIsAPiece(p2)
                    && getBoard().positionExists(p2)
            ) {
                possibleMoves[p.getRow()][p.getColumn()] = true;
            }

            //diagonais
            p.setValues(position.getRow() -1, position.getColumn() -1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                possibleMoves[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() -1, position.getColumn() +1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                possibleMoves[p.getRow()][p.getColumn()] = true;
            }

            //special move en passant
            if (position.getRow() == 3) {
                Position left = new Position(position.getRow() ,position.getColumn() - 1);
                if (getBoard().positionExists(left) && getBoard().thereIsAPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
                    possibleMoves[left.getRow() -1 ][left.getColumn()] = true;
                }

                Position right = new Position(position.getRow() ,position.getColumn() + 1);
                if (getBoard().positionExists(right) && getBoard().thereIsAPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
                    possibleMoves[right.getRow() -1 ][right.getColumn()] = true;
                }
            }
        } else {
            p.setValues(position.getRow() +1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                possibleMoves[p.getRow()][p.getColumn()] = true;
            }

            //first can move 2 forward
            p.setValues(position.getRow() + 2, position.getColumn());
            Position p2 = new Position(position.getRow() + 1, position.getColumn());
            if (    getBoard().positionExists(p)
                    && !getBoard().thereIsAPiece(p)
                    && getMoveCount() == 0
                    && !getBoard().thereIsAPiece(p2)
                    && getBoard().positionExists(p2)
            ) {
                possibleMoves[p.getRow()][p.getColumn()] = true;
            }

            //diagonais
            p.setValues(position.getRow() +1, position.getColumn() -1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                possibleMoves[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() +1, position.getColumn() +1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                possibleMoves[p.getRow()][p.getColumn()] = true;
            }

            //special move en passant
            if (position.getRow() == 4) {
                Position left = new Position(position.getRow() ,position.getColumn() - 1);
                if (getBoard().positionExists(left) && getBoard().thereIsAPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
                    possibleMoves[left.getRow() + 1 ][left.getColumn()] = true;
                }

                Position right = new Position(position.getRow() ,position.getColumn() + 1);
                if (getBoard().positionExists(right) && getBoard().thereIsAPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
                    possibleMoves[right.getRow() +1][right.getColumn()] = true;
                }
            }
        }
        return possibleMoves;
    }
}
