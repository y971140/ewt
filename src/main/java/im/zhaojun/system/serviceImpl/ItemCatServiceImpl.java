package im.zhaojun.system.serviceImpl;

import im.zhaojun.system.mapper.ItemCatMapper;
import im.zhaojun.system.model.ItemCat;
import im.zhaojun.system.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private ItemCatMapper itemCatMapper;

	@Override
	public String findItemCatService(Long itemCatId) {
		//查询商品分类对象
		ItemCat itemCat = itemCatMapper.selectById(itemCatId);
		//获取商品分类名称
		return itemCat.getName();
	}
}