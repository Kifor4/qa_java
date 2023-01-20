import com.example.AlexLion;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AlexLionTest {

    @Mock
    Feline feline;

    private final AlexLion ALEX;

    {
        try {
            ALEX = new AlexLion(feline);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void getKittensTest() {
        Assert.assertEquals("Алекс не предохранялся", 0, ALEX.getKittens());
    }

    @Test
    public void getFriendsTest() {
        Assert.assertEquals("Что-то с друзьями", List.of("Марти", "Глория", "Мелман"), ALEX.getFriends());
    }

    @Test
    public void getPlaceOfLivingTest() {
        Assert.assertEquals( "Алекс сбежал!","Нью-Йоркский зоопарк", ALEX.getPlaceOfLiving());
    }
}
