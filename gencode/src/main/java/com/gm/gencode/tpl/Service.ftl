package ${package};

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gm.service.BaseService;
import ${entityPackage};
import ${daoPackage}.${className}Dao;

@Transactional
@Service
public class ${className}Service extends BaseService<${className}, Integer> {
	@Resource
	private ${className}Dao dao;

	@Override
	public ${className}Dao getDao() {
		return dao;
	}
}