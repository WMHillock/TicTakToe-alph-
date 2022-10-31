class WinCondition {

    public static boolean checkMatrix(String[][] gameField, String sign) {
        String[][] controlArr = new String[5][5];
        boolean answer = false;

        for (int i = 0; i < gameField.length - 4; i++) {
            for (int j = 0; j < gameField[0].length - 4; j++) {

                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        controlArr[k][l] = gameField[i + k][j + l];
                    }
                }
                if (checkWin(controlArr, sign)){
                    answer = true;
                }
            }
        }
        return answer;
    }

    // не нравится текущий вариант паттернов для проверки
    public static boolean checkLine(String[][] controlArr, int x, int y, int dx, int dy, String sign) {
        for (int i = 0; i < 5; i++) {
            if (controlArr[x + i * dx][y + i * dy] != sign)
                return false;
        }
        return true;
    }

    public static boolean checkWin(String[][] controlArr, String sign) {
        for (int j = 0; j < 5; j++) {
            if (checkLine(controlArr, j, 0, 0, 1, sign)) return true;
            if (checkLine(controlArr, 0, j, 1, 0, sign)) return true;
        }
        if (checkLine(controlArr, 0, 0, 1, 1, sign)) return true;
        if (checkLine(controlArr, 0, 4, 1, -1, sign)) return true;
        return false;
    }
}