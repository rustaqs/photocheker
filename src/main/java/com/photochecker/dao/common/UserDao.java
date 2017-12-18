package com.photochecker.dao.common;

import com.photochecker.dao.GenericDao;
import com.photochecker.model.common.User;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

public interface UserDao extends GenericDao<User> {

    List<User> findAllByLogin(String login);

    User checkLoginAndPassword(String login, String password);

    int saveNewUser(User user, String password, String salt);

    void saveUserReports(User user);
}
