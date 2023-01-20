import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    Predator predator = Mockito.mock(Feline.class);
    private final Cat CAT = new Cat((Feline) predator);

    @Test
    public void getSoundTest() {
        Assert.assertEquals("Неправильный звук кошки", "Мяу", CAT.getSound());
    }

    @Test
    public void getFoodTest() {
        try {
            CAT.getFood();
            Mockito.verify(predator, Mockito.times(1)).eatMeat();
        } catch (Exception e) {
            Assert.fail("Выбросило исключение: " + e.getMessage());
        }

    }
}
