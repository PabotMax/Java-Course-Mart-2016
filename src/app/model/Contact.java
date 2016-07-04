package app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created by mda on 5/13/16.
 */
public class Contact {
    @SerializedName("uid")
    @Expose
    Long Uid;

    @SerializedName("id")
    @Expose
    Long id;

    @SerializedName("firstName")
    @Expose
    public String firstName;

    @SerializedName("lastName")
    @Expose
    public String lastName;

    @SerializedName("address")
    @Expose
    public Address address;

    @SerializedName("phones")
    @Expose
    public List<String> phones;

    @SerializedName("emails")
    @Expose
    public List<String> emails;

    @SerializedName("photoPath")
    @Expose
    public String photoPath;

    @SerializedName("birthday")
    @Expose
    public Date birthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (!firstName.equals(contact.firstName)) return false;
        return lastName.equals(contact.lastName);

    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "Uid=" + Uid +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", phones=" + phones +
                ", emails=" + emails +
                ", photoPath='" + photoPath + '\'' +
                ", birthday=" + birthday +
                '}';
    }


}
