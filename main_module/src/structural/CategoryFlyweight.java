package structural;
import java.util.HashMap;
import java.util.Map;

public class CategoryFlyweight {
    private static final Map<String, String> pool = new HashMap<>();

    public static String getCategory(String key) {
        return pool.computeIfAbsent(key, k -> switch(k) {
            case "food" -> "Продукты";
            case "electronics" -> "Электроника";
            case "clothing" -> "Одежда";
            case "drink" -> "Напитки";
            case "household" -> "Товары для дома";
            default -> "Общее";
        });
    }
}