package domain;

public interface PurchaseComponent {
    double getTotalCost();
    double getTotalWeight();
    void add(PurchaseComponent component);
    void remove(PurchaseComponent component);
    String getName();
    int getCount();
}
