package com.photochecker.service.common.daoImpl;

import com.photochecker.dao.common.FormatTypeDao;
import com.photochecker.model.common.FormatType;
import com.photochecker.service.common.FormatTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormatTypeServiceDaoImpl implements FormatTypeService {

    @Autowired
    private FormatTypeDao formatTypeDao;


    @Override
    public List<FormatType> getAllFormats() {
        return formatTypeDao.findAll();
    }
}
