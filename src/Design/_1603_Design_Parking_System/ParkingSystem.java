package Design._1603_Design_Parking_System;

import java.util.HashMap;
import java.util.Map;

public class ParkingSystem {
    Map<Integer, Integer> map;

    public ParkingSystem(int big, int medium, int small) {
        map = new HashMap<>();
        map.put(1, big);
        map.put(2, medium);
        map.put(3, small);
    }

    public boolean addCar(int carType) {
        int num;
        if ((num = map.get(carType)) > 0) {
            map.put(carType, num - 1);
            return true;
        }
        return false;
    }
}
