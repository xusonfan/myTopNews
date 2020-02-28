package com.dyt.mytoplist.service.impl;

import com.dyt.mytoplist.dao.V2exDao;
import com.dyt.mytoplist.pojo.V2ex;
import com.dyt.mytoplist.service.IV2exService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class V2exServiceImpl implements IV2exService {
    @Autowired
    private V2exDao v2exDao;


    @Override
    public List<V2ex> findAll() {

        return v2exDao.findAll();
    }

    @Transactional
    @Scheduled(fixedDelay = 60 * 60 * 1000)
    @Override
    public void saveAll() throws Exception {
        Document dom = Jsoup.parse(new URL("https://www.v2ex.com/?tab=hot"), 10000);
        Elements topics = dom.getElementsByClass("topic-link");
        List<V2ex> v2exes = new ArrayList<>();

        for (Element topic : topics) {
            String url = topic.attr("href");
            String title = topic.text();
            V2ex v2ex = new V2ex();
            v2ex.setTitle(title);
            v2ex.setUrl("https://www.v2ex.com" + url);
            v2ex.setCreateTime(new Date());
            v2exes.add(v2ex);
        }
        v2exDao.saveAll(v2exes);
        log.info(new Date().toString()+"保存了一次");
    }
}
