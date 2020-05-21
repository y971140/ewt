package im.zhaojun;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import im.zhaojun.system.mapper.ItemCatMapper;
import im.zhaojun.system.mapper.ProviderMapper;
import im.zhaojun.system.model.ItemCat;
import im.zhaojun.system.model.Provider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class demo {
	@Autowired
	private ProviderMapper providerMapper;
 
  @Test
  public void testInsert(){
	  Provider provider = new Provider();
	  provider.setPname("jack11");
	  provider.setId(1100L);
	  provider.setPid("23ijdfadsf");
	  provider.setEmail("4849111@qq.com");
    int result= providerMapper.insert(provider);
    System.out.println(result);
    System.out.println(provider);
  }
  //测试修改id为15681L的供应商，并修改更新时间
	@Test
	public void testUpdate(){
	  Provider provider = new Provider();
	  provider.setId(158203L);
	  provider.setPname("杨景升");
	  int result = providerMapper.updateById(provider);
	  System.out.println(result);
	}
	
}
