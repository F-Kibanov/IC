package ToyRaffle;

public class Toy {
    private int toyId;
    private String toyName;

    public Toy(int toyId, String toyName) {
        this.toyId = toyId;
        this.toyName = toyName;
    }

    public int getToyId() {
        return toyId;
    }

    public void setToyId(int toyId) {
        this.toyId = toyId;
    }

    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    @Override
    public String toString() {
        return "Toy [toyId = " + toyId + ", toyName = " + toyName + "\n" + "]";
    }
}
