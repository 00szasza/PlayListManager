package com.szasza.service;

/**
 * Created by szasza on 2016. 02. 14..
 */
public interface LocalSharedDataService {

    Object getData();
    void saveData( Object obj );
}
