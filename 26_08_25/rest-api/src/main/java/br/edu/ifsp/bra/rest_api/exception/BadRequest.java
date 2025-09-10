package br.edu.ifsp.bra.rest_api.exception;

public class BadRequest extends Exception {
    public BadRequest(String message) {
        super(message);
    }
}