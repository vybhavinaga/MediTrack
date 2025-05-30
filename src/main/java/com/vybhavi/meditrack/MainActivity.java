package com.vybhavi.meditrack;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private MedicationViewModel viewModel;
    private MedicationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // make sure this is your actual layout file

        // 1. Hook up input fields and button
        EditText nameInput = findViewById(R.id.nameInput);
        EditText dosageInput = findViewById(R.id.dosageInput);
        EditText timeInput = findViewById(R.id.timeInput);
        Button addButton = findViewById(R.id.addButton);

        // 2. Set up RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MedicationAdapter();
        recyclerView.setAdapter(adapter);

        // 3. Get ViewModel and observe LiveData
        viewModel = new ViewModelProvider(this).get(MedicationViewModel.class);
        viewModel.getMedicationList().observe(this, medications -> {
            adapter.setList(medications);
        });

        // 4. Handle Add button click
        addButton.setOnClickListener(v -> {
            String name = nameInput.getText().toString().trim();
            String dosage = dosageInput.getText().toString().trim();
            String time = timeInput.getText().toString().trim();

            if (!name.isEmpty() && !dosage.isEmpty() && !time.isEmpty()) {
                Medication med = new Medication(name, dosage, time);
                viewModel.addMedication(med);

                nameInput.setText("");
                dosageInput.setText("");
                timeInput.setText("");
            }
        });
    }
}
