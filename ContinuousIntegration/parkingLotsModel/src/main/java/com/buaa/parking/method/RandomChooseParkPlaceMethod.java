package com.buaa.parking.method;

import com.buaa.parking.bizexception.NoPlaceException;
import com.buaa.parking.entity.ParkPlace;
import com.buaa.parking.service.IChooseParkPlaceMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 51ibm
 * Date: 12-12-2
 * Time: 下午2:50
 * To change this template use File | Settings | File Templates.
 */
public class RandomChooseParkPlaceMethod implements IChooseParkPlaceMethod {

    @Override
    public ParkPlace ChooseParkPlace(List<ParkPlace> ParkPlaces) {
        List<ParkPlace> availablepalces = new ArrayList<ParkPlace>();
        for (ParkPlace PP : ParkPlaces)
        {
            if( PP.GetAvailableNum() > 0)
            {
                availablepalces.add(PP) ;
            }
        }
        if(availablepalces.size() ==0)
        {
            throw new NoPlaceException("没有停车位了！");
        }
        int index = availablepalces.size();
        index = (int)(Math.random()*index);
        return availablepalces.get( index ==  availablepalces.size()? 0:index)  ;
    }
}
