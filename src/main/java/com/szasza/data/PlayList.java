package com.szasza.data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by szasza on 2016. 02. 14..
 */

public class PlayList implements Serializable {


    private List<FileData> available;
    private List<FileData> released;
    private List<FileData> deleted;

    public  List<FileData> getAvailable() { return this.available; }

    public void setAvailable( List<FileData> available)
    {
        this.available = available;
    }

    public  List<FileData> getReleased() { return this.released; }

    public void setReleased( List<FileData> released)
    {
        this.released = released;
    }

    public  List<FileData> getDeleted() { return this.deleted; }

    public void setDeleted( List<FileData> deleted)
    {
        this.deleted = deleted;
    }


}
