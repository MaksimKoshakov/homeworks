package de.ait.homework37;

import java.util.ArrayList;
import java.util.List;

public class InventoryManagement {

    private List<MobilePhone> allMobilePhones = new ArrayList<>();

    public void addMobilePhone(MobilePhone phone) {
            allMobilePhones.add(phone);
    }

    //
    public void deleteMobilePhone(int id) {
        if (checkMobilePhoneId(id)) {
            for (MobilePhone mobilePhone : allMobilePhones) {
                if (mobilePhone.getId()==id) {
                    allMobilePhones.remove(mobilePhone);
                    break;
                }
            }
       } else {
            System.out.println("Mobile phone wis ID" + id + " can not be removed, was not found ");
        }
    }

    MobilePhone getMobilePhone(int id) {
        return searchMobilePhoneByID(id);
    }

    public List<MobilePhone> listMobilePhones() {
        return allMobilePhones;
    }

    public boolean updateMobilePhone(int id, MobilePhone updatePhone) {
        MobilePhone mobilePhone = searchMobilePhoneByID(id);
        if (mobilePhone != null) {
            mobilePhone.setBrand(updatePhone.getBrand());
            mobilePhone.setModel(updatePhone.getModel());
            mobilePhone.setOperatingSystem(updatePhone.getOperatingSystem());
            mobilePhone.setPrice(updatePhone.getPrice());
            return true;
        }
        return false;
    }

    private MobilePhone searchMobilePhoneByID(int id) {
        for (MobilePhone mobilePhone : allMobilePhones) {
            if (mobilePhone.getId()== id) {
                return mobilePhone;
            }
        }
        return null;
    }

    private boolean checkMobilePhoneId(int id) {
        for (MobilePhone mobilePhone : allMobilePhones) {
            if (mobilePhone.getId()==id) {
                return true;
            }
        }
        return false;
    }
}

