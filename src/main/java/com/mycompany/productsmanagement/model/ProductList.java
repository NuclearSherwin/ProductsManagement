/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsmanagement.model;

import com.mycompany.productsmanagement.upgrade.UpFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author phong
 */
public class ProductList {
    // where product being save
    private ArrayList<Product> list = new ArrayList<>();
    private int currentIndex = 0;
    private String path = "E:\\labs\\PROG191\\labsYT\\data.dat";
    
    public void saveToFile() throws IOException {
        UpFile.writeObject(path, list);
    }
    
    public void loadFormFile() throws Exception {
        File file = new File(path);
        
        if (!file.exists()) {
            initProductData();
        }
//        
        list = (ArrayList<Product>) UpFile.readObj(path);
    }
    
    // init table
    private void initProductData() {
        list.add(new Product("TV", "Mouse", "DPI 800", "2022", "Paika", "Technical", 222));
        list.add(new Product("BN", "Keyboard", "example", "2022", "Sherwin", "Technical", 222));
        list.add(new Product("AM", "Screen", "example", "2022", "Universe", "Technical", 222));
        list.add(new Product("MV", "Adapter", "example", "2022", "Phong", "Technical", 222));
    }
    
    public void moveToFirst() {
        if (currentIndex > 0) {
            currentIndex = 0;
        }
    }
    
    public void moveToLast() {
        currentIndex = list.size() -1;    
    }
    
    public void moveToPrevious() {
        if (currentIndex > 0) {
            currentIndex--;
        }
    }
    
    public void moveToNext() {
        if (currentIndex < list.size() - 1){
            currentIndex++;
        }
    }
    
    public int getCurrentProductIndex() {
        return currentIndex;
    }
    
    public Product getCurrentProduct() {
        if (list.size() == 0)
            return null; 
        return list.get(currentIndex);
    }
    
    // change stutus of list when moving page
    public String getCurrentProductStatus() {
        return "Record " + (currentIndex + 1) + " of " + list.size();
    }
    
    // change positon of product when naviagtion element
    public void setCurrentProductToRow(Product product) {
        currentIndex = list.indexOf(product);
    }
    
    
    // add product
    public void add(Product product) {
        list.add(product);
    }
    
    // search product by it's ID
    public Product searchById(String productId) {
        for (Product product : list) {
            if (product.getProductId().toLowerCase().equals(productId)) {
                return product;
            }
        }
        return null;
    }
    
    // update product by it's ID
    public boolean updateProduct(Product product) {
        Product productInList = searchById(product.getProductId());
        boolean status = false;
        if (productInList == null) {
            return status;
        }
            productInList.setName(product.getName());
            productInList.setDescription(product.getDescription());
            productInList.setProductionDate(product.getProductionDate());
            productInList.setQuantity(product.getQuantity());
            productInList.setCategory(product.getCategory());
            productInList.setShop(product.getShop());
            return true;
    }
    
    
    // render to table
    public void renderToTable(DefaultTableModel tblModel) {
        tblModel.setRowCount(0);
        
        
        for (Product product : list) {
            // each object of Product will create a row
            Object[] row = new Object[]{
                product.getProductId(),
                product.getName(),
                product.getDescription(),
                product.getQuantity(),
                product.getProductionDate(),
                product.getCategory(),
                product.getShop()
            };
            
            tblModel.addRow(row);
        }
        
        // change info
        tblModel.fireTableDataChanged();
    }
    
    
    
    // delete product by it's ID 
    public boolean delete(String productId) {
        for (Product product : list) {
            if (product.getProductId().equals(productId)) {
                list.remove(product);
                return true;
            }
        }
        return false;
    }
}
