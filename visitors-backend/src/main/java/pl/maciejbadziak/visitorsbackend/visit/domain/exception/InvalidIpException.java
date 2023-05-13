package pl.maciejbadziak.visitorsbackend.visit.domain.exception;

import java.io.Serial;

public class InvalidIpException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public InvalidIpException(final String ip) {
        super(String.format("IP [%s] is not valid", ip));
    }
}
