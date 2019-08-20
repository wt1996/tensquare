package com.tensquare.controller;

import com.tensquare.entity.HttpResult;
import com.tensquare.entity.PageResult;
import com.tensquare.entity.StatusCode;
import com.tensquare.pojo.Label;
import com.tensquare.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName LabelController
 * @Auth 桃子
 * @Date 2019-8-19 15:14
 * @Version 1.0
 * @Description 标签控制层
 **/
@RestController
@RequestMapping("label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    /**
     * 查询全部列表
     * @return
     */
    @GetMapping
    public HttpResult<List> findAll(){
        return new HttpResult<List>(true, StatusCode.SUCCESS,"查询所有数据成功", labelService.findAll() );
    }

    /**
     * 根据ID查询标签
     * @param id
     * @return
     */
    @GetMapping(value="/{id}")
    public HttpResult<Label> findById(@PathVariable String id){
        System.out.println(labelService.findById(id));
        return new HttpResult<>(true,StatusCode.SUCCESS,"根据ID查询成功",labelService.findById(id));
    }

    /**
     * 根据ID增加标签
     * @param label
     * @return
     */
    @PostMapping
    public HttpResult add( @RequestBody Label label){
        labelService.add(label);
        return new HttpResult(true,StatusCode.SUCCESS,"根据ID查询增加成功","");
    }

    /**
     * 修改标签
     * @param label
     * @return
     */
    @PutMapping(value="/{id}")
    public HttpResult update( @RequestBody Label label,@PathVariable String id){
        label.setId(id);
        labelService.update(label);
        return new HttpResult(true,StatusCode.SUCCESS,"修改成功","");
    }

    /**1
     * 删除标签
     * @param id
     * @return
     */
    @DeleteMapping(value="/{id}")
    public HttpResult deleteById(@PathVariable String id){
        labelService.deleteById(id);
        return new HttpResult(true,StatusCode.SUCCESS,"删除成功","");
    }

    /**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @PostMapping(value="/search")
    public HttpResult<List> findSearch( @RequestBody Map searchMap){
        return new HttpResult<>(true,StatusCode.SUCCESS,"根据条件查询成功",labelService.findSearch(searchMap));
    }

    /**
     * 条件+分页查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value="/search/{page}/{size}")
    public HttpResult findSearch(@RequestBody Map searchMap,@PathVariable int page,@PathVariable int size){
        Page pageList= labelService.findSearch(searchMap,page,size);
        return new HttpResult(true, StatusCode.SUCCESS, "分页条件查询成功",
                new PageResult<Label>(pageList.getContent(),pageList.getTotalElements()));
    }

}
