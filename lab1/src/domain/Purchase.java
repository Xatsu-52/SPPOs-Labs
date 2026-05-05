package domain;
import behavioral.PurchaseObserver;
import behavioral.PricingStrategy;
import behavioral.StandardPricing;
import java.util.ArrayList;
import java.util.List;

public class Purchase implements PurchaseComponent {
    private final String name;
    private final List<PurchaseComponent> items = new ArrayList<>();

    private final List<PurchaseObserver> observers = new ArrayList<>();

    private PricingStrategy strategy = new StandardPricing();

    public Purchase(String name) {
        this.name = name;
    }

    @Override
    public double getTotalCost() {
        return items.stream().mapToDouble(PurchaseComponent::getTotalCost).sum();
    }

    @Override
    public double getTotalWeight() {
        return items.stream().mapToDouble(PurchaseComponent::getTotalWeight).sum();
    }

    @Override
    public void add(PurchaseComponent component) {
        items.add(component);
        notifyObservers(); // 👈 УВЕДОМЛЯЕМ НАБЛЮДАТЕЛЕЙ после добавления
    }

    @Override
    public void remove(PurchaseComponent component) {
        items.remove(component);
        notifyObservers(); // 👈 И после удаления тоже
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public List<PurchaseComponent> getItems() {
        return items;
    }

    public void addObserver(PurchaseObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        double total = getCalculatedCost(); // Используем стратегию для расчёта
        for (PurchaseObserver obs : observers) {
            obs.onTotalUpdated(total); // 👈 ВЫЗЫВАЕМ onTotalUpdated
        }
    }

    public void setStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public double getCalculatedCost() {
        return strategy.calculateTotalCost(this);
    }

    public double getCalculatedWeight() {
        return strategy.calculateTotalWeight(this);
    }

    public void printStructure(String indent) {
        System.out.println(indent + "+ " + getName() +
                " | Итого: " + getTotalCost() + " руб, " +
                getTotalWeight() + " г");
        for (PurchaseComponent item : items) {
            if (item instanceof Purchase) {
                ((Purchase) item).printStructure(indent + "  ");
            } else {
                System.out.println(indent + "  - " + item.getName() +
                        " | " + item.getTotalCost() + " руб, " +
                        item.getTotalWeight() + " г");
            }
        }
    }
}