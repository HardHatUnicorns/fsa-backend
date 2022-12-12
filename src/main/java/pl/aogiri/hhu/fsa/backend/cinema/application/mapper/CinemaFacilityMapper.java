package pl.aogiri.hhu.fsa.backend.cinema.application.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDto;
import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaFacilityEntity;
import pl.aogiri.hhu.fsa.backend.cinema.exception.CinemaFacilityNotFoundException;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CinemaFacilityMapper {
    public CinemaFacilityDto toDto(Optional<CinemaFacilityEntity> cinemaFacilityEntityPossible){
        if(cinemaFacilityEntityPossible.isEmpty())
            throw new CinemaFacilityNotFoundException("Try mapper null object.");

        CinemaFacilityEntity cinemaFacilityEntity = cinemaFacilityEntityPossible.get();
        CinemaFacilityDto cinemaFacilityDto = new CinemaFacilityDto();
        cinemaFacilityDto.setId(cinemaFacilityEntity.getId()); //TODO Should we mapper Id from database or create new?
        cinemaFacilityDto.setName(cinemaFacilityEntity.getName());
        cinemaFacilityDto.setAddress(cinemaFacilityEntity.getAddress());
        return cinemaFacilityDto;
    }

}
