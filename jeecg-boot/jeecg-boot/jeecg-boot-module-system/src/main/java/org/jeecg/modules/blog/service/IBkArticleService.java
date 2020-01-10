package org.jeecg.modules.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jeecg.modules.blog.BkArticleVo;
import org.jeecg.modules.blog.entity.BkArticle;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: 文章表
 * @Author: jeecg-boot
 * @Date:   2019-12-31
 * @Version: V1.0
 */
public interface IBkArticleService extends IService<BkArticle> {

    public Page<BkArticleVo> queryPageList(Page<BkArticleVo> bkArticleVoPage, BkArticle bkArticle);
}
