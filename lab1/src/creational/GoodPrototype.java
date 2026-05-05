package creational;
import domain.Good;
public class GoodPrototype implements Cloneable{
    private String name;
    private double weight;
    private double cost;
    private String type;
    private int ID;

    public GoodPrototype(String name, double weight, double cost, String type) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
        this.type = type;
        this.ID = -1;
    }
    @Override
    public GoodPrototype clone() {
        try {
            return (GoodPrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
    }

    public GoodPrototype setName(String name) {
        this.name = name;
        return this;
    }

    public GoodPrototype setCost(double cost) {
        this.cost = cost;
        return this;
    }

    public GoodPrototype setID(int ID) {
        this.ID = ID;
        return this;
    }
    public Good build() {
        return new GoodBuilder(name, weight, cost)
                .ID(ID)
                .type(type)
                .build();
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
