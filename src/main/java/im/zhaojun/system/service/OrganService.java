package im.zhaojun.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import im.zhaojun.system.model.Organ;
import im.zhaojun.system.model.Provider;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Hill
 * @since 2020-05-22
 */
public interface OrganService extends IService<Organ> {

    /**
    * 分页查询列表
    * @param organ
    * @return
    */

    /**
    * 新增数据
    * @param organ
    */
    int add(Organ organ);


    /**
    * 查看详情
    * @param id
    * @return
    */
    Organ getDetailsById(Integer id);

    /**
    * 删除数据
    * @param id
    * @return
    */
    int deleteById(Integer id);

    /**
    * 批量删除
    * @param ids
    * @return
    */
    int deleteBatch(List<Long> ids);

    List<Organ> selectPageList(int page, int limit, Organ organ);

    Organ selectOne(Integer id);
    void updateOrgan(Organ organ);
}

