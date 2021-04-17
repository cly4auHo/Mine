package paket;

public class Miner implements Runnable {

    private static final int DEFAULT_CAPACITY = 30;
    private Mine mine;
    private int capacity;
    private int resource;

    @Override
    public void run() {
        synchronized (mine) {
            while (!mine.isEmpty()) {
                resource += mine.getResource(capacity);
                mine.workDone();
                mine.waiting();
            }

            mine.workDone();
            System.out.println("I`m get " + resource);
        }
    }

    public Miner(Mine mine, int capacity) throws IllegalArgumentException {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be more than 0");
        }

        if(mine == null){
            throw  new IllegalArgumentException("Mine must be not null");
        }

        this.mine = mine;
        this.capacity = capacity;
        new Thread(this).start();
    }

    public Miner(Mine mine) throws IllegalArgumentException {
        new Miner(mine, DEFAULT_CAPACITY);
    }
}
