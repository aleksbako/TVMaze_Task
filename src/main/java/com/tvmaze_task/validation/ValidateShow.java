package com.tvmaze_task.validation;

import com.tvmaze_task.model.Episode;
import com.tvmaze_task.model.Show;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class ValidateShow {
    private static final Validator VALIDATOR;
    private static final Logger LOGGER = Logger.getLogger(ValidateShow.class.getName());

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        VALIDATOR = factory.getValidator();
    }

    public static boolean isValid(Show show) {
        Set<ConstraintViolation<Show>> violations = VALIDATOR.validate(show);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<Show> violation : violations) {
                LOGGER.log(Level.WARNING, "Validation failure - Property: {0}, Message: {1}",
                        new Object[]{violation.getPropertyPath(), violation.getMessage()});
            }
            return false;
        }

        return true;
    }


    public static boolean isListValid(List<Show> shows) {
        for (Show show : shows) {
            if (!ValidateShow.isValid(show)) {
                return false;
            }
        }
        return true;
    }
}