package com.tensquare.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ClassName Label
 * @Auth 桃子
 * @Date 2019-8-19 14:50
 * @Version 1.0
 * @Description
 **/
@Data
@Table(name="tb_label")
@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Label  implements Serializable {

    @Id
    private String id;//
    private String labelname;//标签名称
    private String state;//状态  0：无效，1：有效
    private Long count;//使用数量
    private Long fans;//关注数
    private String recommend;//是否推荐 0:不推荐，1：推荐

}
