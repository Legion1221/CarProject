package projectCar;

import java.io.IOException;
import java.util.*;

public class CarService {
    private List<projectCar.CarModelDTO> models;
    private Random rand;

    public CarService(String path) throws IOException {
        this.models = projectCar.CarModelDTO.loadFromFile(path);
        this.rand = new Random();
    }

    public Set<String> getDistinctBrands() {
        Set<String> brands = new HashSet<>();
        for (projectCar.CarModelDTO model : models) {
            brands.add(model.getBrand());
        }
        return brands;
    }

    public List<String> getModelsForBrand(String brand) {
        List<String> result = new ArrayList<>();
        models.stream()
                .filter(model -> model.getBrand().equalsIgnoreCase(brand))
                .forEach(model -> result.add(model.getModel()));
        return result;
    }

    public Map<String, Integer> getBrandCounts() {
        Map<String, Integer> brandCountMap = new HashMap<>();
        models.forEach(model -> brandCountMap.merge(model.getBrand(), 1, Integer::sum));
        return brandCountMap;
    }

    public List<CarDTO> createCars(DealerCenter center, int quantity) {
        List<CarDTO> carList = new ArrayList<>();
        String[] statuses = {"Не занят", "В пути", "В наличии", "Продан", "Забронирован"};
        String[] configs = {"Базовая", "Средняя", "Максимальная"};
        String[] carColors = {"Красный", "Синий", "Черный", "Белый", "Серый"};

        for (int i = 0; i < quantity; i++) {
            String carId = "CAR" + (i + 1);
            CarModelDTO model = models.get(rand.nextInt(models.size()));
            String status = statuses[rand.nextInt(statuses.length)];
            String config = configs[rand.nextInt(configs.length)];
            String color = carColors[rand.nextInt(carColors.length)];
            double price = 20000 + rand.nextDouble() * 30000;

            CarDTO car = new CarDTO(carId, model, center, status, config, color, price);
            carList.add(car);
            center.addCar(car);
        }
        return carList;
    }

    public long timeExecution(Runnable task) {
        long start = System.currentTimeMillis();
        task.run();
        return System.currentTimeMillis() - start;
    }


    public static class Main {
        public static void main(String[] args) {
            try {
                CarService service = new CarService("Cars.txt");
                DealerCenter center = new DealerCenter("Auto Dealer");

                long execTime = service.timeExecution(() -> {
                    service.createCars(center, 10);
                });

                System.out.println("Generated cars in " + execTime + " ms");
                System.out.println(center);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
