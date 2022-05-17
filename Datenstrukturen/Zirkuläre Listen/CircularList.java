
import java.rmi.UnexpectedException;

class CircularList<T extends Comparable<T>> {
    private ListElement<T> head;

    // --------KONSTRUKTOR

    public CircularList() {
        head = new ListElement<>();
        head.next = null;
    }

    // ---------METHODEN-----------

    // Prüft, ob die List leer ist.
    public boolean empty() {
        if (head.next == null) {
            return true;
        } else {
            return false;
        }
    }

    // Bestimmt die Anzahl der Listenelemente
    public int size() {
        int counter = 0;
        ListElement<T> current = head.next;

        if (empty() == false) {
            ListElement<T> lastElement = head.next.last;

            do {
                counter++;
                current = current.next;
            } while (current != head.next);

        }

        return counter;
    }

    // Löscht alle Listenelemente
    public void clear() {
        if (empty() == false) {
            System.out.println("Hallo");
            ListElement<T> toDelete = head.next;
            while (head.next != null) {
                head.next = head.next.next;
                // head.next.last = toDelete.last;
                toDelete.last = null;
                toDelete.next = null;

            }
        }

    }

    // Fügt ein neues Element mit Wert t am Ende an
    public boolean append(T t) {

        ListElement<T> toAppend = new ListElement<>();
        toAppend.data = t;
        if (empty() == true) {
            head.next = toAppend;
            toAppend.last = toAppend;
            toAppend.next = toAppend;
            return true;
        }
        ListElement<T> oldLastElement = head.next.last;
        oldLastElement.next = toAppend;
        toAppend.last = oldLastElement;
        toAppend.next = head.next;
        head.next.last = toAppend;
        return true;

    }

    // Hängt alle Elemente aus l ( in unveränderter Reihenfolge )
    // ans Ende Dieser Liste an. Diese Liste l sol danach leer sein.
    public void concatenate(CircularList<T> l) {
        ListElement<T> current = l.head.next;
        ListElement<T> lastElement;
        // 1. hänge Element am Ende der Liste
        // 2. Lösch das Element + fix den Head - Zeiger

        do {
            // Am Ende der Liste hängen
            lastElement = this.head.next.last;
            lastElement.next = current;
            current.next = this.head.next;
            current.last = lastElement;
            this.head.next.last = current;
            // Head - Zeiger von l fixen

            l.head.next = l.head.next.next;
            current = l.head.next;

        } while (current.next != l.head.next);
    }

    // Ausgabe der Liste in der Form [22,5,3]
    @Override
    public String toString() {
        String ausgabe = "";
        ListElement<T> current = head.next;
        ListElement<T> lastElement = head.next.last;

        do {
            if (current == head.next) {
                ausgabe = ausgabe + current.data;
            }
            if (current == head.next.last) {
                ausgabe = ausgabe + " " + current.data;

            } else {
                ausgabe = ausgabe + " " + current.data + ",";
            }

            current = current.next;
        } while (current != head.next);

        return "[" + ausgabe + "]";
    }

    // ------------MAIN-METHODE---------
    public static void main(String[] args) {

        CircularList<String> list = new CircularList<>();
        CircularList<String> list2 = new CircularList<>();
        list.append("Eremiya");
        list.append("Eremiya2");
        list.append("Eremiya3");
        list.append("Eremiya4");

        list2.append("Emo");
        list2.append("Emo2");
        list2.append("Emo3");

        System.out.println("BEFORE : " + list);
        list.concatenate(list2);
        System.out.println("AFTER : " + list);

    }

}
