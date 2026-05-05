import creational.GoodBuilder;
import domain.Good;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Create new good...");
        Good chips = new GoodBuilder("Чипсы", 140f, 180f).ID(0).type("Еда").build();
        System.out.println(chips);
        Good milk = new GoodBuilder("Молоко", 1000f, 90f).ID(1).type("Напиток").build();
        System.out.println(milk);
    }
}