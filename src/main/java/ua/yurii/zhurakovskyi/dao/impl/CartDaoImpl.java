package ua.yurii.zhurakovskyi.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import ua.yurii.zhurakovskyi.dao.CartDao;
import ua.yurii.zhurakovskyi.domain.Cart;
import ua.yurii.zhurakovskyi.utils.ConnectionUtils;

public class CartDaoImpl implements CartDao {

	private static String CREATE = "insert into bucket(`user_id`, `product_id`, `purchase_date`) values (?,?,?)";
	private static String READ_BY_ID = "select * from bucket where id = ?";
	private static String READ_ALL = "select * from bucket";
	private static String DELETE_BY_ID = "delete from bucket where id = ?";
	private static Logger LOGGER = LogManager.getLogger(CartDaoImpl.class);

	@Override
	public Cart create(Cart cart) {
		try (Connection connection = ConnectionUtils.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(CREATE,
						Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setInt(1, cart.getUserId());
			preparedStatement.setInt(2, cart.getProductId());
			preparedStatement.setDate(3, new Date(cart.getPurchaseDate().getTime()));
			preparedStatement.executeUpdate();
			try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
				cart.setId(rs.getInt(1));
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOGGER.error(e);
		}
		return cart;
	}

	@Override
	public Cart read(Integer id) {
		Cart cart = null;
		try (Connection connection = ConnectionUtils.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(READ_BY_ID)) {
			preparedStatement.setInt(1, id);
			try (ResultSet result = preparedStatement.executeQuery()) {
				result.next();
				Integer bucketId = result.getInt("id");
				Integer userId = result.getInt("user_id");
				Integer productId = result.getInt("product_id");
				java.util.Date purchaseDate = result.getDate("purchase_date");
				cart = new Cart(bucketId, userId, productId, purchaseDate);
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOGGER.error(e);
		}
		return cart;
	}

	@Override
	public Cart update(Cart cart) {
		throw new IllegalStateException("There is no update for bucket");
	}

	@Override
	public void delete(Integer id) {
		try (Connection connection = ConnectionUtils.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOGGER.error(e);
		}
	}

	@Override
	public List<Cart> readAll() {
		List<Cart> carts = new ArrayList<>();
		try (Connection connection = ConnectionUtils.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(READ_ALL)) {
			try (ResultSet result = preparedStatement.executeQuery()) {
				while (result.next()) {
					Integer bucketId = result.getInt("id");
					Integer userId = result.getInt("user_id");
					Integer productId = result.getInt("product_id");
					java.util.Date purchaseDate = result.getDate("purchase_date");
					carts.add(new Cart(bucketId, userId, productId, purchaseDate));
				}
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOGGER.error(e);
		} 
		return carts;
	}

}
