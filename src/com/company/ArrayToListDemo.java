package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayToListDemo {
    Integer[] myarray = {1,2,3};
    List myList = Arrays.stream(myarray).collect(Collectors.toList());
    List list = Arrays.asList(myarray);
}
