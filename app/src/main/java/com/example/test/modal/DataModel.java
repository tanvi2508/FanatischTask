package com.example.test.modal;

public class DataModel {
    private String firstName;
    private String lastName;
    private String Email;
    private String mobileNumber;
    private String age;
    private String image_url;


    public DataModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
       this.Email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public DataModel(String firstName, String lastName, String email, String mobileNumber, String age, String image_url) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Email = email;
        this.mobileNumber = mobileNumber;
        this.age = age;
        this.image_url = image_url;


    }
    }
