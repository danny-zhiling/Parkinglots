import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 51ibm
 * Date: 12-12-2
 * Time: 下午2:50
 * To change this template use File | Settings | File Templates.
 */
public class SmartChooseParkPlaceMethod implements IChooseParkPlaceMethod {

    @Override
    public ParkPlace ChooseParkPlace(List<ParkPlace> ParkPlaces) {
        ParkPlace maxnumberpalce = null;
        for (ParkPlace PP : ParkPlaces)
        {
            if(maxnumberpalce == null)
            {
                maxnumberpalce =  PP;
            }
            else
            {
                maxnumberpalce=maxnumberpalce.GetAvailableNum()< PP.GetAvailableNum()?PP:maxnumberpalce;
            }
        }
        if(maxnumberpalce.GetAvailableNum() != 0)
        {
            return maxnumberpalce  ;
        }
        throw new NoPlaceException("没有停车位了！");
    }
}
