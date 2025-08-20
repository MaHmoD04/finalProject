package com.example.finalproject.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.finalproject.Home_screen;
import com.example.finalproject.MainActivity;
import com.example.finalproject.R;

public class ProfileFragment extends Fragment {

    public ProfileFragment() { }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle s) {
        super.onViewCreated(v, s);

        v.findViewById(R.id.ib_iconBack).setOnClickListener(btn -> {
            // يستدعي دالة في الـ Activity للرجوع لتبويب Home
            if (requireActivity() instanceof Home_screen) {
                ((Home_screen) requireActivity()).goToHome();
            } else {
                requireActivity().getOnBackPressedDispatcher().onBackPressed();
            }
        });

        // أمثلة لأحداث الضغط على الصفوف:
        v.findViewById(R.id.row_edit).setOnClickListener(x -> {
            // افتح شاشة تعديل الملف الشخصي مثلاً
            // startActivity(new Intent(requireContext(), EditProfileActivity.class));
        });
        v.findViewById(R.id.row_payment).setOnClickListener(x -> { /* ... */ });
        v.findViewById(R.id.row_old_password).setOnClickListener(x -> { /* ... */ });
        v.findViewById(R.id.row_new_password).setOnClickListener(x -> { /* ... */ });
    }
}

