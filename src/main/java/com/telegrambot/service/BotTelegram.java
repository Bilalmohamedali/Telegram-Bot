package com.telegrambot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class BotTelegram  extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        final String messageTextReceived = update.getMessage().getText();

        System.out.println("Escribiste en el bot " + messageTextReceived);

        final long chatId = update.getMessage().getChatId();


        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Gracias por escribir ");

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "bi_bot";
    }

    @Override
    public String getBotToken() {
        return ""; //Obtener api key desde Botfather.
    }


}
