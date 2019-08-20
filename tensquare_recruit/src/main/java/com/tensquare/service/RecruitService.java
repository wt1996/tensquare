package com.tensquare.service;

import com.tensquare.dao.RecruitDao;
import com.tensquare.pojo.Recruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @ClassName RecruitService
 * @Auth 桃子
 * @Date 2019-8-20 16:55
 * @Version 1.0
 * @Description
 **/
@Service
@Transactional
public class RecruitService {

    @Autowired
    private RecruitDao recruitDao;

    /**
     * 根据状态查询
     * @param state
     * @return
     */
    public List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state){
        return recruitDao.findTop4ByStateOrderByCreatetimeDesc(state);
    }

    public List<Recruit> newlist() {
        return recruitDao.findTop12ByStateNotOrderByCreatetimeDesc("0");
    }
}
