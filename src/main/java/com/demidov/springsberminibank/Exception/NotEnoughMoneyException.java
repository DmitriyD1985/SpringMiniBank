package com.demidov.springsberminibank.Exception;

public class NotEnoughMoneyException extends Exception{

        public NotEnoughMoneyException(String text)
        {
            super(text);
        }
}
