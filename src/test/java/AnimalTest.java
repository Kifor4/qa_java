import com.example.Animal;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(JUnitParamsRunner.class)
public class AnimalTest {

    private final Animal ANIMAL = new Animal();

    @Test
    public void getFamily() {
        Assert.assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи",
                ANIMAL.getFamily());
    }

    @Test
    @Parameters({"Травоядное, Трава, Различные растения", "Хищник, Животные, Птицы, Рыба", "Всеядное, Всё"})
    public void getFoodTest(String animalKind, String... foodArray) {
        try {
            Assert.assertEquals("Неверный список еды для: " + animalKind, List.of(foodArray), ANIMAL.getFood(animalKind));
        } catch (Exception e) {
            Assert.assertEquals("Исключение выбросило, при виде: " + animalKind,"Всеядное", animalKind);
            Assert.assertEquals("Неожидаемая ошибка","Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
        }
    }
}
