package im.zhaojun.common.config;

import com.alipay.api.domain.UserLoginStatusDetail;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import im.zhaojun.common.util.ShiroUtil;
import im.zhaojun.system.model.User;
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
        User userEntity = ShiroUtil.getCurrentUser();
        // 先判断是否存在该字段
        boolean createTime = metaObject.hasSetter("createTime");
        boolean updateTime = metaObject.hasSetter("updateTime");
        boolean createId = metaObject.hasSetter("createId");
        boolean createName = metaObject.hasSetter("createName");
        boolean modifyTime = metaObject.hasSetter("modifyTime");
        if (createId) {
            this.setFieldValByName("createId", userEntity.getUserId(), metaObject);
        }
        if (createName) {
            this.setFieldValByName("createName", userEntity.getUsername(), metaObject);
        }
        if (createTime) {
            setFieldValByName("createTime", new Date(), metaObject);
        }
        if (updateTime) {
            setFieldValByName("updateTime", new Date(), metaObject);
        }
        if (modifyTime) {
            setFieldValByName("modifyTime", new Date(), metaObject);
        }
    }

	/**
	 * 修改时填充
	 *
	 * @param metaObject
	 */
	@Override
    public void updateFill(MetaObject metaObject) {
        User userEntity = ShiroUtil.getCurrentUser();
        // 先判断该值是否为空，为空才填充，这是错的，暂时注释，不应该只为空值时更新，应该是有修改后就必须更新
        //Object updateTime = getFieldValByName("updateTime", metaObject);
        boolean updateTime = metaObject.hasSetter("updateTime");
        boolean updateId = metaObject.hasSetter("updateId");
        boolean updateName = metaObject.hasSetter("updateName");
        boolean modifyTime = metaObject.hasSetter("modifyTime");
        if (updateTime) {
            setFieldValByName("updateTime", new Date(), metaObject);
        }
        if (updateId) {
            this.setFieldValByName("updateId", userEntity.getUserId(), metaObject);
        }
        if (updateName) {
            this.setFieldValByName("updateName", userEntity.getUsername(), metaObject);
        }
        if (modifyTime) {
            this.setFieldValByName("modifyTime", userEntity.getUsername(), metaObject);
        }
    }
}