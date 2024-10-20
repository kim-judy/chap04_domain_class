package com.javalab.sec19;

import com.javalab.sec18.Category;
import com.javalab.sec18.Employee;
import com.javalab.sec18.Order;
import com.javalab.sec18.Product;


public class CafeManagementSystem {

    public static void main(String[] args) {
        System.out.println("Cafe Management System");
        // 1. 카테고리 데이터 생성
        Category[] categories = initializeCategoryData();
        printCategory(categories);

        // 2. 상품 데이터 생성
        Product[] products = initializeProductData();
        printProduct(products);

        // 3. 특정 카테고리에 속한 상품들 출력, 카테고리 이름을 전달해서 해당 카테고리에 속한 상품들을 반환
        Product[] categoryProducts = getProductsByCatoryName("Coffee", categories, products);

        // 4. 위에서 찾아진 카테고리에 소속된 상품들 출력하기
        printProductListWithCategoryName(categoryProducts);

        // 5. 상품의 이름으로 상품 1개만 조회
        Product product = findProductByName("초코라떼", products);

        // 6. 찾아진 상품 출력
        printOneProduct(product);

        // 7. 특정 상품의 가격을 변경, "~ 상품의 가격이 ~에서 ~로 변경되었습니다." 출력
        updateProductPrice("초코라떼", 6000, products); // 기존 가격 5000 -> 6000

        // 8. 빵종류의 상품 가격을 밀가루값 인상으로 15% 인상
        increaseBakeryPrice(products);

        // 9. 사원 기초 데이터 생성
        Employee[] employees = initializeEmployeeData();
        printEmployeeData(employees);

        // 10. 주문 기초 데이터 생성
        Order[] orders = initializeOrderData();

        // 11. 주문을 처리하는 메소드
        // Alice 사원이 2024-10-17 03:52에 1번 상품을 2개 주문하는 건을 처리함.
        // 주문 객체 생성
        //Order order1 = new Order(0, "2024-10-17 03:52", 1, 201, 2);
        // 주문 추가 메소드
        //addOrder(order1, orders);

        //12. 주문 데이터 출력
        showOrderData(categories, products, orders, employees);

        // 13. 주문 통계 출력 메소드
        // - 총주문금액(중)
        // - 가장 큰 주문액
        //showOrderStatistics(orders, categories, products, employees);

        // 14. 사원별 주문 처리 건수 출력
        showOrderCountByEmployee(orders, employees);

        // 15. 베스트 셀링 상품 출력
        showBestSellingProduct(orders, products);

        // 16. 최고 매출을 올린 사원
        showBestEmployee(employees, orders, products);

    }


    private static void showBestEmployee(Employee[] employees, Order[] orders, Product[] products) {
        System.out.println("<< 최고 매출을 올린 사원 >>");
        Employee topEmployee = null;
        int highestSales = 0;
        for (Employee employee : employees) {
            int totalSales = 0;
            for (Order order : orders) {
                if (order.getEmployeeId() == employee.getEmployeeId()) {
                    int price = findPrice(order.getProductId(), products);
                    totalSales += order.getQuantity() * price; // 해당 사원이 처리한 주문의 총금액이 누적
                }
            }
            if (totalSales > highestSales) {
                highestSales = totalSales;
                topEmployee = employee;
            }
        }
        if (topEmployee != null) {
            System.out.println("최고 매출을 기록한 사원: " + topEmployee.getName() + ", 총 매출: "
                    + highestSales + "원");
        }
        System.out.println("=============================================");
    }

    // 상품의 id로 상품 가격을 찾는 메소드
    private static int findPrice(int productId, Product[] products) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return (int) product.getPrice();
            }
        }
        return 0;
    }

    private static void showBestSellingProduct(Order[] orders, Product[] products) {
        System.out.println("<< 베스트 셀링 상품 >>");
        Product bestSellingProduct = null;  // 가장 많이 판매된 상품을 보관할 변수
        int highestQuantity = 0;        // 가장 많이 판매된 상품의 판매 수량을 보관할 변수
        for (Product product : products) {
            int totalQuantity = 0; // 상품별 총 판매 수량을 보관할 변수
            for (Order order : orders) {
                if (order.getProductId() == product.getProductId()) {
                    totalQuantity += order.getQuantity(); // 상품별 총 판매 수량 누적
                }
            }
            // 위에서 구해진 상품별 총 판매 수량이 가장 많은 상품을 찾기 위해서 비교
            if (totalQuantity > highestQuantity) {
                highestQuantity = totalQuantity;
                bestSellingProduct = product;
            }
        }
        if (bestSellingProduct != null) {
            System.out.println("가장 많이 판매된 상품: " + bestSellingProduct.getProductName()
                    + ", 판매 수량: " + highestQuantity);
        }
        System.out.println("=============================================");
    }

    private static void showOrderCountByEmployee(Order[] orders, Employee[] employees) {
        System.out.println("<< 사원별 주문 처리 건수 출력 >>");
        for (Employee employee : employees) {
            int orderCount = 0; // 한 사원의 주문처리건수 누적 변수를 초기화
            for (Order order : orders) {
                if (order.getEmployeeId() == employee.getEmployeeId()) { // 사원이 처리한 주문인 경우
                    orderCount++; // 주문 처리 건수 누적
                }
            }
            System.out.println(employee.getName() + " 사원이 처리한 주문 건수: " + orderCount);
        }
        System.out.println("=============================================");
    }

    //    private static void showOrderEmployee(Employee[] employees, Order[] orders) {
//        System.out.println("=============================================");
//        System.out.println(" EmployeeID     주문건수 ");
//        int emp = 0;
//        int totalOrderCount = 0; // 주문 건수
//        for (int i = 0; i < employees.length; i++) {
//            for (Order order : orders) {
//                emp = employees[i].getEmployeeId();
//                totalOrderCount += order.getQuantity();
//            }
//        }
//        System.out.println(emp + "-" + totalOrderCount);
//
//    }

    private static void printEmployeeData(Employee[] employees) {
        System.out.println("<< 사원 데이터 출력 >>");
        System.out.println(" EmployeeID Name Position Salary ");
        System.out.println("---------------------------------------------");
        for (Employee employee : employees) {
            System.out.println(employee.getEmployeeId() + "\t" + employee.getName() + "\t" +
                    employee.getPosition() + "\t" + employee.getSalary());
        }
        System.out.println("=============================================");
    }

    private static void printProduct(Product[] products) {
        System.out.println("<< 상품 데이터 출력 >>");
        System.out.println(" ProductId Name CategoryId Price ");
        System.out.println("---------------------------------------------");
        for (Product product : products) {
            System.out.println(product.getProductId() + "\t" + product.getProductName() + "\t" +
                    product.getCategoryId() + "\t" + product.getPrice());
        }
        System.out.println("=============================================");
    }

    private static void printCategory(Category[] categories) {
        System.out.println("<< 카테고리 데이터 출력 >>");
        System.out.println(" CategoryID Name Description ");
        System.out.println("---------------------------------------------");
        for (Category category : categories) {
            System.out.println(category.getCategoryId() + "\t" + category.getName() + "\t" + category.getDescription());
        }
        System.out.println("=============================================");
    }

    /**
     * 주문 데이터 출력
     *
     * @param categories
     * @param products
     * @param orders
     * @param employees
     */
    private static void showOrderData(Category[] categories, Product[] products,
                                      Order[] orders, Employee[] employees) {
        System.out.println("<< 주문 데이터 출력 >>");
        System.out.println(" OrderID OrderDate ProductID productName CategoryName EmployeeID EmployeeName Quantity ");
        System.out.println("---------------------------------------------------------------------------------------");

        int totalOrderAmount = 0; // 총 주문 금액
        int highestOrderAmount = 0; // 가장 큰 주문 금액
        Order highestOrder = null; // 가장 큰 주문 객체

        for (Order order : orders) {
            // 상품 정보 출력
            Product product = findProductById(order.getProductId(), products);

            // 카테고리 정보 출력
            Category category = findCategoryById(product.getCategoryId(), categories);

            // 사원 정보 출력
            Employee employee = findEmployeeById(order.getEmployeeId(), employees);

            // 주문 금액 계산
            int orderAmount = (int) product.getPrice() * order.getQuantity();
            totalOrderAmount += orderAmount; // 총 주문 금액 누적

            // 가장 큰 주문 찾기
            if (orderAmount > highestOrderAmount) {
                highestOrderAmount = orderAmount;
                highestOrder = order;
            }

            // 주문 정보 출력
            System.out.println(order.getOrderId() + "\t" + order.getOrderDate() + "\t" +
                    order.getProductId() + "\t" + product.getProductName() + "\t" +
                    category.getName() + "\t" +
                    order.getEmployeeId() + "\t" + employee.getName() + "\t" +
                    order.getQuantity() + "\t" + orderAmount);
        }

        // 총 주문 금액 출력
        System.out.println("총 주문 금액: " + totalOrderAmount + "원");

        // 가장 금액이 높은 주문 출력
        if (highestOrder != null) {
            Product highestProduct = findProductById(highestOrder.getProductId(), products);
            System.out.println("가장 금액이 높은 주문: 주문ID " + highestOrder.getOrderId() + ", 상품명: " + highestProduct.getProductName() +
                    ", 주문 금액: " + highestOrderAmount + "원");
        }
    }

    /**
     * 사원 id로 사원 객체 찾기
     *
     * @param employeeId
     * @param employees
     */
    private static Employee findEmployeeById(int employeeId, Employee[] employees) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                return employee;
            }
        }
        return null;
    }

    /**
     * 특정 카테고리 조회
     * - 전달된 카테고리id로 카테고리 배열에서 해당 객체 찾아서 반환
     */
    private static Category findCategoryById(int cagegoryId, Category[] categories) {
        for (Category category : categories) {
            if (category.getCategoryId() == cagegoryId) {
                return category;
            }
        }
        return null;
    }

    // 현재 주문이 갖고 있는 상품의id와 동일한 상품 객체를 찾아서 반환.
    private static Product findProductById(int productId, Product[] products) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product; // 함수종료
            }
        }
        return null;
    }


    /**
     * 빵 카테고리에 속한 상품들의 가격을 밀가루값 인상으로 15% 인상하는 메소드
     * - 빵 카테고리 : categoryId = 5
     *
     * @param products
     */
    private static void increaseBakeryPrice(Product[] products) {
        for (Product product : products) {
            if (product.getCategoryId() == 5) {  // 빵 카테고리
                int beforePrice = (int) product.getPrice();
                int afterPrice = (int) (beforePrice * 1.15);
                product.setPrice(afterPrice);
                System.out.println(product.getProductName() + " 상품의 가격이 " + beforePrice + "에서 " +
                        afterPrice + "로 변경되었습니다.");
            }
        }
    }

    /**
     * 상품의 가격을 변경하는 메소드
     *
     * @param productName
     * @param price       변화시킬 가격
     * @param products
     */
    private static void updateProductPrice(String productName, int price, Product[] products) {
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                int beforePrice = (int) product.getPrice();
                product.setPrice(price); // 세터 메소드를 사용해서 가격 변경
                System.out.println(product.getProductName() + " 상품의 가격이 " + beforePrice + "에서 " + price +
                        "로 변경되었습니다.");
                break;
            }
        }
    }

    private static void printOneProduct(Product product) {
        System.out.println("<< 특정 카테고리의 상품 1개 출력 >>");
        System.out.println(" ProductID Name CategoryId Price ");
        System.out.println("---------------------------------------------");
        System.out.println(product.getProductId() + "\t" + product.getProductName() + "\t" +
                product.getCategoryId() + "\t" + product.getPrice());
        System.out.println("=============================================");
    }

    // 상품의 이름으로 상품 1개 조회
    private static Product findProductByName(String productName, Product[] products) {
        Product product = null; // 찾아진 상품 객체를 저장할 변수
        for (Product p : products) {
            if (p.getProductName().equals(productName)) {
                product = p;
                break;
            }
        }
        return product;
    }

    /**
     * 특정 카테고리에 속한 상품들을 출력하는 메소드
     *
     * @param categoryProducts
     */
    private static void printProductListWithCategoryName(Product[] categoryProducts) {
        // 상품 가격 누적 변수
        int totalAmount = 0;
        System.out.println("=============================================");
        System.out.println(" ProductID Name CategoryId Price ");
        System.out.println("---------------------------------------------");
        for (Product product : categoryProducts) {
            if (product == null) {
                break;
            }
            System.out.println(product.getProductId() + "\t" + product.getProductName() + "\t" +
                    product.getCategoryId() + "\t" + product.getPrice());
            totalAmount += product.getPrice();  // 상품 가격 누적
        }
        System.out.println("=============================================");
        System.out.println("카테고리에 소속된 상품의 합계: $" + totalAmount);
    }

    // 특정 카테고리에 속한 상품들을 반환하는 메소드
    public static Product[] getProductsByCatoryName(String categoryName,
                                                    Category[] categories,
                                                    Product[] products) {
        // 1. 전달받은 카테고리 이름과 일치하는 상품 객체들을 저장할 배열 생성
        Product[] categoryProducts = new Product[products.length];

        // 2. 전달받은 카테고리 이름에 해당하는 카테고리의 id를 찾아온다.
        int categoryId = 0;
        for (Category category : categories) {
            if (category.getName().equals(categoryName)) {
                categoryId = category.getCategoryId();
                break;
            }
        }
        // 3. 찾은 카테고리 id에 해당하는 상품 객체들을 찾아서 배열에 저장
        int count = 0;
        for (Product product : products) {
            if (product.getCategoryId() == categoryId) {
                categoryProducts[count++] = product;
            }
        }
        return categoryProducts;
    }


    public static Category[] initializeCategoryData() {
        Category[] categories = new Category[6];
        categories[0] = new Category(1, "Coffee", "모든 종류의 커피");
        categories[1] = new Category(2, "Latte", "다양한 종류의 라떼");
        categories[2] = new Category(3, "Ade/Shake", "신선한 에이드와 쉐이크");
        categories[3] = new Category(4, "Smoothie/Juice", "건강한 스무디와 주스");
        categories[4] = new Category(5, "Bakery", "갓 구운 빵");
        categories[5] = new Category(6, "Tea", "전통 차와 허브 차");
        return categories;
    }

    private static Product[] initializeProductData() {
        Product[] products = new Product[28];
        products[0] = new Product(1, "카라멜마끼아또", 1, 5000);
        products[1] = new Product(2, "홍차라떼", 2, 5000);
        products[2] = new Product(3, "초코라떼", 2, 5000);
        products[3] = new Product(4, "오레오쉐이크", 3, 5000);
        products[4] = new Product(5, "아이스아메리카노", 1, 5000);
        products[5] = new Product(6, "딸기라떼", 2, 4500);
        products[6] = new Product(7, "복숭아스무디", 4, 5000);
        products[7] = new Product(8, "커피콩빵", 5, 3000);
        products[8] = new Product(9, "바니라라떼", 1, 5000);
        products[9] = new Product(10, "매실차", 6, 4500);
        products[10] = new Product(11, "깔라만시", 6, 4500);
        products[11] = new Product(12, "카페라떼", 1, 4000);
        products[12] = new Product(13, "헤이즐넛라떼", 1, 5000);
        products[13] = new Product(14, "더치커피", 1, 5000);
        products[14] = new Product(15, "아메리카노", 1, 4000);
        products[15] = new Product(16, "캐모마일", 6, 4500);
        products[16] = new Product(17, "아포가또", 3, 5500);
        products[17] = new Product(18, "비엔나커피", 1, 5000);
        products[18] = new Product(19, "베이글", 5, 3500);
        products[19] = new Product(20, "카푸치노", 1, 4000);
        products[20] = new Product(21, "허니브레드", 5, 6000);
        products[21] = new Product(22, "카페모카", 1, 5000);
        products[22] = new Product(23, "얼그레이", 6, 4500);
        products[23] = new Product(24, "히비아이스트", 3, 5000);
        products[24] = new Product(25, "플레인 와플", 5, 6000);
        products[25] = new Product(26, "요거트", 3, 5500);
        products[26] = new Product(27, "유자스무디", 4, 5000);
        products[27] = new Product(28, "딸기스무디", 4, 5000);
        return products;
    }

    private static Order[] initializeOrderData() {
        Order[] orders = new Order[74];
        orders[0] = new Order(38167668, "2017-09-13 10:15", 1, 201, 1);
        orders[1] = new Order(89217297, "2017-09-13 10:20", 2, 201, 1);
        orders[2] = new Order(39178816, "2017-09-13 10:40", 3, 201, 1);
        orders[3] = new Order(63105816, "2017-09-13 10:05", 4, 201, 1);
        orders[4] = new Order(47018158, "2017-09-13 11:15", 5, 201, 1);
        orders[5] = new Order(46078737, "2017-09-13 11:25", 6, 201, 1);
        orders[6] = new Order(32215456, "2017-09-13 11:35", 7, 201, 1);
        orders[7] = new Order(60728464, "2017-09-13 11:45", 8, 201, 1);
        orders[8] = new Order(99145980, "2017-09-13 11:50", 9, 201, 1);
        orders[9] = new Order(65700654, "2017-09-13 12:00", 8, 202, 1);
        orders[10] = new Order(75801947, "2017-09-13 12:01", 7, 202, 1);
        orders[11] = new Order(84752631, "2017-09-13 12:02", 6, 202, 1);
        orders[12] = new Order(93671852, "2017-09-13 12:03", 5, 202, 1);
        orders[13] = new Order(54449843, "2017-09-13 12:10", 4, 202, 1);
        orders[14] = new Order(66578200, "2017-09-13 12:15", 3, 202, 1);
        orders[15] = new Order(79287280, "2017-09-13 12:35", 3, 202, 1);
        orders[16] = new Order(56679560, "2017-09-13 12:50", 6, 203, 1);
        orders[17] = new Order(39865396, "2017-09-13 12:55", 4, 203, 1);
        orders[18] = new Order(49791945, "2017-09-13 13:15", 6, 203, 1);
        orders[19] = new Order(29501238, "2017-09-13 13:15", 8, 203, 1);
        orders[20] = new Order(85372640, "2017-09-13 13:15", 11, 203, 1);
        orders[21] = new Order(42187936, "2017-09-13 13:15", 12, 203, 1);
        orders[22] = new Order(73592627, "2017-09-13 13:30", 13, 203, 1);
        orders[23] = new Order(57111296, "2017-09-13 13:45", 14, 203, 1);
        orders[24] = new Order(47851236, "2017-09-13 13:45", 15, 203, 1);
        orders[25] = new Order(36985247, "2017-09-13 13:45", 16, 203, 1);
        orders[26] = new Order(56372948, "2017-09-13 13:45", 17, 203, 1);
        orders[27] = new Order(69598408, "2017-09-13 13:05", 18, 203, 1);
        orders[28] = new Order(12457869, "2017-09-13 13:05", 19, 203, 1);
        orders[29] = new Order(98765321, "2017-09-13 13:05", 20, 203, 1);
        orders[30] = new Order(25437894, "2017-09-13 13:05", 21, 205, 1);
        orders[31] = new Order(69452873, "2017-09-13 14:31", 20, 205, 1);
        orders[32] = new Order(67173436, "2017-09-13 14:32", 19, 205, 1);
        orders[33] = new Order(78265149, "2017-09-13 14:33", 20, 205, 1);
        orders[34] = new Order(83495128, "2017-09-13 14:30", 15, 205, 1);
        orders[35] = new Order(94371682, "2017-09-13 14:35", 15, 205, 1);
        orders[36] = new Order(36320862, "2017-09-13 14:05", 15, 205, 1);
        orders[37] = new Order(71781108, "2017-09-13 14:55", 15, 205, 1);
        orders[38] = new Order(55756203, "2017-09-13 14:55", 15, 205, 1);
        orders[39] = new Order(19384756, "2017-09-13 14:55", 15, 205, 1);
        orders[40] = new Order(58472913, "2017-09-13 14:55", 15, 205, 1);
        orders[41] = new Order(65234879, "2017-09-13 15:00", 20, 205, 1);
        orders[42] = new Order(22817525, "2017-09-13 15:15", 11, 205, 1);
        orders[43] = new Order(55183914, "2017-09-13 15:40", 12, 205, 1);
        orders[44] = new Order(39118494, "2017-09-13 15:45", 13, 204, 1);
        orders[45] = new Order(56152549, "2017-09-13 16:45", 14, 204, 1);
        orders[46] = new Order(44004393, "2017-09-13 16:55", 15, 204, 1);
        orders[47] = new Order(57522351, "2017-09-13 16:55", 17, 204, 1);
        orders[48] = new Order(12984365, "2017-09-13 16:55", 19, 204, 1);
        orders[49] = new Order(23847519, "2017-09-13 16:55", 20, 204, 1);
        orders[50] = new Order(38472615, "2017-09-13 17:40", 20, 204, 1);
        orders[51] = new Order(45798214, "2017-09-13 17:55", 20, 204, 1);
        orders[52] = new Order(97267860, "2017-09-13 18:20", 20, 204, 1);
        orders[53] = new Order(23534034, "2017-09-13 19:15", 20, 204, 1);
        orders[54] = new Order(91629257, "2017-09-13 19:20", 21, 204, 1);
        orders[55] = new Order(37776984, "2017-09-13 19:25", 13, 203, 1);
        orders[56] = new Order(46888645, "2017-09-13 20:25", 1, 203, 1);
        orders[57] = new Order(47293154, "2017-09-13 20:45", 2, 203, 1);
        orders[58] = new Order(34402591, "2017-09-13 20:55", 3, 203, 1);
        orders[59] = new Order(75967086, "2017-09-13 21:25", 4, 203, 1);
        orders[60] = new Order(41288267, "2017-09-13 21:40", 5, 203, 1);
        orders[61] = new Order(38559076, "2017-09-13 22:00", 14, 203, 1);
        orders[62] = new Order(16229001, "2017-09-13 22:10", 15, 203, 1);
        orders[63] = new Order(59480814, "2017-09-13 22:35", 16, 203, 1);
        orders[64] = new Order(96791246, "2017-09-13 22:40", 17, 203, 1);
        orders[65] = new Order(50021775, "2017-09-13 22:50", 18, 203, 1);
        orders[66] = new Order(55861805, "2017-09-13 22:50", 21, 203, 1);
        orders[67] = new Order(68585789, "2017-09-13 22:52", 10, 203, 1);
        orders[68] = new Order(16372948, "2017-09-13 22:53", 15, 203, 1);
        orders[69] = new Order(76239485, "2017-09-13 22:54", 10, 202, 1);
        orders[70] = new Order(14582397, "2017-09-13 23:15", 15, 202, 1);
        orders[71] = new Order(27463859, "2017-09-13 23:20", 16, 202, 1);
        orders[72] = new Order(94113278, "2017-09-13 23:25", 17, 202, 1);
        orders[73] = new Order(17708771, "2017-09-13 23:45", 12, 202, 1);
        return orders;
    }

    private static Employee[] initializeEmployeeData() {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee(201, "Alice", "사원", 3000);
        employees[1] = new Employee(202, "Bob", "대리", 4000);
        employees[2] = new Employee(203, "Charlie", "과장", 5000);
        employees[3] = new Employee(204, "David", "사원", 3200);
        employees[4] = new Employee(205, "Eve", "대리", 4200);
        return employees;
    }
}
