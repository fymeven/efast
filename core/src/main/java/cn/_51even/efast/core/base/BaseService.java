package cn._51even.efast.core.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public abstract class BaseService<Entity,ID>{

    @Autowired
    protected BaseMapper<Entity> mapper;

    public boolean save(Entity entity){
        int i = mapper.insertSelective(entity);
        return i > 0 ? true : false;
    }

    public boolean updateIncludeNull(Entity entity){
        int i = mapper.updateByPrimaryKey(entity);
        return i > 0 ? true : false;
    }

    public boolean updateNotNull(Entity entity){
        int i = mapper.updateByPrimaryKeySelective(entity);
        return i > 0 ? true : false;
    }

    public boolean updateIncludeNull(Entity entity,Example example){
        int i = mapper.updateByExample(entity,example);
        return i > 0 ? true : false;
    }

    public boolean updateNotNull(Entity entity,Example example){
        int i = mapper.updateByExampleSelective(entity,example);
        return i > 0 ? true : false;
    }

    public boolean delete(ID id){
        int i = mapper.deleteByPrimaryKey(id);
        return i > 0 ? true : false;
    }

    public boolean deleteByIds(String ids){
        int i = mapper.deleteByIds(ids);
        return i > 0 ? true : false;
    }

    public PageInfo<Entity> selectPage(Integer pageNum,Integer pageSize,Entity entity){
        PageHelper.startPage(pageNum,pageSize);
        List<Entity> list = select(entity);
        return new PageInfo<>(list);
    }

    public PageInfo<Entity> selectPage(Integer pageNum,Integer pageSize,Example example){
        PageHelper.startPage(pageNum,pageSize);
        List<Entity> list = select(example);
        return new PageInfo<>(list);
    }

    public PageInfo<Entity> selectPage(Integer pageNum,Integer pageSize,Condition condition){
        PageHelper.startPage(pageNum,pageSize);
        List<Entity> list = select(condition);
        return new PageInfo<>(list);
    }

    public Entity selectByPrimaryKey(ID id){
        return mapper.selectByPrimaryKey(id);
    }

    public Entity selectOne(Entity entity){
        return mapper.selectOne(entity);
    }

    public Entity selectOne(Example example){
        return mapper.selectOneByExample(example);
    }

    public List<Entity> select(Entity entity){
        return mapper.select(entity);
    }

    public List<Entity> select(Example example){
        return mapper.selectByExample(example);
    }

    public List<Entity> selectByCondition(Condition condition){
        return mapper.selectByCondition(condition);
    }

    public List<Entity> selectAll(){
        return mapper.selectAll();
    }

    public int selectCount(Entity entity){
        return mapper.selectCount(entity);
    }

    public int selectCountByExample(Example example){
        return mapper.selectCountByExample(example);
    }

    public int selectCountByCondition(Condition condition){
        return mapper.selectCountByCondition(condition);
    }
}
