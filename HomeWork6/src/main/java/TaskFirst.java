import java.util.Arrays;

public class TaskFirst {
    public int[] choose(int... arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) {
                return Arrays.copyOfRange(arr, i + 1, arr.length);
            }
        }
        throw new RuntimeException("The array does not contain 4");
    }
}
