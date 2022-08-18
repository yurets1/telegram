package com.example.RealTimeApp.telegram;

import com.example.RealTimeApp.controller.TaskController;
import com.example.RealTimeApp.service.telegram.CsvExport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class Bot extends TelegramLongPollingBot {
    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    private CsvExport csvExport;

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    private TaskController taskController;


    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            String chatId = update.getMessage().getChatId().toString();


            SendMessage sm = new SendMessage();
            sm.setChatId(chatId);
            sm.setText(message);
            if (sm.getText().equals("/start")) {
                sm.setText("hi");
            } else if (sm.getText().equals("get task")) {


            } else {
                sm.setText("I'm sorry, I did not understand you");
            }



            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
            replyKeyboardMarkup.setResizeKeyboard(true);
            replyKeyboardMarkup.setSelective(true);
            List<KeyboardRow> keyboardRowList = new ArrayList<>();
            KeyboardRow keyboardRow1 = new KeyboardRow();
            KeyboardButton keyboardButton1 = new KeyboardButton();
            keyboardButton1.setText("get task");
            keyboardRow1.add(keyboardButton1);
            keyboardRowList.add(keyboardRow1);
            replyKeyboardMarkup.setKeyboard(keyboardRowList);




            sm.setReplyMarkup(replyKeyboardMarkup);
            try {
                execute(sm);
            } catch (TelegramApiException e) {
                //todo add logging to the project.
                e.printStackTrace();
            }
        }
    }


}
