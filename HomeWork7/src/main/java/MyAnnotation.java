public class MyAnnotation {

    @BeforeSuite
    public void beginning() {
        System.out.println("Начало тестов");
    }

    @Test(priority = 1)
    public void test1() {
        System.out.println("Тест 1 запущен");
    }

    @Test(priority = 2)
    public void test2() {
        System.out.println("Тест 2 запущен");
    }

    @Test(priority = 3)
    public void test3() {
        System.out.println("Тест 3 запущен");
    }

    @Test(priority = 4)
    public void test4() {
        System.out.println("Тест 4 запущен");
    }

    @Test(priority = 4)
    public void test_4() {
        System.out.println("Тест 4 запущен");
    }

    @Test(priority = 5)
    public void test5() {
        System.out.println("Тест 5 запущен");
    }

    @Test(priority = 6)
    public void test6() {
        System.out.println("Тест 6 запущен");
    }

    @Test(priority = 7)
    public void test7() {
        System.out.println("Тест 7 запущен");
    }

    @Test(priority = 8)
    public void test8() {
        System.out.println("Тест 8 запущен");
    }

    @Test(priority = 9)
    public void test9() {
        System.out.println("Тест 9 запущен");
    }

    @Test(priority = 10)
    public void test10() {
        System.out.println("Тест 10 запущен");
    }

    @AfterSuite
    public void finish() {
        System.out.println("Тесты завершены");
    }
}
