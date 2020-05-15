package im.zhaojun.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import im.zhaojun.system.model.TbItem;

import java.util.List;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author maqh
 * @since 2020-04-19
 */
public interface TbItemService extends IService<TbItem> {

    /**
     * 查询商品表分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<TbItem>
     */
    IPage<TbItem> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加商品表
     *
     * @param tbItem 商品表
     * @return int
     */
    int add(TbItem tbItem);

    /**
     * 删除商品表
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改商品表
     *
     * @param tbItem 商品表
     * @return int
     */
    int updateData(TbItem tbItem);

    /**
     * id查询数据
     *
     * @param id id
     * @return TbItem
     */
    TbItem findById(Long id);

	List<TbItem> selectAllItem(int page, int limit, TbItem tbItem);
}
