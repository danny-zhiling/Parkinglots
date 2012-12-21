/**
 * Created with IntelliJ IDEA.
 * User: 51ibm
 * Date: 12-12-16
 * Time: 下午3:26
 * To change this template use File | Settings | File Templates.
 */
public interface IParking {

    Ticket parking(Car c);

    Car getCar(Ticket proof);

    void SetIChooseParkPlaceMethod(IChooseParkPlaceMethod smartChooseParkPlaceMethod);
}
