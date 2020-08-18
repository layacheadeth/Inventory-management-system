package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Blob;

// this product class is the concrete command, body or definition of what the command should do.
public class product {
    private StringProperty name_property;
    private StringProperty tel_property;
    private StringProperty categories_property;
    private StringProperty item_name_property;
    private StringProperty price_property;
    private StringProperty status_property;

    public product(String name, String tel, String categories, String item_name, String price, String status){
        this.name_property=new SimpleStringProperty(name);
        this.tel_property=new SimpleStringProperty(tel);
        this.categories_property=new SimpleStringProperty(categories);
        this.item_name_property=new SimpleStringProperty(item_name);
        this.price_property=new SimpleStringProperty(price);
        this.status_property=new SimpleStringProperty(status);
    }

    //get method
    public String getName_property() {
        return name_property.get();
    }

    public String getTel_property() {
        return tel_property.get();
    }

    public String getCategories_property() {
        return categories_property.get();
    }

    public String getItem_name_property() {
        return item_name_property.get();
    }

    public String getPrice_property() {
        return price_property.get();
    }

    public String getStatus_property() {
        return status_property.get();
    }

    //set method

    public void setName_property(String name_property) {
        this.name_property.set(name_property);
    }

    public void setTel_property(String tel_property) {
        this.tel_property.set(tel_property);
    }

    public void setCategories_property(String categories_property) {
        this.categories_property.set(categories_property);
    }

    public void setItem_name_property(String item_name_property) {
        this.item_name_property.set(item_name_property);
    }

    public void setPrice_property(String price_property) {
        this.price_property.set(price_property);
    }

    public void setStatus_property(String status_property) {
        this.status_property.set(status_property);
    }

    //properties method

    public StringProperty name_propertyProperty() {
        return name_property;
    }

    public StringProperty tel_propertyProperty() {
        return tel_property;
    }

    public StringProperty categories_propertyProperty() {
        return categories_property;
    }

    public StringProperty item_name_propertyProperty() {
        return item_name_property;
    }

    public StringProperty price_propertyProperty() {
        return price_property;
    }

    public StringProperty status_propertyProperty() {
        return status_property;
    }
}
