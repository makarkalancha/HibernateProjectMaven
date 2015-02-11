package org.testhibernate.entity;


import java.sql.Date;














import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import org.hibernate.procedure.internal.Util.ResultClassesResolutionContext;


/**
 * @author makar
 * Date: Feb 10, 2015
 * Time: 10:49:43 AM
 */

//@NamedStoredProcedureQuery(name = "getexhibitor", 
//	procedureName = "getexhibitor", 
//	parameters = {
//		@StoredProcedureParameter(name = "exhid", type = Integer.class),
//		@StoredProcedureParameter(name = "curs1", type = String.class)
//	},
//	resultClasses = AnnotationExhibitor.class)

@NamedNativeQueries({
	@NamedNativeQuery (
			name="getexhibitor",
			query="select getexhibitor(11,\"exhibitor\")",
			resultClass = AnnotationExhibitor.class
			) 
})

@Entity
@Table(name = "exhibitor")
public class AnnotationExhibitor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="exhibitor_id_seq")
	@SequenceGenerator(name="exhibitor_id_seq", sequenceName="exhibitor_id_seq", allocationSize=1)
	@Column(name="ID")
	private int id;
	
	@Column(name="import_batch_id") private Integer importBatchId;
	@Column(name="edition_id") private Integer editionId;
	@Column(name="name") private String name;
	@Column(name="shortname") private String shortName;
	@Column(name="publishedname") private String publishedName;
	@Column(name="featured") private boolean featured;
	@Column(name="firsttime") private boolean firstTime;
	@Column(name="customref1") private String customRef1;
	@Column(name="customref2") private String customRef2;
	@Column(name="statusclientandbilling") private String statusClientAndBilling = "";
	@Column(name="duedateclientandbilling") private Date dueDateClientAndBilling;
	@Column(name="statusorder") private String statusOrder = "";
	@Column(name="duedateorder") private Date dueDateOrder;
	@Column(name="statusaccount") private String statusAccount = "";
	@Column(name="duedateaccount") private Date dueDateAccount;
	@Column(name="statusfollowupnotes") private String statusFollowupNotes;
	@Column(name="duedatefollowupnotes") private Date dueDateFollowupNotes;
	@Column(name="statusconfirmation") private String statusConfirmation;
	@Column(name="duedateconfirmation") private Date dueDateConfirmation;
	@Column(name="initialdescription") private String initialDescription;
	@Column(name="fulldescription") private String fullDescription;
	@Column(name="foreignid") private String foreignId;
	@Column(name="orderemailsubject") private String orderEmailSubject;
	@Column(name="orderemailbody") private String orderEmailBody;
	@Column(name="ordersalesrep") private String orderSalesRep;
	@Column(name="mainexhibitor") private boolean mainExhibitor;
	@Column(name="deleted") private boolean deleted;
	@Column(name="color") private String color;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getImportBatchId() {
		return importBatchId;
	}
	public void setImportBatchId(Integer importBatchId) {
		this.importBatchId = importBatchId;
	}
	public Integer getEditionId() {
		return editionId;
	}
	public void setEditionId(Integer edition_id) {
		this.editionId = edition_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getPublishedName() {
		return publishedName;
	}
	public void setPublishedName(String publishedName) {
		this.publishedName = publishedName;
	}
	public boolean isFeatured() {
		return featured;
	}
	public void setFeatured(boolean featured) {
		this.featured = featured;
	}
	public boolean isFirsttime() {
		return firstTime;
	}
	public void setFirsttime(boolean firsttime) {
		this.firstTime = firsttime;
	}
	public String getCustomref1() {
		return customRef1;
	}
	public void setCustomref1(String customref1) {
		this.customRef1 = customref1;
	}
	public String getCustomref2() {
		return customRef2;
	}
	public void setCustomref2(String customref2) {
		this.customRef2 = customref2;
	}
	public String getStatusClientAndBilling() {
		return statusClientAndBilling;
	}
	public void setStatusClientAndBilling(String statusClientAndBilling) {
		this.statusClientAndBilling = statusClientAndBilling;
	}
	public Date getDueDateClientAndBilling() {
		return dueDateClientAndBilling;
	}
	public void setDueDateClientAndBilling(Date dueDateClientAndBilling) {
		this.dueDateClientAndBilling = dueDateClientAndBilling;
	}
	public String getStatusOrder() {
		return statusOrder;
	}
	public void setStatusOrder(String statusOrder) {
		this.statusOrder = statusOrder;
	}
	public Date getDueDateOrder() {
		return dueDateOrder;
	}
	public void setDueDateOrder(Date dueDateOrder) {
		this.dueDateOrder = dueDateOrder;
	}
	public String getStatusAccount() {
		return statusAccount;
	}
	public void setStatusAccount(String statusAccount) {
		this.statusAccount = statusAccount;
	}
	public Date getDueDateAccount() {
		return dueDateAccount;
	}
	public void setDueDateAccount(Date dueDateAccount) {
		this.dueDateAccount = dueDateAccount;
	}
	public String getStatusFollowupNotes() {
		return statusFollowupNotes;
	}
	public void setStatusFollowupNotes(String statusFollowupNotes) {
		this.statusFollowupNotes = statusFollowupNotes;
	}
	public Date getDueDateFollowupNotes() {
		return dueDateFollowupNotes;
	}
	public void setDueDateFollowupNotes(Date dueDateFollowupNotes) {
		this.dueDateFollowupNotes = dueDateFollowupNotes;
	}
	public String getStatusConfirmation() {
		return statusConfirmation;
	}
	public void setStatusConfirmation(String statusConfirmation) {
		this.statusConfirmation = statusConfirmation;
	}
	public Date getDueDateConfirmation() {
		return dueDateConfirmation;
	}
	public void setDueDateConfirmation(Date dueDateConfirmation) {
		this.dueDateConfirmation = dueDateConfirmation;
	}
	public String getInitialDescription() {
		return initialDescription;
	}
	public void setInitialDescription(String initialDescription) {
		this.initialDescription = initialDescription;
	}
	public String getFullDescription() {
		return fullDescription;
	}
	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}
	public String getForeignId() {
		return foreignId;
	}
	public void setForeignId(String foreignId) {
		this.foreignId = foreignId;
	}
	public String getOrderEmailSubject() {
		return orderEmailSubject;
	}
	public void setOrderEmailSubject(String orderEmailSubject) {
		this.orderEmailSubject = orderEmailSubject;
	}
	public String getOrderEmailBody() {
		return orderEmailBody;
	}
	public void setOrderEmailBody(String orderEmailBody) {
		this.orderEmailBody = orderEmailBody;
	}
	public String getOrderSalesRep() {
		return orderSalesRep;
	}
	public void setOrderSalesRep(String orderSalesRep) {
		this.orderSalesRep = orderSalesRep;
	}
	public boolean isMainExhibitor() {
		return mainExhibitor;
	}
	public void setMainExhibitor(boolean mainExhibitor) {
		this.mainExhibitor = mainExhibitor;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Exhibitor [id=" + id + ", importBatchId=" + importBatchId
				+ ", edition_id=" + editionId + ", name=" + name
				+ ", shortName=" + shortName + ", publishedName="
				+ publishedName + ", featured=" + featured + ", firsttime="
				+ firstTime + ", customref1=" + customRef1 + ", customref2="
				+ customRef2 + ", statusClientAndBilling="
				+ statusClientAndBilling + ", dueDateClientAndBilling="
				+ dueDateClientAndBilling + ", statusOrder=" + statusOrder
				+ ", dueDateOrder=" + dueDateOrder + ", statusAccount="
				+ statusAccount + ", dueDateAccount=" + dueDateAccount
				+ ", statusFollowupNotes=" + statusFollowupNotes
				+ ", dueDateFollowupNotes=" + dueDateFollowupNotes
				+ ", statusConfirmation=" + statusConfirmation
				+ ", dueDateConfirmation=" + dueDateConfirmation
				+ ", initialDescription=" + initialDescription
				+ ", fullDescription=" + fullDescription + ", foreignId="
				+ foreignId + ", orderEmailSubject=" + orderEmailSubject
				+ ", orderEmailBody=" + orderEmailBody + ", orderSalesRep="
				+ orderSalesRep + ", mainExhibitor=" + mainExhibitor
				+ ", deleted=" + deleted + ", color=" + color + "]";
	}
	
	
}



