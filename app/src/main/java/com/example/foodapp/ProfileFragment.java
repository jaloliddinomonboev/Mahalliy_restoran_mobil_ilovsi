package com.example.foodapp;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private TextView nameTextView, phoneTextView, addressTextView;
    private AppCompatButton loadButton;

    private SQLiteHelper dbHelper;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        dbHelper = new SQLiteHelper(getContext());


        nameTextView = view.findViewById(R.id.nameTextView);
        phoneTextView = view.findViewById(R.id.phoneTextView);
        addressTextView = view.findViewById(R.id.addressTextView);
        loadButton = view.findViewById(R.id.loadButton);


        loadButton.setOnClickListener(v -> checkAndLoadUserData());

        return view;
    }

    private void checkAndLoadUserData() {
        Cursor cursor = dbHelper.getUser();

        if (cursor != null && cursor.moveToFirst()) {
            try {

                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(SQLiteHelper.COLUMN_NAME));
                @SuppressLint("Range") String phone = cursor.getString(cursor.getColumnIndex(SQLiteHelper.COLUMN_PHONE));
                @SuppressLint("Range") String address = cursor.getString(cursor.getColumnIndex(SQLiteHelper.COLUMN_ADDRESS));

                nameTextView.setText(name);
                phoneTextView.setText(phone);
                addressTextView.setText(address);
            } finally {
                cursor.close();
            }
        } else {

            showRegistrationDialog();
        }
    }

    private void showRegistrationDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_register, null);
        dialogBuilder.setView(dialogView);

        EditText nameEditText = dialogView.findViewById(R.id.dialogNameEditText);
        EditText phoneEditText = dialogView.findViewById(R.id.dialogPhoneEditText);
        EditText addressEditText = dialogView.findViewById(R.id.dialogAddressEditText);
        AppCompatButton registerButton = dialogView.findViewById(R.id.dialogRegisterButton);

        AlertDialog alertDialog = dialogBuilder.create();

        registerButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString();
            String phone = phoneEditText.getText().toString();
            String address = addressEditText.getText().toString();

            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(address)) {
                Toast.makeText(getContext(), "Iltimos, barcha maydonlarni toldiring", Toast.LENGTH_SHORT).show();
            } else {
                dbHelper.insertUser(name, phone, address, "path/to/image");
                Toast.makeText(getContext(), "Foydalanuvchi muvaffaqiyatli ro'yxatdan o'tdi", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();


                checkAndLoadUserData();
            }
        });

        alertDialog.show();
    }
}
