class TablePrinter {

    // synchronized method
    synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.print(n * i + " ");
        }
        System.out.println();
    }
}

class MyThread extends Thread {
    TablePrinter t;
    int num;

    MyThread(TablePrinter t, int num) {
        this.t = t;
        this.num = num;
    }

    public void run() {
        t.printTable(num);
    }
}

public class SynchronizationDemo {
    public static void main(String[] args) {

        TablePrinter obj = new TablePrinter();

        MyThread t1 = new MyThread(obj, 5);
        MyThread t2 = new MyThread(obj, 100);

        t1.start();
        t2.start();
    }
}