package com.buaa.parking.entity;

import com.buaa.parking.method.DefaultCodeNumGenerator;
import com.buaa.parking.method.RandomChooseParkPlaceMethod;
import com.buaa.parking.service.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 51ibm
 * Date: 12-12-16
 * Time: 下午1:19
 * To change this template use File | Settings | File Templates.
 */
public class ParkingManager implements IParking,IReportState,IParkPlaceManager {
    ArrayList<ParkingBoy> ParkingBoys = new ArrayList<ParkingBoy>();
    private ParkingBoy SelfPB = new ParkingBoy();
    private ICodeNumGenrator ParkingBoyNumGenrator = new DefaultCodeNumGenerator();
    public ParkingManager() {
    }
    public ParkingManager(ArrayList<ParkPlace> alPP,ArrayList<ParkingBoy> alPB) {
        SelfPB = new  ParkingBoy(alPP);
        ParkingBoys =  alPB;
        this.SetIChooseParkPlaceMethod(new RandomChooseParkPlaceMethod());
    }
    public void AddParkingBoy(ParkingBoy PB) {
        ParkingBoys.add(PB) ;
    }

    public List<ParkingBoy> GetAllParkingBoy() {
        return ParkingBoys;  //To change body of implemented methods use File | Settings | File Templates.
    }
    @Override
    public void AddParkPlace(ParkPlace PP) {
        SelfPB.AddParkPlace(PP) ;
    }

    @Override
    public List<ParkPlace> GetAllParkPlace() {
        return SelfPB.GetAllParkPlace();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Ticket parking(Car c) {
        return SelfPB.parking(c);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Car getCar(Ticket proof) {
        return SelfPB.getCar(proof);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void SetIChooseParkPlaceMethod(IChooseParkPlaceMethod smartChooseParkPlaceMethod) {
        SelfPB.SetIChooseParkPlaceMethod(smartChooseParkPlaceMethod) ;
    }

    @Override
    public List<String> GetReport() {
        List<String> resultReport=new ArrayList<String>();
        int TotalCarNum = 0;
        int TotalAvailableCarNum = 0;

        for(ParkingBoy PB :this.ParkingBoys )
        {
            String NumString=ParkingBoyNumGenrator.GetCodeNum(PB);
            resultReport.add("停车仔编号："+NumString) ;
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
