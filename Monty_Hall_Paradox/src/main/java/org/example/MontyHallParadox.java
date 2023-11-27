import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MontyHallParadox {
    public static void main(String[] args) {
        int tests = 1000;
        int stayWins = 0;
        int switchWins = 0;

        Map<Integer, String> results = new HashMap<>();

        for (int i = 1; i <= tests; i++) {
            // Создаем три двери
            String[] doors = {"Goat", "Goat", "Car"};
            // Перемешиваем двери
            shuffleArray(doors);
            // Игрок выбирает случайную дверь
            int playerChoice = new Random().nextInt(3);
            // Ведущий открывает дверь с козой
            int openedDoor;
            do {
                openedDoor = new Random().nextInt(3);
            } while (openedDoor == playerChoice || doors[openedDoor].equals("Car"));
            // Проверяем результат при выборе оставаться при первом выборе
            if (doors[playerChoice].equals("Car")) {
                stayWins++;
                results.put(i, "Stay");
            } else {
                // Проверяем результат при выборе сменить выбор
                switchWins++;
                results.put(i, "Switch");
            }

        }
        // Выводим статистику побед и поражений
        System.out.println("Stay wins: " + stayWins);
        System.out.println("Switch wins: " + switchWins);
        System.out.println("Results: " + results);
    }

    // Метод для перемешивания массива
    private static void shuffleArray(String[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            String temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}