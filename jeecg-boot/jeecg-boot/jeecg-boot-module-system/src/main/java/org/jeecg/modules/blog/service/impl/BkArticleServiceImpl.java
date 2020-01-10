package org.jeecg.modules.blog.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jeecg.modules.blog.BkArticleVo;
import org.jeecg.modules.blog.entity.BkArticle;
import org.jeecg.modules.blog.mapper.BkArticleMapper;
import org.jeecg.modules.blog.service.IBkArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 文章表
 * @Author: jeecg-boot
 * @Date:   2019-12-31
 * @Version: V1.0
 */
@Service
public class BkArticleServiceImpl extends ServiceImpl<BkArticleMapper, BkArticle> implements IBkArticleService {
    @Autowired
    private BkArticleMapper bkArticleMapper;

    @Override
    public Page<BkArticleVo> queryPageList(Page<BkArticleVo> bkArticleVoPage, BkArticle bkArticle) {
        return bkArticleVoPage.setRecords(bkArticleMapper.queryPageList(bkArticleVoPage,bkArticle));
    }
}
