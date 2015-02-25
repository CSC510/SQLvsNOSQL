/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package ${packageName}.${moduleName}.dao${subModuleName};

import org.springframework.stereotype.Repository;

import com.thinkgem.jeesite.common.persistence.BaseDao;
import com.thinkgem.jeesite.common.persistence.Parameter;
import ${packageName}.${moduleName}.entity${subModuleName}.${ClassName};

/**
 * ${functionName}DAO interface
 * @author ${classAuthor}
 * @version ${classVersion}
 */
@Repository
public interface ${ClassName}Dao extends BaseDao<${ClassName}> {
	
}
