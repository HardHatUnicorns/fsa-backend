package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDto;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.request.AddCinemaFacilityRequest;
import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaEntity;
import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaFacilityEntity;

public class CinemaFacilityMapper {

    public static CinemaFacilityDto toDto(CinemaFacilityEntity cinemaFacilityEntity) {
        CinemaFacilityDto cinemaFacilityDto = new CinemaFacilityDto();
        cinemaFacilityDto.setId(cinemaFacilityEntity.getId());
        cinemaFacilityDto.setName(cinemaFacilityEntity.getName());
        cinemaFacilityDto.setAddress(cinemaFacilityEntity.getAddress());
        return cinemaFacilityDto;
    }

    public static CinemaFacilityEntity toEntity(CinemaEntity cinemaEntity, AddCinemaFacilityRequest addCinemaFacilityRequest){
        CinemaFacilityEntity cinemaFacilityEntity = new CinemaFacilityEntity();
        cinemaFacilityEntity.setName(addCinemaFacilityRequest.getName());
        cinemaFacilityEntity.setCinema(cinemaEntity);
        cinemaFacilityEntity.setEmail(addCinemaFacilityRequest.getEmail());
        cinemaFacilityEntity.setAddress(addCinemaFacilityRequest.getAddress());
        cinemaFacilityEntity.setDescription(addCinemaFacilityRequest.getDescription());
        cinemaFacilityEntity.setTelephone(addCinemaFacilityRequest.getTelephone());
        return cinemaFacilityEntity;
    }

}
