package pl.maciejbadziak.visitorsbackend.visitarchive.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;
import pl.maciejbadziak.visitorsbackend.visitarchive.domain.exception.InvalidIpException;

import java.util.regex.Pattern;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Ip {

    private static final Pattern IP_ADDRESS_PATTERN = Pattern.compile("^((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)\\.?\\b){4}$");

    String value;

    public static Ip of(final String value) {
        validate(value);
        return new Ip(value);
    }

    private static void validate(final String value) {
        if (!IP_ADDRESS_PATTERN.matcher(value).matches()) {
            throw new InvalidIpException(value);
        }
    }
}
