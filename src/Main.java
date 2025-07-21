import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int[][] teams = {
                {45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
                {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}
        };

        int[] nationalTeam = mergeAll(teams);
        System.out.println(Arrays.toString(nationalTeam)); // [51, 45, 31, 31, 30, 24, 22, 20, 18, 17]
    }

    /**
     * Метод для слияния всех команд в одну национальную
     */
    public static int[] mergeAll(int[][] teams) {
        if (teams.length == 0)
            return new int[0];

        int[] result = Arrays.copyOf(teams[0], 10);

        for (int i = 1; i < teams.length; i++) {
            result = merge(result, teams[i]);
        }

        return result;
    }

    /**
     * Метод для слияния двух команд в одну
     */
    public static int[] merge(int[] teamA, int[] teamB) {
        int[] result = new int[10]; // сразу создаём массив нужного размера
        int i = 0, j = 0;

        for (int k = 0; k < 10; k++) {
            if (i < 10 && (j >= 10 || teamA[i] > teamB[j])) {
                result[k] = teamA[i++];
            } else {
                result[k] = teamB[j++];
            }
        }

        return result;
    }
}