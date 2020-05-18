package im.zhaojun.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import im.zhaojun.common.annotation.OperationLog;
import im.zhaojun.common.util.PageResultBean;
import im.zhaojun.system.model.TbItem;
import im.zhaojun.system.service.TbItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author maqh
 * @since 2020-04-19
 */
@Api(tags = {"商品表"})
@Controller
@RequestMapping("/item")
public class TbItemController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private TbItemService tbItemService;

    @GetMapping("/index")
	public String index() {
		return "item/item-list";
	}

	@OperationLog("获取商品列表")
	@GetMapping("/list")
	@ResponseBody
	public PageResultBean<TbItem> getList(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit, TbItem tbItemQuery) {
		List<TbItem> Item = tbItemService.selectAllItem(page, limit, tbItemQuery);
		PageInfo<TbItem> itemPageInfo = new PageInfo<>(Item);
		return new PageResultBean<>(itemPageInfo.getTotal(), itemPageInfo.getList());
	}

    @ApiOperation(value = "新增商品表")
    @PostMapping()
    public int add(@RequestBody TbItem tbItem){
        return tbItemService.add(tbItem);
    }

    @ApiOperation(value = "删除商品表")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return tbItemService.delete(id);
    }

    @ApiOperation(value = "更新商品表")
    @PutMapping()
    public int update(@RequestBody TbItem tbItem){
        return tbItemService.updateData(tbItem);
    }

    @ApiOperation(value = "查询商品表分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<TbItem> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return tbItemService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询商品表")
    @GetMapping("{id}")
    public TbItem findById(@PathVariable Long id){
        return tbItemService.findById(id);
    }

}
