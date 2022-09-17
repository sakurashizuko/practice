//package com.xjy.practice.model;
//
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.extension.activerecord.Model;
//import com.baomidou.mybatisplus.annotation.TableId;
//import java.time.LocalDateTime;
//import java.io.Serializable;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//
///**
// * <p>
// * 爬虫作业配置表
// * </p>
// *
// * @author zf
// * @since 2022-06-02
// */
//@Data
//@EqualsAndHashCode(callSuper = false)
//public class CrawlJobConf extends Model<CrawlJobConf> {
//
//    private static final long serialVersionUID = 1L;
//
//    /**
//     * 作业id
//     */
//    @TableId(value = "job_id", type = IdType.AUTO)
//    private Integer jobId;
//
//    /**
//     * 参数配置id
//     */
//    private String confId;
//
//    /**
//     * 作业名
//     */
//    private String jobName;
//
//    /**
//     * 作业描述
//     */
//    private String jobDesc;
//
//    /**
//     * 作业类型，1：heritrix，2：selenium
//     */
//    private Integer jobType;
//
//    /**
//     * Quartz表达式
//     */
//    private String jobSchedule;
//
//    /**
//     * 代理id
//     */
//    private String proxyId;
//
//    /**
//     * 是否生效，1：启用，0：否
//     */
//    private Integer isValid;
//
//    /**
//     * 是否调度：1: 是，0：否
//     */
//    private Integer isSchedule;
//
//    /**
//     * 主机ip信息
//     */
//    private String hostId;
//
//    /**
//     * 是否生效，1：启用，0：否
//     */
//    private Integer isOpenRandomSchedule;
//
//    /**
//     * 随机睡眠的取数区间，单位：分钟
//     */
//    private Integer randomInterval;
//
//    /**
//     * 失败重试是否开启，1：启用，0：不启用
//     */
//    private Integer isOpenFailAttempt;
//
//    /**
//     * 作业标识
//     */
//    private String jobUuid;
//
//    /**
//     * 任务html
//     */
//    private String jobHtml;
//
//    /**
//     * 定时设置参数
//     */
//    private String jobScheduleParam;
//
//    /**
//     * 用户id
//     */
//    private String userId;
//
//    /**
//     * 作业创建时间
//     */
//    private LocalDateTime createTime;
//
//    /**
//     * 更新时间
//     */
//    private LocalDateTime updateTime;
//
//    /**
//     * 是否上线，1：是，0：否
//     */
//    private Integer isOnline;
//
//    /**
//     * 作业下线时间
//     */
//    private LocalDateTime offlineTime;
//
//    /**
//     * 作业是否删除，0：否，1：是
//     */
//    private Integer isDelete;
//
//    /**
//     * 开发者模式：dev
//     */
//    private String jobMode;
//
//    /**
//     * 浏览器类型，1：火狐浏览器，2：谷歌浏览器
//     */
//    private Integer browserType;
//
//    /**
//     * 分组id
//     */
//    private Long groupId;
//
//    /**
//     * 作业生效开始时间
//     */
//    private LocalDateTime validStartTime;
//
//    /**
//     * 作业生效结束时间
//     */
//    private LocalDateTime validEndTime;
//
//    /**
//     * 任务缩略图url
//     */
//    private String jobPicUrl;
//
//    /**
//     * 作业名称
//     */
//    private String jobChnName;
//
//    /**
//     * cron备注
//     */
//    private String jobScheduleDesc;
//
//    /**
//     * 任务执行分组
//     */
//    private String hostGroup;
//
//    /**
//     * 业务线id
//     */
//    private Integer businessId;
//
//    /**
//     * 平台类型id
//     */
//    private Integer siteGroupId;
//
//    /**
//     * 平台id
//     */
//    private Integer siteId;
//
//
//    @Override
//    protected Serializable pkVal() {
//        return this.jobId;
//    }
//
//}
