package com.wrh.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class t_user {
	@Id
	@Column(name = "ID")
    private Integer id;
	
	@Column(name = "NAME")
    private String name;
	
	@Column(name = "ZHIWU")
    private String zhiwu;
	
	@Column(name = "AGE")
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getZhiwu() {
        return zhiwu;
    }

    public void setZhiwu(String zhiwu) {
        this.zhiwu = zhiwu == null ? null : zhiwu.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}