package thread;

public class WaitMessages {
    public static void main(String args[])
        throws InterruptedException {
        String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
        };



        for (int i = 0;
             i < importantInfo.length;
             i++) {
            //Pause for 4 seconds
            Thread.sleep(4000);
            //Print a message
            System.out.println(importantInfo[i]);
        }

//        for (int i = 0; i < inputs.length; i++) {
//            heavyCrunch(inputs[i]);
//            if (Thread.interrupted()) {
//                // We've been interrupted: no more crunching.
//                return;
//            }
//        }
//
//        if (Thread.interrupted()) {
//            throw new InterruptedException();
//        }

    }
}