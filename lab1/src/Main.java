import creational.*;
import domain.*;
import structural.*;
import behavioral.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("ЗАПУСК МАГАЗИНА\n");
        System.out.println("1 - Доступные категории");
        for (GoodType type : GoodType.values()) {
            System.out.println("-" + type + " — " + type.getLabel());
        }
        System.out.println("\n2. Создание товаров");
        GoodFactory foodFactory = new FoodGoodFactory();
        Good milk = foodFactory.create("Молоко", 1000.0f, 95.0f);
        milk.setID(0);
        System.out.println("Создан товар: " + milk);

        GoodFactory elecFactory = new ElectronicsGoodFactory();
        Good laptop = elecFactory.create("Ноутбук ASUS", 2300.0f, 85000.0f);
        laptop.setID(1);
        System.out.println("Создан товар: " + laptop);
        GoodFactory hsholderFactory = new HouseHoldsGoodFactory();
        Good soap = hsholderFactory.create("Мыло хозяйственное", 100.0f, 20.0f);
        soap.setID(2);
        System.out.println("Создан товар: " + soap + "\n");
        Good lockWithKey = hsholderFactory.create("Замок с ключом", 1000.0f, 500.0f);
        lockWithKey.setID(5);

        System.out.println("3. Создание прототипа");
        GoodPrototype soapTamplate = new GoodPrototype("Мыло", 100.0f, 100.0f, "household");
        Good soapLiquid = soapTamplate.setName("Жидкое мыло").setCost(200.0f).setID(3).build();
        Good soapStrawberry = soapTamplate.setName("Клубничное мыло").setCost(120.0f).setID(4).build();
        System.out.println("Клонированные товары мыла: " + "\n" +soapLiquid + "\n" + soapStrawberry + "\n");

        System.out.println("4. Набор товаров в карзину");
        Purchase cart = new Purchase("Корзина в Пятёрочке");
        cart.add(new GoodItem(milk, 14));
        cart.add(new GoodItem(soapLiquid, 25));
        cart.add(new GoodItem(lockWithKey, 8));
        cart.printStructure("  ");
        System.out.println("Базовая сумма: " + cart.getTotalCost() + " руб.\n");

        System.out.println("5. Скидка");
        PurchaseComponent discountedCart = new DiscountDecorator(cart, 0.10); // 10%
        System.out.println("В праздничный день вам начислена скидка 10%), Итого " + discountedCart.getTotalCost() + " руб. с весом " + cart.getTotalWeight() + "г\n");

        System.out.println("6. Добавлена карта лояльности");
        cart.setStrategy(new LoyaltyPricing(10000, 0.15));
        System.out.println("Сумма по стратегии лояльности при покупке от 10000 руб: " + cart.getCalculatedCost() + " руб. с весом " + cart.getTotalWeight() + "г\n");
        try {
            System.out.println("7. Проверка на превышение максимальной суммы в 50000");
            cart.addObserver(new BudgetWatcher(50000));
            // для проаерки работоспособности
            //Good juice = new DrinkGoodFactory().create("Сок Rich", 500.0f, 120.0f);
            //cart.add(new GoodItem(juice, 1000));
            System.out.println();
        }
        catch (RuntimeException e) {
            System.err.println("ОШИБКА: " + e.getMessage());
            System.err.println("Покупка не может быть завершена.");
            System.exit(1);
        }
        System.out.println("8. Формаирование чека");
        ReceiptVisitor visitor = new ReceiptVisitor();
        visitor.visit(cart);
        System.out.println(visitor.print());
    }
}