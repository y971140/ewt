package im.zhaojun.system.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import im.zhaojun.system.mapper.OrganMapper;
import im.zhaojun.system.mapper.ProviderMapper;
import im.zhaojun.system.model.Organ;
import im.zhaojun.system.model.Provider;
import im.zhaojun.system.service.OrganService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Hill
 * @since 2020-05-22
 */
@Service
public class OrganServiceImpl extends ServiceImpl<OrganMapper, Organ> implements OrganService {
    @Resource
    private OrganMapper organMapper;

    /**
     * 分页查询列表
     *
     * @return
     */
    @Override
    public List<Organ> selectPageList(int page, int rows, Organ organ) {
        QueryWrapper<Organ> queryWrapper = new QueryWrapper<>();
        queryWrapper.and(wrapper -> wrapper.eq("1", "1").eq(!"null".equals(String.valueOf(organ.getUseFlag())), "use_flag", organ.getUseFlag()).like(!StringUtils.isEmpty(organ.getOrganName()), "organ_name", organ.getOrganName()).like(!StringUtils.isEmpty(organ.getAbbreviation()), "abbreviation", organ.getAbbreviation())).orderByAsc("create_time");
        PageHelper.startPage(page, rows);
        return organMapper.selectList(queryWrapper);
    }
    /**
     * 新增数据
     *
     * @param organ
     */
    @Override
    public int add(Organ organ) {
        return organMapper.insert(organ);
    }
    /**
     * 按ID查询机构内容，先查后改
     *
     * @param id
     * @return
     */
    @Override
    public Organ selectOne(Integer id) {
        QueryWrapper<Organ> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        return organMapper.selectOne(queryWrapper);
    }

    @Transactional
    @Override
    public void updateOrgan(Organ organ) {
      //  QueryWrapper<Organ> queryWrapper = new QueryWrapper<>(organ);
//暂时屏蔽判断
        /*
        queryWrapper.eq("organName", organ.getOrganName());
        if (queryWrapper.equals(String.valueOf(organ.getOrganName()))){
            checkProviderNameExistOnCreate(organ.getOrganName());
        }*/
        this.organMapper.updateById(organ);
    }
    /**
     * 查看详情
     *
     * @param id
     * @return
     */
    @Override
    public Organ getDetailsById(Integer id) {
        return baseMapper.selectById(id);
    }

    /**
     * 删除数据
     */
    @Transactional
    @Override
    public int deleteById(Integer id) {
        QueryWrapper<Organ> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
            int rows = organMapper.delete(queryWrapper);
        //System.out.println("删除最终显示：" + Arrays.asList(pid));
        return rows;
    }



    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @Override
    public int deleteBatch(List<Long> ids) {
        return baseMapper.deleteBatchIds(ids);
    }

}

