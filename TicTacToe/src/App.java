
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // write your code here

        Scanner input  = new Scanner(System.in);

        //System.out.print("Enter cells: ");
        //char[] array = new char[9];
        // array = input.nextLine().toCharArray();

        //Adding elements to Matrix
        char[][]  matrix = new char[3][3];
        for (int i = 0; i < 9; i++) {
            matrix[i / 3][i % 3] = ' ';
        }

        //It's time to print the matrix of TicTacToe
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.printf("| %c %c %c |",
                    matrix[i][0],matrix[i][1],matrix[i][2]);
            System.out.println();
        }
        System.out.println("---------");

        //Phase-2
        //Take co-ordinates from user to insert X value in that position
        //Conditions:
        //1.If entered co-ordinates are not number -> You should enter numbers!
        //2.If numbers don't fit under matrix indices -> Co-ordinates should be from 1 to 3!
        //3.If co-ordinates index is already filled with numbers -> This cell is occupied! Choose another one!


        String rowNumber = null;
        String colNumber = null ;



        for (int i = 1; i <= 9 ; i++) {
            boolean loop = true;
            if (i % 2 == 0) {
                System.out.println("O :  ");
            } else {
                System.out.println("X : ");
            }

            while (loop) {
                System.out.println("Enter Co-ordinates: ");
                rowNumber = input.next();
                colNumber = input.next();

                if (rowNumber.matches("\\D")  || colNumber.matches("\\D") ) {
                    System.out.println("You should enter numbers!");
                } else if (Integer.parseInt(rowNumber) > 3 || Integer.parseInt(rowNumber) < 1 ||
                        Integer.parseInt(colNumber) > 3 || Integer.parseInt(colNumber) < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (matrix[Integer.parseInt(rowNumber) - 1][Integer.parseInt(colNumber) - 1] == 'X'
                        || matrix[Integer.parseInt(rowNumber) - 1][Integer.parseInt(colNumber) - 1] == 'O') {
                    System.out.println("This cell is occupied!");
                } else loop = false;


            }
            //Filling the X | O
            if (i % 2 == 0) {
                matrix[Integer.parseInt(rowNumber)  - 1][Integer.parseInt(colNumber) - 1] = 'O';
            } else {
                matrix[Integer.parseInt(rowNumber)  - 1][Integer.parseInt(colNumber) - 1] = 'X';
            }

            System.out.println("---------");
            for (int j = 0; j < 3; j++) {
                System.out.printf("| %c %c %c |",
                        matrix[j][0],matrix[j][1],matrix[j][2]);
                System.out.println();
            }
            System.out.println("---------");

//            int xs = 0;
//            int os = 0;
            boolean xxx = false;
            boolean ooo = false;

            for (int ii = 0; ii < 3; ii++) {

                //setting all sum to zero for next iteration
                int rowSum = 0;
                int colSum = 0;
                int rightDiagonal = 0;
                int leftDiagonal = 0;

                for (int j = 0; j < 3; j++) {

                    //Now
                    //Traversing by row
                    rowSum += matrix[ii][j];

                    //Traversing By column
                    colSum += matrix[j][ii];

                    //left Diagonal 00 11 22
                    leftDiagonal += matrix[j][j];

                    //right Diagonal 02 11 20
                    rightDiagonal += matrix[j][2-j];

                }
                xxx = xxx || rowSum == 264 || colSum == 264 || rightDiagonal == 264 || leftDiagonal == 264;
                ooo = ooo || rowSum == 237 || colSum == 237 || rightDiagonal == 237 || leftDiagonal == 237;

            }

            if (xxx) {
                System.out.println("X wins");
                break;
            } else if (ooo) {
                System.out.println("O wins");
                break;
            } else if (i == 9) {
                System.out.println("Draw");
                break;
            }


        }








        //Fill given co-ordinates index with X


        //Printing Matrix
//        System.out.println("---------");
//        for (int i = 0; i < 3; i++) {
//            System.out.printf("| %c %c %c |",
//                    matrix[i][0],matrix[i][1],matrix[i][2]);
//            System.out.println();
//        }
//        System.out.println("---------");



    }
}