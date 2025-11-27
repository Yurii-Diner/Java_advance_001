package homework01;

public class MyThread extends Thread {

    private Integer start; // Поле для начала отсчета
    private Integer stop;  // Поле обозначает до скольки считать
    private long result;   // Поле для хранения результата

    public MyThread(Integer start, Integer stop) {
        this.start = start;
        this.stop = stop;
    }

    // Метод который принимает два числа считает сумму чисел которые между ними
    private long summ(int start, int stop) {
        long sum = 0;
        for (int i = start; i <= stop; i++) {
            sum += i;
        }
        return sum;
    }

    @Override
    public void run() {
        result = summ(start, stop);  // Сохраняем результат
    }

    // Геттер для получения результата
    public long getResult() {
        return result;
    }
}