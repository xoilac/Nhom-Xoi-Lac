/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author MinhNguyen
 */
public class DisplayComboBoxModel {
//Tạo 2 biến kiểu đối tượng Object
    public Object DisplayMember;
    public Object DislayValue;

    //Hàm khởi tạo 2 tham số
    public DisplayComboBoxModel(Object DisplayMember, Object DislayValue) {
        this.DisplayMember = DisplayMember;
        this.DislayValue = DislayValue;
    }

    //Kế thừa hàm trả về String, mục đích là trả về biến DisplayMember kiểu String
    @Override
    public String toString() {
        return DisplayMember.toString();
    }
}
