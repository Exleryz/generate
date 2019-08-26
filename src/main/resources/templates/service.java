package [(${packageName})].[(${serviceSuffix})].impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dayou.cipher.entity.[(${entityName})];
import com.dayou.cipher.mapper.[(${entityName})][(${daoSuffix})];
import com.dayou.cipher.service.[(${entityName})][(${serviceSuffix})];
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Exler(yz)
 */

@Service
public class [(${entityNameU})][(${serviceImplSuffix})] implements [(${entityNameU})][(${serviceSuffix})] {

    @Autowired
    [(${entityNameU})][(${daoSuffix})] [(${entityName})][(${daoSuffix})];

    @Override
    public void create([(${entityNameU})] [(${entityName})]) {
        [(${entityName})][(${daoSuffix})].insert([(${entityName})]);
    }

    @Override
    public [(${entityNameU})] get[(${entityNameU})]ById(Integer id) {
        [(${entityNameU})] [(${entityName})] = [(${entityName})][(${daoSuffix})].selectById(id);
        return [(${entityName})];
    }

    @Override
    public JSONObject get[(${entityNameU})]List(Integer pageNum, Integer pageSize) {
        Page<[(${entityNameU})]> page = new Page<>(pageNum, pageSize);
        QueryWrapper<[(${entityNameU})]> queryWrapper = new QueryWrapper<>();
        IPage<[(${entityNameU})]> iPage = [(${entityName})][(${daoSuffix})].selectPage(page, queryWrapper);
        List<[(${entityNameU})]> records = iPage.getRecords();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("dataList", records);
        // 总页数
        jsonObject.put("allPageNum", iPage.getPages());
        // 总记录数
        jsonObject.put("allNum", iPage.getTotal());
        return jsonObject;
    }

    @Override
    public void delete[(${entityNameU})](Integer id) {
        [(${entityName})][(${daoSuffix})].deleteById(id);
    }

    @Override
    public void update[(${entityNameU})](Integer id, [(${entityNameU})] [(${entityName})]) {
        [(${entityName})].setId(id);
        [(${entityName})][(${daoSuffix})].updateById([(${entityName})]);
    }
}
