package com.tensquare.controller;

import com.tensquare.entity.HttpResult;
import com.tensquare.entity.StatusCode;
import com.tensquare.pojo.Recruit;
import com.tensquare.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName RecruitController
 * @Auth 桃子
 * @Date 2019-8-20 17:02
 * @Version 1.0
 * @Description
 **/
@RestController
@RequestMapping("recruit")
public class RecruitController {

    @Autowired
    private RecruitService recruitService;

    //查询最新推荐
    @GetMapping("/search/recommend")
    public HttpResult recommend(){
        List<Recruit> list = recruitService.findTop4ByStateOrderByCreatetimeDesc("2");
        return new HttpResult(true, StatusCode.SUCCESS,"查询成功",list);
    }


    /**
     * 最新职位列表
     * @return
     */
    @RequestMapping(value="/search/newlist",method= RequestMethod.GET)
    public HttpResult newlist(){
        return new HttpResult(true,StatusCode.SUCCESS,"查询成 功",recruitService.newlist());
    }

}
