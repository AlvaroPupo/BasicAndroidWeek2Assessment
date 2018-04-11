package com.example.rodneytressler.week2assessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    // Alvaro Hernandez Pupo

    @BindView(R.id.input_email)
    protected EditText email;
    @BindView(R.id.input_name)
    protected EditText name;

    private WelcomeFragment welcomeFragment;
    public static final String NAME_AND_EMAIL = "name_and_email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void toastRegistrationFailure() {
        Toast.makeText(this, "Please enter all fields first!", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.button_register)
    protected void registerButton() {


        String userName = name.getText().toString();
        String userEmail = email.getText().toString();

        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(userEmail)) {
            toastRegistrationFailure();
        } else {

            Account account = new Account(userName, userEmail);

            welcomeFragment = WelcomeFragment.newInstance();

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, welcomeFragment).commit();

            Bundle bundle = new Bundle();
            bundle.putParcelable(NAME_AND_EMAIL, account);
            welcomeFragment.setArguments(bundle);

            email.setText("");
            name.setText("");
        }
    }
}
