package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaDto;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.request.AddCinemaRequest;
import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaEntity;

import java.sql.Timestamp;
import java.time.Instant;

public class CinemaMapper {

    public static CinemaDto toDto(CinemaEntity cinemaEntity) {
        final var cinemaDto = new CinemaDto();
        cinemaDto.setId(cinemaEntity.getId());
        cinemaDto.setName(cinemaEntity.getName());
        cinemaDto.setAddress(cinemaEntity.getUrl());
        return cinemaDto;
    }

    public static CinemaEntity toEntity(AddCinemaRequest addCinemaRequest) {
        final var cinemaEntity = new CinemaEntity();
        cinemaEntity.setName(addCinemaRequest.getName());
        cinemaEntity.setUrl(addCinemaRequest.getAddress());
        return cinemaEntity;
    }
}
