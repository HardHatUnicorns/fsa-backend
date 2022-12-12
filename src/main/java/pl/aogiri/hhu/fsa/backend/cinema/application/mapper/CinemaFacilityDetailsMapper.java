package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDetailsDto;
import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaFacilityEntity;
import pl.aogiri.hhu.fsa.backend.cinema.exception.CinemaFacilityNotFoundException;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CinemaFacilityDetailsMapper {
    public CinemaFacilityDetailsDto toDto(Optional<CinemaFacilityEntity> cinemaFacilityEntityPossible){
        if(cinemaFacilityEntityPossible.isEmpty())
            throw new CinemaFacilityNotFoundException("Try mapper null object.");

        CinemaFacilityEntity cinemaFacilityEntity = cinemaFacilityEntityPossible.get();

        CinemaFacilityDetailsDto cinemaFacilityDetailsDto = new CinemaFacilityDetailsDto();
        cinemaFacilityDetailsDto.setId(cinemaFacilityEntity.getId()); //TODO Should we mapper Id from database or create new ID?
        cinemaFacilityDetailsDto.setName(cinemaFacilityEntity.getName());
        cinemaFacilityDetailsDto.setAddress(cinemaFacilityEntity.getAddress());
        cinemaFacilityDetailsDto.setEmail(cinemaFacilityEntity.getEmail());
        cinemaFacilityDetailsDto.setDescription(cinemaFacilityEntity.getDescription());
        cinemaFacilityDetailsDto.setTelephone(cinemaFacilityEntity.getTelephone());
        return cinemaFacilityDetailsDto;
    }

}
