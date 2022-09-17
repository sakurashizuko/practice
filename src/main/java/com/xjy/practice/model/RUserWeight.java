package com.xjy.practice.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RUserWeight extends Model<RUserWeight> {

  @TableId(value = "wt_id", type = IdType.AUTO)
  private Long wtId;

  private Long userId;
  private Double weight;
  private Integer eatKcal;
  private Integer burnKcal;
  private Integer hasStudy;
  private String recordTime;
  private LocalDateTime createTime;

  @TableField(exist = false)
  private String momentWord;
}
