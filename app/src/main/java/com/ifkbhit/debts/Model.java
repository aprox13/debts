package com.ifkbhit.debts;

import com.ifkbhit.debts.data.Operation;
import com.ifkbhit.debts.data.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Model {


    private final List<Person> data = Arrays.asList(
            new Person("Lu", R.drawable.ic_0, 100, 1),
            new Person("Jake", R.drawable.ic_1, -1490, 2),
            new Person("Ann", R.drawable.ic_2, 0, 3),
            new Person("Mike", R.drawable.ic_3, 300, 4),
            new Person("Emma", R.drawable.ic_4, -80, 5),
            new Person("Lin", R.drawable.ic_5, -2, 6));


    private final List<List<Double>> operations = Arrays.asList(

            Arrays.asList(200.0, -100.0),
            Arrays.asList(200.0, -100.0, -1590.0),
            Arrays.asList(200.0, -100.0, -100.0),
            Collections.emptyList(),
            Arrays.asList(200.0, -280.0),
            Arrays.asList(98.0, -100.0)
    );


    public Model() {
    }

    public List<Person> getPersons() {
        return new ArrayList<>(data);
    }

    public Person getPersonById(long id) {
        for (Person p : data) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }


    public List<Operation> getOperationsForPerson(long personId){
        List<Operation> result = new ArrayList<>();
        for(Double v: operations.get((int) personId)){
            result.add(new Operation(v));
        }
        return result;
    }

}
