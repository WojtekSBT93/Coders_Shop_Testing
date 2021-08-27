package zadanie_pierwsze.pages;

public class AddressFormData {
    private String alias;
    private String address;
    private String city;
    private int zipCode;
    private int country;
    private int phoneNumber;

    public String getAlias() {
        return alias;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public int getCountry() {
        return country;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public AddressFormData setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public AddressFormData setAddress(String address) {
        this.address = address;
        return this;
    }

    public AddressFormData setCity(String city) {
        this.city = city;
        return this;
    }

    public AddressFormData setZipCode(int zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public AddressFormData setCountry(int country) {
        this.country = country;
        return this;
    }

    public AddressFormData setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}




