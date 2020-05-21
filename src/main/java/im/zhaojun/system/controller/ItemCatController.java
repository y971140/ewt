package im.zhaojun.system.controller;

import im.zhaojun.common.annotation.OperationLog;
import im.zhaojun.common.util.ResultBean;
import im.zhaojun.system.model.ItemCat;
import im.zhaojun.system.service.ItemCatService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = {"商品类目表"})
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
	@Resource
	private ItemCatService itemCatService;

	@GetMapping("/index")
	public String index() {
		return "itemcat/item-cat-list";
	}

	@OperationLog("获取列表")
	@GetMapping("/list")
	@ResponseBody
	public ResultBean getList(@RequestParam(required = false) Integer parentId) {
		List<ItemCat> itemCatList = itemCatService.selectByParentId(parentId);
		return ResultBean.success(itemCatList);
	}

	@GetMapping("/tree/root")
	@ResponseBody
	public ResultBean treeAndRoot() {
		return ResultBean.success(itemCatService.selectAllDeptTreeAndRoot());
	}

	@GetMapping("/tree")
	@ResponseBody
	public ResultBean tree() {
		return ResultBean.success(itemCatService.selectAllDeptTree());
	}

	@GetMapping
	public String add() {
		return "itemcat/item-cat-add";
	}

	@OperationLog("新增类目")
	@PostMapping
	@ResponseBody
	public ResultBean add(ItemCat itemCat) {
		return ResultBean.success(itemCatService.insert(itemCat));
	}

	@OperationLog("删除类目")
	@RequestMapping("/{id}")
	@ResponseBody
	public ResultBean delete(@PathVariable("id") Integer id) {
		itemCatService.deleteCascadeByID(id);
		return ResultBean.success();
	}

	@OperationLog("修改类目")
	@PutMapping
	@ResponseBody
	public ResultBean update(ItemCat itemCat) {
		itemCatService.updateByPrimaryKey(itemCat);
		return ResultBean.success();
	}

	@GetMapping("/{id}")
	public String update(@PathVariable("id") Integer id, Model model) {
		ItemCat itemCat= itemCatService.selectByPrimaryKey(id);
		model.addAttribute("itemCat", itemCat);
		return "itemcat/item-cat-add";
	}

	@OperationLog("调整类目排序")
	@PostMapping("/swap")
	@ResponseBody
	public ResultBean swapSort(Integer currentId, Integer swapId) {
		itemCatService.swapSort(currentId, swapId);
		return ResultBean.success();
	}


	/**
	 * 根据id查询商品分类名称 
	 * url:/item/cat/queryItemName
	 *   参数: itemCatId:val
	 *   结果: 商品分类名称
	 */
	@ResponseBody
	@OperationLog("查询商品分类名称")
	@RequestMapping(value = "/queryItemName")
	public String findItemCatNameById(Integer itemCatId) {
		return itemCatService.findItemCatService(itemCatId);
	}

	

}