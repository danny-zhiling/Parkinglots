package com.buaa.parking.entity;

import com.buaa.parking.bizexception.NoCarException;
import com.buaa.parking.method.DefaultChooseParkPlacMethod;
import com.buaa.parking.method.DefaultCodeNumGenerator;
import com.buaa.parking.service.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 51ibm
 * Date: 12-11-25
 * Time: 下午4:39
 * To change this template use File | Settings | File Templates.
 */
public class ParkingBoy implements IParking, IReportState,IParkPlaceManager {
    protected List< ParkPlace> ParkPlaces = new ArrayList<ParkPlace>();
    private IChooseParkPlaceMethod ChooseParkPlaceMethodObj = new DefaultChooseParkPlacMethod() ;
    private ICodeNumGenrator ParkPlaceGenrator = new DefaultCodeNumGenerator();

    public ParkingBoy()
    {

    }
    public ParkingBoy(List<ParkPlace> PPs) {
        ParkPlaces =  PPs;
    }
    public void SetICodeNumGenrator(ICodeNumGenrator GenratorObj) {
        this.ParkPlaceGenrator = GenratorObj;
    }

    @Override
    public void AddParkPlace(ParkPlace PP)
    {
        ParkPlaces.add(PP);
    }
    @Override
    public List<ParkPlace> GetAllParkPlace() {
        return this.ParkPlaces;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Ticket parking(Car c)
    {
        return  ChooseParkPlaceMethodObj.ChooseParkPlace(ParkPlaces).parking(c) ;
    }

    @Override
    public Car getCar(Ticket proof) {
        for (ParkPlace PP : ParkPlaces)
        {
            if(PP.HaveCar(proof))
            {
                return PP.GetParkedCar(proof);
            }
        }
        throw new NoCarException("没有此车 请拨打110！");
    }

    @Override
    public void SetIChooseParkPlaceMethod(IChooseParkPlaceMethod smartChooseParkPlaceMethod) {
        this.ChooseParkPlaceMethodObj = smartChooseParkPlaceMethod;
    }

    @Override
    public  List<String>  GetReport()
    {
        List<String> resultReport=new ArrayList<String>();
        int TotalCarNum = 0;
        int TotalAvailableCarNum = 0;
          for(ParkPlace PP : ParkPlaces)
          {
              String NumString=ParkPlaceGenrator.GetCodeNum(PP);
              resultReport.add("停车场编号："+NumString) ;
              resultReport.add("    车位数："+PP.getMaxParkingNum()) ;
              resultReport.add("    空位数："+PP.GetAvailableNum()) ;
              TotalCarNum+=  PP.getMaxParkingNum();
              TotalAvailableCarNum+=  PP.GetAvailableNum();
          }
        resultReport.add("Total车位数："+TotalCarNum) ;
        resultReport.add("Total空位数："+TotalAvailableCarNum) ;
        return  resultReport;
    }
}
