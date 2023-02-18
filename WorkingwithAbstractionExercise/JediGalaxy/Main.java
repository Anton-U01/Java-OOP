package WorkingwithAbstractionExercise.JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            int[] dimentions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int rows = dimentions[0];
            int cols = dimentions[1];

        int[][] matrix = fillMatrix(rows, cols);

        String command = scanner.nextLine();
            int sum = 0;
            while (!command.equals("Let the Force be with you"))
            {
                int[] peters = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
                int[] evil = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int xP = peters[0];
                int yP = peters[1];
                int xE = evil[0];
                int yE = evil[1];

                evilsPath(matrix, xE, yE);

                sum = PetersPath(matrix, sum, xP, yP);

                command = scanner.nextLine();
            }

        System.out.println(sum);


    }

    private static int PetersPath(int[][] matrix, int sum, int xP, int yP) {
        while (xP >= 0 && yP < matrix[1].length)
        {
            if (xP >= 0 && xP < matrix.length && yP >= 0 && yP < matrix[0].length)
            {
                sum += matrix[xP][yP];
            }

            yP++;
            xP--;
        }
        return sum;
    }

    private static void evilsPath(int[][] matrix, int xE, int yE) {
        while (xE >= 0 && yE >= 0)
        {
            if (xE >= 0 && xE < matrix.length && yE >= 0 && yE < matrix[0].length)
            {
                matrix[xE] [yE] = 0;
            }
            xE--;
            yE--;
        }
    }

    private static int[][] fillMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        int value = 0;
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                matrix[i][j] = value++;
            }
        }
        return matrix;
    }
}
