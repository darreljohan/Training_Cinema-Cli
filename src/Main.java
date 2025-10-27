//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cinema moby = new Cinema();
        TestUtility mobyUtility = new TestUtility(moby);
        mobyUtility.injectMockData();
        View view = new View(moby);
        view.mainMenu();

    }
}