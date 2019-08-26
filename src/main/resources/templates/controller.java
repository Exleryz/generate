package [(${packageName})].[(${controllerDirName})];

import com.alibaba.fastjson.JSONObject;
import [(${packageName})].[(${entityDir})].[(${entityNameU})];
import [(${packageName})].[(${serviceDirName})].[(${entityNameU})][(${serviceSuffix})];
import [(${packageName})].util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Exler(yz)
 */

@RestController
public class [(${entityNameU})][(${controllerSuffix})] {

    @Autowired
    [(${entityNameU})][(${serviceSuffix})] [(${entityName})][(${serviceSuffix})];

    /**
     * 添加
     */
    @PostMapping("/[(${entityName})]")
    public JSONObject create[(${entityNameU})]([(${entityNameU})] [(${entityName})]) {
        [(${entityName})][(${serviceSuffix})].create([(${entityName})]);
        return JsonResult.success(null);
    }

    /**
     * 根据id获取
     */
    @GetMapping("/[(${entityName})]/{id}")
    public JSONObject get[(${entityNameU})]ById(@PathVariable("id") Integer id) {
        [(${entityNameU})] [(${entityName})] = [(${entityName})][(${serviceSuffix})].get[(${entityNameU})]ById(id);
        return JsonResult.success([(${entityName})]);
    }

    /**
     * 获取列表
     */
    @GetMapping("/[(${entityName})]s")
    public JSONObject get[(${entityNameU})]s(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        JSONObject data = [(${entityName})][(${serviceSuffix})].get[(${entityNameU})]List(pageNum, pageSize);
        return JsonResult.success(data);
    }

    /**
     * 删除
     */
    @DeleteMapping("/[(${entityName})]/{id}")
    public JSONObject delete[(${entityNameU})](@PathVariable("id") Integer id) {
        [(${entityName})][(${serviceSuffix})].delete[(${entityNameU})](id);
        return JsonResult.success(null);
    }

    /**
     * 更新
     */
    @PutMapping("/[(${entityName})]/{id}")
    public JSONObject update[(${entityNameU})](@PathVariable("id") Integer id, [(${entityNameU})] [(${entityName})]) {
        [(${entityName})][(${serviceSuffix})].update[(${entityNameU})](id, [(${entityName})]);
        return JsonResult.success(null);
    }
}

