package im.zhaojun.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Auther: Hill
 * @Date: 2020/04/18 23:30
 * @Description: MP自动填充类
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
	/**
	 * 新增时填充
	 *
	 * @param metaObject
	 */
	@Override
    public void insertFill(MetaObject metaObject) {
        // 先判断是否存在该字段
        boolean createTime = metaObject.hasSetter("createTime");
        if (createTime) {
            System.out.println("insertFill......");
            setFieldValByName("createTime", new Date(), metaObject);
            setFieldValByName("updateTime", new Date(), metaObject);
        }
    }

	/**
	 * 修改时填充
	 *
	 * @param metaObject
	 */
	@Override
    public void updateFill(MetaObject metaObject) {
        // 先判断该值是否为空，为空才填充
        Object updateTime = getFieldValByName("updateTime", metaObject);
        if (updateTime == null) {
            System.out.println("updateFill......");
            setFieldValByName("updateTime", new Date(), metaObject);
        }
    }
}