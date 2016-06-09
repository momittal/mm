package com.mittalmohit.hotelbooking.pojo;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="room")
@NamedQueries({
	@NamedQuery(
			name = "getRoomById",
			query = "from Room r where r.roomId = :roomId"
			),
	@NamedQuery(
			name = "getRoomsListByHotelId",
			query = "from Room r where r.hotelId = :hotelId"
			)
})
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="roomid")
	private long roomId;
	
	
	@Column(name="rate")
	private int rate;
	
	@Column(name="numofrooms")
	private int numOfRooms;

	@JoinColumn(name="hotelid")
	@Column(name="hotelid")
	private long hotelId;
	
	@Transient
	private String hotelName;
	
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy = "room", cascade=CascadeType.ALL)
	private Service service;
	
	@Column(name="photo")
	private String photo;
	
	
	@Column(name="roomtype")
	private String roomType;

	
	
	Room(){
		
	}	
	

	

	public Room(int rate, String roomType) {
		super();
		this.rate = rate;
		this.roomType = roomType;
	}




	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public long getHotelId() {
		return hotelId;
	}
	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
	}


	public String getRoomType() {
		return roomType;
	}




	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}



	public int getNumOfRooms() {
		return numOfRooms;
	}


	public void setNumOfRooms(int numOfRooms) {
		this.numOfRooms = numOfRooms;
	}


	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}


	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}




	public String getHotelName() {
		return hotelName;
	}




	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	

	
}
