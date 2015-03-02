/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.thinkgem.jeesite.modules.or.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.IdEntity;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;

/**
 * houseEntity
 * @author ThinkGem
 * @version 2015-02-19
 */
@Entity
@Table(name = "or_house")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class House extends IdEntity<House> {
	
	public final static int RESIDENCE_HALL = 1;
	public final static int GENERAL_APARTMENT = 2;
	public final static int FAMILY_APARTMENT = 3;
	
	public static final String  AVAILABLE = "available";
	public static final String  WAITED = "waited";
	public static final String  RESERVED  = "reserved";
	public static final String  RENTED = "rented";
	
	private static final long serialVersionUID = 1L;
	private String name; 	// 名称
	private String address;
	private String telephone;
	private int houseType;
	private int rooms;
	private List<Room> rentRooms;
	
	private int baths;
	private int rate;
	private String rentStatus;
	
	private List<Application> applications;

	

	public House() {
		super();
	}

	public House(String id){
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Transient
	public String getHouseTypeDictLabel() {
		return DictUtils.getDictLabel(String.valueOf(houseType), "or_house_type", "");
	}
	

	public int getHouseType() {
		return houseType;
	}

	public void setHouseType(int houseType) {
		this.houseType = houseType;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	
    @OneToMany(mappedBy="house")
    @Where(clause="del_flag='"+DEL_FLAG_NORMAL+"'")
	@NotFound(action = NotFoundAction.IGNORE)
	//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<Room> getRentRooms() {
		return rentRooms;
	}

    @Transient
    public List<String>  getRoomIds(){
    	List<String > roomIds = new ArrayList<String>();
    	for(Room room : rentRooms){
    		roomIds.add(room.getId());
    	}
    	return roomIds;
    }
    
    @OneToMany(mappedBy="house")
    @Where(clause="del_flag='"+Application.DEL_FLAG_NORMAL+"'")
	@NotFound(action = NotFoundAction.IGNORE)
    public List<Application> getApplications(){
    	return applications;
    }
    
    public void setApplications(List<Application> applications){
    	this.applications = applications;
    }
    
    
	public void setRentRooms(List<Room> rentRooms) {
		this.rentRooms = rentRooms;
	}

	public int getBaths() {
		return baths;
	}

	public void setBaths(int baths) {
		this.baths = baths;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getRentStatus() {
		return rentStatus;
	}

	public void setRentStatus(String rentStatus) {
		this.rentStatus = rentStatus;
	}
	
	public void changeStatus( int Add_Or_Reduce){
		int applicationSize = this.applications.size() +( Add_Or_Reduce);
		if(applicationSize==0){
			this.rentStatus= Room.AVAILABLE;
		}else if(applicationSize < Room.MAX_APPLICATIONS){
			this.rentStatus  = Room.WAITED;
		}else{
			this.rentStatus = Room.RESERVED;
		}
	}
	
}


