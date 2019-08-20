package com.tensquare.dao;

import com.tensquare.pojo.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @ClassName RecruitDao
 * @Auth 桃子
 * @Date 2019-8-20 16:55
 * @Version 1.0
 **/
public interface RecruitDao extends JpaRepository<Recruit,String>, JpaSpecificationExecutor<Recruit> {
    /**
     * 查询最新职位列表(按创建日期降序排序)
     * @return
     */
    public List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state);

    List<Recruit> findTop12ByStateNotOrderByCreatetimeDesc(String state);
}
