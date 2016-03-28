package com.szasza.repositories;

import com.szasza.data.FileData;

import java.util.List;

/**
 * Created by szasza on 2016. 02. 14..
 */
public interface FilesRepository {

    List<FileData> getFileList();

    void setFileList( List<FileData> fileList);

    void add(FileData fileData);
}
