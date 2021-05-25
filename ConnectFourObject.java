

/**
 * Write a description of class ConnectFourObject here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ConnectFourObject
{
    int[][] myArray =  { {0,0,0,0,0,0,0},
                         {0,0,0,0,0,0,0},
                         {0,0,0,0,0,0,0},
                         {0,0,0,0,0,0,0},
                         {0,0,0,0,0,0,0},
                         {0,0,0,0,0,0,0},
                       };
    int rowSize = 6;
    int columnSize = 7;
    
    public int PlaceACoin(int column, int playerNumber) {
        int rowNumber = 0;
        for (int row = rowSize - 1 ; row >= 0; row--){
            int myInt = myArray[row][column];
            if (myInt == 0) {
                myArray[row][column] = playerNumber;
                rowNumber = row;
                return rowNumber;
            }
        }
        return rowNumber;
    }
    
    public boolean HasFourInARow(int column, int playerNumber) {
        int numberOfCoinsInARow = 1;
        int row = PlaceACoin(column, playerNumber);
        boolean haveFourInARow = false;
        // Go down the Column
        // Check to see how many coins that matches playerNumber going down the Row
        if (row != rowSize - 1){   
            boolean keepCounting = true;
            int rowNumber = row + 1;
            while (keepCounting) {  
                if (myArray[rowNumber][column] == playerNumber)
                {
                    numberOfCoinsInARow++;
                    if (rowNumber == rowSize - 1)
                    {
                        keepCounting = false;
                    }
                    else
                    {
                        rowNumber++;
                    }
                }
                else
                {
                    keepCounting = false;
                }
            }
        } 
        
        if (numberOfCoinsInARow < 4){
            //We do not have four in a row yet so reset the number of coins
            numberOfCoinsInARow = 1;
        }
        else{
            haveFourInARow = true;
        }

        // Go across the Row from left to right
        // Check to see how many coins that matches playerNumber going across the Row from left to right
        if (haveFourInARow == false && column != columnSize - 1){      
            boolean keepCounting = true;
            int columnNumber = column + 1;            
            
            while (keepCounting) {  
                if (myArray[row][columnNumber] == playerNumber)
                {
                    numberOfCoinsInARow++;
                    if (columnNumber == columnSize - 1)
                    {
                        keepCounting = false;
                    }  
                    else
                    {
                        columnNumber++;
                    }
                }
                else
                {
                    keepCounting = false;                    
                }
            }
        } 
        // Go across the Row from right to left
        // Check to see how many coins that matches playerNumber going across the Row from right to left
        if (haveFourInARow == false && column != 0){  
            
            boolean keepCounting = true;
            int columnNumber = column - 1;            

            while (keepCounting) {  
                if (myArray[row][columnNumber] == playerNumber)
                {
                    numberOfCoinsInARow++;
                    if (columnNumber == 0)
                    {
                        keepCounting = false;
                    }  
                    else
                    {
                        columnNumber--;
                    }
                }
                else
                {
                    keepCounting = false;
                }
            }
        } 
        
        if (numberOfCoinsInARow < 4){
            numberOfCoinsInARow = 1;
        }
        else {
            haveFourInARow = true;
        }
        
        // Check downward diagonal to see if we have 4 in a row.
        
        // Going down from left to right.
        if ( (haveFourInARow == false) && (column != columnSize - 1) && (row != rowSize -1)){  
            
            boolean keepCounting = true;
            int columnNumber = column + 1;            
            int rowNumber = row + 1;

            while (keepCounting) {  

                if (myArray[rowNumber][columnNumber] == playerNumber)
                {
                    
                    numberOfCoinsInARow++;
                    if ((columnNumber != columnSize - 1) && (rowNumber != rowSize -1))
                    {
                        columnNumber++;
                        rowNumber++;
                    }  
                    else
                    {
                        keepCounting = false; // exit the loop
                    }
                }
                else
                {
                    keepCounting = false;
                }
            }
        } 
        
        // Going up from right to left.
        if ( (haveFourInARow == false) && (column != 0) && (row != 0)){  
            
            boolean keepCounting = true;
            int columnNumber = column - 1;            
            int rowNumber = row - 1;

            while (keepCounting) {  

                if (myArray[rowNumber][columnNumber] == playerNumber)
                {
                    
                    numberOfCoinsInARow++;
                    if ((columnNumber != 0) && (rowNumber != 0))
                    {
                        columnNumber--;
                        rowNumber--;
                    }  
                    else
                    {
                        keepCounting = false; // exit the loop
                    }
                }
                else
                {
                    keepCounting = false;
                }
            }
        } 
        if (numberOfCoinsInARow < 4){
            numberOfCoinsInARow = 1;
        }
        else {
            haveFourInARow = true;
        }

        //Check upward diagonal to see if we have 4 in a row.
        //Going left to right.
        if ( (haveFourInARow == false) && (column != columnSize - 1) && (row != 0)){  
            
            boolean keepCounting = true;
            int columnNumber = column + 1;            
            int rowNumber = row - 1;
            
            while (keepCounting) {                  
                if (myArray[rowNumber][columnNumber] == playerNumber)
                {                   
                    numberOfCoinsInARow++;
                    if ((columnNumber != columnSize - 1) && (rowNumber != 0))
                    {
                        columnNumber++;
                        rowNumber--;
                    }  
                    else
                    {
                        keepCounting = false; // exit the loop
                    }
                }
                else
                {
                    keepCounting = false;
                }
            }
        } 
        
        //Going down from right to left.
        if ( (haveFourInARow == false) && (column != 0) && (row != rowSize - 1)){  
            
            boolean keepCounting = true;
            int columnNumber = column - 1;            
            int rowNumber = row + 1;
            
            while (keepCounting) {                 
                if (myArray[rowNumber][columnNumber] == playerNumber)
                {
                    numberOfCoinsInARow++;
                    if ((columnNumber != 0) && (rowNumber != rowSize - 1))
                    {
                        columnNumber--;
                        rowNumber++;
                    }  
                    else
                    {
                        keepCounting = false; // exit the loop
                    }
                }
                else
                {
                    keepCounting = false;
                }
            }
        } 
        if (numberOfCoinsInARow == 4){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void PrintGrid() {
        System.out.println("Here is the connect four game board.");
        for (int x = 0; x < rowSize; x++) {
            for (int y = 0; y < columnSize; y++) { 
                int myInt = myArray[x][y];
                    
                if (myInt == 2){
                    System.out.print("\uD83D\uDE42");
                }
                else if (myInt == 1){
                    System.out.print("\uD83D\uDE10");
                }
                else 
                {
                    System.out.print("\uD83C\uDF15");
                }
            }
            System.out.println("");
                
        }        
    }
}
