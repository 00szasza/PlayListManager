package com.szasza.controller;

import com.szasza.data.PlayList;
import com.szasza.service.LocalSharedDataService;
import com.szasza.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;

/**
 * Created by szasza on 2015. 11. 29..
 */

@Controller
public class PlayListController {

    private PlayListService playListService;

    private LocalSharedDataService localSharedDataService;

    @Autowired
    public void setPlayListService( PlayListService playListService )
    {
        this.playListService = playListService;
    }

    @Autowired
    public void setLocalSharedDataService(LocalSharedDataService localSharedDataService) { this.localSharedDataService = localSharedDataService; }

    @RequestMapping(value = "/playlist", method = RequestMethod.GET )
    public String refresh(Model model)
    {

        PlayList playList = new PlayList();
        playList.setAvailable( this.getAvailableList());
        playList.setReleased(this.getReleasedList());
        playList.setDeleted( this.getDeletedList());

        this.localSharedDataService.saveData(playList);
        model.addAttribute("availablefiles", this.playListService.getAvailableList() );
        model.addAttribute("releasedfiles", this.playListService.getReleasedList() );
        model.addAttribute("deletedfiles", this.playListService.getDeletedList() );
        return "playlist";
    }

    @RequestMapping(value = "add/available", method = RequestMethod.POST)
    public String addToAvailable(File file)
    {
        return "redirect:/playlist";
    }

    @RequestMapping(value = "add/managed", method = RequestMethod.POST)
    public String addToManaged(File file)
    {
        return "redirect:/playlist";
    }
}
