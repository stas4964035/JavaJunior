import java.util.Arrays;
import java.util.List;

public class Avg {
    public static void main(String[] args) {
        // Программа выводит среднее значение четных чисел списка, если такоевые имеются, в обратном случае -- ничего не выводится.
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> dataFail = Arrays.asList(1, 3, 5, 7, 9);
        data.stream().filter(x -> x % 2 == 0).mapToInt(x -> x).average().ifPresent(x -> System.out.println(x));
        dataFail.stream().filter(x -> x % 2 == 0).mapToInt(x -> x).average().ifPresent(x -> System.out.println(x));

    }
}
