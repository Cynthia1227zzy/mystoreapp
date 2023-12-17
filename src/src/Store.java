package src;

public class Store {
    private Cloth[] cloth;
    private int total = 0;

    public Store(int numberCloth) {
        cloth = new Cloth[numberCloth];
    }

    private boolean isFull() {
        return total == cloth.length;
    }

    private boolean isEmpty() {
        return total == 0;
    }

    public boolean add(Cloth newCloth) {
        if (isFull()) {
            return false;
        } else {
            cloth[total] = newCloth;
            total++;
            return true;
        }
    }
}