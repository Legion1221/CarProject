package projectCar;

import java.util.ArrayList;
import java.util.List;

public class DealerCenter {
    private String centerName;
    private List<CarDTO> carList;

    public DealerCenter(String centerName) {
        this.centerName = centerName;
        this.carList = new ArrayList<>();
    }

    public String getCenterName() {
        return centerName;
    }

    public List<CarDTO> getCarList() {
        return carList;
    }

    public void addCar(CarDTO car) {
        carList.add(car);
    }

    @Override
    public String toString() {
        return "DealerCenter{centerName='" + centerName + '\'' + ", cars=" + carList + '}';
    }
}
