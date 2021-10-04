package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortManager {

    private List<Drug> drug;

    public SortManager(List<Drug> drug){
        this.drug = drug;
    }


    public List<Drug> sortByNumber(boolean check){

        List<Drug> result = new ArrayList<>(drug);
        if(check){
            NumberComparator comparator = new NumberComparator();
            result.sort(comparator.reversed());
            return result;
        }
        result.sort(new NumberComparator());
        return result;
    }

    public List<Drug> sortByType(boolean check){
        TypeComparator comparator = new TypeComparator();
        List<Drug> result = new ArrayList<>(drug);
        if(check){
            result.sort(Collections.reverseOrder(comparator));
            return result;
        }
        result.sort(comparator);
        return result;
    }

    public List<Drug> sortByPrice(boolean check){
        List<Drug> result = new ArrayList<>(drug);

        Comparator<Drug> priceComparator = new Comparator<Drug>() {
            @Override
            public int compare(Drug o1, Drug o2) {
                int res = o1.getPrice().compareTo(o2.getPrice());
                if(res == 0){
                    res = o1.getName().compareTo(o1.getName());
                }
                return res;
            }
        };

        if (check){
            result.sort(Collections.reverseOrder(priceComparator));
            return result;
        }

        result.sort(priceComparator);
        return result;

    }

    public List<Drug> sortByName(boolean check){
        List<Drug> result = new ArrayList<>(drug);

        Comparator<Drug> nameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());

        if (check){
            result.sort(Collections.reverseOrder(nameComparator));
            return result;
        }

        result.sort(nameComparator);
        return result;
    }

    private static class NumberComparator implements Comparator<Drug>{

        @Override
        public int compare(Drug o1, Drug o2) {
            int res = Integer.compare(o1.getNumber(), o2.getNumber());
            return res;
        }
    }

    private class TypeComparator implements Comparator<Drug>{

        @Override
        public int compare(Drug o1, Drug o2) {
            return o1.getType().compareTo(o2.getType());
        }

    }

}
