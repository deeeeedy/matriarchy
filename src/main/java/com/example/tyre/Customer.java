package com.example.tyre;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.text.SimpleDateFormat;
import java.util.Date;
public class Customer {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty phoneNumber;
    private final StringProperty carNumber;
    private final IntegerProperty clientId;
    private final StringProperty carModel;
    private final String addingDate;
    public Customer() {
        this(null,null, null, null,null, 0);
    }
    public Customer (String firstName, String lastName, String carNumber, String carModel, String phoneNumber, int clientId, String date) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.carNumber = new SimpleStringProperty(carNumber);
        this.carModel = new SimpleStringProperty(carModel);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.clientId = new SimpleIntegerProperty(clientId);
        this.addingDate = date;

    }
    public Customer(String firstName, String lastName, String carNumber, String carModel, String phoneNumber, int clientId){
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.carNumber = new SimpleStringProperty(carNumber);
        this.carModel = new SimpleStringProperty(carModel);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.clientId = new SimpleIntegerProperty(clientId);
        this.addingDate = new SimpleStringProperty(new SimpleDateFormat("dd-MM-yyyy").format(new Date())).getValue();
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getCarNumber() {
        return carNumber.get();
    }

    public void setCarNumber(String carNumber) {
        this.carNumber.set(carNumber);
    }

    public StringProperty carNumberProperty() {
        return carNumber;
    }
    public String getCarModel() {
        return carModel.get();
    }

    public void setCarModel(String carModel) {
        this.carModel.set(carModel);
    }

    public StringProperty carModelProperty() {
        return carModel;
    }
    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }
    public int getClientId() {
        return clientId.get();
    }

    public void setClientId(int clientId) {
        this.clientId.set(clientId);
    }

    public IntegerProperty clientIdProperty() {
        return clientId;
    }

    public String getAddingDate() {
        return addingDate;
    }
}