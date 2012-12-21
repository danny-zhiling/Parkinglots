import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 51ibm
 * Date: 12-12-16
 * Time: 下午1:19
 * To change this template use File | Settings | File Templates.
 */
public class ParkingDirector implements IReportState,IParkPlaceManager  {
    ArrayList<ParkingManager> ParkingParkingManagers = new ArrayList<ParkingManager>();
    protected List< ParkPlace> ParkPlaces = new ArrayList<ParkPlace>();
    private ICodeNumGenrator  ParkingBoyNumGenrator = new DefaultCodeNumGenerator();
    public ParkingDirector() {

}
    public void AddParkingManager(ParkingManager PM) {
        ParkingParkingManagers.add(PM) ;
    }

    public List<ParkingManager> GetAllParkingManager() {
        return ParkingParkingManagers;
    }

    @Override
    public void AddParkPlace(ParkPlace PP) {
        ParkPlaces.add(PP);
    }

    @Override
    public List<ParkPlace> GetAllParkPlace() {
        return ParkPlaces;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<String> GetReport() {
        List<String> resultReport=new ArrayList<String>();
        int TotalCarNum = 0;
        int TotalAvailableCarNum = 0;

        for(ParkingManager PB :this.ParkingParkingManagers )
        {
            String NumString=ParkingBoyNumGenrator.GetCodeNum(PB);
            resultReport.add("经理编号："+NumString) ;
            for(String Report :PB.GetReport())
            {
                resultReport.add("    "+Report);
            }

        }
        for(ParkPlace PP :this.GetAllParkPlace() )
        {
            TotalCarNum+=  PP.getMaxParkingNum();
            TotalAvailableCarNum+=  PP.GetAvailableNum();
        }
        resultReport.add("Total车位数："+TotalCarNum) ;
        resultReport.add("Total空位数："+TotalAvailableCarNum) ;
        return  resultReport;
    }
}
