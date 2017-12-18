package com.photochecker.service.nst.daoImpl;

import com.photochecker.dao.nst.NstOblDao;
import com.photochecker.dao.nst.NstRespDao;
import com.photochecker.dao.nst.NstStatDao;
import com.photochecker.model.common.User;
import com.photochecker.model.nst.NstObl;
import com.photochecker.model.nst.NstResp;
import com.photochecker.model.nst.NstStat;
import com.photochecker.service.nst.NstOblService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NstOblServiceDaoImpl implements NstOblService {

    @Autowired
    private NstOblDao nstOblDao;
    @Autowired
    private NstRespDao nstRespDao;
    @Autowired
    private NstStatDao nstStatDao;

    @Override
    public List<NstObl> getNstObls(User user, LocalDate startDate, LocalDate endDate, int formatId, int repTypeIndex) {
        List<NstObl> allNstObls = nstOblDao.findAllByDates(startDate, endDate, formatId, repTypeIndex);

        if (user.getRole() == 1) {
            List<NstResp> nstRespList = nstRespDao.findAllByUser(user);

            List<NstObl> allowedObls = nstRespList.stream()
                    .filter(nstResp -> nstResp.getNstFormat().getId() == formatId)
                    .map(resp -> resp.getNstObl())
                    .distinct()
                    .collect(Collectors.toList());
            allNstObls.removeIf(nstObl -> !allowedObls.contains(nstObl));
        }

        List<NstStat> nstStats = nstStatDao.getOblListStat(startDate, endDate);

        for (NstObl nstObl : allNstObls) {
            int oblId = nstObl.getId();
            boolean allChecked = nstStats.stream()
                    .filter(nstStat -> nstStat.getFormatId() == formatId)
                    .filter(nstStat -> nstStat.getOblId() == oblId)
                    .anyMatch(nstStat -> nstStat.getOblCount() == nstStat.getOblChecked());
            nstObl.setChecked(allChecked);
        }

        return allNstObls;
    }
}
