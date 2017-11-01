package com.login.dao;

import com.login.model.Good;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by hzl on 2017/4/25.
 */
public interface IGoodsDao {
    public List<Good> select_all_goods();

    public Good select_by_id();

    public void delete(@Param("goods_name") String goods_name);

    public void update(@Param("goods_name") String goods_name, @Param("goods_link")
            String goods_link, @Param("goods_price") float goods_price);

    public void insert(@Param("goods_name") String goods_name, @Param("goods_link")
            String goods_link, @Param("goods_price") float goods_price);
}
