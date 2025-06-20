import java.util.*;
class Product {
    int pId;
    String pName;
    String cat;
    public Product(int pId, String pName, String cat) {
        this.pId = pId;
        this.pName = pName;
        this.cat = cat;
    }
    public String toString() {
        return "Product ID: " + pId + ", Name: " + pName + ", Category: " + cat;
    }
}

public class EcommerceSearch {
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product p : products) {
            if (p.pName.equalsIgnoreCase(targetName)) {
                return p;
            }
        }
        return null;
    }
    public static Product binarySearch(Product[] products, String targetName) {
        int low = 0;
        int high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = products[mid].pName.compareToIgnoreCase(targetName);
            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
    public static void printProducts(Product[] products) {
        for (Product p : products) {
            System.out.println(p);
        }
    }
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Fashion"),
            new Product(103, "Phone", "Electronics"),
            new Product(104, "Book", "Education"),
            new Product(105, "Watch", "Accessories")
        };
        Arrays.sort(products, Comparator.comparing(p -> p.pName.toLowerCase()));
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name to search: ");
        String target = scanner.nextLine();
        Product linearResult = linearSearch(products, target);
        System.out.println("\nLinear Search Result:");
        System.out.println(linearResult != null ? linearResult : "Product not found.");
        Product binaryResult = binarySearch(products, target);
        System.out.println("\nBinary Search Result:");
        System.out.println(binaryResult != null ? binaryResult : "Product not found.");
    }
}
