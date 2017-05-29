package net.therap.mealplannerspring.service;

import net.therap.mealplannerspring.dao.ItemDao;
import net.therap.mealplannerspring.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemDao itemDao;


    public void addItem(Item item) {
        itemDao.addItem(item);
    }

    public List<Item> showItems() {
        List<Item> items = itemDao.generateItems();
        return items;
    }
}
