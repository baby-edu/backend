package com.hayfar.baby_education.services;

import com.hayfar.baby_education.entity.Animals;
import com.hayfar.baby_education.repositories.AnimalsRepository;
import com.hayfar.baby_education.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnimalsService {

    private final AnimalsRepository animalsRepository;

    public AnimalsService(AnimalsRepository animalsRepository) {
        this.animalsRepository = animalsRepository;
    }

    public Animals addAnimal(Animals animals) {
        Animals editAnimals = new Animals();
        editAnimals.setName(animals.getName());
        editAnimals.setDescription(animals.getDescription());

        animalsRepository.save(editAnimals);
        return editAnimals;
    }

    public List<Animals> getAllAnimals() {
        return animalsRepository.findAll();
    }

    public Optional<Animals> findAnimal(Long billId) {
        return animalsRepository.findById(billId);
    }

    public void deleteAnimal(Long billId) {
        animalsRepository.deleteById(billId);
    }
}
