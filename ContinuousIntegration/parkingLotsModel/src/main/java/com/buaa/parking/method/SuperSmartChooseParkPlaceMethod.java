package com.buaa.parking.method;

import com.buaa.parking.bizexception.NoPlaceException;
import com.buaa.parking.entity.ParkPlace;
import com.buaa.parking.service.IChooseParkPlaceMethod;


import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 51ibm
 * Date: 12-12-2
 * Time: 下午3:54
 * To change this template use File | Settings | File Templates.
 */
public class SuperSmartChooseParkPlaceMethod implements IChooseParkPlaceMethod {
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
                maxnumberpalce=maxnumberpalce.GetAvailableNum()/ maxnumberpalce.getMaxParkingNum()
                        < PP.GetAvailableNum()/ PP.getMaxParkingNum()?PP:maxnumberpalce;
            }
        }
        if(maxnumberpalce.GetAvailableNum() != 0)
        {
            return maxnumberpalce  ;
        }
        throw new NoPlaceException("没有停车位了！");
    }
}
