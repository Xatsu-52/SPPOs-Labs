package domain;
import java.util.ArrayList;
import java.util.List;
public class Person {
    private final String name;
    private final List<Purchase> purchaseHistory = new ArrayList<>();

    public Person(String name) { this.name = name; }

    public void makePurchase(Purchase purchase) {
        purchaseHistory.add(purchase);
    }

    public double getLifetimeSpendings() {
        return purchaseHistory.stream()
                .mapToDouble(Purchase::getTotalCost)
                .sum();
    }

    public void printHistory() {
        System.out.println("История покупок " + name + ":");
        for (Purchase p : purchaseHistory) {
            p.printStructure("  ");
            System.out.println();
        }
    }
}
