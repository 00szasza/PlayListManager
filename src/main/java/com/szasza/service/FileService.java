package com.szasza.service;

import java.io.File;
import java.util.List;

/**
 * Created by szasza on 2016. 02. 13..
 */
public interface FileService
{
    List<File> getFileList( String directory, List<String> extensions );
}
