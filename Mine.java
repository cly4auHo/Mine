package paket;

public class Mine {

    private static final int DEFAULT_RESOURCE_VALUE = 1000;
    private int resource;

    public int getResource(int amount) {
        if (amount <= 0) {
            return 0;
        }

        if (resource > 0 && amount <= resource) {
            resource -= amount;
            return amount;
        } else if (resource > 0 && amount > resource) {
            int value = resource;
            resource = 0;
            return value;
        }

        return 0;
    }

    public void waiting(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void workDone(){
        notifyAll();
    }

    public boolean isEmpty() {
        return resource <= 0;
    }

    public Mine() {
        resource = DEFAULT_RESOURCE_VALUE;
    }

    public Mine(int resourceValue) throws IllegalArgumentException {
        if (resourceValue <= 0) {
            throw new IllegalArgumentException("value must be more than 0");
        }

        resource = resourceValue;
    }
}