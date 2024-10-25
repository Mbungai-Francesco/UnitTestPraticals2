package com.stjean.operation;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class user {

  private int id;
  private String name;
  private int age;
  private String email;
  private String phone;
  private String city;
  private double balancePersonnel;

  public static ArrayList<user> users = new ArrayList<user>();

  public user(int id, String name, int age, String email, String phone, String city, double balancePersonnel) {
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

  private static boolean validateEmail(String email) {
    String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
    Pattern pattern = Pattern.compile(emailRegex);
    if (!pattern.matcher(email).matches()) {
      return false;
    }
    return true;
  }

  public void add(user user) throws EmailInvalidException {
    boolean valid = validateEmail(user.getEmail());
    if(valid){
      users.add(user);
    }
    else{
      throw new EmailInvalidException("Invalid email: " + user.getEmail());
    }
  }

  public void delete(int id) throws DeletionInvalidException {
    boolean removed = users.removeIf(user -> user.getId() == id);
    if (!removed) {
        throw new DeletionInvalidException("User with id " + id + " does not exist.");
    }
}

  public String display(int id) {
    String ans = "";
    for (com.stjean.operation.user user : users) {
      if (user.getId() == id) {
        ans = "User{" +
            "id=" + id +
            ", name='" + user.getName() + 
            ", age=" + user.getAge() +
            ", email='" + user.getEmail() + 
            ", phone='" + user.getPhone() +
            ", city='" + user.getCity() +
            ", balancePersonnel=" + user.getBalancePersonnel() +
            "}";
      }
    }
    return ans;
  }

  public double analyseSoldeGeneral() throws NegativeGeneralBalanceException{
    double totalBalance = 0.0;
    for (User user : users) {
        totalBalance += user.getBalancePersonnel();
    }
    if (totalBalance < 0) {
      throw new NegativeGeneralBalanceException("General balance is negative: " + totalBalance);
  }
    return totalBalance;
  }

  public User getRichestUser() {
    if (users.isEmpty()) {
        return null;
    }
    User richestUser = users.get(0);
    for (User user : users) {
        if (user.getBalancePersonnel() > richestUser.getBalancePersonnel()) {
            richestUser = user;
        }
    }
    return richestUser;
  }
}