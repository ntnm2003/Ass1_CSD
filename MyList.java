public class MyList {
    Node head, tail;

    public MyList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = tail = null;
    }

    public void displayYourInfo() {
        System.out.println("Full name: Nguyen Thi Ngoc Mai");
        System.out.println("Class Name: SE1907");
        System.out.println("ID Student: HE176347");
    }

    public void addLast(Person x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    public void visit(Node p) {
        if (p != null) System.out.print(p.info + " ");
    }

    public void traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
    }

    public void addMany(String[] a, int[] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) addLast(new Person(a[i], b[i]));
    }

    public Node searchByName(String xName) {
        Node p = head;
        while (p != null) {
            if (p.info.name.equals(xName)) return p;
            p = p.next;
        }
        return null;
    }

    public void addFirst(Person x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        q.next = head;
        head = q;
    }

    public void insertAfter(Node q, Person x) {
        if (q == null) return;
        Node p = new Node(x);
        p.next = q.next;
        q.next = p;
        if (q == tail) tail = p;
    }

    public void insertBefore(Node q, Person x) {
        if (q == null || isEmpty()) return;
        if (q == head) {
            addFirst(x);
            return;
        }
        Node p = head;
        while (p != null && p.next != q) {
            p = p.next;
        }
        if (p == null) return;
        Node newNode = new Node(x);
        newNode.next = q;
        p.next = newNode;
    }

    public void remove(Node q) {
        if (q == null || isEmpty()) return;
        if (q == head) {
            head = head.next;
            if (head == null) tail = null;
            return;
        }
        Node p = head;
        while (p != null && p.next != q) {
            p = p.next;
        }
        if (p == null) return;
        p.next = q.next;
        if (q == tail) tail = p;
    }

    public void remove(String xName) {
        Node q = searchByName(xName);
        remove(q);
    }

    // (8)--------------------------------------------------------------------------
    public void remove(int xAge) {
        Node p = head, prev = null;
        while (p != null) {
            if (p.info.age == xAge) {
                if (p == head) {
                    head = head.next;
                    if (head == null) tail = null;
                } else {
                    prev.next = p.next;
                    if (p == tail) tail = prev;
                }
                return;
            }
            prev = p;
            p = p.next;
        }
    }

    // (9)---------------------------------------------------------------------------
    public void removeAll(int xAge) {
        Node p = head, prev = null;
        while (p != null) {
            if (p.info.age == xAge) {
                if (p == head) {
                    head = head.next;
                    if (head == null) tail = null;
                } else {
                    prev.next = p.next;
                    if (p == tail) tail = prev;
                }
            } else {
                prev = p;
            }
            p = p.next;
        }
    }

    // (10)-------------------------------------------------------------------------
    public Node pos(int k) {
        Node p = head;
        int count = 0;
        while (p != null) {
            if (count == k) return p;
            count++;
            p = p.next;
        }
        return null;
    }

    // (11)-------------------------------------------------------------------------
    public void removePos(int k) {
        Node p = pos(k);
        remove(p);
    }

    // (12)--------------------------------------------------------------------
    public void sortByName() {
        if (head == null || head.next == null) return;
        Node p, q;
        Person temp;
        for (p = head; p != null; p = p.next) {
            for (q = p.next; q != null; q = q.next) {
                if (p.info.name.compareTo(q.info.name) > 0) {
                    temp = p.info;
                    p.info = q.info;
                    q.info = temp;
                }
            }
        }
    }

    // (13)----------------------------------------------------------------------
    public void sortByAge() {
        if (head == null || head.next == null) return;
        Node p, q;
        Person temp;
        for (p = head; p != null; p = p.next) {
            for (q = p.next; q != null; q = q.next) {
                if (p.info.age > q.info.age) {
                    temp = p.info;
                    p.info = q.info;
                    q.info = temp;
                }
            }
        }
    }

    // (14)-------------------------------------------------------------------------
    public int size() {
        int count = 0;
        Node p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    // (15)--------------------------------------------------------------------------
    public Person[] toArray() {
        int n = size();
        Person[] arr = new Person[n];
        Node p = head;
        int i = 0;
        while (p != null) {
            arr[i++] = p.info;
            p = p.next;
        }
        return arr;
    }

    // (16)-------------------------------------------------------------------------
    public void reverse() {
        Node prev = null, current = head, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        tail = head;
        head = prev;
    }

    // (17)---------------------------------------------------------------------------
    public Node findMaxAge() {
        if (isEmpty()) return null;
        Node p = head;
        Node maxNode = head;
        while (p != null) {
            if (p.info.age > maxNode.info.age) {
                maxNode = p;
            }
            p = p.next;
        }
        return maxNode;
    }

    // (18)-----------------------------------------------------------------
    public Node findMinAge() {
        if (isEmpty()) return null;
        Node p = head;
        Node minNode = head;
        while (p != null) {
            if (p.info.age < minNode.info.age) {
                minNode = p;
            }
            p = p.next;
        }
        return minNode;
    }

    // (19)--------------------------------------------------------------------
    public void setData(Node p, Person x) {
        if (p != null) {
            p.info = x;
        }
    }

    // (20)-----------------------------------------------------------------------------
    public void sortByAge(int k, int h) {
        if (k >= h) return;
        Node start = pos(k);
        Node end = pos(h);
        if (start == null || end == null) return;
        Node p, q;
        Person temp;
        for (p = start; p != end.next; p = p.next) {
            for (q = p.next; q != end.next; q = q.next) {
                if (p.info.age > q.info.age) {
                    temp = p.info;
                    p.info = q.info;
                    q.info = temp;
                }
            }
        }
    }

    // (21) -------------------------------------------------------------------------------
    public void reverse(int k, int h) {
        if (k >= h) return;
        Node start = pos(k);
        Node end = pos(h);
        if (start == null || end == null) return;
        Node prev = null, current = start, next = null;
        Node endNext = end.next;
        while (current != endNext) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        if (start != head) {
            Node p = head;
            while (p.next != start) {
                p = p.next;
            }
            p.next = prev;
        } else {
            head = prev;
        }
        start.next = endNext;
        if (end == tail) {
            tail = start;
        }
    }
}
