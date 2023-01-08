package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaDetailsDto;
import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaEntity;

public class CinemaDetailsMapper {
    public static CinemaDetailsDto toDto(CinemaEntity cinemaEntity) {
        final var cinemaDetailsDto = new CinemaDetailsDto();
        cinemaDetailsDto.setName(cinemaEntity.getName());
        cinemaDetailsDto.setUrl(cinemaEntity.getUrl());
        return cinemaDetailsDto;
    }
}
