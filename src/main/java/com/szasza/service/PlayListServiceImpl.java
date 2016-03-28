package com.szasza.service;

import com.szasza.data.FileData;
import com.szasza.data.PlayList;
import com.szasza.repositories.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * Created by szasza on 2016. 02. 14..
 */
@Service
public class PlayListServiceImpl implements PlayListService {

    private FilesRepository availableFilesRepository;
    private FilesRepository releasedFilesRepository;
    private FilesRepository deletedFilesRepository;

    @Autowired
    public void setAvailableFilesRepository(FilesRepository availableFilesRepository) {
        this.availableFilesRepository = availableFilesRepository;
    }

    @Autowired
    public void setReleasedFilesRepository(FilesRepository releasedFilesRepository) {
        this.releasedFilesRepository = releasedFilesRepository;
    }

    @Autowired
    public void setDeletedFilesRepository(FilesRepository deletedFilesRepository) {
        this.deletedFilesRepository = deletedFilesRepository;
    }

    @Override
    public void saveAvailableList( List<FileData> available)
    {
        this.availableFilesRepository.setFileList( available );
    }

    @Override
    public void saveReleasedList( List<FileData> released)
    {
        this.releasedFilesRepository.setFileList( released );
    }

    @Override
    public void saveDeletedList(List<FileData> deleted)
    {
        this.deletedFilesRepository.setFileList( deleted );
    }

    @Override
    public  List<FileData> getAvailableList( )
    {
        return this.availableFilesRepository.getFileList();
    }

    @Override
    public  List<FileData> getReleasedList( )
    {
       return this.releasedFilesRepository.getFileList();
    }

    @Override
    public  List<FileData> getDeletedList()
    {
       return this.deletedFilesRepository.getFileList();
    }

    @Override
    public void update(List<File> fileList, PlayList playList) {

        for ( int i =0 ; i< fileList.size(); i++ )
        {
            File file = fileList.get(i);
            FileData fileData = new FileData();
            fileData.setName( file.getName() );
            fileData.setPath( file.getPath() );
            fileData.setId(i);

           // this.addToAvailableList(fileData);
        }

       // this.saveAll();
    }

    public void addToAvailableList( FileData fileData )
    {
        this.availableFilesRepository.add( fileData );
    }

    public void saveAll()
    {
    }
}
