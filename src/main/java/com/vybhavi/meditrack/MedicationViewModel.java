package com.vybhavi.meditrack;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

public class MedicationViewModel extends ViewModel {
    private final MutableLiveData<List<Medication>> medicationList = new MutableLiveData<>(new ArrayList<>());

    public LiveData<List<Medication>> getMedicationList() {
        return medicationList;
    }

    public void addMedication(Medication med) {
        List<Medication> currentList = new ArrayList<>(medicationList.getValue());
        currentList.add(med);
        medicationList.setValue(currentList);
    }
}
