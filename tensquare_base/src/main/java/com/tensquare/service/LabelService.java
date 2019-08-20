package com.tensquare.service;

import com.tensquare.dao.LabelDao;
import com.tensquare.entity.IdWorker;
import com.tensquare.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LabelService
 * @Auth 桃子
 * @Date 2019-8-19 14:56
 * @Version 1.0
 * @Description
 **/
@Service
@Transactional
public class LabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部标签
     * @return
     */
    public List<Label> findAll(){
        return labelDao.findAll();
    }

    /**
     * 根据ID查询标签
     * @return
     */
    public Label findById(String id){
        return labelDao.getOne(id);
    }

    /**
     * 增加标签
     * @param label
     */
    public void add(Label label){
        label.setId(idWorker.nextId() + "");
        labelDao.save(label);
    }

    /**
     * 修改标签
     * @param label
     */
    public void update(Label label){
        labelDao.save(label);
    }

    /**
     * 删除标签
     * @param id
     */
    public void deleteById(String id){
        labelDao.deleteById(id);
    }

    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    private Specification<Label> createSpecification(Map searchMap){

        return new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList=new ArrayList<>();
                if(searchMap.get("labelname")!=null && !"".equals(searchMap.get("labelname"))){
                    predicateList.add(criteriaBuilder.like(root.get("labelname").as(String.class), "%"+ (String)searchMap.get("labelname")+"%" ) );
                }
                if(searchMap.get("state")!=null && !"".equals(searchMap.get("state"))){
                    predicateList.add(criteriaBuilder.equal(root.get("state").as(String.class), (String)searchMap.get("state") ) );
                }
                if(searchMap.get("recommend")!=null && !"".equals(searchMap.get("recommend"))){
                    predicateList.add(criteriaBuilder.equal(root.get("recommend").as(String.class), (String)searchMap.get("recommend") ) );
                }
                return criteriaBuilder.and( predicateList.toArray( new Predicate[predicateList.size()]) );
            }
        };
    }

    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    public List<Label> findSearch(Map searchMap){
        System.out.println("searchMap: " + searchMap);
        Specification specification = createSpecification(searchMap);
        List all = labelDao.findAll(specification);
        System.out.println(all);
        return labelDao.findAll(specification);
    }

    /**
     * 分页条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public Page<Label> findSearch(Map searchMap, int page, int size){
        Specification specification = createSpecification(searchMap);
        PageRequest pageRequest = PageRequest.of(page-1,size);
        return labelDao.findAll(specification,pageRequest);
    }


}
