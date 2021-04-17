package paket;

public class AppMain {

    public static void main(String[] args) {
        try {
            Mine mine = new Mine();
            Miner miner0 = new Miner(mine);
            Miner miner1 = new Miner(mine);
            Miner miner2 = new Miner(mine);
        } catch (IllegalArgumentException e) {

        }
    }
}




