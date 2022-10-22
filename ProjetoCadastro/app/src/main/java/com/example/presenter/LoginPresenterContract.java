package marcelo.atv3mobile.projetocadastro.app.src.main.java.com.example.presenter;

import android.app.Activity;
import android.content.Context;

import marcelo.atv3mobile.projetocadastro.app.src.main.java.com.example.model.User;

public class LoginPresenterContract {
    public interface view {
        public void message(String msg);
        public Activity getActivity();
        public void preferencesUserUpdate(int userId);
    }

    public interface presenter {
        public void checkLogin(String login, String password);
        public void validLogin(User user);

    }
}
