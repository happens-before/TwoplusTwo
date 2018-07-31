package com.xupt.edu.service.impl;


import com.xupt.edu.mapper.TabMapper;
import com.xupt.edu.pojo.Tab;
import com.xupt.edu.service.TabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TabServiceImpl implements TabService {

    @Autowired
    public TabMapper tabDao;

    public List<Tab> getAllTabs()
    {
        return tabDao.getAllTabs();
    }

    public Tab getByTabNameEn(String tabNameEn) {
        Tab tab=tabDao.getByTabNameEn(tabNameEn);
       return  tab;
    }
}
