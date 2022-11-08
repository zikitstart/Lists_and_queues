package transport;

import java.util.ArrayDeque;
import java.util.Queue;

public class ServiceStation {

    private Queue<Transport> queue = new ArrayDeque<>();

    private void add(Transport transport) {
        queue.offer(transport);
    }
    public void addCarToTheQueue(Car car) {
        add(car);
    }
    public void addTruckToTheQueue(Truck truck) {
        add(truck);
    }
    public void technicalInspectionCar() {
        if (!queue.isEmpty()){
            Transport transport = queue.poll();
            transport.repair();
        }
    }

}
