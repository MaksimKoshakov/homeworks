package de.ait.homework37;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

class InventoryManagementTest {

    private InventoryManagement inventoryManagement;
    private MobilePhone nokia;

    @BeforeEach
    void setUp() {
        nokia = new MobilePhone("Nokia", "N70", "NokiaOS", 60);
        inventoryManagement = new InventoryManagement();

    }

    @Test
    void addMobilePhoneSuccess() {
        Assertions.assertTrue(inventoryManagement.addMobilePhone(nokia));
        Assertions.assertEquals(1, inventoryManagement.getAllMobilePhones().size());
    }

    @Test
    void deleteMobilePhoneSuccess() {
        inventoryManagement.addMobilePhone(nokia);
        Assertions.assertTrue(inventoryManagement.deleteMobilePhone(nokia.getId()));
        Assertions.assertEquals(0, inventoryManagement.getAllMobilePhones().size());

    }

    @Test
    void getMobilePhoneSuccess() {
        inventoryManagement.addMobilePhone(nokia);
        UUID idSearchMobilePhone = nokia.getId();
        Assertions.assertNotNull(inventoryManagement.getMobilePhone(idSearchMobilePhone));
        Assertions.assertEquals(nokia, inventoryManagement.getMobilePhone(nokia.getId()));
    }

    void getMobilePhoneFail() {
        UUID fakeUuid = new UUID(10, 10);
        Assertions.assertNull(inventoryManagement.getMobilePhone(fakeUuid));
    }


    @Test
    void updateMobilePhoneSuccess() {
        inventoryManagement.addMobilePhone(nokia);
        nokia.setPrice(1000);
        UUID id = nokia.getId();
        inventoryManagement.updateMobilePhone(id, nokia);

        Assertions.assertTrue(inventoryManagement.updateMobilePhone(id, nokia));
        MobilePhone result = inventoryManagement.getMobilePhone(id);
        Assertions.assertEquals(1000, result.getPrice());
    }

    @Test
    void updateMobilePhoneFail() {
        UUID fakeUuid = new UUID(10, 10);
        Assertions.assertFalse(inventoryManagement.updateMobilePhone(fakeUuid, nokia));
    }

    @Test
    void getAllMobilePhones() {
        inventoryManagement.addMobilePhone(nokia);
        MobilePhone iPhone = new MobilePhone("Apple", "iPhone15ProMax", "iOs17", 1490);
        inventoryManagement.addMobilePhone(iPhone);
        Assertions.assertEquals(2, inventoryManagement.getAllMobilePhones().size());
        Assertions.assertTrue(inventoryManagement.getAllMobilePhones().contains(nokia));
        Assertions.assertTrue(inventoryManagement.getAllMobilePhones().contains(iPhone));

    }
}