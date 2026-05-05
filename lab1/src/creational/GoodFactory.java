package creational;

import domain.Good;

public interface GoodFactory {
    default Good create(String name, double weight, double baseCost) {
        GoodBuilder builder = new GoodBuilder(name, weight, baseCost);
        configure(builder);
        return builder.build();
    }
    void configure(GoodBuilder builder);

    GoodType getType();
}
