/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess.pieces;

import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import boardgame.Board;
import chess.Color;

/**
 *
 * @author guilherme
 */
public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override 
    public String toString() {
        return "K";
    }

    private boolean testRoookCastling(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] possibleMoves = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        //above
        p.setValues(position.getRow() -1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)) {
            possibleMoves[p.getRow()][p.getColumn()] = true;
        }

        //below
        p.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)) {
            possibleMoves[p.getRow()][p.getColumn()] = true;
        }

        //left
        p.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            possibleMoves[p.getRow()][p.getColumn()] = true;
        }

        //right
        p.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            possibleMoves[p.getRow()][p.getColumn()] = true;
        }

        //nw
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            possibleMoves[p.getRow()][p.getColumn()] = true;
        }

        //ne
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            possibleMoves[p.getRow()][p.getColumn()] = true;
        }

        //sw
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            possibleMoves[p.getRow()][p.getColumn()] = true;
        }

        //se
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            possibleMoves[p.getRow()][p.getColumn()] = true;
        }

        //special move castling
        if (getMoveCount() == 0 && !chessMatch.getCheck()) {
            //catling kingside rook
            Position posT1 = new Position(position.getRow(), position.getColumn() + 3);
            if (testRoookCastling(posT1)) {
                Position p1 = new Position(position.getRow(), position.getColumn() + 2);
                Position p2 = new Position(position.getRow(), position.getColumn() + 1);

                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
                    possibleMoves[position.getRow()][position.getColumn() + 2] = true;
                }
            }

            //castling queenside rook
            Position posT2 = new Position(position.getRow(), position.getColumn() - 4);
            if (testRoookCastling(posT2)) {
                Position p1 = new Position(position.getRow(), position.getColumn() - 3);
                Position p2 = new Position(position.getRow(), position.getColumn() -2 );
                Position p3 = new Position(position.getRow(), position.getColumn() -1 );


                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
                    possibleMoves[position.getRow()][position.getColumn() - 2] = true;
                }
            }
        }


        return possibleMoves;
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

}
