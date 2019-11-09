package cn.itcast.service;

import cn.itcast.pojo.TbItem;

/**
 * @author lzw
 * @create 2019/11/09/21:23
 */
public interface ItemService {

    /**
     * 根据商品id查询商品信息
     * @param id
     * @return
     */
    TbItem getItemById(Long id);
}
