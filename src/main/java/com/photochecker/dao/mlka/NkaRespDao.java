package com.photochecker.dao.mlka;

import com.photochecker.dao.GenericDao;
import com.photochecker.model.common.User;
import com.photochecker.model.mlka.NkaResp;

import javax.transaction.Transactional;
import java.util.List;

public interface NkaRespDao extends GenericDao<NkaResp> {

    List<NkaResp> findAllByUser(User user);
}
