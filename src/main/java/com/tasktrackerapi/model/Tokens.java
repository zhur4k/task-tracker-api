package com.tasktrackerapi.model;

public record Tokens(
        String accessToken,
        String accessTokenExpiry,
        String refreshToken,
        String refreshTokenExpiry
) {
}
