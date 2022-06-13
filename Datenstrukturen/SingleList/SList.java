import java.util.Scanner;

public class SList<T extends Comparable<T>> {
    private ListElement<T> head;
    private int size;

    // Prüft, ob die Liste leer ist.
    public boolean empty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    // Bestimmt die Anzahl der Listenelemente
    public int size() {
        size = 0;
        return size;
    }

    // Löscht alle Listenelemente
    public void clear() {
        head = null;
    }

    // Fügt ein neues Element mit Wert t am Ende an.
    public void append(T t) {

        ListElement<T> toAppend = new ListElement<>();
        ListElement<T> current = new ListElement<>();
        toAppend.data = t;
        if (empty()) {
            head = toAppend;
            size++;
        } else {
            current = head;
            for (int i = 1; i < this.size; i++) {
                current = current.next;
            }
            current.next = toAppend;
            size++;
        }
    }

    // Hängt alle Elemente aus l ans Ende der Liste an
    public void concatenate(SList<T> list2) {

        if (list2.empty() == false) {

            ListElement<T> current = new ListElement<>();

            current = head;
            for (int i = 1; i < this.size; i++) {
                current = current.next;
            }
            current.next = list2.head;
            this.size += list2.size;
        }
    }

    // Löscht das k-te Element (k >= 1)
    public void delete(int k) {

        if (k > 1) {
            ListElement<T> current = new ListElement<>();
            current = head;
            for (int i = 1; i < k - 1; i++) {
                current = current.next;
            }

            current.next = current.next.next;
            size = size - 1;
        } else if (k == 1) {
            head = head.next;
            size = size - 1;
        }
    }

    // Gibt den Wert des Elements an der vorher gefragten Stelle aus
    public T get(int k) {
        ListElement<T> current = new ListElement<>();
        current = head;
        for (int i = 1; i < k; i++) {
            current = current.next;
        }

        return current.data;

    }

    // Ausgabe der Liste in der Form [22,5,3]
    @Override
    public String toString() {
        String str = "";
        ListElement<T> current = new ListElement<>();

        if (empty() == false) {

            if (size == 1) {
                return str += head.data;
            }
            current = head;
            for (int i = 1; i <= this.size; i++) {
                str += current.data + ", ";
                current = current.next;
            }

            return str;
        }
        return str;
    }

    public static void main(String[] args) throws InterruptedException {
        SList<String> list = new SList<>();
        list.append("Eremiya");
        list.append("Fenja");
        list.append("Johannes");
        list.append("Fritz");

        list.delete(1);

        System.out.println("HIER " + list);

        Scanner myScanner = new Scanner(System.in);
        ausgabeMenu();

        String eingabe = "e";

        eingabe = myScanner.nextLine();
        while (!(eingabe.equals("e"))) {

            switch (eingabe) {
                case "a":
                    System.out.println("Welchen Wert wollen Sie hinzufügen ?");
                    eingabe = myScanner.nextLine();
                    list.append(eingabe);
                    System.out.println("Ihre neue Liste lautet wie folgt : ");
                    System.out.println(list);
                    break;
                case "i":
                    System.out.println("In Bearbeitung");
                    break;
                case "d":
                    System.out.println("An welche Stelle wollen sie ein Wert löschen ?");
                    eingabe = myScanner.nextLine();
                    list.delete(Integer.parseInt(eingabe));
                    System.out.println("Ihre neue Liste lautet wie folgt : ");
                    System.out.println(list);
                    break;
                case "g":
                    System.out.println("Welche Stelle wollen Sie ausgegeben haben ? ");
                    eingabe = myScanner.nextLine();
                    if (Integer.parseInt(eingabe) > list.size) {
                        System.out.println("Ungültiger Wert");
                        break;
                    }
                    System.out.println(list.get(Integer.parseInt(eingabe)));
                    break;
                case "p":
                    System.out.println("Die Liste sieht folgendermaßen aus:");
                    System.out.println(list);
                    break;
                default:
                    System.out.println("ungültiger Wert ! Probieren Sie es nochmal !");
                    break;
            }
            Thread.sleep(1000);
            ausgabeMenu();
            eingabe = myScanner.nextLine();
        }
        Thread.sleep(1000);
        System.out.println("Programm wird beendet");

    }

    public static void ausgabeMenu() {

        System.out.println("Welche Aktion wollen sie ausführen ?");
        System.out.println("a(ppend) : Dies fügt ein Wert am Ende der Liste ein");
        System.out.println("i(nsert) : Fügt ein Wert an der vorher gefragten Stelle ein");
        System.out.println("d(elete) Löscht ein Wert an der vorher gefragten Stelle");
        System.out.println("g(et) Gibt den Wert aus für eine vorher gefragten Stelle");
        System.out.println("p(rint) gibt die Liste mit allen Elementen aus");
        System.out.println("e(xit) Programm wird verlassen");
    }
}