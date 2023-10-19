package de.ait.homework37;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class InventoryManagementTest {

    private InventoryManagement inventoryManagement;

    @BeforeEach
    void setUp() {
        inventoryManagement = new InventoryManagement();
    }

    @Test
    void addMobilePhoneSuccess() {
        MobilePhone nokia = new MobilePhone(83948839, "Nokia", "N70", "NokiaOS", 60);
        inventoryManagement.addMobilePhone(nokia);
        List<MobilePhone> mobilePhoneListResult = inventoryManagement.listMobilePhones();
        int sizeResult = mobilePhoneListResult.size();
        Assertions.assertEquals(1, sizeResult);
    }

    @Test
    void addMobilePhoneFail() {
        MobilePhone nokia = new MobilePhone(83948839, "Nokia", "N70", "NokiaOS", 60);
        inventoryManagement.addMobilePhone(nokia);
        List<MobilePhone> mobilePhoneListResult = inventoryManagement.listMobilePhones();
        int sizeResult = mobilePhoneListResult.size();
        Assertions.assertEquals(1, sizeResult);
        inventoryManagement.addMobilePhone(nokia);
        Assertions.assertEquals(1, sizeResult);
    }

    @Test
    void deleteMobilePhoneSuccess() {
        MobilePhone nokia = new MobilePhone(1234, "Nokia", "N70", "NokiaOS", 60);
        MobilePhone siemens = new MobilePhone(8394, "Siemens", "N70", "Android", 100);
        MobilePhone iphone = new MobilePhone(2341, "Apple", "N70", "iOS", 990);

        inventoryManagement.addMobilePhone(nokia);
        inventoryManagement.addMobilePhone(siemens);
        inventoryManagement.addMobilePhone(iphone);

        List<MobilePhone> mobilePhoneListResult = inventoryManagement.listMobilePhones();
        int sizeResult = mobilePhoneListResult.size();
        Assertions.assertEquals(3, sizeResult);

        inventoryManagement.deleteMobilePhone(1234);

        List<MobilePhone> mobilePhoneListDelete = inventoryManagement.listMobilePhones();
        Assertions.assertEquals(2, mobilePhoneListDelete.size());

        for (MobilePhone mobilePhone : mobilePhoneListDelete) {
            Assertions.assertNotEquals(1234, mobilePhone.getId());
        }
    }

    void deleteMobilePhoneFail() {
        MobilePhone nokia = new MobilePhone(1234, "Nokia", "N70", "NokiaOS", 60);
        MobilePhone siemens = new MobilePhone(8394, "Samsung", "G28", "Android", 100);
        MobilePhone iphone = new MobilePhone(2341, "Apple", "iPhone15Pro", "iOS", 990);

        inventoryManagement.addMobilePhone(nokia);
        inventoryManagement.addMobilePhone(siemens);
        inventoryManagement.addMobilePhone(iphone);

        List<MobilePhone> mobilePhoneListResult = inventoryManagement.listMobilePhones();
        int sizeResult = mobilePhoneListResult.size();
        Assertions.assertEquals(3, sizeResult);

        inventoryManagement.deleteMobilePhone(12342);

        List<MobilePhone> mobilePhoneListDelete = inventoryManagement.listMobilePhones();
        Assertions.assertEquals(3, mobilePhoneListDelete.size());

    }

    @Test
    void getMobilePhoneSuccess() {
        MobilePhone iphone = new MobilePhone(2341, "Apple", "iPhone15Pro", "iOS", 990);
        inventoryManagement.addMobilePhone(iphone);
        Assertions.assertNotNull(inventoryManagement.getMobilePhone(iphone.getId()));
        Assertions.assertEquals(iphone, inventoryManagement.getMobilePhone(iphone.getId()));
    }

    @Test
    void getMobilePhoneFail() {
        MobilePhone iphone = new MobilePhone(2341, "Apple", "iPhone15Pro", "iOS", 990);
        inventoryManagement.addMobilePhone(iphone);
        Assertions.assertNull(inventoryManagement.getMobilePhone(3425));
    }

    @Test
    void listMobilePhones() {
        MobilePhone nokia = new MobilePhone(1234, "Nokia", "N70", "NokiaOS", 60);
        MobilePhone siemens = new MobilePhone(8394, "Samsung", "G28", "Android", 100);
        MobilePhone iphone = new MobilePhone(2341, "Apple", "iPhone15Pro", "iOS", 990);

        inventoryManagement.addMobilePhone(nokia);
        inventoryManagement.addMobilePhone(siemens);
        inventoryManagement.addMobilePhone(iphone);

        List<MobilePhone> mobilePhoneListResult = inventoryManagement.listMobilePhones();
        Assertions.assertEquals(3, inventoryManagement.listMobilePhones().size());
    }

    @Test
    void updateMobilePhoneSuccess() {
        MobilePhone iphone = new MobilePhone(2341, "Apple", "iPhone15", "iOS", 990);
        inventoryManagement.addMobilePhone(iphone);
        MobilePhone iphoneUpdate = new MobilePhone(2341, "Apple", "iPhone15Pro", "iOS", 1990);
        inventoryManagement.updateMobilePhone(2341, iphoneUpdate);
        MobilePhone mobilePhoneResult = inventoryManagement.getMobilePhone(2341);
        Assertions.assertEquals("iPhone15Pro", mobilePhoneResult.getModel());
        Assertions.assertEquals(1990, mobilePhoneResult.getPrice());
    }

    void updateMobilePhoneFail() {
        MobilePhone iphone = new MobilePhone(2341, "Apple", "iPhone15", "iOS", 990);
        inventoryManagement.addMobilePhone(iphone);
        MobilePhone iphoneUpdate = new MobilePhone(2241, "Apple", "iPhone15Pro", "iOS", 1990);
        inventoryManagement.updateMobilePhone(2241, iphoneUpdate);
        MobilePhone mobilePhoneResult = inventoryManagement.getMobilePhone(2241);
        Assertions.assertNull(mobilePhoneResult);
    }
}