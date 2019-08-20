package com.tensquare.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Recruit
 * @Auth 桃子
 * @Date 2019-8-20 14:40
 * @Version 1.0
 * @Description
 **/
@Table(name = "tb_recruit")
@Entity
@Data
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Recruit implements Serializable {
    @Id
    private String id;
    private String jobname;
    private String salary;
    private String condition;
    private String education;
    private String type; //任职方式
    private String address;
    private String eid; //企业Id
    private Date createtime;
    private String state; //0:关闭 1：开启 2：推荐
    private String url;
    private String label;
    private String content1; //职位描述
    private String content2; //职位要求



}
