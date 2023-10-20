package de.ait.homework37;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InventoryManagement {

    private List<MobilePhone> allMobilePhones = new ArrayList<>();

    public boolean addMobilePhone(MobilePhone phone) {
        return allMobilePhones.add(phone);
    }

    //
    public boolean deleteMobilePhone(UUID id) {
        MobilePhone mobilePhone = getMobilePhone(id);
        if (mobilePhone!=null) {
            allMobilePhones.remove(mobilePhone);
            return true;
        }
        return false;

    }

    public MobilePhone getMobilePhone(UUID id) {
        for (MobilePhone mobilePhone:allMobilePhones){
            if (mobilePhone.getId().equals(id)){
                return mobilePhone;
            }
        }
        return null;
    }

    public List<MobilePhone> getAllMobilePhones() {
        return allMobilePhones;
    }

    public boolean updateMobilePhone(UUID id, MobilePhone updatePhone) {
        MobilePhone mobilePhone = getMobilePhone(id);
        if (mobilePhone == null) {
            System.out.println("Mobile phone with ID " + id.toString() + " was not found");
            return false;
        } else {
            mobilePhone.setOperatingSystem(updatePhone.getOperatingSystem());
            mobilePhone.setPrice(updatePhone.getPrice());
            System.out.println("Mobile phone with ID " + id.toString() + " was was updated");
            return true;
        }
    }

}

