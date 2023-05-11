package pl.maciejbadziak.visitorsbackend.visitarchive.adapter.in.rest.exception;

import java.io.Serial;

public class InvalidRequestException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public InvalidRequestException() {
        super("Mandatory data is missing");
    }
}