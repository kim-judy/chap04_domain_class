package com.javalab.sec22;


import com.javalab.sec18.Employee;
import com.javalab.sec18.Order;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CafeManagementSystem {
    public static void main(String[] args) {

        // 1. 카테고리 기본 데이터 생성 메소드 호출
        ArrayList<Category> categories = initializeCategoryData();

        // 2. 카테고리 id가 3인 카테고리의 description을 조회 및 출력
        Category category = null; // 카테고리id가 3인 카테고리 객체를 저장할 변수
        for(Category c : categories) {
            if(c.getCategoryId() == 3) {
                category = c; // 카테고리id가 3인 카테고리 객체를 찾아서 category 변수에 저장
                break;
            }
        }
        System.out.println("카테고리 id가 3인 카테고리의 설명: " + category.getDescription());

        // 3. 카테고리id가 짝수인 카테고리 객체만 조회, 별도의 ArrayList에 저장해서 출력
        ArrayList<Category> evenCategoryList = new ArrayList<Category>(); // 카테고리id가 짝수인 카테고리 객체를 저장할 ArrayList
        for(Category c : categories) {
            if(c.getCategoryId() % 2 == 0) { // 카테고리id가 짝수인 경우
                evenCategoryList.add(c); // 카테고리id가 짝수인 카테고리 객체를 evenCategoryList에 추가
            }
        }
        // evenCategoryList에 저장된 카테고리 객체 출력
        for(Category c : evenCategoryList) {
            System.out.println(c.getCategoryId() + " " + c.getName() + " " + c.getDescription());
        }

        // 4. 카테고리id가 5인 카테고리의 이름을 "Bread"로 변경, description을 "고소한 빵"으로 변경
        for(Category c : categories) {
            if(c.getCategoryId() == 5) { // 카테고리id가 5인 경우
                c.setName("Bread"); // 카테고리 이름을 "Bread"로 변경
                c.setDescription("고소한 빵"); // 카테고리 설명을 "고소한 빵"으로 변경
            }
        }
        // 변경된 카테고리 정보 출력
        System.out.println("카테고리id가 5인 카테고리의 이름과 설명 변경 후 출력");
        for(Category c : categories) {
            System.out.println(c.getCategoryId() + " " + c.getName() + " " + c.getDescription());
        }

        // 6. 상품데이터 생성 메소드 호출
        ArrayList<Product> products = initializeProdutData();

        // 7. "초코라떼"라는 이름을 가진 상품 객체를 조회하되 별도의 ArrayList에 저장해서 출력
        ArrayList<Product> chocoLatteList = new ArrayList<Product>(); // "초코라떼" 상품 객체를 저장할 ArrayList
        for(Product p : products) {
            if(p.getName().equals("초코라떼")) { // 상품 이름이 "초코라떼"인 경우
                chocoLatteList.add(p); // "초코라떼" 상품 객체를 chocoLatteList에 추가
            }
        }
        // "초코라떼" 상품 객체 출력
        System.out.println("상품 이름이 '초코라떼'인 상품 출력");
        for(Product p : chocoLatteList) {
            System.out.println(p.getProductId() + " " + p.getName() + " " + p.getCategoryId()
                                + " " + p.getPrice() + " " + p.getStock());
        }

    } // end of main

    /**
     * 상품 기본 데이터를 생성하여 ArrayList에 추가하고 반환해주는 메소드
     */
    public static ArrayList<Product> initializeProdutData() {
        // 1. Product 객체를 저장할 수 있는 ArrayList 객체 생성
        ArrayList<Product> pList = new ArrayList<Product>();
        // 2. ArrayList에 추가할 Product 객체 생성
        pList.add(new Product(1, "카라멜마끼아또", 1, 5000, 1));
        pList.add(new Product(2, "홍차라떼", 2, 5000, 2));
        pList.add(new Product(3, "초코라떼", 2, 5000, 3));  // 초코라떼 한 번만 남김
        pList.add(new Product(4, "오레오", 3, 5000, 4));
        pList.add(new Product(5, "초코라떼", 2, 4500, 5));  // 가격이 다른 경우는 중복으로 처리하지 않음
        pList.add(new Product(6, "복숭아스무디", 4, 5000, 6));
        pList.add(new Product(7, "커피콩빵", 5, 3000, 7));
        pList.add(new Product(8, "바니라라떼", 1, 5000, 8));
        pList.add(new Product(9, "매실차", 6, 4500, 9));
        pList.add(new Product(10, "깔라만시", 6, 4500, 10));
        pList.add(new Product(11, "카페라떼", 1, 4000, 10));
        pList.add(new Product(12, "헤이즐넛라떼", 1, 5000, 10));
        pList.add(new Product(13, "아메리카노", 1, 4000, 10));
        pList.add(new Product(14, "캐모마일", 6, 4500, 10));
        pList.add(new Product(15, "아포가또", 3, 5500, 10));
        pList.add(new Product(16, "비엔나커피", 1, 5000, 10));
        pList.add(new Product(17, "베이글", 5, 3500, 10));
        pList.add(new Product(18, "카푸치노", 1, 4000, 10));
        pList.add(new Product(19, "허니브레드", 5, 6000, 10));
        pList.add(new Product(20, "얼그레이", 6, 4500, 10));
        pList.add(new Product(21, "레몬에이드", 3, 5000, 10));
        return pList;
    }



        /**
         * 카테고리 기본 데이터를 생성하여 ArrayList에 추가하는 메소드
         * @return : Category 객체가 추가된 ArrayList를 반환
         */
    public static ArrayList<Category> initializeCategoryData(){
        // 1. Category 객체를 저장할 수 있는 ArrayList 객체 생성
        ArrayList<Category> categoryArrayList = new ArrayList<Category>();
        // 2. ArrayList에 추가할 Category 객체 생성
        Category c1 = new Category(1, "Coffee", "모든 종류의 커피");
        Category c2 = new Category(2, "Latte", "다양한 종류의 라떼");
        Category c3 = new Category(3, "Ade/Shake", "신선한 에이드와 쉐이크");
        Category c4 = new Category(4, "Smoothie/Juice", "건강한 스무디와 주스");
        Category c5 = new Category(5, "Bakery", "갓 구운 빵");
        Category c6 = new Category(6, "Tea", "전통 차와 허브 차");
        // 3. 생성한 카테고리 객체를 ArrayList에 추가
        categoryArrayList.add(c1);
        categoryArrayList.add(c2);
        categoryArrayList.add(c3);
        categoryArrayList.add(c4);
        categoryArrayList.add(c5);
        categoryArrayList.add(c6);
        // 4. 생성한 ArrayList 반환
        return categoryArrayList;
    }

    public static ArrayList<Order> initializeOrderData(){
        // Order 객체 생성
        ArrayList<Order> orderList = new ArrayList<Order>();
        orderList.add(new Order(38167668, "2017-09-13 10:15", 1, 201, 1));
        orderList.add(new Order(89217297, "2017-09-13 10:20", 2, 201, 1));
        orderList.add(new Order(39178816, "2017-09-13 10:40", 3, 201, 1));
        orderList.add(new Order(63105816, "2017-09-13 10:05", 4, 201, 1));
        orderList.add(new Order(47018158, "2017-09-13 11:15", 5, 201, 1));
        orderList.add(new Order(46078737, "2017-09-13 11:25", 6, 201, 1));
        orderList.add(new Order(32215456, "2017-09-13 11:35", 7, 201, 1));
        orderList.add(new Order(60728464, "2017-09-13 11:45", 8, 201, 1));
        orderList.add(new Order(99145980, "2017-09-13 11:50", 9, 201, 1));
        orderList.add(new Order(65700654, "2017-09-13 12:00", 8, 202, 1));
        orderList.add(new Order(75801947, "2017-09-13 12:00", 7 ,202, 1));
        orderList.add(new Order(84752631, "2017-09-13 12:00", 6 ,202, 1));
        orderList.add(new Order(93671852, "2017-09-13 12:00", 5 ,202, 1));
        orderList.add(new Order(54449843, "2017-09-13 12:10", 4 ,202, 1));
        orderList.add(new Order(66578200, "2017-09-13 12:15", 3 ,202, 1));
        orderList.add(new Order(79287280, "2017-09-13 12:35", 3 ,202, 1));
        orderList.add(new Order(56679560, "2017-09-13 12:50", 6 ,203, 1));
        orderList.add(new Order(39865396, "2017-09-13 12:55", 4 ,203, 1));
        orderList.add(new Order(49791945, "2017-09-13 13:15", 6 ,203, 1));
        orderList.add(new Order(29501238, "2017-09-13 13:15", 8 ,203, 1));
        orderList.add(new Order(85372640, "2017-09-13 13:15", 11,203, 1));
        orderList.add(new Order(42187936, "2017-09-13 13:15", 12,203, 1));
        orderList.add(new Order(73592627, "2017-09-13 13:30", 13,203, 1));
        orderList.add(new Order(57111296, "2017-09-13 13:45", 14,203, 1));
        orderList.add(new Order(47851236, "2017-09-13 13:45", 15,203, 1));
        orderList.add(new Order(36985247, "2017-09-13 13:45", 16,203, 1));
        orderList.add(new Order(56372948, "2017-09-13 13:45", 17,203, 1));
        orderList.add(new Order(69598408, "2017-09-13 13:05", 18,203, 1));
        orderList.add(new Order(12457869, "2017-09-13 13:05", 19,203, 1));
        orderList.add(new Order(98765321, "2017-09-13 13:05", 20,203, 1));
        orderList.add(new Order(25437894, "2017-09-13 13:05", 21,205, 1));
        orderList.add(new Order(69452873, "2017-09-13 14:30", 20,205, 1));
        orderList.add(new Order(67173436, "2017-09-13 14:30", 19,205, 1));
        orderList.add(new Order(78265149, "2017-09-13 14:30", 20,205, 1));
        orderList.add(new Order(83495128, "2017-09-13 14:30", 15,205, 1));
        orderList.add(new Order(94371682, "2017-09-13 14:35", 15,205, 1));
        orderList.add(new Order(36320862, "2017-09-13 14:05", 15,205, 1));
        orderList.add(new Order(71781108, "2017-09-13 14:55", 15,205, 1));
        orderList.add(new Order(55756203, "2017-09-13 14:55", 15,205, 1));
        orderList.add(new Order(19384756, "2017-09-13 14:55", 15,205, 1));
        orderList.add(new Order(58472913, "2017-09-13 14:55", 15,205, 1));
        orderList.add(new Order(65234879, "2017-09-13 15:00", 20,205, 1));
        orderList.add(new Order(22817525, "2017-09-13 15:15", 11,205, 1));
        orderList.add(new Order(55183914, "2017-09-13 15:40", 12,205, 1));
        orderList.add(new Order(39118494, "2017-09-13 15:45", 13,204, 1));
        orderList.add(new Order(56152549, "2017-09-13 16:45", 14,204, 1));
        orderList.add(new Order(44004393, "2017-09-13 16:55", 15,204, 1));
        orderList.add(new Order(57522351, "2017-09-13 16:55", 17,204, 1));
        orderList.add(new Order(12984365, "2017-09-13 16:55", 19,204, 1));
        orderList.add(new Order(23847519, "2017-09-13 16:55", 20,204, 1));
        orderList.add(new Order(38472615, "2017-09-13 17:40", 20,204, 1));
        orderList.add(new Order(45798214, "2017-09-13 17:55", 20,204, 1));
        orderList.add(new Order(97267860, "2017-09-13 18:20", 20,204, 1));
        orderList.add(new Order(23534034, "2017-09-13 19:15", 20,204, 1));
        orderList.add(new Order(91629257, "2017-09-13 19:20", 21,204, 1 ));
        orderList.add(new Order(37776984, "2017-09-13 19:25", 13,203, 1 ));
        orderList.add(new Order(46888645, "2017-09-13 20:25", 1 ,203, 1 ));
        orderList.add(new Order(47293154, "2017-09-13 20:45", 2 ,203, 1 ));
        orderList.add(new Order(34402591, "2017-09-13 20:55", 3 ,203, 1 ));
        orderList.add(new Order(75967086, "2017-09-13 21:25", 4 ,203, 1 ));
        orderList.add(new Order(41288267, "2017-09-13 21:40", 5 ,203, 1 ));
        orderList.add(new Order(38559076, "2017-09-13 22:00", 14,203, 1 ));
        orderList.add(new Order(16229001, "2017-09-13 22:10", 15,203, 1));
        orderList.add(new Order(59480814, "2017-09-13 22:35", 16,203, 1));
        orderList.add(new Order(96791246, "2017-09-13 22:40", 17,203, 1));
        orderList.add(new Order(50021775, "2017-09-13 22:50", 18,203, 1 ));
        orderList.add(new Order(55861805, "2017-09-13 22:55", 21,203, 1 ));
        orderList.add(new Order(68585789, "2017-09-13 22:55", 10,203, 1 ));
        orderList.add(new Order(16372948, "2017-09-13 22:55", 15,203, 1 ));
        orderList.add(new Order(76239485, "2017-09-13 22:55", 10,202, 1));
        orderList.add(new Order(14582397, "2017-09-13 23:15", 15,202, 1));
        orderList.add(new Order(27463859, "2017-09-13 23:20", 16,202, 1));
        orderList.add(new Order(94113278, "2017-09-13 23:25", 17,202, 1));
        orderList.add(new Order(17708771, "2017-09-13 23:45", 12,202, 1 ));
        return orderList;
    }

    private static ArrayList<Employee> initializeEmployeeData() {
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee(201, "Alice", "사원", 3000));
        employeeList.add(new Employee(202, "Bob", "대리", 4000));
        employeeList.add(new Employee(203, "Charlie", "과장", 5000));
        employeeList.add(new Employee(204, "David", "사원", 3200));
        employeeList.add(new Employee(205, "Eve", "대리", 4200));
        return employeeList;
    }    
}
