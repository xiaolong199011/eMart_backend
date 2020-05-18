package com.eMart.persistence.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eMart.model.User;
import com.eMart.model.UserResponse;
import com.eMart.persistence.dao.BaseDao;
import com.eMart.persistence.dao.UserDao;
import com.eMart.persistence.entity.Buyer;
import com.eMart.persistence.entity.Seller;
import com.eMart.persistence.service.BaseService;
import com.eMart.JWT.untils.Constants;
import com.eMart.JWT.untils.JwtUtil;

@Service("userService")
@Transactional
public class UserService extends BaseService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BuyerService buyerService;

	@Autowired
	private SellerService sellerService;
	
	Buyer buyer = new Buyer();
	
	Seller seller = new Seller();
	
	@Override
	protected BaseDao getDao() {
		// TODO Auto-generated method stub
		return userDao;
	}
	
	public UserResponse usercheckService(User user) {
		
		String role =user.getRole();

		String username = user.getUsername();
		String password = user.getPassword();

		user.setLastlogintime(new Date());

		// TODO 检验参数的完整性

		UserResponse userResponse = new UserResponse();
		
		//buyer = null;
		long userQuantity;

		switch (role) {

		case "buyer":
			userQuantity = buyerService.findByCondition("username", username).size();
			if (userQuantity != 0) {
				buyer = (Buyer) buyerService.findByCondition("username", username).get(0);
				buyer.setLastlogintime(new Date());

				if (!buyer.getPassword().equals(password)) {
					userResponse.setErrornum(Constants.ERR_NUM_PWD_ERR);
					userResponse.setErrormsg(Constants.ERR_MSG_PWD_ERR);

					return userResponse;
				}
				buyerService.save(buyer);
				userResponse.setId(buyer.getId());
			} else {
				try {
					//Buyer = (Buyer) buyerService.findBy(49);
					System.out.println(buyerService.findBy(1));
					buyer.setId(user.getId());
					buyer.setUsername(user.getUsername());
					buyer.setPassword(user.getPassword());
					buyer.setRole(user.getRole());
					
					buyerService.save(buyer);
				} catch (Exception e) {
					userResponse.setErrornum(Constants.ERR_NUM_SERVER_ERR);
					userResponse.setErrormsg(Constants.ERR_MSG_SERVER_ERR);
					return userResponse;
				}
			}

			break;

		case "seller":
			userQuantity = sellerService.findByCondition("username", username).size();

			if (userQuantity != 0) {
				seller = (Seller) sellerService.findByCondition("username", username).get(0);
				seller.setLastlogintime(new Date());

				if (!seller.getPassword().equals(password)) {
					userResponse.setErrornum(Constants.ERR_NUM_PWD_ERR);
					userResponse.setErrormsg(Constants.ERR_MSG_PWD_ERR);

					return userResponse;
				}
				buyerService.save(seller);
				userResponse.setId(seller.getId());
			} else {
				try {
					seller.setId(user.getId());
					seller.setUsername(user.getUsername());
					seller.setPassword(user.getPassword());
					seller.setRole(user.getRole());
					sellerService.save(seller);
				} catch (Exception e) {
					userResponse.setErrornum(Constants.ERR_NUM_SERVER_ERR);
					userResponse.setErrormsg(Constants.ERR_MSG_SERVER_ERR);
					return userResponse;
				}
			}

			break;
		}

		userResponse.setErrornum(Constants.ERR_NUM_OK);
		userResponse.setErrormsg(Constants.ERR_MSG_OK);
		userResponse.setUserName(username);
		 //userResponse.setId(id);(user.getId());
		userResponse.setToken(JwtUtil.generateToken(username, user.getLastlogintime()));
		
		return userResponse;
		
	}
}
