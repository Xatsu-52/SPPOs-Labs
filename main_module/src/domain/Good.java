package domain;

import java.util.Objects;
import creational.GoodBuilder;

public class Good {
    //обязательные
    private final String name;
    private final double weight;
    private final double cost;
    //опциональные
    private final int ID;
    private final String type;

    public Good(GoodBuilder builder) {
        this.name = builder.getName();
        this.cost = builder.getCost();
        this.ID = builder.getID();
        this.weight = builder.getWeight();
        this.type = builder.getType();
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
    public String getType() {
        return type;
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
                ", weight=" + weight + " грамм" +
                ", cost=" + cost + " рублей" +
                ", ID=" + ID +
                ", type='" + type + '\'' +
                '}';
    }
}

