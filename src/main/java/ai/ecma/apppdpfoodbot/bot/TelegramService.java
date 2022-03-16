package ai.ecma.apppdpfoodbot.bot;

import org.telegram.telegrambots.meta.api.methods.groupadministration.SetChatPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface TelegramService {

    SendMessage welcome(Update update);

    SendMessage order(Update update);

    SendMessage selectCategory(Update update);

    SendPhoto selectProduct(Update update);

    SendMessage myOrders(Update update);

    SendMessage settings(Update update);

    SendMessage aboutUs(Update update);

    SendMessage comment(Update update);

    SendMessage sendMessageWithProduct(Update update);
}
