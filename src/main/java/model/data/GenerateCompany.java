package model.data;

import model.entity.Company;

public class GenerateCompany implements Generator<Company> {
    @Override
    public Company generate(String name) {
        return new Company(RandomizeService.randomizeName(),
                RandomizeService.randomizeName(),
                RandomizeService.randomizeYear());
    }
}
