package com.vybhavi.meditrack;

import org.junit.Before;
import org.junit.Test;
import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import org.junit.Rule;
import java.util.List;

import static org.junit.Assert.*;

public class MedicationViewModelTest {

    @Rule
    public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();

    private MedicationViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new MedicationViewModel();
    }

    @Test
    public void testInitialListIsEmpty() {
        List<Medication> list = viewModel.getMedicationList().getValue();
        assertNotNull(list);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testAddMedication() {
        Medication med = new Medication("Paracetamol", "500mg", "8:00 AM");
        viewModel.addMedication(med);

        List<Medication> list = viewModel.getMedicationList().getValue();
        assertNotNull(list);
        assertEquals(1, list.size());
        assertEquals("Paracetamol", list.get(0).getName());
    }
}
