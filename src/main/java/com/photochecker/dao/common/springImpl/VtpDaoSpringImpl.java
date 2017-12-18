package com.photochecker.dao.common.springImpl;

import com.photochecker.dao.common.VtpDao;
import com.photochecker.model.common.Vtp;

import java.util.List;

public class VtpDaoSpringImpl implements VtpDao {

    @Override
    public int save(Vtp vtp) {
        return 0;
    }

    @Override
    public Vtp find(int id) {
        return null;
    }

    @Override
    public List<Vtp> findAll() {
        return null;
    }

    @Override
    public boolean update(Vtp vtp) {
        return false;
    }

    @Override
    public void remove(Vtp vtp) {

    }
}
