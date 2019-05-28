package Lesson4.Iterator;

public class LinkIteratorApp {


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkInterator itr = new LinkInterator(list);
        itr.insertAfter("Катя", 10);
        itr.insertAfter("Катя", 20);
        itr.insertAfter("Катя", 30);
        itr.insertAfter("Катя", 40);
        itr.insertAfter("Катя", 50);
        itr.insertBefore("Катя", 45);
        list.display();
        System.out.println("----------------------------");
        itr.reset();

        while (true) {
            Link current = itr.getCurrent();
            if (current.age < 51)
                itr.deleteCurrent();
            if (itr.atEnd())
                break;
            itr.nextLink();
        }

        System.out.println("----------------------------");
        list.display();

        /* метод deleteCurrent() работает криво при переборе элементов,
        элементы удаляются через один.
        * */
    }

}

