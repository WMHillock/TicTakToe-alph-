import java.util.*;

class GameField {

    public static final Scanner IN = new Scanner(System.in);

    public static String[][] creatGameField() {

        System.out.print("Введите количество строк\n>>");
        int rowArr = Integer.parseInt(IN.nextLine());

        System.out.print("Введите количество колонок\n>>");
        int columnArr = Integer.parseInt(IN.nextLine());

        ArrayList<ArrayList<String>> gameField = new ArrayList<>();

        for (int i = 0; i < rowArr + 1; i++) {
            gameField.add(new ArrayList<>());
            for (int j = 0; j < columnArr + 1; j++) {
                gameField.get(i).add(j, Main.EMPTY);
            }
        }

        String[][] strNullPos = new String[gameField.size()][gameField.get(0).size()];

        for (int i = 0; i < rowArr + 1; i++) {
            for (int j = 0; j < columnArr + 1; j++) {
                if (i == 0) {
                    strNullPos[i][j] = String.valueOf(j);
                    if (j == 0) {
                        strNullPos[i][j] = " ";
                    }
                } else if (j == 0) {
                    strNullPos[i][j] = String.valueOf(i);
                } else {
                    strNullPos[i][j] = gameField.get(i).get(j);
                }
            }
        }
        return strNullPos;
    }

    public static void showMatrix(String[][] arrNullPos) {
        int rowCount = arrNullPos.length;
        int columnCount = arrNullPos[0].length;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                System.out.printf("%3s",j == columnCount - 1 ? arrNullPos[i][j] +
                        "\n" : arrNullPos[i][j] + " ");
            }
        }
    }

}