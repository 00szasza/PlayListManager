package com.szasza.service;

import com.szasza.data.FileData;
import com.szasza.data.PlayList;

import java.io.File;
import java.util.List;

/**
 * Created by szasza on 2016. 02. 14..
 */
public interface PlayListService {
    
    void saveAvailableList( List<FileData> available);

    List<FileData> getAvailableList( );

    void saveReleasedList( List<FileData> released);

    List<FileData> getReleasedList( );

    void saveDeletedList(List<FileData> deleted);

    List<FileData> getDeletedList();

    void update(List<File> fileList, PlayList playList);
}
