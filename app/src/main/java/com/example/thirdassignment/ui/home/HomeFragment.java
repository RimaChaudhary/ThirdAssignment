package com.example.thirdassignment.ui.home;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thirdassignment.R;
import com.example.thirdassignment.adapter.StudentAdapter;
import com.example.thirdassignment.model.Student;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    // Create a list of students to display in RecyclerView
    static List<Student> studentList = new ArrayList<>();

    private RecyclerView recycler_view;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);


        recycler_view = root.findViewById(R.id.recycler_view);


        // Adding all the contacts object in list
        Student student = new Student("Sujan Odari", "Jhapa", "Male", 23);
        studentList = student.getStudentList();
        if(studentList.isEmpty()) {
            studentList.add(new Student("Sujan Odari", "Jhapa", "Male", 23));
            studentList.add(new Student("Susma Subedi", "Jhapa", "Female", 21));
            student.setStudentList(studentList);
        }
        StudentAdapter studentAdapter = new StudentAdapter(getActivity(), studentList);
        recycler_view.setAdapter(studentAdapter);
        recycler_view.setLayoutManager(new LinearLayoutManager(getActivity()));


        return root;
    }
}