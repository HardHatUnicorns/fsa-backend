package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaDto;
import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaEntity;

public class CinemaMapper {

    public static CinemaDto toDto(CinemaEntity cinemaEntity) {
        final var cinemaDto = new CinemaDto();
        cinemaDto.setId(cinemaEntity.getId());
        cinemaDto.setName(cinemaEntity.getName());
        cinemaDto.setAddress(cinemaEntity.getUrl());
        return cinemaDto;
    }
}
