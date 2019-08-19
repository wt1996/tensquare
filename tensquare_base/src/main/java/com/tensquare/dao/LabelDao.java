package com.tensquare.dao;

import com.tensquare.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @ClassName LabelDao
 * @Auth 桃子
 * @Date 2019-8-19 14:53
 * @Version 1.0
 * @Description
 **/
public interface LabelDao extends JpaRepository<Label,String> , JpaSpecificationExecutor<Label> {

}
