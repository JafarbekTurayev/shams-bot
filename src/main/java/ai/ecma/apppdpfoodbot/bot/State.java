package ai.ecma.apppdpfoodbot.bot;

public interface State {
    String START = "start";
    String MENU = "menu";
    String ORDER = "order";
    String SELECT_CAT = "select_category";
    String SELECT_PRO = "select_product";
}
