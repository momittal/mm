package com.mittalmohit.hotelbooking.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="service")
public class Service {
	@Id
	@GeneratedValue(generator="generator")
	@GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="room"))
	@Column(name="roomid")
	private long roomId;

	
	@Column(name="acInRoom")
	private boolean acInRoom;
	
	@Column(name="refrigeratorInRoom")
	private boolean refrigeratorInRoom;
	
	@Column(name="isRoomSoundProof")
	private boolean isRoomSoundProof;
	
	@OneToOne(fetch=FetchType.EAGER)
	@PrimaryKeyJoinColumn(name="roomId")
	private Room room;
	

	public Service() {
		
	}

	public Service(boolean acInRoom, boolean refrigeratorInRoom, boolean isRoomSoundProof) {
		super();
		this.acInRoom = acInRoom;
		this.refrigeratorInRoom = refrigeratorInRoom;
		this.isRoomSoundProof = isRoomSoundProof;
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public boolean isAcInRoom() {
		return acInRoom;
	}

	public void setAcInRoom(boolean acInRoom) {
		this.acInRoom = acInRoom;
	}

	public boolean isRefrigeratorInRoom() {
		return refrigeratorInRoom;
	}

	public void setRefrigeratorInRoom(boolean refrigeratorInRoom) {
		this.refrigeratorInRoom = refrigeratorInRoom;
	}

	public boolean isRoomSoundProof() {
		return isRoomSoundProof;
	}

	public void setRoomSoundProof(boolean isRoomSoundProof) {
		this.isRoomSoundProof = isRoomSoundProof;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	

	
	
}
