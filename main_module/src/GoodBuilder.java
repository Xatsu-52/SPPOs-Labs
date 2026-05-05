public class GoodBuilder {
    private final String name;
    private final double weight;
    private final double cost;
    private final int ID;

    public GoodBuilder(String name, double weight, double cost, int ID) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
        this.ID = ID;
    }

    public Good build() {return new Good(this);}

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getCost() {
        return cost;
    }

    public int getID() {
        return ID;
    }
}
