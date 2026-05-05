import java.util.Objects;

public class Good {
    private String name;
    private double weight;
    private double cost;
    private int ID;

    public Good(String name, double weight, double cost, int ID) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
