package com.tensquare.service;

import com.tensquare.dao.EnterpriseDao;
import com.tensquare.pojo.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @ClassName EnterpriseService
 * @Auth 桃子
 * @Date 2019-8-20 15:02
 * @Version 1.0
 * @Description
 **/
@Service
@Transactional
public class EnterpriseService {

    @Autowired
    private EnterpriseDao enterpriseDao;
    /**
     * 热门企业列表
     * @return
     */
    public List<Enterprise> hotlist(){
        return this.enterpriseDao.findByIshot("1");
    }
}
