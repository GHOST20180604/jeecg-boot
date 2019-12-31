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
 * @Description: 文件表
 * @Author: jeecg-boot
 * @Date:   2019-12-31
 * @Version: V1.0
 */
@Data
@TableName("bk_file")
public class BkFile implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**ID*/
	@TableId(type = IdType.ID_WORKER_STR)
    private String id;
	/**文件名*/
	@Excel(name = "文件名", width = 15)
    private String name;
	/**文件后缀*/
	@Excel(name = "文件后缀", width = 15)
    private String suffix;
	/**文件路径*/
	@Excel(name = "文件路径", width = 15)
    private String url;
	/**文件ID(modb中保存ID)*/
	@Excel(name = "文件ID(modb中保存ID)", width = 15)
    private String fileId;
	/**上传人人*/
	@Excel(name = "上传人人", width = 15)
    private String createUser;
	/**上传时间*/
	@Excel(name = "上传时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createTime;
}
