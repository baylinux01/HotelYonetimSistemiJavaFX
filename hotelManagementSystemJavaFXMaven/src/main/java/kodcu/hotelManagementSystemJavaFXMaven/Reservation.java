package kodcu.hotelManagementSystemJavaFXMaven;

import java.util.Objects;

public class Reservation {
	
	protected long reservationNo;
	protected String reservationStartDate;
	protected String reservationEndDate;
	protected long daysToStay;
	protected long roomNo;
	protected long pricePerDay;
	protected long totalPrice;
	protected String paidOrUnpaid;
	protected String clientNameAndSurname;
	protected String clientCellPhone;
	protected String clientAddress;
	
	public long getReservationNo() {
		return reservationNo;
	}
	public void setReservationNo(long reservationNo) {
		this.reservationNo = reservationNo;
	}
	public String getReservationStartDate() {
		return reservationStartDate;
	}
	public void setReservationStartDate(String reservationStartDate) {
		this.reservationStartDate = reservationStartDate;
	}
	public String getReservationEndDate() {
		return reservationEndDate;
	}
	public void setReservationEndDate(String reservationEndDate) {
		this.reservationEndDate = reservationEndDate;
	}
	public long getDaysToStay() {
		return daysToStay;
	}
	public void setDaysToStay(long daysToStay) {
		this.daysToStay = daysToStay;
	}
	public long getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(long roomNo) {
		this.roomNo = roomNo;
	}
	public long getPricePerDay() {
		return pricePerDay;
	}
	public void setPricePerDay(long pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	public long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getPaidOrUnpaid() {
		return paidOrUnpaid;
	}
	public void setPaidOrUnpaid(String paidOrUnpaid) {
		this.paidOrUnpaid = paidOrUnpaid;
	}
	public String getClientNameAndSurname() {
		return clientNameAndSurname;
	}
	public void setClientNameAndSurname(String clientNameAndSurname) {
		this.clientNameAndSurname = clientNameAndSurname;
	}
	public String getClientCellPhone() {
		return clientCellPhone;
	}
	public void setClientCellPhone(String clientCellPhone) {
		this.clientCellPhone = clientCellPhone;
	}
	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	Reservation(){}
	Reservation(ReservationToShow r){
		this.setTotalPrice(r.getTotalPrice());
		this.setRoomNo(r.getRoomNo());
		this.setReservationStartDate(r.getReservationStartDate());
		this.setReservationNo(r.getReservationNo());
		this.setReservationEndDate(r.getReservationEndDate());
		this.setPricePerDay(r.getPricePerDay());
		this.setDaysToStay(r.getDaysToStay());
		this.setClientNameAndSurname(r.getClientNameAndSurname());
		this.setClientCellPhone(r.getClientCellPhone());
		this.setClientAddress(r.getClientAddress());
		if(r.getPaidOrUnpaid().equals("Paid")||r.getPaidOrUnpaid().equals("Ödendi"))
			this.setPaidOrUnpaid("Paid");
		if(r.getPaidOrUnpaid().equals("Unpaid")||r.getPaidOrUnpaid().equals("Ödenmedi"))
			this.setPaidOrUnpaid("Unpaid");
	}
	
	
	
	
	
	
}
