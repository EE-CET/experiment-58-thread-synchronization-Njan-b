class Table {

    // Synchronized method to avoid interleaving
    synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.print(n * i + " ");
        }
        System.out.println();
    }
}

class MyThread extends Thread {
    Table obj;
    int number;

    MyThread(Table obj, int number) {
        this.obj = obj;
        this.number = number;
    }

    public void run() {
        obj.printTable(number);
    }
}

public class SynchronizationDemo {
    public static void main(String[] args) {

        Table table = new Table();

        MyThread t1 = new MyThread(table, 5);
        MyThread t2 = new MyThread(table, 100);

        t1.start();
        t2.start();
    }
}
