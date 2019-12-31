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
 * @Description: 评论表
 * @Author: jeecg-boot
 * @Date:   2019-12-31
 * @Version: V1.0
 */
@Data
@TableName("bk_comment")
public class BkComment implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**评论ID*/
	@TableId(type = IdType.ID_WORKER_STR)
    private String id;
	/**评论内容*/
	@Excel(name = "评论内容", width = 15)
    private String content;
	/**文章ID*/
	@Excel(name = "文章ID", width = 15)
    private String articleId;
	/**回复评论ID,如果是评论文章则为-1*/
	@Excel(name = "回复评论ID,如果是评论文章则为-1", width = 15)
    private String pid;
	/**回复人名称*/
	@Excel(name = "回复人名称", width = 15)
    private String pname;
	/**获赞数*/
	@Excel(name = "获赞数", width = 15)
    private Integer praiseNum;
	/**评论人留email*/
	@Excel(name = "评论人留email", width = 15)
    private String email;
	/**评论人留链接路径*/
	@Excel(name = "评论人留链接路径", width = 15)
    private String url;
	/**创建人*/
	@Excel(name = "创建人", width = 15)
    private String createTime;
	/**创建时间*/
	@Excel(name = "创建时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createUser;
}
