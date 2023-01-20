import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class FelineTest {
    private final Feline FELINE = new Feline();

    @Test
    public void eatMeatTest() {
        List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба");
        try {
            List<String> actualFoodList = FELINE.eatMeat();
            Assert.assertEquals("Неправильный список еды", expectedFoodList, actualFoodList);
        } catch (Exception e) {
            Assert.fail("Выбросило исключение: " + e.getMessage());
        }

    }

    @Test
    public void getFamilyTest() {
        Assert.assertEquals("Неправильное семейство", "Кошачьи", FELINE.getFamily());
    }

    @Test
    public void getKittensDefaultTest() {
        Assert.assertEquals("Неправильное количество котят", 1, FELINE.getKittens());
    }

    @Test
    public void getKittensWithParamTest() {
        Assert.assertEquals("Неправильное количество котят", 5, FELINE.getKittens(5));
    }
}
