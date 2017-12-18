package com.photochecker.dao.common;

import com.photochecker.dao.GenericDao;
import com.photochecker.model.common.Responsibility;
import com.photochecker.model.common.User;

import javax.transaction.Transactional;
import java.util.List;


public interface ResponsibilityDao extends GenericDao<Responsibility> {

    List<Responsibility> findAllByUser(User user);
}