import java.util.Scanner;

public class Java8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns for the first matrix:");
        int rowsA = scanner.nextInt();
        int colsA = scanner.nextInt();
        int[][] matrixA = new int[rowsA][colsA];
        System.out.println("Enter the elements of the first matrix:");
        readMatrix(scanner, matrixA, rowsA, colsA);

        System.out.println("Enter the number of rows and columns for the second matrix:");
        int rowsB = scanner.nextInt();
        int colsB = scanner.nextInt();

        if (colsA != rowsB) {
            System.out.println("Matrix multiplication is not possible.");
            return;
        }

        int[][] matrixB = new int[rowsB][colsB];
        System.out.println("Enter the elements of the second matrix:");
        readMatrix(scanner, matrixB, rowsB, colsB);

        int[][] productMatrix = multiplyMatrices(matrixA, matrixB, rowsA, colsA, colsB);

        System.out.println("Product of the matrices:");
        printMatrix(productMatrix);
    }

    // Function to read a matrix from user input
    public static void readMatrix(Scanner scanner, int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }
    public static int[][] multiplyMatrices(int[][] A, int[][] B, int rowsA, int colsA, int colsB) {
        int[][] result = new int[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                result[i][j] = 0;
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
