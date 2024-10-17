package com.javalab.sec17;

public class ShoppingMain {
    public static void main(String[] args) {
        // 1. 상품데이터 생성 및 초기화
        Product[] products = initializeProductData();
        // 2. 회원데이터 생성 및 초기화
        Member[] members = initializeMemberData();
        // 3. 주문데이터 생성
        Order[] orders = initializeOrderData();
        // 4. 모든 회원 정보 출력
        printMemberList(members);
        // 5. 모든 상품 정보 출력
        printProductList(products);
        // 6. 모든 주문 정보 출력
        printOrderList(orders);
        // 7. 전체 주문 금액 출력
        TotalOrderAmount(orders);
        // 8. 모든 주문 정보 출력(화원명과, 상품명 포함)
        printOrderListWithName(orders, members, products);
    }

    public static void printOrderListWithName(Order[] orders, Member[] members, Product[] products) {
        System.out.println("===================");
        System.out.println("OrderId   MemberName   ProductName  Quantity    TotalAmount   ");
        System.out.println("-------------------");
        for (Order order : orders) {
            String memberName = findMemberName(order.getMemberId(), members);
            String productName = findProductName(order.getProductId(), products);
            System.out.println(order.getOrderId() + "\t" + memberName + "\t" + productName + "\t" + order.getQuantity()
                    + "\t" + order.getTotalAmount());
        }
        System.out.println("===================");
    }

    public static String findProductName(int productId, Product[] products) {
        String productName = "";
        for (Product product : products) {
            if (product.getProductId() == productId) {
                productName = product.getProductName();
                break;
            }
        }
        return productName;
    }


    public static String findMemberName(String memberId, Member[] members) {
        String memberName = "";
        for (Member member : members) {
            if (member.getId().equals(memberId)) {
                memberName = member.getId();
                break;
            }
        }
        return memberName;
    }


    private static void TotalOrderAmount(Order[] orders) {
        double totalAmount = 0;
        for (Order order : orders) {
            totalAmount += order.getTotalAmount();
        }
        System.out.println("전체 주문 금액 $ " + totalAmount);
    }


    private static void printOrderList(Order[] orders) {
        System.out.println("===================");
        System.out.println("OrderId   MemberId    ProductId   Quantity   TotalAmount  ");
        System.out.println("-------------------");
        for (Order order : orders) {
            System.out.println(order.getOrderId() + "\t" + order.getMemberId() + "\t" + order.getProductId()
                    + "\t" + order.getQuantity() + "\t" + order.getTotalAmount());
        }
        System.out.println("==================");
    }

    private static void printProductList(Product[] products) {
        System.out.println("===================");
        System.out.println("ProductID   Name    Price   Stock   ");
        System.out.println("-------------------");
        for (Product product : products) {
            System.out.println(product.getProductId() + "\t" + product.getProductName() + "\t" + product.getPrice() + "\t" + product.getStock());
        }
        System.out.println("==================");
    }

    private static void printMemberList(Member[] members) {
        System.out.println("===================");
        System.out.println("id      name    email   ");
        System.out.println("-------------------");
        for (Member member : members) {
            System.out.println(member.getId() + "\t" + member.getName() + "\t" + member.getEmail());
        }
        System.out.println("==================");
    }

    // 3. 주문데이터 생성
//        Order ord1 = new Order(1, "user1", 1, 2, 1000.00);
//        Order ord2 = new Order(2, "user2", 2, 1, 300.00);
//        Order ord3 = new Order(3, "user3", 3, 3, 2100.00);
//        Order ord4 = new Order(4, "user4", 4, 4, 600.00);
//        Order ord5 = new Order(5, "user5", 5, 5, 500.00);

    private static Order[] initializeOrderData() {
        Order[] orders = new Order[5];
        orders[0] = new Order(1, "user1", 1, 2, 1000.00);
        orders[1] = new Order(2, "user2", 2, 1, 300.00);
        orders[2] = new Order(3, "user3", 3, 3, 2100.00);
        orders[3] = new Order(4, "user4", 4, 4, 600.00);
        orders[4] = new Order(5, "user5", 5, 5, 500.00);
        return orders;
    }

    private static Member[] initializeMemberData() {
        // 회원 객체 저장용 배열 5칸
        Member[] members = new Member[5];
        members[0] = new Member("user1", "1234", "홍길동", "hong@gmail.com");
        members[1] = new Member("user2", "1234", "이순신", "lee@gmail.com");
        members[2] = new Member("user3", "1234", "강감찬", "kang@gmail.com");
        members[3] = new Member("user4", "1234", "을지문덕", "eulji@gmail.com");
        members[4] = new Member("user5", "1234", "김유신", "kim@gmail.com");
        return members;
    }

    private static Product[] initializeProductData() {
        // 상품 객체 저장용 배열 10칸
        Product[] products = new Product[10];
        products[0] = new Product(1, "냉장고", 500.00, 10);
        products[1] = new Product(2, "세탁기", 300.00, 5);
        products[2] = new Product(3, "에어컨", 700.00, 7);
        products[3] = new Product(4, "공기청정기", 150.00, 12);
        products[4] = new Product(5, "가습기", 100.00, 20);
        products[5] = new Product(6, "청소기", 250.00, 8);
        products[6] = new Product(7, "TV", 900.00, 4);
        products[7] = new Product(8, "전자레인지", 120.00, 15);
        products[8] = new Product(9, "토스터", 60.00, 18);
        products[9] = new Product(10, "믹서기", 80.00, 10);
        return products;
    }
}
