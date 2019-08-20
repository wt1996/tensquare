package com.tensquare.controller;

import com.tensquare.entity.HttpResult;
import com.tensquare.entity.StatusCode;
import com.tensquare.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName EnterPriseController
 * @Auth 桃子
 * @Date 2019-8-20 14:47
 * @Version 1.0
 * @Description  企业视图控制层
 **/
@RestController
@RequestMapping("enterPrise")
public class EnterPriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping("/search/hotlist")
    public HttpResult hotList(){
        return new HttpResult(true, StatusCode.SUCCESS, "查询热门企业成功", enterpriseService.hotlist() );
    }
}
