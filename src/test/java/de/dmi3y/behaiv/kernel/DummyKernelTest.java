package de.dmi3y.behaiv.kernel;

import org.apache.commons.math3.util.Pair;
import org.junit.Test;

import java.util.ArrayList;

import static de.dmi3y.behaiv.kernel.KernelTest.HOME;
import static de.dmi3y.behaiv.kernel.KernelTest.WORK;
import static org.junit.Assert.assertEquals;

public class DummyKernelTest {


    @Test
    public void predictOne() {
        ArrayList<Pair<ArrayList<Double>, String>> data = KernelTest.getTrainingData();
        Kernel dummyKernel = new DummyKernel();
        dummyKernel.fit(data);
        ArrayList<Double> predictList = new ArrayList<>();
        predictList.add((10 * 60 + 30.0) / (24 * 60));
        predictList.add(WORK[0]);
        predictList.add(WORK[1]);
        predictList.add(1.0);

        dummyKernel.update(null);
        String prediction = dummyKernel.predictOne(predictList);
        assertEquals("WORK_SCREEN", prediction);

        //TODO predictOne fails in dummy because of re-usage of data
    }

}