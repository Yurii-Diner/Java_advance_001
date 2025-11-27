package lesson01;

public class CounterTask implements Runnable {
    private String taskName;
    private int countTo;

    public CounterTask(String taskName, int countTo) {
        this.taskName = taskName;
        this.countTo = countTo;
    }

    @Override
    public void run() {
        System.out.println(taskName + " запущена в потоке: " +
                Thread.currentThread().getName());

        for (int i = 0; i <= countTo; i++) {
            System.out.println(taskName + ": " + i + "/" + countTo);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // Правильная обработка прерывания
                System.out.println(taskName + " прервана");
                Thread.currentThread().interrupt(); // Восстановить флаг прерывания
                return; // Выход из метода
            }
        }

        System.out.println(taskName + " завершена");
    }
}
