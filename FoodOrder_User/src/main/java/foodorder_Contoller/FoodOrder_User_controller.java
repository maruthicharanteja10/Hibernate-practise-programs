package foodorder_Contoller;

import java.util.List;
import java.util.Scanner;
import foodorder_DAO.FoodOrderDao;
import foodorder_DAO.UserDao;
import foodorder_DTO.FoodOrder;
import foodorder_DTO.User;

public class FoodOrder_User_controller {
	static Scanner s = new Scanner(System.in);
	static UserDao userdao = new UserDao();
	static FoodOrderDao foodorderdao = new FoodOrderDao();

	public static void main(String[] args) {
		System.out.println("1.Save User");
		System.out.println("2.Update User");
		System.out.println("3.Find User by ID");
		System.out.println("4.Verify User by phone and password");
		System.out.println("5.Verify User by Email and password");
		System.out.println("6.Delete User");
		System.out.println("7.Place Order/Save FoodOrder");
		System.out.println("8.Update the FoodOrder");
		System.out.println("9.Find FoodOrders By UserId");
		System.out.println("10.Cancel the FoodOrder/Delete the FoodOrder");
		System.out.println("Enter Your Choice");
		switch (s.nextInt()) {
		case 1:
			saveUser();
			break;
		case 2:
			UpdateUser();
			break;
		case 3:
			FinduserById();
			break;
		case 4:
			verifyUserByPhoneAndPassword();
			break;
		case 5:
			verifyUserByEmailAndPassword();
			break;
		case 6:
			deleteUser();
			break;
		case 7:
			PlaceOrder();
			break;
		case 8:
			UpdateTheFoodOrder();
			break;
		case 9:
			FindFoodOrdersByUserID();
			break;
		case 10:
			cancleTheFoodOrder();
			break;
		default:
			System.err.println("Invalid Choice");
		}

	}

	public static void saveUser() {
		System.out.println("Enter the name,phoneno,Email,Password of an user");
		User u = new User();
		u.setName(s.next());
		u.setPhone(s.nextLong());
		u.setEmail(s.next());
		u.setPassword(s.next());
		u = userdao.saveUser(u);
		System.out.println("User saved with ID:" + u.getId());

	}

	public static void UpdateUser() {
		System.out.println("Enter the User id to update");
		int id = s.nextInt();
		System.out.println("Enter the name,phoneno,Email,passowrd to Update an user");
		User u = new User();
		u.setId(id);
		u.setName(s.next());
		u.setPhone(s.nextLong());
		u.setEmail(s.next());
		u.setPassword(s.next());
		u = userdao.UpdateUser(u);
		System.out.println("User with ID with " + u.getId() + " Updated");

	}

	static void FinduserById() {
		System.out.println("Enter ID to find user details");
		int id = s.nextInt();
		User u = userdao.findUser(id);
		if (u != null) {
			System.out.println("User ID:" + u.getId());
			System.out.println("Name :" + u.getName());
			System.out.println("Phone :" + u.getPhone());
			System.out.println("Email :" + u.getEmail());
			System.out.println("Password :" + u.getPassword());
		} else {
			System.err.println("You have entered an invalid id");
		}
	}

	public static void verifyUserByPhoneAndPassword() {
		System.out.println("Enter Phone and Password to verify user");
		long phone = s.nextLong();
		String psswd = s.next();
		User u = userdao.verifyUser(phone, psswd);
		if (u != null) {
			System.out.println("Verfied succesfully");
			System.out.println("User ID:" + u.getId());
			System.out.println("Name :" + u.getName());
			System.out.println("Phone :" + u.getPhone());
			System.out.println("Email :" + u.getEmail());
			System.out.println("Password :" + u.getPassword());
		} else {
			System.err.println("You have entered an invalid phone or password");
		}

	}

	public static void verifyUserByEmailAndPassword() {
		System.out.println("Enter Email and Password to verify user");
		String email = s.next();
		String psswd = s.next();
		User u = userdao.verifyUser(email, psswd);
		if (u != null) {
			System.out.println("verified succesfully");
			System.out.println("User ID:" + u.getId());
			System.out.println("Name :" + u.getName());
			System.out.println("Phone :" + u.getPhone());
			System.out.println("Email :" + u.getEmail());
			System.out.println("Password :" + u.getPassword());
		} else {
			System.err.println("You have entered an invalid email or password");
		}
	}

	public static void deleteUser() {
		System.out.println("Enter id to delete the user");
		int id = s.nextInt();
		boolean deleted = userdao.deleteUser(id);
		if (deleted) {
			System.out.println("User is removed");
		} else {
			System.out.println("User not found");
		}
	}

	public static void PlaceOrder() {
		System.out.println("Enter UserId to add foodOrder");
		int user_id = s.nextInt();
		System.out.println("Enter the fooditem,cost,address to place order");
		FoodOrder fo = new FoodOrder();
		fo.setFood_item(s.next());
		fo.setCost(s.nextInt());
		fo.setAddress(s.next());
		
		 fo = foodorderdao.savefoodorder(fo, user_id);
		if (fo != null) {
			System.out.println("product saved with Id:" + fo.getId());
		} else {
			System.err.println("Invalid Merchant Id!! cannot add product");
		}
	}

	public static void UpdateTheFoodOrder() {
		System.out.println("Enter UserId to update FoodOrder");
		int user_id = s.nextInt();
		System.out.println("Enter the fooditem,cost,address to update order");
		FoodOrder fo = new FoodOrder();
		fo.setId(user_id);
		fo.setFood_item(s.next());
		fo.setCost(s.nextInt());
		fo.setAddress(s.next());
		FoodOrder f = foodorderdao.updateFoodOrder(fo, user_id);
		if (f != null) {
			System.out.println("product with Id:" + f.getId() + " updated succesfully");
		} else {
			System.err.println("Invalid Merchant Id!! cannot add product");
		}
	}

	public static void FindFoodOrdersByUserID() {
		System.out.println("enter userId to get foodOrders");
		int user_id = s.nextInt();
		List<FoodOrder> o = foodorderdao.FindfoodorderbyuserID(user_id);
		if (o.size() > 0) {
			for (FoodOrder fo : o) {
				System.out.println("FoodOrder ID :" + fo.getId());
				System.out.println("Food item :" + fo.getFood_item());
				System.out.println("Cost :" + fo.getCost());
				System.out.println("Ordered time :" + fo.getOrdered_time());
				System.out.println("Delivery time :" + fo.getDelivery_time());
				System.out.println("Address :" + fo.getAddress());
				System.out.println("--------------------");
			}
		} else {
			System.err.println("No foodOrder is placed with userID");
		}
	}

	public static void cancleTheFoodOrder() {
		System.out.println("Enter userID  to delete/cancel foodorder");
		int user_id = s.nextInt();
		FoodOrder fo=new FoodOrder();
		fo.setId(user_id);
		boolean deleted = foodorderdao.deletefoodorder(fo,user_id);
		if (deleted) {
			System.out.println("food order is canclled");
		} else {
			System.out.println("food order not cancelled");
		}
	}

}
