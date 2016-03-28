package com.szasza.controller;

import com.szasza.data.PlayList;
import com.szasza.service.FileService;
import com.szasza.service.LocalSharedDataService;
import com.szasza.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by szasza on 2016. 03. 07..
 */

@Controller
public class IndexController {

    private FileService fileService;

    private LocalSharedDataService localSharedDataService;

    private PlayListService playListService;

    @Autowired
    public void setFileService(FileService fileService) { this.fileService = fileService; }

    @Autowired
    public void setLocalSharedDataService(LocalSharedDataService localSharedDataService) { this.localSharedDataService = localSharedDataService; }

    @Autowired
    public void setPlayListService( PlayListService playListService )
    {
        this.playListService = playListService;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET )
    public String showPlayList(@RequestParam(value="extensions", required = false, defaultValue = "" )ArrayList<String> extensions,
                               @RequestParam(value="directory", required = false, defaultValue = "" )String directory,
                               Model model)
    {
        List<File> fileList =  this.fileService.getFileList( directory,extensions );
        PlayList playList = (PlayList) this.localSharedDataService.getData();

        this.playListService.update( fileList, playList );

        return "redirect:/playlist";
    }
}
