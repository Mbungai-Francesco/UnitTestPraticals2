package com.stjean.operation;

import java.util.ArrayList;

public class User {

  private int id;
  private String name;
  private int age;
  private String email;
  private String phone;
  private String city;
  private double balancePersonnel;

  public static ArrayList<User> users;

  public User(int id, String name, int age, String email, String phone, String city, double balancePersonnel) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.email = email;
    this.phone = phone;
    this.city = city;
    this.balancePersonnel = balancePersonnel;
  }

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPhone() {
    return phone;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }
  public double getBalancePersonnel() {
    return balancePersonnel;
  }
  public void setBalancePersonnel(double balancePersonnel) {
    this.balancePersonnel = balancePersonnel;
  }

  public static void add(User user) {
    users.add(user);
  }

  public static void delete(int id) {
      users.removeIf(user -> user.getId() == id);
  }

  public static void display(int id) {
      for (User user : users) {
        if (user.getId() == id) {
            System.out.println(
              "User{" +
              "id=" + id +
              ", name='" + user.getName() + '\'' +
              ", age=" + user.getAge() +
              ", email='" + user.getEmail() + '\'' +
              ", phone='" + user.getPhone() + '\'' +
              ", city='" + user.getCity() + '\'' +
              ", balancePersonnel=" + user.getBalancePersonnel() +
              '}'
            );
        }
      }
  }

}
