/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.thinkgem.jeesite.modules.or.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.common.persistence.IdEntity;

/**
 * applicationEntity
 * @author Jentle
 * @version 2015-02-22
 */
@Entity
@Table(name = "or_application")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Application extends IdEntity<Application> {
	
	private static final long serialVersionUID = 1L;		 
	private String name; 	
    private String houseType;
	private Date startTime;
    private Date endTime;
    private String comment;
    
    private String processInstanceId;
    
	private String processStatus;
    
    
	public Application() {
		super();
	}

	public Application(String id){
		this();
		this.id = id;
	}
	 
	@Length(min=1, max=200)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	  public String getHouseType() {
			return houseType;
		}

		public void setHouseType(String houseType) {
			this.houseType = houseType;
		}
        
		@Temporal(TemporalType.TIMESTAMP)
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		public Date getStartTime() {
			return startTime;
		}

		public void setStartTime(Date startTime) {
			this.startTime = startTime;
		}
        
		@Temporal(TemporalType.TIMESTAMP)
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		public Date getEndTime() {
			return endTime;
		}

		public void setEndTime(Date endTime) {
			this.endTime = endTime;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}
		
		public String getProcessInstanceId() {
			return processInstanceId;
		}

		public void setProcessInstanceId(String processInstanceId) {
			this.processInstanceId = processInstanceId;
		}

		public String getProcessStatus() {
			return processStatus;
		}

		public void setProcessStatus(String processStatus) {
			this.processStatus = processStatus;
		}

}


