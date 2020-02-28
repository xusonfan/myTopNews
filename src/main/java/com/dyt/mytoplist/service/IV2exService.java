package com.dyt.mytoplist.service;

import com.dyt.mytoplist.pojo.V2ex;

import java.util.List;

public interface IV2exService {
    List<V2ex> findAll();
    void saveAll() throws Exception;
}
