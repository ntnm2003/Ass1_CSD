import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyList list = new MyList();
        list.displayYourInfo();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add Last");
            System.out.println("2. Add First");
            System.out.println("3. Insert After");
            System.out.println("4. Insert Before");
            System.out.println("5. Remove by Node");
            System.out.println("6. Remove by Name");
            System.out.println("7. Remove by Age");
            System.out.println("8. Remove All by Age");
            System.out.println("9. Search by Name");
            System.out.println("10. Get Position");
            System.out.println("11. Remove by Position");
            System.out.println("12. Sort by Name");
            System.out.println("13. Sort by Age");
            System.out.println("14. Get Size");
            System.out.println("15. Convert to Array");
            System.out.println("16. Reverse List");
            System.out.println("17. Find Max Age");
            System.out.println("18. Find Min Age");
            System.out.println("19. Set Data");
            System.out.println("20. Sort by Age (Range)");
            System.out.println("21. Reverse (Range)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    list.addLast(new Person(name, age));
                    list.traverse();
                    break;
                case 2:
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    age = scanner.nextInt();
                    list.addFirst(new Person(name, age));
                    list.traverse();
                    break;
                case 3:
                    System.out.print("Enter name to insert after: ");
                    String afterName = scanner.nextLine();
                    Node afterNode = list.searchByName(afterName);
                    if (afterNode != null) {
                        System.out.print("Enter name: ");
                        name = scanner.nextLine();
                        System.out.print("Enter age: ");
                        age = scanner.nextInt();
                        list.insertAfter(afterNode, new Person(name, age));
                    } else {
                        System.out.println("Person not found.");
                    }
                    list.traverse();
                    break;
                case 4:
                    System.out.print("Enter name to insert before: ");
                    String beforeName = scanner.nextLine();
                    Node beforeNode = list.searchByName(beforeName);
                    if (beforeNode != null) {
                        System.out.print("Enter name: ");
                        name = scanner.nextLine();
                        System.out.print("Enter age: ");
                        age = scanner.nextInt();
                        list.insertBefore(beforeNode, new Person(name, age));
                    } else {
                        System.out.println("Person not found.");
                    }
                    list.traverse();
                    break;
                case 5:
                    System.out.print("Enter name to remove: ");
                    String removeName = scanner.nextLine();
                    Node removeNode = list.searchByName(removeName);
                    list.remove(removeNode);
                    list.traverse();
                    break;
                case 6:
                    System.out.print("Enter name to remove: ");
                    removeName = scanner.nextLine();
                    list.remove(removeName);
                    list.traverse();
                    break;
                case 7:
                    System.out.print("Enter age to remove: ");
                    int removeAge = scanner.nextInt();
                    list.remove(removeAge);
                    list.traverse();
                    break;
                case 8:
                    System.out.print("Enter age to remove all: ");
                    int removeAllAge = scanner.nextInt();
                    list.removeAll(removeAllAge);
                    list.traverse();
                    break;
                case 9:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    Node searchNode = list.searchByName(searchName);
                    if (searchNode != null) {
                        System.out.println("Found: " + searchNode.info);
                    } else {
                        System.out.println("Person not found.");
                    }
                    break;
                case 10:
                    System.out.print("Enter position: ");
                    int pos = scanner.nextInt();
                    Node posNode = list.pos(pos);
                    if (posNode != null) {
                        System.out.println("Person at position " + pos + ": " + posNode.info);
                    } else {
                        System.out.println("Position out of range.");
                    }
                    break;
                case 11:
                    System.out.print("Enter position to remove: ");
                    int removePos = scanner.nextInt();
                    list.removePos(removePos);
                    list.traverse();
                    break;
                case 12:
                    list.sortByName();
                    list.traverse();
                    break;
                case 13:
                    list.sortByAge();
                    list.traverse();
                    break;
                case 14:
                    System.out.println("Size of list: " + list.size());
                    break;
                case 15:
                    Person[] array = list.toArray();
                    for (Person person : array) {
                        System.out.print(person + " ");
                    }
                    System.out.println();
                    break;
                case 16:
                    list.reverse();
                    list.traverse();
                    break;
                case 17:
                    Node maxAgeNode = list.findMaxAge();
                    if (maxAgeNode != null) {
                        System.out.println("Person with max age: " + maxAgeNode.info);
                    } else {
                        System.out.println("List is empty.");
                    }
                    break;
                case 18:
                    Node minAgeNode = list.findMinAge();
                    if (minAgeNode != null) {
                        System.out.println("Person with min age: " + minAgeNode.info);
                    } else {
                        System.out.println("List is empty.");
                    }
                    break;
                case 19:
                    System.out.print("Enter name to set data: ");
                    String setDataName = scanner.nextLine();
                    Node setDataNode = list.searchByName(setDataName);
                    if (setDataNode != null) {
                        System.out.print("Enter new name: ");
                        name = scanner.nextLine();
                        System.out.print("Enter new age: ");
                        age = scanner.nextInt();
                        list.setData(setDataNode, new Person(name, age));
                    } else {
                        System.out.println("Person not found.");
                    }
                    list.traverse();
                    break;
                case 20:
                    System.out.print("Enter start position: ");
                    int startPos = scanner.nextInt();
                    System.out.print("Enter end position: ");
                    int endPos = scanner.nextInt();
                    list.sortByAge(startPos, endPos);
                    list.traverse();
                    break;
                case 21:
                    System.out.print("Enter start position: ");
                    startPos = scanner.nextInt();
                    System.out.print("Enter end position: ");
                    endPos = scanner.nextInt();
                    list.reverse(startPos, endPos);
                    list.traverse();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
