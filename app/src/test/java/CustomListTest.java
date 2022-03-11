import com.example.simpleparadox.listycity.City;
import com.example.simpleparadox.listycity.CustomList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    @BeforeEach
    public void createList() {
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void addCityTest() {
        int listSize = list.getCount();
        list.addCity(new City("Edmonton", "AB"));
        assertEquals(listSize+1, list.getCount());
    }

    @Test
    public void deleteTest() {
        City city = new City("Toronto", "ON");
        list.addCity(city);
        list.delete(city);
        assertEquals(0, list.getCount());
    }

    @Test
    public void deleteExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            list.delete(new City("Regina", "SK"));
        });
    }

    @Test
    public void hasCityTest() {
        City city = new City("Edmonton", "AB");
        list.addCity(city);
        assertTrue(list.hasCity(city));
        assertFalse(list.hasCity(new City("Vancouver", "BC")));
    }
}
