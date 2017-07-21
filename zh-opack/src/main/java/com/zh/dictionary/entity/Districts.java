package com.zh.dictionary.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Table;

/**
 * Created by Lait on 2017/7/20.
 * <p>
 * `id` smallint (5),
 * `pid` smallint (5),
 * `name` varchar (270),
 * `initial` char (3),
 * `initials` varchar (30),
 * `pinyin` varchar (600),
 * `extra` varchar (60),
 * `suffix` varchar (15),
 * `code` char (30),
 * `area_code` varchar (30),
 * `order` tinyint (2)
 */
@Data
@NoArgsConstructor
@ToString
@Table(name="districts")
public class Districts {

    private Long id;

    private Long pid;

    private String name;

    private String initial;

    private String initials;

    private String pinyin;

    private String extra;

    private String suffix;

    private String code;

    // area code
    private String acode;

    private int order;
}

