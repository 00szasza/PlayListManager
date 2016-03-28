package com.szasza;

import com.szasza.data.FileData;
import com.szasza.data.PlayList;
import com.szasza.repositories.FilesRepository;
import com.szasza.service.LocalSharedDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by szasza on 2016. 02. 14..
 */

@Component
public class LoadPlayList implements ApplicationListener<ContextRefreshedEvent> {

    private FilesRepository availableFilesRepository;
    private FilesRepository releasedFilesRepository;
    private FilesRepository deletedFilesRepository;

    private LocalSharedDataService localFileDataService;

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

    @Autowired
    public void setLocalFileDataService(LocalSharedDataService localFileDataService) {
        this.localFileDataService = localFileDataService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        PlayList playList = ( PlayList ) this.localFileDataService.getData();

        if ( playList == null )
        {
            playList = new PlayList();
            playList.setAvailable( new ArrayList<FileData>() );
            playList.setReleased( new ArrayList<FileData>() );
            playList.setDeleted( new ArrayList<FileData>() );
        }

        this.availableFilesRepository.setFileList( playList.getAvailable() );
        this.releasedFilesRepository.setFileList( playList.getReleased() );
        this.deletedFilesRepository.setFileList(playList.getDeleted());
    }
}
