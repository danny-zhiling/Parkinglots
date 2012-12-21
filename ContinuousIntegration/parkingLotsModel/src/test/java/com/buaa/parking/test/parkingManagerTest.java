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
public class parkingManagerTest {
    ParkingManager PM ;

    @Before
    public void Init() {
        ArrayList<ParkPlace>  AL = new   ArrayList<ParkPlace>();
        ArrayList<ParkingBoy>  ALParkingBoy = new   ArrayList<ParkingBoy>();
        PM = new ParkingManager();
        for(int i=0;i<2;i++)
        {
            ParkingBoy PB = new  ParkingBoy();
            ALParkingBoy.add(PB);
            PM.AddParkingBoy(PB);
        }

        for(int i=0;i<6;i++)
        {
            ParkPlace PP = new ParkPlace(2);
            PM.AddParkPlace(PP);
            ALParkingBoy.get(i%2).AddParkPlace(PP);
        }

    }

    @Test
    public void ParkingManager_Parking_HavePlace()  {
        Ticket proof =  PM.parking(new Car());
        Assert.assertNotNull(proof);
    }
    @Test
    public void ParkingManager_GetReport()  {
        Ticket proof =  PM.parking(new Car());

        List<String> Reports = PM.GetReport();
        for(String s:Reports)System.out.println(s);
        //根据行数确定报告格式正确
        int Count = 0;
        for(ParkingBoy PB : PM.GetAllParkingBoy())
        {
            Count +=1;
            Count += PB.GetAllParkPlace().size()*3+2;
        }
        Count +=2;
        Assert.assertTrue(Reports.size() ==Count );
    }
}
