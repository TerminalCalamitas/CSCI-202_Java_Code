package testing;
public class RotateArray {

    public static void main(String[] args) {
        int[][] arr = {{1, 2},
                       {3, 4}};
        int n = arr.length;
        int[][] new_arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                new_arr[j][i] = arr[n - 1 - i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(new_arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
