package pl.aogiri.hhu.fsa.backend.movie.application.mapper;

import pl.aogiri.hhu.fsa.backend.auth.user.entity.UserEntity;
import pl.aogiri.hhu.fsa.backend.auth.user.enums.Gender;

public class UserEntityFixture {

    public static UserEntity johnDoe() {
        final var userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setEmail("john.doe@gmail.com");
        userEntity.setPassword("password");
        userEntity.setName("John");
        userEntity.setSurname("Doe");
        userEntity.setGender(Gender.MALE);
        userEntity.setCountry("United States");
        userEntity.setEnabled(true);
        return userEntity;
    }

    public static UserEntity janeDoe() {
        final var userEntity = new UserEntity();
        userEntity.setId(2L);
        userEntity.setEmail("jane.doe@gmail.com");
        userEntity.setPassword("password");
        userEntity.setName("Jane");
        userEntity.setSurname("Doe");
        userEntity.setGender(Gender.FEMALE);
        userEntity.setCountry("United Kingdom");
        userEntity.setEnabled(true);
        return userEntity;
    }

    public static UserEntity johnSmith() {
        final var userEntity = new UserEntity();
        userEntity.setId(3L);
        userEntity.setEmail("john.smith@gmail.com");
        userEntity.setPassword("password");
        userEntity.setName("John");
        userEntity.setSurname("Smith");
        userEntity.setGender(Gender.MALE);
        userEntity.setCountry("Australia");
        userEntity.setEnabled(true);
        return userEntity;
    }
}
