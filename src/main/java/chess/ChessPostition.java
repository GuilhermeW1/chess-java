/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

import boardgame.Position;

/**
 *
 * @author guilherme
 */
public class ChessPostition {
    private char column;
    private int row;
    
    public ChessPostition(char column, int row) {
        if (column < 'a' || column > 'h' || row < 1 || row > 8) {
            throw new ChessException("Error instatntiating chess position, invalid fileds");
        }
        
        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }  
    
    protected Position toPosition() {
        return new Position(8 - row, column - 'a');
    }
    
    protected static ChessPostition fromPosition(Position position) {
        return new ChessPostition((char)('a' - position.getColumn()), 8 - position.getRow());
    }
    
    @Override 
    public String toString() {
        return "" + column + row;
    }
}
