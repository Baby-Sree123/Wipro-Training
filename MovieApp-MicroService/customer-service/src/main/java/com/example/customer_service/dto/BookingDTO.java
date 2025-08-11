package com.example.customer_service.dto;

public class BookingDTO {

    private Long id;
    private String bookingDate;
    private int seats;
    private String movieTitle;
    private String theaterName;

    // No-argument constructor
    public BookingDTO() {
    }

    // All-argument constructor
    public BookingDTO(Long id, String bookingDate, int seats, String movieTitle, String theaterName) {
        this.id = id;
        this.bookingDate = bookingDate;
        this.seats = seats;
        this.movieTitle = movieTitle;
        this.theaterName = theaterName;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    // Builder Pattern Implementation (optional, if you want it without Lombok)

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String bookingDate;
        private int seats;
        private String movieTitle;
        private String theaterName;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder bookingDate(String bookingDate) {
            this.bookingDate = bookingDate;
            return this;
        }

        public Builder seats(int seats) {
            this.seats = seats;
            return this;
        }

        public Builder movieTitle(String movieTitle) {
            this.movieTitle = movieTitle;
            return this;
        }

        public Builder theaterName(String theaterName) {
            this.theaterName = theaterName;
            return this;
        }

        public BookingDTO build() {
            return new BookingDTO(id, bookingDate, seats, movieTitle, theaterName);
        }
    }

    // toString method

    @Override
    public String toString() {
        return "BookingDTO{" +
                "id=" + id +
                ", bookingDate='" + bookingDate + '\'' +
                ", seats=" + seats +
                ", movieTitle='" + movieTitle + '\'' +
                ", theaterName='" + theaterName + '\'' +
                '}';
    }
}
