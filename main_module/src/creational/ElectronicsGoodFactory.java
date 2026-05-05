package creational;

public class ElectronicsGoodFactory implements GoodFactory{

    @Override
    public void configure(GoodBuilder builder) {
        builder.type(GoodType.ELECTRONICS.getLabel());

    }

    @Override
    public GoodType getType() {
        return GoodType.ELECTRONICS;
    }
}
