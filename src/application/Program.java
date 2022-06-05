package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("check-in (DD/MM/YYYY):");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("check-out (DD/MM/YYYY):");
		Date checkOut = sdf.parse(sc.next());
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: check-out date must be after check-in date!");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter date to update the reservation:");
			System.out.println("check-in (DD/MM/YYYY):");
			checkIn = sdf.parse(sc.next());
			System.out.println("check-out (DD/MM/YYYY):");
			checkOut = sdf.parse(sc.next());
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: reservation dates for updates must be future dates");
			} else {
				if (!checkOut.after(checkIn)) {
					System.out.println("check-out date must be after check-in date");
				} else {

					reservation.updateDate(checkIn, checkOut);
					System.out.println("Reservation " + reservation);
				}
			}

		}

		sc.close();
	}

}
