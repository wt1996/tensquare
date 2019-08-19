package com.tensquare.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName HttpResult
 * @Auth 桃子
 * @Date 2019-8-19 11:06
 * @Version 1.0
 * @Description
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HttpResult<T> implements Serializable {

    private boolean flag;//是否成功
    private Integer returnCode;// 返回码
    private String returnMsg;//返回信息
    private Object returnContent;// 返回数据

}
