package org.jeecg.modules.blog.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;

/**
 * @Description: 文章表
 * @Author: jeecg-boot
 * @Date:   2019-12-31
 * @Version: V1.0
 */
@Data
@TableName("bk_article")
public class BkArticle implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**ID*/
	@TableId(type = IdType.ID_WORKER_STR)
    private String id;
	/**用户ID*/
	@Excel(name = "用户ID", width = 15)
    private String userId;
	/**标题*/
	@Excel(name = "标题", width = 15)
    private String title;
	/**内容*/
	@Excel(name = "内容", width = 15)
    private String content;
	/**状态;0:草稿;1:已发布;2:已删除;*/
	@Excel(name = "状态;0:草稿;1:已发布;2:已删除;", width = 15)
    private String status;
	/**获赞次数*/
	@Excel(name = "获赞次数", width = 15)
    private Integer praiseNum;
	/**是否可评论;0否;1是*/
	@Excel(name = "是否可评论;0否;1是", width = 15)
    private String canComment;
	/**是否公开;0否;1是*/
	@Excel(name = "是否公开;0否;1是", width = 15)
    private String isPublic;
	/**创建人*/
	@Excel(name = "创建人", width = 15)
    private String createBy;
	/**创建时间*/
	@Excel(name = "创建时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createTime;
	/**变更人*/
	@Excel(name = "变更人", width = 15)
    private String updateBy;
	/**变更时间*/
	@Excel(name = "变更时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updateTime;
	/**分类ID*/
	@Excel(name = "分类ID", width = 15)
    private String categoryId;
}
