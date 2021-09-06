import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TaskFirstTestCase {

    private TaskFirst taskFirst;

    int[] array = {1, 2, 4, 4, 2, 3, 4, 1, 4, 8, 7};
    int[] array1 = {1, 2, 2, 3, 1, 8, 7};

    @BeforeEach
    public void init() {
        taskFirst = new TaskFirst();
    }

    @Test
    public void test_array_not_null() {
        taskFirst = new TaskFirst();
        Assertions.assertNotNull(array);
    }

    @Test
    public void test_throws_runtime_exception() {
        taskFirst = new TaskFirst();
        Assertions.assertThrows(RuntimeException.class, () -> {
            taskFirst.choose(array1);
        });
    }

    @ParameterizedTest
    @MethodSource("dataForTaskFirst")
    public void test_array_choose(int[] arr, int[] resultArr) {
        taskFirst = new TaskFirst();
        Assertions.assertArrayEquals(resultArr, taskFirst.choose(arr));
    }

    // метод генерирует данные для теста
    public static Stream<Arguments> dataForTaskFirst() {
        List<Arguments> out = new ArrayList<>();
        //out.add(Arguments.arguments(new int[]{входной массив}, ожидаемый результат new int[]{массив, после метода}));
        out.add(Arguments.arguments(new int[]{4, 4, 1, 4, 7, 9}, new int[]{7, 9}));
        out.add(Arguments.arguments(new int[]{4, 6, 8, 1, 5}, new int[]{6, 8, 1, 5}));
        out.add(Arguments.arguments(new int[]{10, 2, 4, -4, 3}, new int[]{-4, 3}));
        out.add(Arguments.arguments(new int[]{5, 0, 1, 21, 4}, new int[]{}));
        return out.stream();
    }
}
