package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import projectCar.CarService; // Импорт соответствует структуре папок

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CarServiceTest {
    private CarService service;

    @Before
    public void setUp() throws IOException {
        service = new CarService("Cars.txt"); // Убедитесь, что файл "Cars.txt" существует в корне проекта
    }

    @Test
    public void testGetDistinctBrands() {
        Set<String> brands = service.getDistinctBrands();
        Assert.assertNotNull(brands);
        Assert.assertFalse(brands.isEmpty());
    }

    @Test
    public void testGetModelsForBrand() {
        List<String> toyotaModels = service.getModelsForBrand("Toyota");
        Assert.assertNotNull(toyotaModels);
        Assert.assertFalse(toyotaModels.isEmpty());
        Assert.assertTrue(toyotaModels.contains("Camry"));
    }

    @Test
    public void testGetBrandCounts() {
        Map<String, Integer> brandCountMap = service.getBrandCounts();
        Assert.assertNotNull(brandCountMap);
        Assert.assertFalse(brandCountMap.isEmpty());
    }
}
