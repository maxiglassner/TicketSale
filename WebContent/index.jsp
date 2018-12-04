
<%@page import="webApp.TicketsSale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

Hallo!!

<%
TicketsSale k = (TicketsSale)application.getAttribute("kartenverkauf");
%>

<table rules="all" cellpadding="5" border="2" style="">
<tr>
<%
for (int i=0; i<100; i++) {
	
%>
<td>
<%= k.getSeat(i).toHTML() %>
</td>
<%
if(i % 10==9){
%>
</tr>
<tr>
<%
}}
%>
</tr>
</table>


<%=k.isReservations_possible() ? "Reservierungen können noch angenommen werden." : "Reservierungen sind nicht mehr möglich." %>
<p/>
<a href="Verkauf_eines_freien_Tickets.html">Verkauf eines freien Tickets</a>
<p/>
<a href="Reservierung_eines_Tickets.html">Reservierung eines Tickets</a>
<p/>
<a href="Verkauf_eines_reservierten_Tickets.html">Verkauf eines reservierten Tickets</a>
<p/>
<a href="Stornierung_eines_Tickets.html">Stornierung eines Tickets</a>
<p/>
<a href="Reservierungen_aufheben.html">Reservierungen aufheben</a>
</body>
</html>