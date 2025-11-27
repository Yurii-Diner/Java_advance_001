package homework01;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Решение задачи последовательно в одном потоке


        long start = System.currentTimeMillis();
        System.out.println("Один поток начало работы: " + start);

        long sum = 0;
        for (int i = 0; i <= 1000000; i++) {
            sum += i;
        }

        long sequentialTime = System.currentTimeMillis() - start;
        System.out.println("Сумма: " + sum);
        System.out.println("Результат последовательного выполнения: " + sequentialTime + " мс");

        // Решение задачи параллельно в двух потоках
        long startTwoThread = System.currentTimeMillis();

        MyThread thread1 = new MyThread(1, 500_000);
        MyThread thread2 = new MyThread(500_001, 1_000_000);

        thread1.start();
        thread2.start();

        // ждем завершения обоих потоков!
        thread1.join();
        thread2.join();

        long parallelTime = System.currentTimeMillis() - startTwoThread;

        // Складываем результаты из обоих потоков
        long totalParallelSum = thread1.getResult() + thread2.getResult();

        System.out.println("Сумма из двух потоков: " + totalParallelSum);
        System.out.println("Результат параллельного выполнения: " + parallelTime + " мс");

        // Сравнение результатов
        System.out.println("\n=== СРАВНЕНИЕ ===");
        System.out.println("Суммы совпадают: " + (sum == totalParallelSum));
        System.out.println("Последовательное время: " + sequentialTime + " мс");
        System.out.println("Параллельное время: " + parallelTime + " мс");

        if (sequentialTime > parallelTime) {
            System.out.println("Параллельное выполнение быстрее на " +
                    (sequentialTime - parallelTime) + " мс");
        } else {
            System.out.println("Последовательное выполнение быстрее на " +
                    (parallelTime - sequentialTime) + " мс");
        }
    }
}