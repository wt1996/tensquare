package com.tensquare.dao;

import com.tensquare.pojo.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @ClassName EnterpriseDao
 * @Auth 桃子
 * @Date 2019-8-20 14:49
 * @Version 1.0
 **/
public interface EnterpriseDao extends JpaRepository<Enterprise,String>, JpaSpecificationExecutor<Enterprise> {
    /**
     * 根据热门状态获取企业列表
     * @param ishot
     * @return
     */
    public List<Enterprise> findByIshot(String ishot);
}
