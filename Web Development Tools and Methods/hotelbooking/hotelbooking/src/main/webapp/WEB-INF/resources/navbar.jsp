
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/WEB-INF/resources/css/style.css"%>

<c:choose>
	<c:when test="${!empty sessionScope.user}">

		<c:choose>
			<c:when test="${sessionScope.user.userRole =='affiliate'}">
				[<a href="/HotelBooking/affiliate/views/affiliateworkflow/addroom">Add Room</a>]
				[<a href="/HotelBooking/affiliate/views/affiliateworkflow/viewrooms">View Rooms</a>]
				[<a href="logoutuser.htm">Log Out</a>] 	
  			</c:when>
			<c:when test="${sessionScope.user.userRole =='user'}">
  				[<a href="/HotelBooking">Home</a>]
  				[<a href="bookinghistory.htm">Booking History</a>]
  				[<a href="editprofile.htm">Profile</a>]   
				[<a href="logoutuser.htm">Log Out</a>]
  			</c:when>
		</c:choose>

	</c:when>

	<c:otherwise>
		<c:choose>
			
			<c:when test="${requestScope.role =='affiliate'}">
				[<a href="/HotelBooking">Home</a>]
  				[<a
					href="/HotelBooking/affiliate/views/flows/affiliateregistrationflow/">Sign
					Up</a>] 
                 --
				[<a href="/HotelBooking/affiliate/views/flows/loginflow">Log In</a>]	
  			</c:when>
  			
			<c:otherwise>
				
				[<a href="/HotelBooking">Home</a>]
				 --
				[<a href="/HotelBooking/booking/views/flows/registrationflow/">Sign
					Up</a>] 
                 --
				[<a href="/HotelBooking/booking/views/flows/loginflow">Log In</a>]
  			</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose>

