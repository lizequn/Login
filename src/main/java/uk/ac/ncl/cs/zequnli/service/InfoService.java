package uk.ac.ncl.cs.zequnli.service;

import uk.ac.ncl.cs.zequnli.model.Info;

import java.util.List;

/**
 * @Auther: Li Zequn
 * Date: 12/12/13
 */
public interface InfoService {
    void addInfo(Info info);
    List<Info> getAllInfo();
}
