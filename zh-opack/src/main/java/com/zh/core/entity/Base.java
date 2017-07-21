package com.zh.core.entity;

import java.util.Date;

/**
 * Created by Lait on 2017/7/17.
 */
public abstract class Base {

    private Long id;
    private String sid;
    private int status;

    private int ucount;
    private Long caid;
    private Long uaid;
    private Date ctime;
    private Date utime;

    public <E> E insert( Base entity){


        return null;
    }


}
