//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Create new good...");
        Good chips = new GoodBuilder("Lays", 140, 180, 0).build();
        System.out.println(chips);
        Good crackers = new GoodBuilder("Tuc", 70, 65, 1).build();
        System.out.println(crackers);
    }
}