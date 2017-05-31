package net.therap.mealplannerspring.web.validator;

import net.therap.mealplannerspring.domain.Meal;
import net.therap.mealplannerspring.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MealValidator implements Validator {
    @Autowired
    private MealService mealService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Meal.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Meal meal = (Meal) target;

        if (mealService.contains(meal)) {
            errors.reject("dayAndType");
        }
    }
}