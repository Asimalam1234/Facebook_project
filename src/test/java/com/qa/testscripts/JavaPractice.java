package com.qa.testscripts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JavaPractice {

    public static void main(String[] args) {
        
        List<Object> list = new ArrayList<Object>();
        list.add("Asim");
        list.add(101);
        
        Iterator<Object> it = list.iterator();
        
        // Corrected the condition to it.hasNext()
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
