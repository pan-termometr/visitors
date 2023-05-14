package pl.maciejbadziak.visitorsbackend.visit.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pl.maciejbadziak.visitorsbackend.visit.domain.exception.InvalidIpException;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class IpTest {

    private static final String VALID_IP = "127.0.0.1";
    private static final String INVALID_IP_NUMBER = "1270.0.0.1";
    private static final String INVALID_IP_SYMBOL = "127-0-0-1";
    private static final String ERROR_MESSAGE = "IP [%s] is not valid";

    @Test
    void shouldCreateValidIp() {
        // given
        // when
        // then
        assertThat(Ip.of(VALID_IP).getValue()).isEqualTo(VALID_IP);
    }

    @ParameterizedTest
    @MethodSource("dataErrors")
    void shouldRejectInvalidIpNumber(
            final String ip,
            final String errorMessage
    ) {
        // given
        // when
        final Throwable result = catchThrowable(() -> Ip.of(ip));

        // then
        assertThat(result)
                .isInstanceOf(InvalidIpException.class)
                .hasMessage(errorMessage);
    }

    private static Object[][] dataErrors() {
        return new Object[][] {
                { INVALID_IP_NUMBER, format(ERROR_MESSAGE, INVALID_IP_NUMBER) },
                { INVALID_IP_SYMBOL, format(ERROR_MESSAGE, INVALID_IP_SYMBOL) },
        };
    }
}
