
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestClass {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        startAnnotation();
    }

    private static void startAnnotation() throws InvocationTargetException, NoSuchMethodException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        // создать экземпляр класса
        MyAnnotation myAnnotation = new MyAnnotation();

        // получить список (массив) методов, которые имеются в классе MyAnnotation
        for (Method method : myAnnotation.getClass().getDeclaredMethods()) {
            // получить экземпляр конкретной аннотации (тип аннотации)
            BeforeSuite beforeSuite = method.getAnnotation(BeforeSuite.class);
            // если аннотация присутствует в методе
            if (beforeSuite != null) {
                method.invoke(myAnnotation);
            }
        }

        for (Method method : myAnnotation.getClass().getDeclaredMethods()) {
            Test test = method.getAnnotation(Test.class);
            if (test != null) {
                if (test.priority() == 1) {
                    method.invoke(myAnnotation);
                }
            }
        }

        for (Method method : myAnnotation.getClass().getDeclaredMethods()) {
            Test test = method.getAnnotation(Test.class);
            if (test != null) {
                if (test.priority() == 2) {
                    method.invoke(myAnnotation);
                }
            }
        }

        for (Method method : myAnnotation.getClass().getDeclaredMethods()) {
            Test test = method.getAnnotation(Test.class);
            if (test != null) {
                if (test.priority() == 3) {
                    method.invoke(myAnnotation);
                }
            }
        }

        for (Method method : myAnnotation.getClass().getDeclaredMethods()) {
            Test test = method.getAnnotation(Test.class);
            if (test != null) {
                if (test.priority() == 4) {
                    method.invoke(myAnnotation);
                }
            }
        }

        for (Method method : myAnnotation.getClass().getDeclaredMethods()) {
            Test test = method.getAnnotation(Test.class);
            if (test != null) {
                if (test.priority() == 5) {
                    method.invoke(myAnnotation);
                }
            }
        }

        for (Method method : myAnnotation.getClass().getDeclaredMethods()) {
            Test test = method.getAnnotation(Test.class);
            if (test != null) {
                if (test.priority() == 6) {
                    method.invoke(myAnnotation);
                }
            }
        }

        for (Method method : myAnnotation.getClass().getDeclaredMethods()) {
            Test test = method.getAnnotation(Test.class);
            if (test != null) {
                if (test.priority() == 7) {
                    method.invoke(myAnnotation);
                }
            }
        }

        for (Method method : myAnnotation.getClass().getDeclaredMethods()) {
            Test test = method.getAnnotation(Test.class);
            if (test != null) {
                if (test.priority() == 8) {
                    method.invoke(myAnnotation);
                }
            }
        }

        for (Method method : myAnnotation.getClass().getDeclaredMethods()) {
            Test test = method.getAnnotation(Test.class);
            if (test != null) {
                if (test.priority() == 9) {
                    method.invoke(myAnnotation);
                }
            }
        }

        for (Method method : myAnnotation.getClass().getDeclaredMethods()) {
            Test test = method.getAnnotation(Test.class);
            if (test != null) {
                if (test.priority() == 10) {
                    method.invoke(myAnnotation);
                }
            }
        }

        for (Method method : myAnnotation.getClass().getDeclaredMethods()) {
            AfterSuite afterSuite = method.getAnnotation(AfterSuite.class);
            if (afterSuite != null) {
                method.invoke(myAnnotation);
            }
        }
    }
}
