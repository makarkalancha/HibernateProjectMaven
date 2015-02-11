package org.testhibernate.entity;

import java.sql.Timestamp;

/**
 * @author makar
 * Date: Feb 10, 2015
 * Time: 2:24:41 PM
 */
public class Category {
	private static final String EVENT_CATEGORY="EVENTCATEGORY";
	
	private long id;
	private Category parentCategoryId;
	private String domain;
    private Integer displaySequence;
    private String code;
    private String name;
    private String domainParam1;
    private String domainParam2;
    private String foreignId;
    private boolean deleted;
    private Timestamp creationTime;
    private Timestamp updateTime;
    
    public Category(){
        // ORMLite needs a no-arg constructor
    }

    public Category(String name){
        this.name = name;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Category getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(Category parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public Integer getDisplaySequence() {
		return displaySequence;
	}

	public void setDisplaySequence(Integer displaySequence) {
		this.displaySequence = displaySequence;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDomainParam1() {
		return domainParam1;
	}

	public void setDomainParam1(String domainParam1) {
		this.domainParam1 = domainParam1;
	}

	public String getDomainParam2() {
		return domainParam2;
	}

	public void setDomainParam2(String domainParam2) {
		this.domainParam2 = domainParam2;
	}

	public String getForeignId() {
		return foreignId;
	}

	public void setForeignId(String foreignId) {
		this.foreignId = foreignId;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
}


