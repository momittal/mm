package com.mittalmohit.hotelbooking.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.hibernate.HibernateException;

import com.mittalmohit.hotelbooking.exception.AdException;
import com.mittalmohit.hotelbooking.pojo.UserAccount;
import com.mittalmohit.hotelbooking.pojo.Employee;
import com.mittalmohit.hotelbooking.pojo.Hotel;
import com.mittalmohit.hotelbooking.pojo.Room;
import com.mittalmohit.hotelbooking.pojo.Service;
import org.hibernate.Query;


public class RoomDAO extends DAO{
	 public RoomDAO() {
	    }
	 
	 public Room getRoom(long roomId){
		 Query query = getSession().getNamedQuery("getRoomById");
         query.setString("roomId",String.valueOf(roomId));
         Room room = (Room)query.uniqueResult();
		 return room; 
	 }
	 
	 public void create(String roomType,String filePathWithExtension,boolean acInRoom,boolean refrigeratorInRoom,
				boolean soundProof, int rate,UserAccount userAccount) throws AdException {
	        try {
	            begin();
	            System.out.println("inside DAO");
	            
	            //getting hotelId and hotel
	            long hotelId = ((Employee) userAccount).getHotelId();
	            Query query = getSession().getNamedQuery("getHotelById");
	            query.setString("hotelId",String.valueOf(hotelId));
	            Hotel hotel = (Hotel)query.uniqueResult();
	            
	            //saving room details
	            
	            Service service = new Service(acInRoom, refrigeratorInRoom, soundProof);
	            Room room = new Room(rate, roomType);
	            room.setPhoto(filePathWithExtension);
	            room.setHotelId(hotelId);
	            room.setHotelName(hotel.getHotelName());
	            room.setService(service);
	            service.setRoom(room);
	            getSession().saveOrUpdate(room);
	            commit();
	            System.out.println("Dao complete");
	        } catch (Exception e) {
	            rollback();    
	            throw new AdException("Failed to save into databse Exception: " + e.getMessage());
	        }
	    }
	 
	 public List<Room> getRoomList(Employee employee){
		 
		 long hotelId = employee.getHotelId();
		 
		 Query query = getSession().getNamedQuery("getRoomsListByHotelId");
		 query.setString("hotelId", String.valueOf(hotelId));
		 List<Room> rooms = query.list();
		 for(Room room : rooms){
	            log.info("List of Rooms::"+room.getRoomId()+","+room.getRoomType());
	        }
		 
		 return rooms;
	 }

	 
}
