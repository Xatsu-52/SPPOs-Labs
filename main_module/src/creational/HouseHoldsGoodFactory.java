package creational;

public class HouseHoldsGoodFactory implements GoodFactory{
    @Override
    public void configure(GoodBuilder builder) {
        builder.type(GoodType.HOUSEHOLD.getLabel());
    }

    @Override
    public GoodType getType() {
        return GoodType.HOUSEHOLD;
    }
}
