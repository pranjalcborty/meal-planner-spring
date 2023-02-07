package net.therap.mealplannerspring.web.validator;

import net.therap.mealplannerspring.domain.Item;
import net.therap.mealplannerspring.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ItemValidator implements Validator {
    @Autowired
    private ItemService itemService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Item.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Item item = (Item) target;

        if (itemService.contains(item)) {
            errors.reject("name");
        }
    }
}
