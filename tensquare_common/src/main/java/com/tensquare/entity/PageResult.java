package com.tensquare.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @ClassName PageResult
 * @Auth 桃子
 * @Date 2019-8-19 11:20
 * @Version 1.0
 * @Description
 **/
@Data
@AllArgsConstructor
public class PageResult<T> {
    private List<T>  rows;
    private Long total;
}
