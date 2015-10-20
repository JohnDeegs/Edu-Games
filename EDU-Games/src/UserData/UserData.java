/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserData;

/**
 *
 * @author Ronan
 */
public class UserData {
    
//    public static UserData myUser = new UserData();
    
    private int user_id;
    private String name;
    private String avatar;
    private int coins;


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    public int getCoins(){
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
    
}
