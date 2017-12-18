package com.photochecker.dao.common;

import com.photochecker.dao.GenericDao;
import com.photochecker.model.common.ReportType;
import com.photochecker.model.common.User;

import javax.transaction.Transactional;
import java.util.List;


public interface ReportTypeDao extends GenericDao<ReportType> {

    List<ReportType> findAllByUser(User user);
}
