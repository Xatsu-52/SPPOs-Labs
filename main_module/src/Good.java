import java.util.Objects;

public class Good {
    private final String name;
    private final double weight;
    private final double cost;
    private final int ID;

    public Good(GoodBuilder builder) {
        this.name = builder.getName();
        this.cost = builder.getCost();
        this.ID = builder.getID();
        this.weight = builder.getWeight();
    }

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return Double.compare(weight, good.weight) == 0 && Double.compare(cost, good.cost) == 0 && ID == good.ID && Objects.equals(name, good.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, cost, ID);
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", cost=" + cost +
                ", ID=" + ID +
                '}';
    }
}
