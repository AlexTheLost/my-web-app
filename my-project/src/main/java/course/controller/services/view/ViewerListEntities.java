package course.controller.services.view;

import java.util.ArrayList;
import java.util.List;

public class ViewerListEntities {

    private List<? extends Object> list;
    private int max = 0;
    private int index = 0;
    private int countReturnEntities = 5;
    List<? extends Object> currentList;

    public ViewerListEntities(List<? extends Object> list) {
        this.list = list;
        this.max = list.size();
        this.index = 0;
    }

    public void setList(List<? extends Object> list) {
        this.list = list;
        this.max = list.size();
        this.index = 0;
    }

    /**
     * default countReturnEntities == 5
     */
    public void setCountReturnEntities(int countReturnEntities) {
        this.countReturnEntities = countReturnEntities;

    }

    public List<? extends Object> next(int index) {
        int first = index;
        int last;
        if (index > (max - countReturnEntities)) {
            last = max;
        } else {
            last = index + countReturnEntities;
            index = last;
        }
        List<? extends Object> subList = list.subList(first, last);
        currentList = subList;
        return subList;
    }

    public boolean hasNext(int index) {
        if (index <= (max - countReturnEntities))
            return true;
        return false;
    }

    public List<? extends Object> prev(int index) {
        if (index == max)
            index = max - countReturnEntities;
        int first;
        int last = index;
        if (index <= 0) {
            first = 0;
        } else {
            first = index - countReturnEntities;
            index = first;
        }
        List<? extends Object> subList = list.subList(first, last);
        currentList = subList;
        return subList;
    }

    public boolean hasPrev(int index) {
        if (index > 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            list.add(new Integer(i).toString());
        }
        ViewerListEntities view = new ViewerListEntities(list);

//        System.out.println(view.getNext());
//        System.out.println(view.getHasNext());
//        System.out.println(view.getNext());
//        System.out.println(view.getHasNext());
//        System.out.println(view.getNext());
//        System.out.println(view.getHasNext());
//        System.out.println(view.getNext());
//        System.out.println(view.getHasNext());
//        System.out.println(view.getNext());
//
//        System.out.println("------------------");
//
//        System.out.println(view.getPrev());
//        System.out.println(view.getHasPrev());
//        System.out.println(view.getPrev());
//        System.out.println(view.getHasPrev());
//        System.out.println(view.getPrev());
//        System.out.println(view.getHasPrev());
//        System.out.println(view.getPrev());
//        System.out.println(view.getHasPrev());
//        System.out.println(view.getPrev());
//        System.out.println(view.getHasPrev());
    }
}
