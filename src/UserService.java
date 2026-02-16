// for login and signup

import java.util.*;

public class UserService {
    //username ---> user
    private Map<String, User> userMap = new HashMap<>();
    private User currentUser = null;

    // user registration
    public boolean registerUser(String userName, String password, String fullName, String email, String phoneNumber) {
        if (userMap.containsKey(userName)) {
            System.out.println("Same suer name already exists! please choose another one");
            return false;
        }
        User  user = new User(userName, password, fullName, email, phoneNumber);  // create new user
        userMap.put(userName, user);  // adding new user in the userMap
        System.out.println("User registered successfully!");
        return true;
    }

    // login user
    public boolean loginUser(String userName, String password) {
        if (!userMap.containsKey(userName)) {
            System.out.println("No user found");
            return false;
        } else if (!userMap.get(userName).getPassword().equals(password)) {
            System.out.println("Wrong password");
            return false;
        }
        currentUser=userMap.get(userName); // current user updated
        System.out.println("User logged in successfully!");
        System.out.println("Welcome: " + userName);
        return true;
    }

    //logout user
    public void logoutUser() {
        if(currentUser!=null){
            System.out.println("User logged out successfully!");
        }
        currentUser = null;  // now current user set as null
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn(){
        return currentUser!=null;
    }
}

