package com.tvmaze_task.validation;

import com.tvmaze_task.model.Episode;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ValidateEpisode {
    private static final Validator VALIDATOR;
    private static final Logger LOGGER = Logger.getLogger(ValidateEpisode.class.getName());

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        VALIDATOR = factory.getValidator();
    }

    public static boolean isValid(Episode episode) {
        Set<ConstraintViolation<Episode>> violations = VALIDATOR.validate(episode);
        //Check if string values have symbols

        if (!violations.isEmpty()) {
            for (ConstraintViolation<Episode> violation : violations) {
                LOGGER.log(Level.WARNING, "Validation failure - Property: {0}, Message: {1}",
                        new Object[]{violation.getPropertyPath(), violation.getMessage()});
            }
            return false;
        }

        return true;
    }

    public static boolean isListValid(List<Episode> episodes){
        for (Episode episode : episodes) {
            if (!ValidateEpisode.isValid(episode)) {
                return false;
            }
        }
        return true;
    }
}
