package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {


    @Test
    public void testAddAllBooks() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "HarryPotter", 100, "Joanne Rowling");
        Book book2 = new Book(2, "HarryPotter2", 200, "Joanne Rowling");
        Book book3 = new Book(3, "The Lord of the Rings1", 300, "John Ronald Reuel Tolkien");
        Book book4 = new Book(4, "The Lord of the Rings2", 150, "John Ronald Reuel Tolkien");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] expected = {book1, book2, book3, book4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddOneBookAddOneSmartphone() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "HarryPotter", 100, "Joanne Rowling");
        Book book2 = new Book(2, "HarryPotter2", 200, "Joanne Rowling");
        Book book3 = new Book(3, "The Lord of the Rings1", 300, "John Ronald Reuel Tolkien");
        Book book4 = new Book(4, "The Lord of the Rings2", 150, "John Ronald Reuel Tolkien");
        Smartphone phone1 = new Smartphone(5, "iphone 14", "Apple", 1000);
        Smartphone phone2 = new Smartphone(6, "Galaxy s20 FE", "Samsung", 1500);

        manager.add(book1);
        manager.add(phone2);

        Product[] expected = {book1, phone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearch() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "HarryPotter", 100, "Joanne Rowling");
        Book book2 = new Book(2, "HarryPotter2", 200, "Joanne Rowling");
        Book book3 = new Book(3, "The Lord of the Rings1", 300, "John Ronald Reuel Tolkien");
        Book book4 = new Book(4, "The Lord of the Rings2", 150, "John Ronald Reuel Tolkien");


        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] expected = {book1, book2};
        Product[] actual = manager.searchBy("HarryPotter");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveBookAndSmartphoneRepo() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "HarryPotter", 100, "Joanne Rowling");
        Book book2 = new Book(2, "HarryPotter2", 200, "Joanne Rowling");
        Book book3 = new Book(3, "The Lord of the Rings1", 300, "John Ronald Reuel Tolkien");
        Book book4 = new Book(4, "The Lord of the Rings2", 150, "John Ronald Reuel Tolkien");
        Smartphone phone1 = new Smartphone(5, "iphone 14", "Apple", 1000);
        Smartphone phone2 = new Smartphone(6, "Galaxy s20 FE", "Samsung", 1500);


        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(phone1);
        manager.add(phone2);

        repo.removeById(1);
        repo.removeById(2);
        repo.removeById(5);


        Product[] expected = {book3, book4, phone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveBookAndSmartphoneManager() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "HarryPotter", 100, "Joanne Rowling");
        Book book2 = new Book(2, "HarryPotter2", 200, "Joanne Rowling");
        Book book3 = new Book(3, "The Lord of the Rings1", 300, "John Ronald Reuel Tolkien");
        Book book4 = new Book(4, "The Lord of the Rings2", 150, "John Ronald Reuel Tolkien");
        Smartphone phone1 = new Smartphone(5, "iphone 14", "Apple", 1000);
        Smartphone phone2 = new Smartphone(6, "Galaxy s20 FE", "Samsung", 1500);


        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(phone1);
        manager.add(phone2);

        manager.removeById(1);
        manager.removeById(3);
        manager.removeById(5);


        Product[] expected = {book2, book4, phone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestOneProduct() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "HarryPotter", 100, "Joanne Rowling");

        manager.add(book1);

        Product[] expected = {book1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testNullProduct() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}