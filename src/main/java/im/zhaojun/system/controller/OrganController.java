package im.zhaojun.system.controller;

import com.github.pagehelper.PageInfo;
import im.zhaojun.common.annotation.OperationLog;
import im.zhaojun.common.util.PageResultBean;
import im.zhaojun.common.util.ResultBean;
import im.zhaojun.common.validate.groups.Create;
import im.zhaojun.system.model.Organ;
import im.zhaojun.system.model.Provider;
import im.zhaojun.system.model.User;
import im.zhaojun.system.service.OrganService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Hill
 * @since 2020-05-22
 */
@Controller
@RequestMapping("/organ")
public class OrganController {

    @Resource
    private OrganService organService;

    /**
    * 跳转到主页面
    */
    @GetMapping("/index")
    public String index() {
        return  "organ/organ-list";
    }
    /**
    * 查询列表
    * @param organ
    * @param limit
    * @param page
    * @return
    */
    @OperationLog("获取机构列表")
    @GetMapping("/list")
    @ResponseBody
    public PageResultBean<Organ> getList(@RequestParam(value = "page", defaultValue = "1") int page,
                                            @RequestParam(value = "limit", defaultValue = "10") int limit, Organ organ) {
        List<Organ> Organ = organService.selectPageList(page, limit, organ);
        PageInfo<Organ> providerPageInfo = new PageInfo<>(Organ);
        return new PageResultBean<>(providerPageInfo.getTotal(), providerPageInfo.getList());
    }

    /**
    * 新增数据
    */
    @GetMapping
    public String add(Model model) {
        return "organ/organ-add";
    }
    @OperationLog("新增用户")
    @PostMapping
    @ResponseBody
    public ResultBean add(@Validated(Create.class) Organ organ) {
        return ResultBean.success(organService.add(organ));
    }


    @OperationLog("修改机构-获取内容")
    @GetMapping("/{id}")
    public String update(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("organ", organService.selectOne(id));
        return "organ/organ-add";
    }

    @OperationLog("修改供应商")
    @PutMapping
    @ResponseBody
    public ResultBean update(@Valid Organ organ ) {
        organService.updateOrgan(organ);
        return ResultBean.success();
    }

    /**
    * 查看详情
    * @param id
    * @return
    */
    @RequestMapping("/detail")
    @ResponseBody
    public ResultBean detail(Integer id) {
        Organ organ = organService.getDetailsById(id);
        return ResultBean.success(organ);
    }

    /**
    * 根据ID删除记录
    * @param id
    * @return
    */
    @OperationLog("删除机构")
    @ApiOperation(value = "删除机构",httpMethod = "DELETE",notes = "删除之后返回int值")
    @ApiResponse(code = 400,message = "参数没有填好",response = String.class)
    @DeleteMapping("{id}")
    @ResponseBody
    public ResultBean delete(@PathVariable("id") Integer id) {
        return ResultBean.success(organService.deleteById(id));
    }


    /**
    * 批量删除数据
    * @param ids ID集合
    * @return
    */
    @RequestMapping("/deleteBatch")
    @ResponseBody
    public ResultBean deleteBatch(@RequestParam(value = "ids[]",required = true) List<Long> ids) {
        organService.deleteBatch(ids);
        return ResultBean.success();
    }

}
