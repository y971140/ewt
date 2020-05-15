package im.zhaojun.system.controller;

import com.github.pagehelper.PageInfo;
import im.zhaojun.common.annotation.OperationLog;
import im.zhaojun.common.util.PageResultBean;
import im.zhaojun.common.util.ResultBean;
import im.zhaojun.common.validate.groups.Create;
import im.zhaojun.system.model.Provider;
import im.zhaojun.system.service.ProviderService;
import im.zhaojun.system.service.RoleService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
	public String add(Model model) {
		model.addAttribute("roles", roleService.selectAll());
		return "provider/provider-add";
	}

	@OperationLog("新增供应商")
	@PostMapping
	@ResponseBody
	public ResultBean add(@Validated(Create.class) Provider provider) {
		return ResultBean.success(providerService.add(provider));
	}
	
	@OperationLog("修改供应商")
	@GetMapping("/{id}")
	public String update(@PathVariable("id") Integer id, Model model) {
		//model.addAttribute("provider", providerService.selectOne(id));
		return "provider/provider-add";
	}
		@OperationLog("修改供应商")
		@PostMapping("/{id}")
		@ResponseBody
		public ResultBean update(Provider provider) {
			providerService.updateItem(provider);
			return ResultBean.success();
		}

	@OperationLog("禁用供应商账号")
	@PostMapping("/{pid}/disable")
	@ResponseBody
	public ResultBean disable(@PathVariable("pid") Long id) {

		return ResultBean.success(providerService.disableProviderByID(id));
	}

	@OperationLog("激活供应商账号")
	@PostMapping("/{pid}/enable")
	@ResponseBody
	public ResultBean enable(@PathVariable("pid") Long id) {
		System.out.println(id);
		return ResultBean.success(providerService.enableProviderByID(id));
	}

	
	@OperationLog("删除供应商账号")
	@RequestMapping(value = "/delete")
	@ApiOperation(value = "册除一个用户",notes = "删除之后返回int值")
	//@ApiOperation(value = "接口说明", httpMethod = "接口请求方式", notes = "接口发布说明")
    @ApiImplicitParam(paramType = "query",name = "id",defaultValue="0", value="供应商ID", required = true)
    @ApiResponse(code = 400,message = "参数没有填好",response = String.class)
	@ResponseBody
	public ResultBean delete(@RequestParam("id") Long id) {
		return ResultBean.success(providerService.deleteProvider(id));
		//return "provider/provider-list";
	}

	@OperationLog("批量删除供应商账号")
	@RequestMapping(value = "/deleteAll", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean deleteAll(@RequestParam("id") Long[] id) {
		return ResultBean.success(providerService.deleteAllProvider(id));
	}

}