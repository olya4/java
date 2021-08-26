
public class PrintABC {
    // volatile - используется для ресурса, который может изменять свое состояние
    // и быть прочитанным в разных потоках
    private volatile char currentLetter = 'A';
    // переменная, по которой будет делаться синхориназация
    private final Object monitor = new Object();

    public static void main(String[] args) {
        // экземпляр класса
        PrintABC waitNotifyApp = new PrintABC();
        new Thread(() -> {
            waitNotifyApp.printA();
        }).start();
        new Thread(() -> {
            waitNotifyApp.printB();
        }).start();
        new Thread(() -> {
            waitNotifyApp.printC();
        }).start();
    }

    // печатает букву А 5 раз
    public void printA() {
        // синхронизировать критический блок по переменной-монитору
        synchronized (monitor) {
            for (int i = 0; i < 5; i++) {
                try {
                    // метод находится в ожидании, если сейчас не надо печатать букву А
                    // пока currentLetter не указывает на букву А
                    while (currentLetter != 'A') {
                        // метод ждет
                        monitor.wait();
                    }
                    // когда метод выходит из ожидания, то печатает букву А
                    System.out.print("A");
                    // когда метод напечатал букву А, currentLetter = букве В
                    currentLetter = 'B';
                    // вывести поток из ожидания для буквы B
                    monitor.notify();
                    Thread.sleep(10);
                    // вывести из ожидания все потоки
                    monitor.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // печатает букву В 5 раз
    public void printB() {
        // синхронизировать критический блок по переменной-монитору
        synchronized (monitor) {
            for (int i = 0; i < 5; i++) {
                try {
                    // метод находится в ожидании, если сейчас не надо печатать букву B
                    // пока currentLetter не указывает на букву B
                    while (currentLetter != 'B') {
                        // метод ждет
                        monitor.wait();
                    }
                    // когда метод выходит из ожидания, то печатает букву В
                    System.out.print("B");
                    // когда метод напечатал букву В, currentLetter = букве C
                    currentLetter = 'C';
                    // вывести поток из ожидания для буквы C
                    monitor.notify();
                    Thread.sleep(10);
                    // вывести из ожидания все потоки
                    monitor.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // печатает букву C 5 раз
    public void printC() {
        // синхронизировать критический блок по переменной-монитору
        synchronized (monitor) {
            for (int i = 0; i < 5; i++) {
                try {
                    // метод находится в ожидании, если сейчас не надо печатать букву C
                    // пока currentLetter не указывает на букву C
                    while (currentLetter != 'C') {
                        // метод ждет
                        monitor.wait();
                    }
                    // когда метод выходит из ожидания, то печатает букву C
                    System.out.print("C");
                    // когда метод напечатал букву C, currentLetter = букве А
                    currentLetter = 'A';
                    // вывести поток из ожидания для буквы А
                    monitor.notify();
                    Thread.sleep(10);
                    // вывести из ожидания все потоки
                    monitor.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

