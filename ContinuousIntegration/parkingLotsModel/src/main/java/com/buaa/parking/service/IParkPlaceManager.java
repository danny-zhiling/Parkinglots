package com.buaa.parking.service;

import com.buaa.parking.entity.ParkPlace;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 51ibm
 * Date: 12-12-16
 * Time: 下午11:51
 * To change this template use File | Settings | File Templates.
 */
public interface IParkPlaceManager {
    void AddParkPlace(ParkPlace PP);

    List<ParkPlace> GetAllParkPlace();
}
