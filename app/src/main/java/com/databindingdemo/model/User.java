package com.databindingdemo.model;


import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.PropertyChangeRegistry;

import com.databindingdemo.app.BR;

/**
 * Created by ln-141 on 9/3/16.
 */
public class User extends BaseObservable {
    @Bindable
    private String FirstName;
    @Bindable
    private String LastName;
    @Bindable
    private String Email;
    @Bindable
    private String Phone;

    private final PropertyChangeRegistry mPropertyChangeRegistry =
            new PropertyChangeRegistry();

    public User(String firstName, String lastName, String email, String phone) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Phone = phone;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
        mPropertyChangeRegistry.notifyChange(this, BR.FirstName);
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
        mPropertyChangeRegistry.notifyChange(this, BR.LastName);
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
        mPropertyChangeRegistry.notifyChange(this, BR.Email);
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
        mPropertyChangeRegistry.notifyChange(this, BR.Phone);

    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        mPropertyChangeRegistry.add(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        mPropertyChangeRegistry.remove(callback);
    }
}
