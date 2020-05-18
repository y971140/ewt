package im.zhaojun.system.controller;

import com.github.pagehelper.PageInfo;
import im.zhaojun.common.annotation.OperationLog;
import im.zhaojun.common.util.PageResultBean;
import im.zhaojun.common.util.ResultBean;
import im.zhaojun.common.validate.groups.Create;
import im.zhaojun.system.model.Provider;
import im.zhaojun.system.model.User;
import im.zhaojun.system.service.ProviderService;
import im.zhaojun.system.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
@Api(tags = {"供应商资料表"})
@Controller
@RequestMapping("/provider")
public class ProviderController {

	@Resource
	private RoleService roleService;
	@Resource
	private ProviderService providerService;

	@GetMapping("/index")
	public String index() {
		return "provider/provider-list";
	}

	@OperationLog("获取供应商列表")
	@GetMapping("/list")
	@ResponseBody
	public PageResultBean<Provider> getList(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit, Provider provider) {
		List<Provider> Provider = providerService.selectAllProvider(page, limit, provider);
		PageInfo<Provider> providerPageInfo = new PageInfo<>(Provider);
		return new PageResultBean<>(providerPageInfo.getTotal(), providerPageInfo.getList());
	}

	@GetMapping
	public String add() {
		return "provider/provider-add";
	}

	@OperationLog("新增供应商")
	@PostMapping()
	@ResponseBody
	public ResultBean add(@Validated(Create.class) Provider provider) {
		return ResultBean.success(providerService.add(provider));
	}

	@OperationLog("修改供应商-获取内容")
	@GetMapping("/{id}")
	public String update(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("provider", providerService.selectOne(id));
		return "provider/provider-add";
	}

		@OperationLog("修改供应商")
		@PutMapping
		@ResponseBody
		public ResultBean update(@Valid Provider provider ) {
			providerService.updateItem(provider);
			return ResultBean.success();
		}
	@ApiOperation(value = "禁用供应商账号",httpMethod = "POST",notes = "激活之后返回int值")
	@ApiResponse(code = 400,message = "参数没有填好",response = String.class)
	@OperationLog("禁用供应商账号")
	@PostMapping("/{pid}/disable")
	@ResponseBody
	public ResultBean disable(@PathVariable("pid") Long id) {

		return ResultBean.success(providerService.disableProviderByID(id));
	}
	@ApiOperation(value = "激活供应商账号",httpMethod = "POST",notes = "激活之后返回int值")
	@ApiResponse(code = 400,message = "参数没有填好",response = String.class)
	@OperationLog("激活供应商账号")
	@PostMapping("/{pid}/enable")
	@ResponseBody
	public ResultBean enable(@PathVariable("pid") Long id) {
		System.out.println(id);
		return ResultBean.success(providerService.enableProviderByID(id));
	}


	@OperationLog("删除供应商账号")
	@ApiOperation(value = "删除供应商账号",httpMethod = "DELETE",notes = "删除之后返回int值")
	@ApiResponse(code = 400,message = "参数没有填好",response = String.class)
	@DeleteMapping("{id}")
	@ResponseBody
	public ResultBean delete(@PathVariable("id") Integer id) {
		return ResultBean.success(providerService.deleteProvider(id));
		//return "provider/provider-list";
	}

	@OperationLog("批量删除供应商账号")
	@ApiOperation(value = "批量删除供应商账号",httpMethod = "DELETE",notes = "删除之后返回int值")
	@ApiResponse(code = 400,message = "参数没有填好",response = String.class)
	@DeleteMapping("/delall/{id}")
	@ResponseBody
	public ResultBean deleteAll(@PathVariable("id") Long[] id) {
		return ResultBean.success(providerService.deleteAllProvider(id));
	}


}