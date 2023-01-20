import com.example.Feline;
import com.example.Lion;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@RunWith(JUnitParamsRunner.class)
public class LionTest {

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Mock
    Feline feline;

    @Test
    public void getKittensTest() {
        try {
            Lion lion = new Lion("Самец", feline);
            lion.getKittens();
            Mockito.verify(feline).getKittens();
        } catch (Exception e) {
            Assert.fail("Выбросило исключение: " + e.getMessage());
        }

    }

    @Test
    public void getFoodTest() {
        try {
            Lion lion = new Lion("Самец", feline);
            lion.getFood();
            Mockito.verify(feline).getFood("Хищник");
        } catch (Exception e) {
            Assert.fail("Выбросило исключение: " + e.getMessage());
        }
    }

    @Test
    @Parameters({"Самец, true", "Самка, false", "гендерно-независимый лев, false"})
    public void doesHaveManeTest(String sex, boolean hasMane) {
        try {
            Lion lion = new Lion(sex, feline);
            Assert.assertEquals("Неожиданный результат для пола: " + sex, hasMane, lion.doesHaveMane());
        } catch (Exception e) {
            Assert.assertEquals("Исключение выбросило, при поле: " + sex,"гендерно-независимый лев", sex);
            Assert.assertEquals("Неожидаемая ошибка","Используйте допустимые значения пола животного - самей или самка", e.getMessage());
        }
    }

}
