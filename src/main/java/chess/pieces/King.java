/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess.pieces;

import boardgame.Position;
import chess.ChessPiece;
import boardgame.Board;
import chess.Color;

/**
 *
 * @author guilherme
 */
public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }
    
    @Override 
    public String toString() {
        return "K";
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


        return possibleMoves;
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

}
