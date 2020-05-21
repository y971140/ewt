package im.zhaojun.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import im.zhaojun.system.model.ItemCat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemCatMapper extends BaseMapper<ItemCat> {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemCat itemCat);

    ItemCat selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(ItemCat itemCat);

    List<ItemCat> selectByParentId(@Param("parentId") Integer parentId);

    List<ItemCat> selectAllTree();

    List<Integer> selectChildrenIDByPrimaryKey(@Param("id") Integer id);

    int selectMaxOrderNum();

    int swapSort(@Param("currentId") Integer currentId, @Param("swapId") Integer swapId);

}
