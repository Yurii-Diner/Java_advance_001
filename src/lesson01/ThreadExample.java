package lesson01;

public class ThreadExample {
    public static void main(String[] args) {
        System.out.println("Главный поток начинает работу");

        MyThread thread1 = new MyThread("Поток-1");
        MyThread thread2 = new MyThread("Поток-2");

        // ВАЖНО: вызываем start(), а НЕ run()!
        // start() создает новый поток и вызывает run() в нем
        // run() просто выполнит метод в текущем потоке
        thread1.start();
        thread2.start();

        System.out.println("Главный поток продолжает свою работу");
        // Главный поток НЕ ЖДЕТ завершения thread1 и thread2
        // Таким образом, все три потока выполняются параллельно
    }
}
