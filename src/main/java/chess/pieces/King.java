/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess.pieces;

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
}
