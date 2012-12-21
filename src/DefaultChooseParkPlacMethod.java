import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 51ibm
 * Date: 12-12-2
 * Time: 下午2:37
 * To change this template use File | Settings | File Templates.
 */
public class DefaultChooseParkPlacMethod implements IChooseParkPlaceMethod {
    @Override
    public ParkPlace ChooseParkPlace(List<ParkPlace> ParkPlaces) {
        for (ParkPlace PP : ParkPlaces)
        {
            if(PP.GetAvailableNum() != 0)
            {
                return PP;
            }
        }
        throw new NoPlaceException("没有停车位了！");
    }
}
