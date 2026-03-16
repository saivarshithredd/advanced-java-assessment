package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.client.MovieClient;
import com.example.demo.model.Booking;
import com.example.demo.model.Movie;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class BookingService {

    @Autowired
    private MovieClient movieClient;

    private List<Booking> bookings = new ArrayList<>();


    @CircuitBreaker(name = "movieService", fallbackMethod = "movieFallback")
    public Booking createBooking(int bookingId, int movieId, int tickets) {

        Movie movie = movieClient.getMovie(movieId);

        double totalAmount = movie.getPrice() * tickets;

        Booking booking = new Booking(bookingId, movieId, tickets, totalAmount);

        bookings.add(booking);

        return booking;
    }


    public List<Booking> getAllBookings() {
        return bookings;
    }


    public Booking movieFallback(int bookingId, int movieId, int tickets, Exception e) {

        Booking booking = new Booking();

        booking.setBookingId(bookingId);
        booking.setMovieId(movieId);
        booking.setTickets(tickets);
        booking.setTotalAmount(0);

        return booking;
    }

}