import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WorkingWithNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);

        // Фильтруем положительные числа
        List<Integer> positiveNumbers = new ArrayList<>();
        for (int num : numbers) {
            if (num > 0) {
                positiveNumbers.add(num);
            }
        }

        // Фильтруем только четные числа
        List<Integer> evenNumbers = new ArrayList<>();
        for (int num : positiveNumbers) {
            if (num % 2 == 0) {
                evenNumbers.add(num);
            }
        }

        // Сортируем список по возрастанию
        Collections.sort(evenNumbers);

        // Выводим результат
        for (int num : evenNumbers) {
            System.out.println(num);
        }
    }
}
