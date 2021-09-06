public class TaskSecond {
    public boolean check(int... arr) {

        boolean number1 = false;
        boolean number4 = false;

        for (int value : arr) {
            switch (value) {
                case 1:
                    number1 = true;
                    break;
                case 4:
                    number4 = true;
                    break;
                default:
                    return false;
            }
        }
        return number1 && number4;
    }
}
