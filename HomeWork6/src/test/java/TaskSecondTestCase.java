import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class TaskSecondTestCase {

    private TaskSecond taskSecond;

    int[] array1 = {1, 1, 1, 4, 4, 1, 4, 4};

    @BeforeEach
    public void init() {
        taskSecond = new TaskSecond();
    }

    @Test
    public void test_array_not_null() {
        taskSecond = new TaskSecond();
        Assertions.assertNotNull(array1);
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public void test_time_check() throws InterruptedException {
        taskSecond = new TaskSecond();
//        Thread.sleep(2000);
        Assertions.assertEquals(true, taskSecond.check(array1));
    }

    @ParameterizedTest
    @MethodSource("dataForTaskSecond")
    public void test_array_choose(int[] arr, boolean result) {
        taskSecond = new TaskSecond();
        Assertions.assertEquals(result, taskSecond.check(arr));
    }

    // метод генерирует данные для теста
    public static Stream<Arguments> dataForTaskSecond() {
        List<Arguments> out = new ArrayList<>();
        //out.add(Arguments.arguments(new int[]{входной массив}, ожидаемый результат));
        out.add(Arguments.arguments(new int[]{1, 1, 1, 4, 4, 1, 4, 4}, true));
        out.add(Arguments.arguments(new int[]{1, 1, 1, 1, 1, 1}, false));
        out.add(Arguments.arguments(new int[]{4, 4, 4, 4, 4}, false));
        out.add(Arguments.arguments(new int[]{1, 2, 3, 4, 5}, false));
        return out.stream();
    }
}
