package creational;

public class ClothingGoodFactory implements GoodFactory{
    @Override
    public void configure(GoodBuilder builder) {
        builder.type(GoodType.CLOTHING.getLabel());
    }

    @Override
    public GoodType getType() {
        return GoodType.CLOTHING;
    }
}
