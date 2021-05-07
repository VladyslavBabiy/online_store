package ua.babiy.online_store.exceptions;

public class StockIsNotEnoughException extends RuntimeException {
    final static String message = "Stock is not enough";

    public StockIsNotEnoughException() {
        super(message);
    }
}