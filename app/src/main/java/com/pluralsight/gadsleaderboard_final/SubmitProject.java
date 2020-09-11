package com.pluralsight.gadsleaderboard_final;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.pluralsight.gadsleaderboard_final.projectpost.ApiClient;
import com.pluralsight.gadsleaderboard_final.projectpost.UserRequest;
import com.pluralsight.gadsleaderboard_final.projectpost.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitProject extends AppCompatActivity {

    public static final String TAG = "TAG";
    EditText firstName, lastName, emailAddress, postUrl;
    Button postRequest; //yes button

    Dialog submissionPopup;
    Dialog submissionSuccessful;
    Dialog submissionError;
    Button closePopup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submission_form);

        firstName = findViewById(R.id.text_first_name);
        lastName = findViewById(R.id.text_last_name);
        emailAddress = findViewById(R.id.text_email_address);
        postUrl = findViewById(R.id.text_github_link);

        postRequest = findViewById(R.id.button_submit);

        postRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If all of the details have been filled in correctly, proceed to producing the submission confirmation popup
                if(TextUtils.isEmpty(firstName.getText().toString()))
                {
                    Toast.makeText(SubmitProject.this, "First Name Field Empty", Toast.LENGTH_LONG).show();
                }else if(TextUtils.isEmpty(lastName.getText().toString()))
                {

                }else if(TextUtils.isEmpty(emailAddress.getText().toString()))
                {

                }else if(TextUtils.isEmpty(postUrl.getText().toString()))
                {

                }else
                {
                    ShowPopup();
                    //postProject(createUserRequest());
                }
            }
        });

        submissionPopup = new Dialog(this);
    }

    public UserRequest createUserRequest(){
        UserRequest userRequest = new UserRequest();
        userRequest.setFirstName(firstName.getText().toString());
        userRequest.setLastName(lastName.getText().toString());
        userRequest.setEmail(emailAddress.getText().toString());
        userRequest.setProjectLink(postUrl.getText().toString());

        return userRequest;
    }

    public void postProject(UserRequest userRequest)
    {
        Call<UserResponse> userResponseCall = ApiClient.getUserService().
                postProject(emailAddress.getText().toString(),  firstName.getText().toString(), lastName.getText().toString(), postUrl.getText().toString());
                userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(response.isSuccessful()){
                    //allow the submission successful dialog to popup
                    Toast.makeText(SubmitProject.this, "Submission was successful", Toast.LENGTH_LONG).show();
                    successSubmissionPopup();
                }else{
                    //allow the submission error dialog to popup
                    Toast.makeText(SubmitProject.this, "Submission failed", Toast.LENGTH_LONG).show();
                    failureSubmissionPopup();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                //allow the submission error dialog to popup
                Log.e(TAG, "Unable to submit post to API");
                Toast.makeText(SubmitProject.this, "Submission failed "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                failureSubmissionPopup();
            }
        });
    }

    private void failureSubmissionPopup()
    {
        submissionError.setContentView(R.layout.submission_error);
        submissionError.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    private void successSubmissionPopup()
    {
        submissionSuccessful.setContentView(R.layout.submission_success_popup);
        submissionSuccessful.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    public void ShowPopup(){
        Button acceptSubmission;
        submissionPopup.setContentView(R.layout.confirmation_popup);
        closePopup = submissionPopup.findViewById(R.id.close_popup);
        acceptSubmission = submissionPopup.findViewById(R.id.yes_button);

        closePopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submissionPopup.dismiss();
            }
        });

        acceptSubmission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postProject(createUserRequest());
            }
        });
    }
}
