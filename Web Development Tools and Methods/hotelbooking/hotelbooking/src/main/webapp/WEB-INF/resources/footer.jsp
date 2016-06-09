<font size="4">
	<c:choose>
  		<c:when test="${requestScope.role == 'affiliate'}">
  		
  			<c:choose>
  				<c:when test="${empty sessionScope.user}">
   					[<a href="/HotelBooking">I am Here to Book a Room</a>]
   				</c:when>
 				<c:otherwise>
					
  				</c:otherwise>
			</c:choose>
   		</c:when>
 		<c:otherwise>
 			<c:choose>
  				<c:when test="${empty sessionScope.user}">
   					[<a href="/HotelBooking/affiliate/views/flows/loginflow/">I am a Hotel Booking Affiliate</a>]
   				</c:when>
 				<c:otherwise>
					
  				</c:otherwise>
			</c:choose>
			
  		</c:otherwise>
	</c:choose>
</font>

<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script><%@ include file="/WEB-INF/resources/js/regex.js"%></script>
