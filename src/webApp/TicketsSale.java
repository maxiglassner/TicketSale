package webApp;

public class TicketsSale {

	private Seat[] seats;

	private boolean reservations_possible;

	public TicketsSale() {
		seats = new Seat[100];
		for (int i = 0; i < 100; i++)
			seats[i] = new Seat(i + 1);
		reservations_possible = true;
	}

	public void show_all_tickets() {
		for (int i = 0; i < seats.length - 1; i++) {
			System.out.println(seats[i].state);
			if (seats[i].state == State.AVAILABLE) {
				System.out.println("Seat is still available");
			} else {
				System.out.println("Seat is NOT available");
			}
		}
	}

	public void sell_free_ticket(int seatnumber) {
		int index = seatnumber - 1;
		if (index > -1 && index < 100) {
			switch (seats[index].state) {

			case AVAILABLE:
				seats[index].state = State.SOLD;
				break;

			case RESERVED:
				throw new Kartenverkaufexception("seat is already reserved");

			case SOLD:
				throw new Kartenverkaufexception("seat is already sold");

			default:
				break;
			}

		} else {
			throw new Kartenverkaufexception("Please insert a correct seat number");
		}
	}

	public void reserve_ticket(int seatnumber, String reservation_name) {
		if (!reservations_possible) throw new Kartenverkaufexception("no reservations are posible");
		else {
		int index = seatnumber - 1;
		if (index > -1 && index < 100) {
			switch (seats[index].state) {

			case AVAILABLE:
				if (reservation_name.equals(null))
					throw new Kartenverkaufexception("Please insert a Reservationname");
				else {
					seats[index].state = State.RESERVED;
					seats[index].reservation_name = reservation_name;
				}
				break;

			case RESERVED:
				throw new Kartenverkaufexception("seat is already reserved");

			case SOLD:
				throw new Kartenverkaufexception("Seast already sold");

			default:
				break;
			}

		} else {
			throw new Kartenverkaufexception("Please insert a correct seat number");
		}
		}
	}

	public void sell_reserved_ticket(int seatnumber, String reservation_name) {
		int index = seatnumber - 1;
		if (index > -1 && index < 100) {
			switch (seats[index].state) {

			case AVAILABLE:
				throw new Kartenverkaufexception("Reserve ticket first");

			case RESERVED:
				if (reservation_name.equals(seats[index].reservation_name)) {
					seats[index].state = State.SOLD;
				} else
					throw new Kartenverkaufexception("Wrong reservationname for this seat number");
				break;

			case SOLD:
				throw new Kartenverkaufexception("Sealt already sold");

			default:
				break;
			}

		} else {
			throw new Kartenverkaufexception("Please insert a correct seat number");
		}
	}

	public void cancel_ticket(int seatnumber) {
		int index = seatnumber - 1;
		if (index > -1 && index < 100) {
			switch (seats[index].state) {

			case AVAILABLE:
				throw new Kartenverkaufexception("Ticket is free");

			case RESERVED:
				seats[index].state = State.AVAILABLE;
				seats[index].reservation_name = "";
				break;

			case SOLD:
				seats[index].state = State.AVAILABLE;
				break;

			default:
				break;
			}

		} else {
			throw new Kartenverkaufexception("Please insert a correct seat number");
		}
	}

	public void cancel_all_reservations() {
		if (reservations_possible) {
			reservations_possible = false;
			for (int i = 0; i < seats.length; i++) {
				if (seats[i].state == State.RESERVED) {
					seats[i].state = State.AVAILABLE;
					seats[i].reservation_name = "";
				}
			}

		} else {
			throw new Kartenverkaufexception("Reservations are already canceled");
		}

	}

	public Seat getSeat(int i) {
		return seats[i];
	}

	public boolean isReservations_possible() {
		return reservations_possible;
	}
}