package ru.clevertec;


import ru.clevertec.view.StoreView;

public class Shop_test {

    public static void main(String[] args) {
        String list = "";
        for (String s : args){
            list+=s + '\n';
        }
        StoreView storeView = new StoreView();
        storeView.start(list);
    }
}