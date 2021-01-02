import java.util.Arrays;

public class GatesWalls {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {0, 0, -1, -2},
                {-2, 0, 0, 0}
        };
        int[][] visited = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == -2) {
                    findDistance(matrix, i, j, 0, visited);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void findDistance(int[][] matrix, int row, int col, int level, int[][] visited) {
        if (row < 0 || col < 0 || row > matrix.length - 1 || col > matrix[0].length - 1
                || matrix[row][col] == -1 || visited[row][col] == 1) {
            return;
        }

        if (matrix[row][col] == 0 || matrix[row][col] > level) {
            matrix[row][col] = level;
        }

        visited[row][col] = 1;
        findDistance(matrix, row + 1, col, level+1, visited);
        findDistance(matrix, row - 1, col, level+1, visited);
        findDistance(matrix, row, col + 1, level+1, visited);
        findDistance(matrix, row, col - 1, level+1, visited);
        visited[row][col] = 0;
    }
}
