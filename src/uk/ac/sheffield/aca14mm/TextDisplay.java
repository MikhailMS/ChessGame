package uk.ac.sheffield.aca14mm;
/*
Author - Mikhail Molotkov.
Last update - 01/04/2015.
*/
/*
    TextDisplay class implements a Display interface to output a board.
    Consists of two methods :
        implemented from interface showPieceOnBoard() - display all pieces of players on board.
        intToChar - converts integer value to char to make displayed board more readable. 
*/
public class TextDisplay implements Display {

    @Override
    public void showPiecesOnBoard(Piece[][] data) {
        for (int i=-1;i<data.length+1;++i) {
            if(i==-1|i==8){
                System.out.print("  |");   
            }
            else
                System.out.print(this.intToChar(i+1)+"| ");               
            for (int j=0;j<data.length;++j){
                if (i==-1)
                    System.out.print((j+1)+"|");
                else if(i==8)
                    System.out.print((j+1)+"|");
                else if(data[i][j]==null)
                    System.out.print(". ");
                else
                    System.out.print(data[i][j].toString()+" "); 
            }
            if(i==-1|i==8){
                System.out.print("");   
            }
            else
                System.out.print("|"+this.intToChar(i+1));
            System.out.println("");
        }
    }
    
    //converts numbers to letters to make text display look more like real game board.
    public char intToChar(int num) {
        switch(num){
            case 1:
                return 'A';
            case 2:
                return 'B';
            case 3:
                return 'C';
            case 4:
                return 'D';
            case 5:
                return 'E';
            case 6:
                return 'F';
            case 7:
                return 'G';
            case 8:
                return 'H';
            default:
                return 'e';
        }
    }
    
}