package im.zhaojun.system.controller;

import im.zhaojun.common.annotation.OperationLog;
import im.zhaojun.system.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item/cat")
public class ItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;
	
	/**
	 * 根据id查询商品分类名称 
	 * url:/item/cat/queryItemName
	 *   参数: itemCatId:val
	 *   结果: 商品分类名称
	 */
	/*	@RequestMapping("/queryItemName")
		public String findItemCatNameById(Long itemCatId) {
			
			//return itemCatService.findItemCatService(itemCatId);
		}*/
	
	
	@OperationLog("查询商品分类名称")
	@RequestMapping(value = "/queryItemName")
	/*@ApiOperation(value = "册除一个用户",notes = "删除之后返回int值")
	//@ApiOperation(value = "接口说明", httpMethod = "接口请求方式", notes = "接口发布说明")
	@ApiImplicitParam(paramType = "query",name = "id",defaultValue="0", value="供应商ID", required = true)
	@ApiResponse(code = 400,message = "参数没有填好",response = String.class)*/
	public String findItemCatNameById(Long itemCatId) {
		
		return itemCatService.findItemCatService(itemCatId);
	}
	
	
	/*
	 @GetMapping("/{userId}")
	    public String update(@PathVariable("userId") Integer userId, Model model) {
	        model.addAttribute("roleIds", userService.selectRoleIdsById(userId));
	        model.addAttribute("user", userService.selectOne(userId));
	        model.addAttribute("roles", roleService.selectAll());
	        return "user/user-add";
	    }*/
	
}