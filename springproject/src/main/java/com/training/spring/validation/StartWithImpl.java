package com.training.spring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartWithImpl implements ConstraintValidator<StartWith, String> {

    private StartWith ano;

    @Override
    public void initialize(final StartWith ano) {
        this.ano = ano;
    }

    @Override
    public boolean isValid(final String valueParam,
                           final ConstraintValidatorContext contextParam) {
        return valueParam.startsWith(this.ano.value());
    }

}
