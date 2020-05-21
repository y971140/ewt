package im.zhaojun.system.serviceImpl;
import im.zhaojun.system.mapper.ItemCatMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


@Service
public class ItemCatServiceImpl {
    @Resource
    private ItemCatMapper itemCatMapper;


}