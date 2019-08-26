package [(${packageName})].[(${serviceDirName})];

import com.alibaba.fastjson.JSONObject;
import [(${packageName})].[(${entityDir})].[(${entityNameU})];

/**
 * @author Exler(yz)
 */
public interface [(${entityNameU})]Service {

    /**
     * 新增
     *
     * @param [(${entityName})]
     */
    void create([(${entityNameU})] [(${entityName})]);

    /**
     * 根据id获取 [(${entityName})]
     *
     * @param id
     * @return
     */
    [(${entityNameU})] get[(${entityNameU})]ById(Integer id);

    /**
     * 获取[(${entityName})]列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    JSONObject get[(${entityNameU})]List(Integer pageNum, Integer pageSize);

    /**
     * 根据id删除
     *
     * @param id
     */
    void delete[(${entityNameU})](Integer id);

    /**
     * 更新
     *
     * @param id
     * @param [(${entityName})]
     */
    void update[(${entityNameU})](Integer id, [(${entityNameU})] [(${entityName})]);
}
