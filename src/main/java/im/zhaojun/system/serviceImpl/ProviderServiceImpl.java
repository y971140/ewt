package im.zhaojun.system.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.PageHelper;
import im.zhaojun.common.exception.DuplicateNameException;
import im.zhaojun.system.mapper.ProviderMapper;
import im.zhaojun.system.model.Provider;
import im.zhaojun.system.service.ProviderService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class ProviderServiceImpl implements ProviderService {
	@Resource
	private ProviderMapper providerMapper;
	@Override
	/*public List<Provider> selectAllProvider(int page, int rows, Provider provider) {
		PageHelper.startPage(page, rows);
		return providerMapper.selectList(queryWrapper);
	}*/
	public List<Provider> selectAllProvider(int page, int rows,Provider provider) {
		QueryWrapper<Provider> queryWrapper = new QueryWrapper<>();
		//queryWrapper.eq("1","1");
		queryWrapper.and(
				wrapper ->
						wrapper.eq("1","1")
								.eq(!"null".equals(String.valueOf(provider.getIsActivate())),"is_activate", provider.getIsActivate())
								.like(!StringUtils.isEmpty(provider.getPname()),"pname", provider.getPname())
								.like(!StringUtils.isEmpty(provider.getMobile()),"mobile", provider.getMobile())

		).orderByDesc("create_time");
		PageHelper.startPage(page, rows);
		return providerMapper.selectList(queryWrapper);
	}


	/**
	 * 新增供应商
	 */
	@Transactional
	@Override
	public String add(Provider provider) {
		checkProviderNameExistOnCreate(provider.getPname());
		//生成随机UUID，去掉"-"号及字母大写
		String uuidStr = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		provider.setPid(uuidStr);//写入随机UUID
			//	.setMakeDate(new Date());//写入创建日期
		providerMapper.insert(provider);//执行mybatis plus插入
		return provider.getPid();
	}

	/**
	 * 新增时校验供应商是否重复
	 * @param pname  供应商名
	 */
	public void checkProviderNameExistOnCreate(String pname) {
		/**
		 * 统计已经有几个此供应商, 用来检测供应商是否重复.
		 */
		Provider provider = new Provider();
		provider.setPname(pname);
		//利用对象中不为null的属性充当where条件  where name sex
		QueryWrapper<Provider> queryWrapper = new QueryWrapper<Provider>(provider);
		//List<Provider> providerList = providerMapper.selectList(queryWrapper);
		//System.out.println(providerList);
		if (providerMapper.selectCount(queryWrapper) > 0) {
			throw new DuplicateNameException();
		}
	}

	@Transactional
	@Override
	public int disableProviderByID(Long id) {
		UpdateWrapper<Provider> updateWrapper = new UpdateWrapper<>();
		updateWrapper.eq("id", id);
		Provider provider = new Provider();
		provider.setIsActivate(0);
		int updateById = providerMapper.update(provider, updateWrapper); //根据主键更新
		return updateById;
	}

	@Transactional
	@Override
	public int enableProviderByID(Long id) {
		UpdateWrapper<Provider> updateWrapper = new UpdateWrapper<>();
		updateWrapper.eq("id", id);
		Provider provider = new Provider();
		provider.setIsActivate(1);
		int updateById = providerMapper.update(provider, updateWrapper); //根据主键更新
		return updateById;
	}

	@Transactional
	@Override
	public int deleteProvider(Long id) {
		QueryWrapper<Provider> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("id", id);
		int rows = providerMapper.delete(queryWrapper);
		//System.out.println("删除最终显示：" + Arrays.asList(pid));
		return rows;
	}

	@Transactional
	@Override
	public int deleteAllProvider(Long[] id) {
		//System.out.println("批量删除最终显示：" + Arrays.asList(id));
		int rows = providerMapper.deleteBatchIds(Arrays.asList(id));
		//System.out.println("影响记录数：" + rows);
		return rows;
	}

	@Transactional
	@Override
	public void updateItem(Provider provider) {
		//provider.setUpdateTime(new Date());
		this.providerMapper.updateById(provider);
	}

	@Override
	public Provider selectOne(Integer id) {
		QueryWrapper<Provider> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(Provider::getId, id);
		 return providerMapper.selectOne(queryWrapper);
	}

}
