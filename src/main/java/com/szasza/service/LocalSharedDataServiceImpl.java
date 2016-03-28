package com.szasza.service;

import org.springframework.stereotype.Service;

import java.io.*;

/**
 * Created by szasza on 2016. 02. 14..
 */
@Service
public class LocalSharedDataServiceImpl implements LocalSharedDataService {

    private ObjectInputStream inputStream = null;
    private String fileName = "file.dat";


    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Object getData()
    {
        Object inputObj = null;

        if( new File( this.fileName ).exists() )
        {
            try
            {
                FileInputStream fileInput = new FileInputStream( this.fileName );
                this.inputStream = new ObjectInputStream( fileInput );

                inputObj = this.inputStream.readObject();
                this.inputStream.close();

            }
            catch (IOException e)
            {
                e.printStackTrace();

            } catch (ClassNotFoundException e)
            {

                e.printStackTrace();
            }
        }

        return inputObj;
    }

    public void saveData( Object obj )
    {
        try
        {
            FileOutputStream fileOutput = new FileOutputStream( this.fileName );
            ObjectOutputStream outputStream = new ObjectOutputStream( fileOutput );
            outputStream.writeObject( obj );
            outputStream.flush();
            outputStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
