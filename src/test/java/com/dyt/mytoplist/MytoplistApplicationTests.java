package com.dyt.mytoplist;

import com.dyt.mytoplist.dao.V2exDao;
import com.dyt.mytoplist.pojo.V2ex;
import com.dyt.mytoplist.service.IV2exService;
import com.dyt.mytoplist.service.impl.V2exServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MytoplistApplicationTests {
    @Autowired
    private V2exDao v2exDao;

    @Autowired
    private IV2exService v2exService;

    @Test
    void contextLoads() {
        List<V2ex> all = v2exDao.findAll();
        for (V2ex v2ex : all) {
            System.out.println(v2ex);
        }

    }

    @Test
    void saveAllTest() throws Exception {
        v2exService.saveAll();
    }

}
