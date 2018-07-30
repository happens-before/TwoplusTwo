package com.xupt.edu.service;


import com.xupt.edu.pojo.Tab;

import java.util.List;

public interface TabService {
    List<Tab> getAllTabs();

    Tab getByTabNameEn(String tabName);
}
