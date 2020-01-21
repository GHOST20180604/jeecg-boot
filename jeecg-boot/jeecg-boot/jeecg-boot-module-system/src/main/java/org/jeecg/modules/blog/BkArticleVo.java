package org.jeecg.modules.blog;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * BkArticleVo
 * <p>
 * <p><a href="BkArticleVo.java.html"><i>View Source</i></a></p>
 *
 * @author <a href="mailto:afteryuan@gmail.com">Spires</a>
 * @version 1.0
 */
@Data
public class BkArticleVo {
    /**
     * ID
     */
    private String id;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 状态;0:草稿;1:已发布;2:已删除;
     */
    private String status;
    /**
     * 获赞次数
     */
    private Integer praiseNum;
    /**
     * 是否可评论;0否;1是
     */
    private String canComment;
    /**
     * 是否公开;0否;1是
     */
    private String isPublic;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    /**
     * 变更人
     */
    private String updateBy;
    /**
     * 变更时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;
    /**
     * 分类ID
     */
    private String categoryId;
    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 标题名称(只是单纯为其前端页面展示列表用,其他地方永不倒)
     */
    private String titleName;
}
