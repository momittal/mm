package com.mittalmohit.hotelbooking.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import com.mittalmohit.hotelbooking.exception.AdException;
import com.mittalmohit.hotelbooking.pojo.Booking;
import com.mittalmohit.hotelbooking.pojo.Payment;
import com.mittalmohit.hotelbooking.pojo.Room;
import com.mittalmohit.hotelbooking.pojo.UserAccount;

public class BookingDAO extends DAO {
	public BookingDAO() {
	}

	public void book(int amount, Date creditCardExpireDate, long creditCardNumber, Date bookingDate, Date checkinDate,
			Date checkoutDate, Room room, UserAccount userAccount) {
		try {
			begin();

			// saving hotel details
			Booking booking = new Booking();
			Payment payment = new Payment();
			payment.setAmount(amount);
			payment.setBooking(booking);
			payment.setCreditCardExpireDate(creditCardExpireDate);
			payment.setCreditCardNumber(creditCardNumber);

			booking.setBookingDate(bookingDate);
			booking.setCheckinDate(checkinDate);
			booking.setCheckoutDate(checkoutDate);
			booking.setRoom(room);
			booking.setUserAccount(userAccount);
			booking.setPayment(payment);
			getSession().save(booking);
			commit();
		} catch (HibernateException e) {
			rollback();
			System.out.println("Exception: " + e.getMessage());
		}
	}

	public List<Booking> getAllBookingsByRoomId(Room room, Date checkinDate, Date checkoutDate) {
		Criteria criteria = getSession().createCriteria(Booking.class);
		criteria.add(Restrictions.eq("room", room));

		// both dates fall between the 2 dates ==
		// disjunction.add(Restrictions.between(checkoutDate, "checkinDate",
		// "checkoutDate"));
		// disjunction of this type directly was not possible because between
		// accepts (String, Object, Object)

		// Criterion dbCheckinBeforeqCheckinDate =
		// Restrictions.lt("checkinDate", checkinDate);
		Criterion dbCheckinBeforeqCheckoutDate = Restrictions.lt("checkinDate", checkoutDate);
		// Criterion dbCheckoutAfterqCheckinDate =
		// Restrictions.gt("checkoutDate", checkinDate);
		Criterion dbCheckoutAfterqCheckoutDate = Restrictions.gt("checkoutDate", checkoutDate);
		
		Conjunction conjunction = Restrictions.conjunction();
		// conjunction.add(dbCheckinBeforeqCheckinDate);
		conjunction.add(dbCheckinBeforeqCheckoutDate);
		// conjunction.add(dbCheckoutAfterqCheckinDate);
		conjunction.add(dbCheckoutAfterqCheckoutDate);

		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(conjunction);
		disjunction.add(Restrictions.between("checkinDate", checkinDate, checkoutDate));
		disjunction.add(Restrictions.between("checkoutDate", checkinDate, checkoutDate));

		criteria.add(disjunction);

		List<Booking> bookings = criteria.list();

		return bookings;
	}

	public List<Booking> getAllBookingsByUserAccount(UserAccount userAccount) {
		Criteria criteria = getSession().createCriteria(Booking.class);
		criteria.add(Restrictions.eq("userAccount", userAccount));	
		List<Booking> bookings = criteria.list();
		return bookings;
	}

}
