package net.therap.mealplannerspring.web.validator;

import net.therap.mealplannerspring.domain.Item;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ItemValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Item.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // Validation
    }
}
