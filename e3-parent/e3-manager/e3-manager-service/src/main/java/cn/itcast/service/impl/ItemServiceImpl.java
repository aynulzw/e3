package cn.itcast.service.impl;

import cn.itcast.mapper.TbItemMapper;
import cn.itcast.pojo.TbItem;
import cn.itcast.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lzw
 * @create 2019/11/09/21:25
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    TbItemMapper itemMapper;

    @Override
    public TbItem getItemById(Long id) {
        TbItem item = itemMapper.selectByPrimaryKey(id);
        return item;
    }
}
