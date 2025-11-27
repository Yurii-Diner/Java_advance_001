package lesson01;

public class AnonymousThreadExample {
    public static void main(String[] args) {
        Thread thread = new Thread( new Runnable(){
            @Override
            public void run(){
                for (int i = 0; i < 7; i++) {
                    System.out.println("Анонимный поток " +i);

                    try{
                        Thread.sleep(500);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();
    }
}
