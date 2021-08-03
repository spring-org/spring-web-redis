package com.example.springwebredis.dto;

import com.example.springwebredis.domain.RedisEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@ToString
public class RedisDto {
    private String id;
    private String value;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime createdAt;

    @Builder
    public RedisDto(String id, String value, LocalDateTime createdAt) {
        this.id = id;
        this.value = value;
        this.createdAt = createdAt;
    }

    public static RedisDto toDto(RedisSaveDto saveDto) {
        return RedisDto.builder()
                .value(saveDto.getValue())
                .build();
    }

    public static RedisEntity toEntity(RedisDto redisDto) {
        return RedisEntity.builder()
                .value(redisDto.getValue())
                .createdAt(redisDto.getCreatedAt())
                .build();
    }

    public static RedisEntity toEntity(String id, RedisDto redisDto) {
        return RedisEntity.builder()
                .id(id)
                .value(redisDto.getValue())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
