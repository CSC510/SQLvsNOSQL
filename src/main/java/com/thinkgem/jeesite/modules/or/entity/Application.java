/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.thinkgem.jeesite.modules.or.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import com.drew.lang.annotations.NotNull;
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
	private Date startTime;
    private Date endTime;
    private String comment;
    private Room room;
    private House house;
    
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
	

        
		
		
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="house_id")
		@NotNull
		public House getHouse(){
			return this.house;
		}
		
		public void setHouse(House house){
			this.house = house;
		}
		
		@ManyToOne( fetch=FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST} )
		@JoinColumn(name="room_id")
		public Room getRoom(){
			return this.room;
		}
		
		public void setRoom(Room room){
			this.room = room;
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


