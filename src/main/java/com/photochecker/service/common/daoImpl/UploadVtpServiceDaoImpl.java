package com.photochecker.service.common.daoImpl;

import com.photochecker.dao.common.ClientCardVtpDao;
import com.photochecker.model.common.ClientCardVtp;
import com.photochecker.service.common.UploadVtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;

@Service("uploadVtpService")
public class UploadVtpServiceDaoImpl implements UploadVtpService {

    @Autowired
    private ClientCardVtpDao clientCardVtpDao;

    @Override
    public String uploadVtpDatas(BufferedReader reader) {
        try {
            String record = reader.readLine();

                readLkaDatas(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Загрузил!";
    }

    private int readLkaDatas(BufferedReader reader) {

        int recordCounter = 0;

        String record;
        clientCardVtpDao.remove();
        try {
            while ((record = reader.readLine())!=null) {

                String[] recordParts = record.split("; ");
                ClientCardVtp clientCardVtp = new ClientCardVtp(
                        Integer.parseInt(recordParts[0]),
                        recordParts[1],
                        recordParts[2],
                        recordParts[3],
                        recordParts[4],
                        Integer.parseInt(recordParts[5]),
                        recordParts[6],
                        recordParts[7],
                        recordParts[8],
                        recordParts[9],
                        Integer.parseInt(recordParts[10]),
                        recordParts[11],
                        recordParts[12],
                        Integer.parseInt(recordParts[13])
                        );

                clientCardVtpDao.save(clientCardVtp);

                recordCounter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recordCounter;
    }

}
