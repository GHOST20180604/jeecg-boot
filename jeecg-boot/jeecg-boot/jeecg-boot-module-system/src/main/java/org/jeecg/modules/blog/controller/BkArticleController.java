package org.jeecg.modules.blog.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecg.common.api.vo.Result;
import org.jeecg.common.constant.BlogConstant;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.blog.BkArticleVo;
import org.jeecg.modules.blog.entity.BkArticle;
import org.jeecg.modules.blog.service.IBkArticleService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;

/**
 * @Description: 文章表
 * @Author: jeecg-boot
 * @Date: 2019-12-31
 * @Version: V1.0
 */
@RestController
@RequestMapping("/blog/bkArticle")
@Slf4j
public class BkArticleController extends JeecgController<BkArticle, IBkArticleService> {
    @Autowired
    private IBkArticleService bkArticleService;

    /**
     * 分页列表查询
     *
     * @param bkArticle
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    @GetMapping(value = "/list")
    public Result<?> queryPageList(BkArticle bkArticle,
                                   @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                   @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                   HttpServletRequest req) {
//		QueryWrapper<BkArticle> queryWrapper = QueryGenerator.initQueryWrapper(bkArticle, req.getParameterMap());
//		Page<BkArticle> page = new Page<BkArticle>(pageNo, pageSize);
//		IPage<BkArticle> pageList = bkArticleService.page(page, queryWrapper);
//		return Result.ok(pageList);
        Page<BkArticleVo> bkArticleVoPage = new Page<BkArticleVo>(pageNo, pageSize);
        bkArticleVoPage = bkArticleService.queryPageList(bkArticleVoPage,bkArticle);//文章列表
//        IPage<BkArticleVo> pageList = bkArticleService.page(bkArticleVoPage);
        return Result.ok(bkArticleVoPage);
    }

    /**
     * 添加
     *
     * @param bkArticle
     * @return
     */
    @PostMapping(value = "/add")
    public Result<?> add(@RequestBody BkArticle bkArticle) {
        if(StringUtils.isEmpty(bkArticle.getStatus())){
            bkArticle.setStatus(BlogConstant.UN_PUBLISHED);
        }
        bkArticleService.save(bkArticle);
        return Result.ok("添加成功！");
    }

    /**
     * 编辑
     *
     * @param bkArticle
     * @return
     */
    @PutMapping(value = "/edit")
    public Result<?> edit(@RequestBody BkArticle bkArticle) {
        bkArticleService.updateById(bkArticle);
        return Result.ok("编辑成功!");
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/delete")
    public Result<?> delete(@RequestParam(name = "id", required = true) String id) {
        bkArticleService.removeById(id);
        return Result.ok("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @DeleteMapping(value = "/deleteBatch")
    public Result<?> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        this.bkArticleService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.ok("批量删除成功!");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/queryById")
    public Result<?> queryById(@RequestParam(name = "id", required = true) String id) {
        BkArticle bkArticle = bkArticleService.getById(id);
        if (bkArticle == null) {
            return Result.error("未找到对应数据");
        }
        return Result.ok(bkArticle);
    }

    /**
     * 导出excel
     *
     * @param request
     * @param bkArticle
     */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, BkArticle bkArticle) {
        return super.exportXls(request, bkArticle, BkArticle.class, "文章表");
    }

    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, BkArticle.class);
    }

}
