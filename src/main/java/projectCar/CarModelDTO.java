package projectCar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CarModelDTO {

    private final String brand; // Бренд
    private final String model; // Модель
    private final String countryOrigin; // Страна происхождения
    private final String countryCode; // Код страны

    // Конструктор
    public CarModelDTO(String brand, String model, String countryOrigin, String countryCode) {
        this.brand = brand;
        this.model = model;
        this.countryOrigin = countryOrigin;
        this.countryCode = countryCode;
    }

    // Геттеры для всех полей
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public String getCountryCode() {
        return countryCode;
    }

    // Метод для загрузки данных из файла
    public static List<CarModelDTO> loadFromFile(String filePath) throws IOException {
        List<CarModelDTO> carModels = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)))) {
            String line;
            reader.readLine(); // Пропускаем заголовок
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) { // Проверка на количество частей
                    CarModelDTO carModel = new CarModelDTO(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim());
                    carModels.add(carModel);
                }
            }
        }
        return carModels;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s, %s)", brand, model, countryOrigin, countryCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarModelDTO that = (CarModelDTO) o;

        return brand.equals(that.brand) && model.equals(that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model);
    }
}
