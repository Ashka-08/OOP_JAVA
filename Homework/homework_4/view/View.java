package Homework.homework_4.view;

import Homework.homework_4.presenter.Presenter;

public interface View {
    void setPresenter(Presenter presenter);
    void start();
    void print(String text);
    String searchSetName();
}
