package com.xjy.practice.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RUser extends Model<RUser> {

  @TableId(value = "user_id", type = IdType.AUTO)
  private Long userId;
  private String userName;
  private Double startWeight;
  private Double targetWeight;
  private String startDate;

}