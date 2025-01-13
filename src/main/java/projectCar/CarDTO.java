package projectCar;

public class CarDTO {
    private String carId;
    private CarModelDTO model;
    private DealerCenter center;
    private String carCondition;
    private String carConfiguration;
    private String carColor;
    private double carPrice;

    // Конструктор
    public CarDTO(String carId, CarModelDTO model, DealerCenter center, String carCondition, String carConfiguration, String carColor, double carPrice) {
        this.carId = carId;
        this.model = model;
        this.center = center;
        this.carCondition = carCondition;
        this.carConfiguration = carConfiguration;
        this.carColor = carColor;
        this.carPrice = carPrice;
    }

    // Геттеры
    public String getCarId() {
        return carId;
    }

    public CarModelDTO getModel() {
        return model;
    }

    public DealerCenter getCenter() {
        return center;
    }

    public String getCarCondition() {
        return carCondition;
    }

    public String getCarConfiguration() {
        return carConfiguration;
    }

    public String getCarColor() {
        return carColor;
    }

    public double getCarPrice() {
        return carPrice;
    }

    @Override
    public String toString() {
        return String.format("CarDTO{carId='%s', model=%s, center=%s, condition='%s', configuration='%s', color='%s', price=%.2f}",
                carId, model, center.getCenterName(), carCondition, carConfiguration, carColor, carPrice);
    }

}
