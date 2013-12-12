package uk.ac.ncl.cs.zequnli.dao;

import uk.ac.ncl.cs.zequnli.model.Info;

import java.util.List;

/**
 * @Auther: Li Zequn
 * Date: 12/12/13
 */
public interface InfoDao {
    List<Info> getAll();
    void addInfo(Info info);
}
