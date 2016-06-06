package thread;

public class HelloRunnable implements Runnable {


    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String args[]) {
        /*Thread thread =  new Thread(new HelloRunnable());
        thread.start();

        thread.start();*/
        HelloRunnable target = new HelloRunnable();

        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(target);
            thread.start();
        }
    }

}