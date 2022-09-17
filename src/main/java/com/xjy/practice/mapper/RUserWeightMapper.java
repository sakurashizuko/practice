package com.xjy.practice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xjy.practice.model.RUserWeight;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 爬虫作业配置表 Mapper 接口
 * </p>
 *
 * @author zf
 * @since 2022-06-02
 */
@Mapper
public interface RUserWeightMapper extends BaseMapper<RUserWeight> {

  /**
   * 插入方法
   */

  @Insert("INSERT INTO data_center.r_user_weight\n" +
      "    (  user_id, weight, record_time) VALUES ( #{userId}, #{weight}, '2022/08/04');")
  void insertWeight(@Param("userId") Integer userId, @Param("weight") Integer weight);


}
