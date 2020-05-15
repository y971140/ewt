package im.zhaojun.system.service;

import im.zhaojun.system.model.Provider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProviderService {

	
	List<Provider> selectAllProvider(int page, int limit, Provider provider);

	String add(Provider provider);

	int disableProviderByID(Long id);

	int enableProviderByID(Long id);

	int deleteProvider(Integer id);

	int deleteAllProvider(Long[] id);

	public void updateItem(Provider provider);

	Provider selectOne(Integer id);
	
}