package com.zm.fx_cms_provider.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.zm.fx_cms_provider.service.ContentService;
import com.zm.fx_dao_common.bean.ContentCategory;
import com.zm.fx_dao_common.bean.IndexContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Describle This Class Is 门户管理
 * @Author ZengMin
 * @Date 2018/8/23 20:11
 */
@RestController
public class ContentController {

    @Autowired
    ContentService contentService;

    /**
     * 取所有分类
     * @return
     */
    @GetMapping("/content/getcates")
    public List<ContentCategory> getContentCates(){
        return contentService.getContentCates();
    }

    /**
     * 根据id取内容
     * @param id
     * @return
     */
    @GetMapping("/content/{id}")
    public IndexContent getContentById(@PathVariable Long id){
        return contentService.getContentsById(id);
    }

    /**
     * 取所有内容
     * @param
     * @return
     */
    @GetMapping("/content/getall")
    public Page getContentAll(){
        return contentService.getContents();
    }

    /**
     * 更新内容
     * @param indexContent
     * @return
     */
    @PostMapping("/content/update")
    public int update(@RequestBody IndexContent indexContent){
        contentService.updateContent(indexContent);
        return 1;
    }

    /**
     * 新增内容
     * @param indexContent
     * @return
     */
    @PutMapping("/content/add")
    public int add(@RequestBody IndexContent indexContent){
        contentService.addContent(indexContent);
        return 1;
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/content/delete/{id}")
    public int delete(@PathVariable String id){
        contentService.deleteById(Long.parseLong(id));
        return 1;
    }

    /**
     * 根据parentid取内容
     * @param parentid
     * @return
     */
    @GetMapping("/content/parent/{parentid}")
    public List<IndexContent> getContentByPId(@PathVariable Long parentid){
        return contentService.getContentByPid(parentid);
    }


}
