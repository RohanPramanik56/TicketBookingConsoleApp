// user service for login and signup

import java.util.*;

public class UserService {
    //username ---> user
    private Map<String, User> userMap = new HashMap<>(); // to maintain username with user
    private User currentUser = null;

    // user registration
    public boolean registerUser(String userName, String password, String fullName, String email, String phoneNumber) {
        // check the user already exists or not
        if (userMap.containsKey(userName)) {
            System.out.println("Same user name already exists! please choose another one");
            return false;
        }
        User  user = new User(userName, password, fullName, email, phoneNumber);  // create new user
        userMap.put(userName, user);  // adding new user in the userMap
        System.out.println("User registered successfully!");
        return true;
    }

    // login user
    public boolean loginUser(String userName, String password) {
        // if user not present in the map
        if (!userMap.containsKey(userName)) {
            System.out.println("No user found");
            return false;
        }
        User user = userMap.get(userName); // fetch user form userMap
        // if inserted password is wrong
        if (!user.getPassword().equals(password)) {
            System.out.println("Wrong password");
            return false;
        }
        // if previous  cases are false then currentUser will updated        currentUser=userMap.get(userName); // current user updated
        System.out.println("User logged in successfully!");
        System.out.println("Welcome: " + userName);
        return true;
    }

    //logout user
    public void logoutUser() {
        // to logged-out user we will set up current user as null
        if(currentUser!=null){
            System.out.println(currentUser.getFullName() + " logged out successfully!");
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

