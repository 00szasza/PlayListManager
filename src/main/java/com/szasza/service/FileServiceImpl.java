package com.szasza.service;

import com.szasza.util.FileUtil;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Vector;

/**
 * Created by szasza on 2016. 02. 12..
 */

@Service
public class FileServiceImpl implements FileService
{
    public List<File> getFileList( String directory, List<String> extensions )
    {
        File workingDirectory = new File( directory ).getAbsoluteFile();

        return this.findFiles(workingDirectory, new Vector<File>(), extensions);
    }

    private List<File> findFiles( File file, List<File> list, List<String> extensions )
    {
        if( file.isDirectory() )
        {
            File[] files = file.listFiles();

            for( int i=0; i< files.length; i++ )
            {
                this.findFiles(files[i], list, extensions);
            }
        }
        else
        {

            if( extensions != null && extensions.size() > 0 )
            {
                String fileExtension = FileUtil.getFileExtension(file.getName());

                if( extensions.indexOf( fileExtension ) != -1 )
                {
                    list.add( file );
                }
            }
            else
            {
                list.add( file );
            }

        }

        return list;
    }


}
