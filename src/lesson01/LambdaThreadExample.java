package lesson01;

public class LambdaThreadExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread( () -> {
            int counter = 0;
            while (counter < 4) {
                System.out.println("Лямбда-поток: " + counter);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter++;
            }
        });

        thread1.start();

        // Более короткая форма для простых операций
        Thread thread2 = new Thread( () ->
                System.out.println("Простая задача в потоке: " +
                        Thread.currentThread().getName()));
        thread2.start();

        // Можно сохранить лямбду в переменную
        Runnable printTask = () -> {
            System.out.println("Выполняется в : " +
                    Thread.currentThread().getName());
        };

        new Thread(printTask, "Поток-А").start();
        new Thread(printTask, "Поток-Б").start();

        Thread thread3 = new Thread( () -> {
            System.out.println("Текущий поток: " +
                    Thread.currentThread().getName());
        });

        // Правильно: создается новый поток
        thread3.start();

        // Неправильно: выполняется в текущем потоке
        thread3.run();

    }
}

