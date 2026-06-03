package com.company.ioctest;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IceCreamShop {
    private String shopName;
    private IceCream iceCream;
    
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String serveFlavor() { return shopName + ">" + iceCream.flavor(); }
    public String serveScoop()  { return shopName + ">" + iceCream.scoop(); }
    public String serveMelt()   { return shopName + ">" + iceCream.melt(); }

    public void print() {
        System.out.println(serveFlavor());
        System.out.println(serveScoop());
        System.out.println(serveMelt());
    }
}