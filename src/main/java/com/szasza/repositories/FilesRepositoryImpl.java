package com.szasza.repositories;

import com.szasza.data.FileData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by szasza on 2016. 02. 14..
 */
public class FilesRepositoryImpl implements FilesRepository {

    private  List<FileData> fileList;

    public  List<FileData> getFileList() {
        return this.fileList;
    }

    public void setFileList( List<FileData> fileList) {
        this.fileList = fileList;
    }

    @Override
    public void add(FileData fileData) {

        if( fileList != null)
        {
            fileList.add(fileData.getId(),fileData);
        }
    }
}
