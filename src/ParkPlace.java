import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: 51ibm
 * Date: 12-11-11
 * Time: 下午3:26
 * To change this template use File | Settings | File Templates.
 */
public class ParkPlace {

    private Map<Ticket, Car> parkedCarList = new HashMap<Ticket, Car>();

    public Integer getMaxParkingNum() {
        return MaxParkingNum;
    }

    private Integer MaxParkingNum = 20;

    public ParkPlace(int maxParkingNum) {
        MaxParkingNum = maxParkingNum;
    }

    public Integer GetAvailableNum() {
        return MaxParkingNum - parkedCarList.size();
    }

    public Ticket parking(Car c) throws NoPlaceException {
        if (this.GetAvailableNum() == 0) {
            throw new NoPlaceException("没有停车位了！");
        }
        Ticket PP = new Ticket();
        synchronized (parkedCarList) {
            parkedCarList.put(PP, c);
        }
        return PP;
    }

    public Car GetParkedCar(Ticket pp) throws NoCarException {
        if (parkedCarList.size() == 0) {
            throw new NoCarException("车库无车！");
        }
        if (parkedCarList.containsKey(pp)) {
            Car car = parkedCarList.get(pp);
            synchronized (parkedCarList) {
                parkedCarList.remove(pp);
            }
            return car;
        }
        throw new NoCarException("没有此车 请拨打110！");
    }

    public boolean HaveCar(Ticket pp)
    {
        if (parkedCarList.size() == 0) {
            throw new NoCarException("车库无车！");
        }
        return  parkedCarList.containsKey(pp);
    }
}
