package marcelo.atv3mobile.projetocadastro.app.src.main.java.com.example.presenter;

import android.content.Intent;
import android.content.res.Resources;

import marcelo.atv3mobile.projetocadastro.app.src.main.java.com.example.R;
import marcelo.atv3mobile.projetocadastro.app.src.main.java.com.example.model.User;
import marcelo.atv3mobile.projetocadastro.app.src.main.java.com.example.repository.UserRepository;
import marcelo.atv3mobile.projetocadastro.app.src.main.java.com.example.view.MainActivity;

public class LoginPresenter implements LoginPresenterContract.presenter{
    private LoginPresenterContract.view view;

    public LoginPresenter(LoginPresenterContract.view view) {
        this.view = view;
    }
    @Override
    public void checkLogin(String login, String password) {
        UserRepository repo  = UserRepository.getInstance(view.getActivity(), null);
        User u = repo.getUserByUserLogin(login);
        if (u == null || ! u.getPassword().equals(password)) {
            view.message("Usuário ou senha Inválido");
        } else {
            validLogin(u);
        }
    }
    @Override
    public void validLogin(User user) {
        Intent intent = new Intent(view.getActivity(), MainActivity.class);
        intent.putExtra("userObj", user);
        view.preferencesUserUpdate(user.getId());
        view.getActivity().startActivity(intent);
    }
}
