package uk.ac.ncl.cs.zequnli.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.ncl.cs.zequnli.dao.InfoDao;
import uk.ac.ncl.cs.zequnli.model.Info;
import uk.ac.ncl.cs.zequnli.service.InfoService;

import java.util.List;

/**
 * @Auther: Li Zequn
 * Date: 12/12/13
 */
@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    private InfoDao infoDao;
    public void addInfo(Info info) {
        infoDao.addInfo(info);
    }

    public List<Info> getAllInfo() {
        return infoDao.getAll();
    }
}
