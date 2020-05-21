package im.zhaojun.system.service;

import im.zhaojun.system.mapper.ItemCatMapper;
import im.zhaojun.system.model.ItemCat;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
@Service
public class ItemCatService implements Serializable {
    @Resource
    private ItemCatMapper itemCatMapper;

    @Transactional
    public ItemCat insert(ItemCat itemCat) {
        int maxOrderNum = itemCatMapper.selectMaxOrderNum();
        itemCat.setSortOrder(maxOrderNum + 1);
        itemCat.setCreateTime(new Date());
        itemCatMapper.insert(itemCat);
        return itemCat;
    }

    @Transactional
    public int deleteByPrimaryKey(Integer id) {
        return itemCatMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    public ItemCat updateByPrimaryKey(ItemCat itemCat) {
        itemCatMapper.updateByPrimaryKey(itemCat);
        return itemCat;
    }

    public ItemCat selectByPrimaryKey(Integer id) {
        return itemCatMapper.selectByPrimaryKey(id);
    }

    /**
     * 删除当前类目及子类目.
     */
    @Transactional
    public void deleteCascadeByID(Integer id) {

        List<Integer> childIDList = itemCatMapper.selectChildrenIDByPrimaryKey(id);
        for (Integer childId : childIDList) {
            deleteCascadeByID(childId);
        }
        deleteByPrimaryKey(id);
    }

    /**
     * 根据父 ID 查询部门
     */
    public List<ItemCat> selectByParentId(Integer parentId) {
        return itemCatMapper.selectByParentId(parentId);
    }

    /**
     * 查找所有的部门的树形结构
     */
    public List<ItemCat> selectAllDeptTree() {
        return itemCatMapper.selectAllTree();
    }


    @Transactional
    public void swapSort(Integer currentId, Integer swapId) {
        itemCatMapper.swapSort(currentId, swapId);
    }

    /**
     * 获取所有菜单并添加一个根节点 (树形结构)
     */
    @Transactional
    public List<ItemCat> selectAllDeptTreeAndRoot() {
        List<ItemCat> itemCatList = selectAllDeptTree();
        ItemCat root = new ItemCat();
        root.setId(0);
        root.setName("根类目");
        root.setChildren(itemCatList);
        List<ItemCat> rootList = new ArrayList<>();
        rootList.add(root);
        return rootList;
    }

    /*	public String findItemCatService(Integer itemCatId) {
            QueryWrapper<ItemCat> wrapper = new QueryWrapper();
            *//*wrapper.eq("id", itemCatId)
				.select("id","Name");*//*
		//查询商品分类对象
		ItemCat itemCat = itemCatMapper.selectById(itemCatId);
		//获取商品分类名称
		return itemCat.getName();
	}*/
    public String findItemCatService(Integer itemCatId) {
        //查询商品分类对象
        ItemCat itemCat = itemCatMapper.selectById(itemCatId);
        //获取商品分类名称
        return itemCat.getName();
    }

}
