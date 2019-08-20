package com.tensquare.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ClassName Enterprise
 * @Auth 桃子
 * @Date 2019-8-20 14:21
 * @Version 1.0
 * @Description
 **/
@Data
@Entity
@Table(name="tb_enterprise")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Enterprise  implements Serializable {
    @Id
    private String id;

    private String name;
    private String summary;
    private String address;
    private String labels;
    private String coordinate;
    private String ishot; //是否热门 0：非热门 1：热门
    private String logo;
    private Integer jobcount;
    private String url;
}
