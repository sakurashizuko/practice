//package com.xjy.practice.controller;
//
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.xjy.practice.model.CrawlJobConf;
//import com.xjy.practice.service.CrawlJobConfService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * <p>
// * 爬虫作业配置表 前端控制器
// * </p>
// *
// * @author zf
// * @since 2022-06-02
// */
//@RestController
//@RequestMapping("/crawl")
//public class CrawlJobConfController {
//
//    @Autowired
//    CrawlJobConfService crawlJobConfService;
//
//    /**
//     * 测试接口：根据id拿记录
//     *
//     * @param id id
//     * @return result
//     */
//    @GetMapping("/getJobById")
//    @ResponseBody
//    public Map<String, Object> getJobById(@RequestParam("jobId") int id) {
//        CrawlJobConf crawlJobConf = crawlJobConfService.getBaseMapper().selectById(id);
//
//        Map<String, Object> result = new HashMap<>();
//        result.put("result", crawlJobConf);
//        result.put("code", 200);
//        result.put("status", "success");
//
//        return result;
//    }
//
//    /**
//     * 分页demo
//     *
//     * @param cursor 起始点
//     * @param size   条数
//     * @return result
//     */
//    @GetMapping("/getJobConfListByLimit")
//    @ResponseBody
//    public Map<String, Object> getJobConfListByLimit(@RequestParam("cursor") int cursor, @RequestParam("size") int size) {
//        Map<String, Object> result = new HashMap<>();
//
//        if (size > 50) {
//            result.put("result", "参数错误！");
//            result.put("code", 200);
//            result.put("status", "error");
//
//            return result;
//        } else {
//            Page<CrawlJobConf> producePage = new Page<>(cursor, size);
//            Page<CrawlJobConf> page = crawlJobConfService.page(producePage);
//            System.out.println(producePage == page);
//            List<CrawlJobConf> records = page.getRecords();
//
//            result.put("result", records);
//            result.put("code", 200);
//            result.put("status", "success");
//        }
//
//        return result;
//    }
//
//}
