package cn._51even.efast.core.base;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;

public interface BaseMapper<T> extends
        tk.mybatis.mapper.common.Mapper<T>,ConditionMapper<T>,IdsMapper<T> {
}
