package net.therap.mealplannerspring.web.editor;

import net.therap.mealplannerspring.domain.Item;

import java.beans.PropertyEditorSupport;

public class ItemEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        long id = text == null ? 0 : Long.parseLong(text);

        Item item = new Item();
        item.setId(id);

        setValue(item);
    }
}
