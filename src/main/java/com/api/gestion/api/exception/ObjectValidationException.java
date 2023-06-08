package com.api.gestion.api.exception;

import java.util.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ObjectValidationException extends RuntimeException {

    @Getter
    private final Set<String> violations;
    @Getter
    private final String violationSource;
}
