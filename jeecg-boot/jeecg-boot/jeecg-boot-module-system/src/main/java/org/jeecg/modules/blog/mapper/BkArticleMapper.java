package org.jeecg.modules.blog.mapper;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.blog.BkArticleVo;
import org.jeecg.modules.blog.entity.BkArticle;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 文章表
 * @Author: jeecg-boot
 * @Date: 2019-12-31
 * @Version: V1.0
 */
public interface BkArticleMapper extends BaseMapper<BkArticle> {

    List<BkArticleVo> queryPageList(Page<BkArticleVo> bkArticleVoPage, @Param("bkArticle") BkArticle bkArticle);
}
