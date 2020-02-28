package com.dyt.mytoplist.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "v2ex")
public class V2ex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String url;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "pic_url")
    private String picUrl;
}
