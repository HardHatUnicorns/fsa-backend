package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDetailsDto;
import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaFacilityEntity;

@RequiredArgsConstructor
@Component
public class CinemaFacilityDetailsMapper {

    public static CinemaFacilityDetailsDto toDto(CinemaFacilityEntity cinemaFacilityEntity) {
        CinemaFacilityDetailsDto cinemaFacilityDetailsDto = new CinemaFacilityDetailsDto();
        cinemaFacilityDetailsDto.setId(cinemaFacilityEntity.getId());
        cinemaFacilityDetailsDto.setName(cinemaFacilityEntity.getName());
        cinemaFacilityDetailsDto.setAddress(cinemaFacilityEntity.getAddress());
        cinemaFacilityDetailsDto.setEmail(cinemaFacilityEntity.getEmail());
        cinemaFacilityDetailsDto.setDescription(cinemaFacilityEntity.getDescription());
        cinemaFacilityDetailsDto.setTelephone(cinemaFacilityEntity.getTelephone());
        return cinemaFacilityDetailsDto;
    }
}
