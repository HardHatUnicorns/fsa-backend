package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDto;
import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaFacilityEntity;

public class CinemaFacilityMapper {

    public static CinemaFacilityDto toDto(CinemaFacilityEntity cinemaFacilityEntity) {
        CinemaFacilityDto cinemaFacilityDto = new CinemaFacilityDto();
        cinemaFacilityDto.setId(cinemaFacilityEntity.getId());
        cinemaFacilityDto.setName(cinemaFacilityEntity.getName());
        cinemaFacilityDto.setAddress(cinemaFacilityEntity.getAddress());
        return cinemaFacilityDto;
    }
}
