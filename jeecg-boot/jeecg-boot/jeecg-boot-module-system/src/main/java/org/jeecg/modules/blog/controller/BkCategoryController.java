package org.jeecg.modules.blog.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.util.JwtUtil;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.blog.entity.BkCategory;
import org.jeecg.modules.blog.service.IBkCategoryService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.modules.system.entity.SysRole;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;

/**
 * @Description: 分类表
 * @Author: jeecg-boot
 * @Date: 2019-12-31
 * @Version: V1.0
 */
@RestController
@RequestMapping("/blog/bkCategory")
@Slf4j
public class BkCategoryController extends JeecgController<BkCategory, IBkCategoryService> {
    @Autowired
    private IBkCategoryService bkCategoryService;

    /**
     * 分页列表查询
     *
     * @param bkCategory
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    @GetMapping(value = "/list")
    public Result<?> queryPageList(BkCategory bkCategory,
                                   @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                   @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                   HttpServletRequest req) {
        QueryWrapper<BkCategory> queryWrapper = QueryGenerator.initQueryWrapper(bkCategory, req.getParameterMap());
        Page<BkCategory> page = new Page<BkCategory>(pageNo, pageSize);
        IPage<BkCategory> pageList = bkCategoryService.page(page, queryWrapper);
        return Result.ok(pageList);
    }

    /**
     * 获取所有分类信息
     *
     * @return
     */
    @RequestMapping(value = "/queryAllCategory", method = RequestMethod.GET)
    public Result<List<BkCategory>> queryall() {
        Result<List<BkCategory>> result = new Result<>();
        List<BkCategory> list = bkCategoryService.list();
        if (list == null || list.size() <= 0) {
            result.error500("未找到分类信息");
        } else {
            result.setResult(list);
            result.setSuccess(true);
        }
        return result;
    }

    /**
     * 添加
     *
     * @param bkCategory
     * @return
     */
    @PostMapping(value = "/add")
    public Result<?> add(@RequestBody BkCategory bkCategory, HttpServletRequest request) {
        bkCategory.setCreateTime(new Date());
        String username = JwtUtil.getUserNameByToken(request);
        bkCategory.setCreateUser(username);
        bkCategoryService.save(bkCategory);
        return Result.ok("添加成功！");
    }

    /**
     * 编辑
     *
     * @param bkCategory
     * @return
     */
    @PutMapping(value = "/edit")
    public Result<?> edit(@RequestBody BkCategory bkCategory, HttpServletRequest request) {
        bkCategory.setUpdateTime(new Date());
        String username = JwtUtil.getUserNameByToken(request);
        bkCategory.setUpdateUser(username);
        bkCategoryService.updateById(bkCategory);
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
        bkCategoryService.removeById(id);
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
        this.bkCategoryService.removeByIds(Arrays.asList(ids.split(",")));
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
        BkCategory bkCategory = bkCategoryService.getById(id);
        if (bkCategory == null) {
            return Result.error("未找到对应数据");
        }
        return Result.ok(bkCategory);
    }

    /**
     * 导出excel
     *
     * @param request
     * @param bkCategory
     */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, BkCategory bkCategory) {
        return super.exportXls(request, bkCategory, BkCategory.class, "分类表");
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
        return super.importExcel(request, response, BkCategory.class);
    }

}
