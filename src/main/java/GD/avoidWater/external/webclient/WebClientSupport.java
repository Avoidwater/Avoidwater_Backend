package GD.avoidWater.external.webclient;

import GD.avoidWater.common.exception.BaseException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;
import java.util.function.Function;

@Component
@Slf4j
@RequiredArgsConstructor
public class WebClientSupport {

    private final WebClient webClient;

    public <T> Mono<T> get(String url, Class<T> responseDtoClass, String... headers) {
        return webClient.get()
                .uri(url)
                .headers(convertStringToHttpHeaders(headers))
                .retrieve()
                .onStatus(HttpStatusCode::isError, onError())
                .bodyToMono(responseDtoClass);
    }

    private Function<ClientResponse, Mono<? extends Throwable>> onError() {
        return response -> {
            System.out.println(response.logPrefix());
            throw new BaseException(response.statusCode().value(), "얘외 발생");
        };
    }

    private Consumer<HttpHeaders> convertStringToHttpHeaders(String... headers) {
        if(headers.length % 2 != 0) {
            throw new BaseException(500, "개발 실수 ㅋㅋ");
        }

        return httpHeaders -> {
            for(int i = 0; i<headers.length; i+=2) {
                httpHeaders.add(headers[i], headers[i+1]);
            }
        };
    }

}