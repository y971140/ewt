package im.zhaojun.system.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import im.zhaojun.system.mapper.TbItemMapper;
import im.zhaojun.system.model.TbItem;
import im.zhaojun.system.service.TbItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author maqh
 * @since 2020-04-19
 */
@Service
public class TbItemServiceImpl extends ServiceImpl<TbItemMapper, TbItem> implements TbItemService {
	@Resource
	private TbItemMapper tbItemMapper;

	@Override
    public List<TbItem> selectAllItem(int page, int limit, TbItem tbItemQuery) {
        PageHelper.startPage(page, limit);
        return selectAllItemByQuery(tbItemQuery);
    }

    public List<TbItem> selectAllItemByQuery(TbItem tbItemQuery) {
        return tbItemMapper.selectAllItemByQuery(tbItemQuery);
    }



    @Override
    public  IPage<TbItem> findListByPage(Integer page, Integer pageCount){
        IPage<TbItem> wherePage = new Page<>(page, pageCount);
        TbItem where = new TbItem();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(TbItem tbItem){
        return baseMapper.insert(tbItem);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(TbItem tbItem){
        return baseMapper.updateById(tbItem);
    }

    @Override
    public TbItem findById(Long id){
        return  baseMapper.selectById(id);
    }

}
