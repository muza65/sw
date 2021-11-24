package com.company;

import java.util.ArrayList;

public class GetNotifications implements Observer{

    @Override
    public void Notify_Passenger() {
        update_Passenger();
    }

    @Override
    public void Notify_Driver() {
        update_Driver();
    }

    @Override
    public void update_Passenger() {
        obj3.getPrice();
    }

    @Override
    public void update_Driver() {
        for (int i=0;i<obj2.getFavAreas().size();i++){
            if(obj.getSrcName().equals(obj2.getFavAreas().get(i))){
                obj2.setSrcAreaList(obj2.getFavAreas().get(i));
                System.out.println("The source area that entered by this passenger is one of the FAV. Areas");
                break;
            }
            else {
                continue;
            }
        }
    }

}
