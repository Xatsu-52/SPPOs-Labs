import creational.FoodGoodFactory;
import creational.GoodBuilder;
import creational.GoodFactory;
import creational.GoodPrototype;
import domain.Good;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Create new goods...");
        Good chips = new GoodBuilder("Чипсы", 140f, 180f).ID(0).type("Еда").build();
        System.out.println(chips);
        Good milk = new GoodBuilder("Молоко", 1000f, 90f).ID(1).type("Напиток").build();
        System.out.println(milk);

        GoodFactory foodFactory = new FoodGoodFactory();
        Good apple = foodFactory.create("Яблоко", 200f,50f);
        apple.setID(2);
        System.out.println(apple);

        GoodPrototype milkTemplate = new GoodPrototype("Молоко", 1000f, 90f, "Напиток");
        GoodPrototype milkSale = milkTemplate.clone();
        milkSale.setName("Молоко(акция)").setCost(65f).setID(3);
        GoodPrototype milkElite = milkTemplate.clone();
        milkElite.setName("Молоко(Элитное)").setCost(140f).setID(4);
        System.out.println(milkSale);
    }
}