package jpabook.jpashop;

import jpabook.jpashop.domain.*;
import jpabook.jpashop.domain.item.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.doInit1();
        initService.doInit2();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{

        private final EntityManager em;
        public void doInit1(){
            Member member = createMember("userA","서울","1","1111");
            em.persist(member);

            Book book1 = createBook("JPA1 BOOK", 10000,100);
            em.persist(book1);
            Book book2 = createBook("JPA2 BOOk", 20000, 300);
            em.persist(book2);

            OrderItem orderItem1 = OrderItem.createOrderItem(book1, book1.getPrice(), 1);
            OrderItem orderItem2 = OrderItem.createOrderItem(book2, book2.getPrice(), 2);

            Delivery delivery = new Delivery();
            delivery.setAddress(member.getAddress());
            Order order = Order.createOrder(member, delivery, orderItem1, orderItem2);
            em.persist(order);
        }

        public void doInit2(){
            Member member = createMember("userB","평택","22","2222");
            em.persist(member);

            Book book1 = createBook("SPRING1 BOOK", 15000, 100);
            em.persist(book1);
            Book book2 = createBook("SPRING2 BOOK", 25000, 200);
            em.persist(book2);

            OrderItem orderItem1 = OrderItem.createOrderItem(book1, book1.getPrice(), 1);
            OrderItem orderItem2 = OrderItem.createOrderItem(book2, book2.getPrice(), 2);

            Delivery delivery = new Delivery();
            delivery.setAddress(member.getAddress());
            Order order = Order.createOrder(member, delivery, orderItem1, orderItem2);
            em.persist(order);
        }

        private Book createBook(String name, int price, int quantity) {
            Book book = new Book();
            book.setName(name);
            book.setPrice(price);
            book.setStockQuantity(quantity);
            return book;
        }

        private Member createMember(String name, String city, String street, String zipcode) {
            Member member = new Member();
            member.setName(name);
            member.setAddress(new Address(city,street,zipcode));
            return member;
        }
    }
}