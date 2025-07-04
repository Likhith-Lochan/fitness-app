package com.fitness.gateway.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final WebClient userServiceWebClient;

    public Mono<Boolean> validateUser(String userId){

            return userServiceWebClient.get().uri("/api/users/{userId}/validate", userId).retrieve().bodyToMono(Boolean.class)
                    .onErrorResume(WebClientResponseException.class,e -> {
                        if(e.getStatusCode()==HttpStatus.NOT_FOUND)
                            return Mono.error(new RuntimeException("user not found : "+userId));
                        else
                            return Mono.error(new RuntimeException("Invalid request : "+ userId));
//                        return Mono.error(new RuntimeException("Unexpected error : "+ e.getMessage()));
                    });

    }

    public Mono<UserResponse> registerUser(RegisterRequest request) {
        return userServiceWebClient.post()
                .uri("/api/users/register")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(UserResponse.class)
                .onErrorResume(WebClientResponseException.class,e -> {
                    if(e.getStatusCode()==HttpStatus.BAD_REQUEST)
                        return Mono.error(new RuntimeException("Bad request: "));
                    else
                        return Mono.error(new RuntimeException("Internal server error : "+ e.getMessage()));
//                        return Mono.error(new RuntimeException("Unexpected error : "+ e.getMessage()));
                });
    }
}
