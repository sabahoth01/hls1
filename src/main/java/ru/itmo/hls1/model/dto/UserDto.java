package ru.itmo.hls1.model.dto;

public record UserDto(
    Long user_id,
    String first_name,
    String last_name,
    String username,
    String email,
    String gender,
    Integer phone){
}
