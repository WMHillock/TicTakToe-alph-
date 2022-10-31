class Main {

    public static final String CROSS = "X";
    public static final String ZERO = "O";
    public static final String EMPTY = "-";

    public static void main(String[] args) {

        String[][] gameField = GameField.creatGameField().clone();

        turnByTurn(gameField);
    }

    public static void turnByTurn(String[][] gameField) {
        int turnCount = 0;
        int winThis = 0;

        while (winThis == 0) {
            GameField.showMatrix(gameField);

            if (turnCount % 2 == 0) {

                System.out.printf("\nХодят %s введите координаты по форме X Y:\n >>", CROSS);

                int row = GameField.IN.nextInt();
                int column = GameField.IN.nextInt();

                if (checkPlace(gameField, row, column)) {
                    gameField[row][column] = CROSS;
                    turnCount++;
                    if (WinCondition.checkMatrix(gameField, CROSS)) {
                        System.out.println("Крестики победили!");
                        GameField.showMatrix(gameField);
                        winThis++;
                    }
                } else {
                    System.out.printf("\nНевозможно разместить %s здесь!\n", CROSS);
                }

            } else {
                System.out.printf("\nХодят %s введите координаты по форме X Y:\n >>", ZERO);

                int row = GameField.IN.nextInt();
                int column = GameField.IN.nextInt();

                if (checkPlace(gameField, row, column)) {
                    gameField[row][column] = ZERO;
                    turnCount++;
                    if (WinCondition.checkMatrix(gameField, ZERO)) {
                        System.out.println("Нолики победили!");
                        GameField.showMatrix(gameField);
                        winThis++;
                    }
                } else {
                    System.out.printf("\nНевозможно разместить %s здесь!", ZERO);
                }
            }
        }
    }

    public static boolean checkPlace(String[][] gameField, int row, int column) {
        return gameField[row][column].equals(EMPTY) && row <= gameField.length && column <= gameField[0].length;
    }
}