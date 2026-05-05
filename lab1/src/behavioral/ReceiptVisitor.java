package behavioral;
import domain.GoodItem;
import domain.Purchase;
import domain.PurchaseComponent;

public class ReceiptVisitor {
    private StringBuilder receipt = new StringBuilder();

    public void visit(PurchaseComponent component) {
        if (component instanceof Purchase) {
            Purchase p = (Purchase) component;
            receipt.append("Покупка: ").append(p.getName()).append("\n");
            receipt.append("-".repeat(40)).append("\n");
            for (PurchaseComponent item : p.getItems()) {
                visit(item);
            }
        } else if (component instanceof GoodItem) {
            GoodItem gi = (GoodItem) component;
            receipt.append(String.format("  • %-15s | %2d шт. | %6.2f руб. | %5.1f г%n",
                    gi.getGood().getName(), gi.getCount(), gi.getTotalCost(), gi.getTotalWeight()));
        }
    }

    public String print() { return receipt.toString(); }
}