package org.jeecg.modules.blog.service.impl;

import org.jeecg.modules.blog.entity.BkComment;
import org.jeecg.modules.blog.mapper.BkCommentMapper;
import org.jeecg.modules.blog.service.IBkCommentService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 评论表
 * @Author: jeecg-boot
 * @Date:   2019-12-31
 * @Version: V1.0
 */
@Service
public class BkCommentServiceImpl extends ServiceImpl<BkCommentMapper, BkComment> implements IBkCommentService {

}
