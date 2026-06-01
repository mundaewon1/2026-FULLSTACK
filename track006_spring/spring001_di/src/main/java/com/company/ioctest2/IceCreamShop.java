package com.company.ioctest2;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("shop")
@Data // lombok Ãß°¡
public class IceCreamShop {
	@Value("${shopName}")
    private String shopName;
	
	//@Autowired  @Qualifier("choco")
    @Resource(name="${iceCream}")
	private IceCream iceCream;

    public String serveFlavor() { return shopName + ">" + iceCream.flavor(); }
    public String serveScoop()  { return shopName + ">" + iceCream.scoop(); }
    public String serveMelt()   { return shopName + ">" + iceCream.melt(); }

    public void print() {
        System.out.println(serveFlavor());
        System.out.println(serveScoop());
        System.out.println(serveMelt());
    }
}