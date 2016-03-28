package com.szasza.data;

import java.io.Serializable;

/**
 * Created by szasza on 2016. 02. 14..
 */
public class FileData implements Serializable {

    private Integer id;
    private String name;
    private String path;

    public Integer getId() { return this.id; }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return new StringBuffer(" Name : ")
                .append(this.name)
                .append(" path : ")
                .append(this.path)
                .append(" id : ")
                .append(this.id).toString();
    }
}
