package pl.aogiri.hhu.fsa.backend.cinema.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.aogiri.hhu.fsa.backend.cinema.application.dto.CinemaFacilityDto;
import pl.aogiri.hhu.fsa.backend.cinema.application.mapper.CinemaFacilityMapper;
import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaFacilityEntity;
import pl.aogiri.hhu.fsa.backend.cinema.domain.repository.CinemaFacilityRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CinemaFacilityService {
    private final CinemaFacilityMapper cinemaFacilityMapper;
    private final CinemaFacilityRepository cinemaFacilityRepository;

    public List<CinemaFacilityDto> getFacilities(Long id){
        List<CinemaFacilityEntity> cinemaFacilityEntityList = cinemaFacilityRepository.findAllByCinemaId(id);
        List<CinemaFacilityDto> cinemaFacilityDtoList = new ArrayList<>(cinemaFacilityEntityList.size());
        for(CinemaFacilityEntity cinemaFacilityEntity: cinemaFacilityEntityList ){
            cinemaFacilityDtoList.add(this.cinemaFacilityMapper.toDto(Optional.of(cinemaFacilityEntity)));
        }

        return cinemaFacilityDtoList;
    }
}
