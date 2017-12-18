package com.photochecker.dao.nka;

import com.photochecker.dao.GenericDao;
import com.photochecker.model.nka.NkaTma;

import javax.transaction.Transactional;
import java.util.List;

public interface NkaTmaDao extends GenericDao<NkaTma> {

    void clearAll();

    List<NkaTma> findAllByNkaAndFormat(int nkaId, int formatId);
}
