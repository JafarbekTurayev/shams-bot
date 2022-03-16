package ai.ecma.apppdpfoodbot.bot;

import ai.ecma.apppdpfoodbot.entity.User;
import ai.ecma.apppdpfoodbot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ShamsBot extends TelegramLongPollingBot {
    @Value("${telegram_bot_username}")
    String username;
    @Value("${telegram_bot_botToken}")
    String botToken;

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }


    final TelegramServiceImpl telegramService;
    final UserRepository userRepository;

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {

        User currentUser;

        if (update.hasMessage()) {
            Optional<User> optionalUser = userRepository.findByChatId(String.valueOf(update.getMessage().getChatId()));
            Message message = update.getMessage();
            if (message.hasText()) {
                if (message.getText().equals("/start")) {
                    if (optionalUser.isPresent()) {
                        currentUser = optionalUser.get();
                        currentUser.setState(State.START);
                        currentUser.setFullName(update.getMessage().getFrom().getFirstName());
                        userRepository.save(currentUser);
                    } else {
                        currentUser = new User();
                        currentUser.setChatId(String.valueOf(update.getMessage().getChatId()));
                        currentUser.setState(State.START);
                        userRepository.save(currentUser);
                    }
                    execute(telegramService.welcome(update));
                } else {
                    currentUser = optionalUser.get(); //qaysi bosqichda
                    switch (currentUser.getState()) {
                        case State.START:
                            //menyudan 5 xil button bosishi mn
                            switch (update.getMessage().getText()) {
                                case Constant.ORDER_BUTTON:
                                    currentUser.setState(State.ORDER);
                                    userRepository.save(currentUser);
                                    execute(telegramService.order(update));
                                    break;
                                case Constant.MY_ORDERS_BUTTON:
                                    execute(telegramService.myOrders(update));
                                    break;
                                case Constant.SETTINGS:
                                    execute(telegramService.settings(update));
                                    break;
                                case Constant.ABOUT_US:
                                    execute(telegramService.aboutUs(update));
                                    break;
                                case Constant.LEAVE_COMMENT:
                                    execute(telegramService.comment(update));
                                    break;
                            }
                            break;
                        case State.ORDER:
                            switch (update.getMessage().getText()) {
                                case Constant.BACK:
                                case Constant.MAIN_MENU_BUTTON:
                                    currentUser.setState(State.START);
                                    userRepository.save(currentUser);
                                    execute(telegramService.welcome(update));
                                    break;
                                default:
                                    currentUser.setState(State.SELECT_CAT);
                                    userRepository.save(currentUser);
                                    execute(telegramService.selectCategory(update));
                            }
                            break;
                        case State.SELECT_CAT:
                            switch (update.getMessage().getText()) {
                                case Constant.MAIN_MENU_BUTTON:
                                    currentUser.setState(State.START);
                                    userRepository.save(currentUser);
                                    execute(telegramService.welcome(update));
                                    break;
                                case Constant.BACK:
                                    currentUser.setState(State.ORDER);
                                    userRepository.save(currentUser);
                                    execute(telegramService.order(update));
                                    break;
                                default:
                                    currentUser.setState(State.SELECT_PRO);
                                    userRepository.save(currentUser);
                                    execute(telegramService.selectProduct(update));
                                    execute(telegramService.sendMessageWithProduct(update));
                            }
                            break;
                    }
                }
            }
        }

    }

}

