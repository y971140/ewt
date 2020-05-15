package im.zhaojun.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import im.zhaojun.system.model.TbItem;

import java.util.List;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author maqh
 * @since 2020-04-19
 */
public interface TbItemMapper extends BaseMapper<TbItem> {

    List<TbItem> selectAllItemByQuery(TbItem tbItemQuery);
    List<TbItem> selectAllItem();
}

