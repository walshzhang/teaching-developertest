package walsh.teaching.junit.theory;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.experimental.theories.PotentialAssignment;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public class BetweenSupplier extends ParameterSupplier {

    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature signature) throws Throwable {
        Between between = signature.getAnnotation(Between.class);

        List<PotentialAssignment> list = new ArrayList<>();
        for (int i = between.first(); i <= between.last(); i++)
            list.add(PotentialAssignment.forValue("ints", i));
        return list;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @ParametersSuppliedBy(BetweenSupplier.class)
    public @interface Between {
        int first();

        int last();
    }
}
