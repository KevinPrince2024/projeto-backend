package br.edu.ifsp.graphql.exceptions;

public class BadRequest extends Exception {
    public BadRequest(String message) {
        super(message);
    }
}
