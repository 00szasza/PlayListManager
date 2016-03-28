package com.szasza.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by szasza on 2016. 02. 12..
 */
public class FileUtil {

    public static String identifyFileType(final String fileName)
    {
        String fileType = "Undetermined";
        final File file = new File(fileName);
        try
        {
            fileType = Files.probeContentType(file.toPath());
        }
        catch (IOException ioException)
        {
            System.out.println(
                    "ERROR: Unable to determine file type for " + fileName
                            + " due to exception " + ioException);
        }
        return fileType;
    }

    public static String getFileExtension( String fileName )
    {

        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        else
        {
            return "";
        }
    }
}
