package model.entity;

import java.util.Objects;

public class Seat {
    private Integer seatNumber;
    private String ownerName;

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public String toString() {
        return "Seat\n" +
                "seatNumber: " + seatNumber +
                ", ownerName: " + ownerName + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return Objects.equals(seatNumber, seat.seatNumber) &&
                Objects.equals(ownerName, seat.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatNumber, ownerName);
    }
}
