package creational;

public class FoodGoodFactory implements GoodFactory{

    @Override
    public void configure(GoodBuilder builder) {
        builder.type(GoodType.FOOD.getLabel());
    }

    @Override
    public GoodType getType() {
        return GoodType.FOOD;
    }
}
