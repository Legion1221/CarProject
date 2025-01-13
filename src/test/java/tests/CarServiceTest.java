package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import projectCar.CarService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CarServiceTest {
    private CarService service;

    @BeforeEach
    public void setUp() throws IOException {
        service = new CarService("Cars.txt"); // Убедитесь, что файл "Cars.txt" существует в корне проекта
    }

    @Test
    public void testGetDistinctBrands() {
        Set<String> brands = service.getDistinctBrands();
        Assertions.assertNotNull(brands);
        Assertions.assertFalse(brands.isEmpty());
    }

    @Test
    public void testGetModelsForBrand() {
        List<String> toyotaModels = service.getModelsForBrand("Toyota");
        Assertions.assertNotNull(toyotaModels);
        Assertions.assertFalse(toyotaModels.isEmpty());
        Assertions.assertTrue(toyotaModels.contains("Camry"));
    }

    @Test
    public void testGetBrandCounts() {
        Map<String, Integer> brandCountMap = service.getBrandCounts();
        Assertions.assertNotNull(brandCountMap);
        Assertions.assertFalse(brandCountMap.isEmpty());
    }
}
