package creational;

public class DrinkGoodFactory implements GoodFactory{
    @Override
    public void configure(GoodBuilder builder) {
        builder.type(GoodType.DRINK.getLabel());
    }

    @Override
    public GoodType getType() {
        return GoodType.DRINK;
    }
}
