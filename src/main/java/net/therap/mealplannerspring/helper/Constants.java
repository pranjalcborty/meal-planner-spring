package net.therap.mealplannerspring.helper;

public interface Constants {

    String USER_NAME = "uname";
    String PASSWORD = "pass";
    String ADD_ITEM_NOTIFY = "messageAddItem";
    String ADD_PLAN_NOTIFY = "messageAddPlan";
    String FAILURE_NOTIFY = "failureMessage";

    String HOME_PATH = "home";
    String ABS_HOME_PATH = "homepage";
    String REGISTER_PATH = "register";
    String ABS_REGISTER_PATH = "register";
    String LOGIN_PATH = "login";
    String ABS_LOGIN_PATH = "index";
    String VIEW_PLANS_PATH = "viewPlans";
    String ABS_VIEW_PLANS_PATH = "viewPlans";
    String VIEW_ITEMS_PATH = "viewItems";
    String ABS_VIEW_ITEMS_PATH = "viewItems";
    String ADD_PLAN_PATH = "addPlan";
    String ABS_ADD_PLAN_PATH = "addPlans";
    String ADD_ITEM_PATH = "addItem";
    String ABS_ADD_ITEM_PATH = "addNewItem";
    String ASSETS_PATH = "/assets";

    String ITEM_LIST = "items";
    String MEAL_LIST = "meals";
    String REDIRECT_TAG = "redirect:";

    String REGISTRATION_ERROR = "Check: \n " +
            "1. Username exists \n" +
            "2. Password must be grater than 5 in length \n" +
            "3. Full Name and username cannot be empty";
}
