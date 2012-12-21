package com.buaa.parking.test;

import com.buaa.parking.entity.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 51ibm
 * Date: 12-12-16
 * Time: 下午1:14
 * To change this template use File | Settings | File Templates.
 */
public class parkingDirectorTest {
    ParkingDirector PD ;
    ArrayList<ParkPlace>  AL = new   ArrayList<ParkPlace>();
    ArrayList<ParkingBoy>  ALParkingBoy = new   ArrayList<ParkingBoy>();
    ArrayList<ParkingManager>  ALParkingManager = new   ArrayList<ParkingManager>();
    @Before
    public void Init() {

        PD = new ParkingDirector();
        //添加2个项目经理
        for(int i=0;i<2;i++)
        {
            ParkingManager PM = new  ParkingManager();
            ALParkingManager.add(PM);
            PD.AddParkingManager(PM);
        }
        //添加5个ParkBoy
        for(int i=0;i<5;i++)
        {
            ParkingBoy PB = new  ParkingBoy();
            ALParkingBoy.add(PB);
            ALParkingManager.get(i%2).AddParkingBoy(PB);
        }
        //添加10个停车场
        for(int i=0;i<10;i++)
        {
            ParkPlace PP = new ParkPlace(3);
            PD.AddParkPlace(PP);
            ParkingManager PM = ALParkingManager.get(i % 2) ;
            PM .AddParkPlace(PP);
            ParkingBoy PB = PM.GetAllParkingBoy().get(PM.GetAllParkPlace().size() % PM.GetAllParkingBoy().size()) ;
            PB.AddParkPlace(PP);
        }
    }
    @Test
    public void ParkingManager_GetReport()  {
        Ticket proof =  ALParkingManager.get(0) .parking(new Car());

        ALParkingManager.get(1).GetAllParkingBoy().get(1).parking(new Car());

        List<String> Reports = PD.GetReport();
        for(String s:Reports)System.out.println(s);
        //根据行数确定报告格式正确
        int Count = 0;
        for(ParkingManager PM : PD.GetAllParkingManager())
        {
            Count +=1;
            Count += PM.GetReport().size();
        }
        Count +=2;
        Assert.assertTrue(Reports.size() ==Count );
    }
}
