package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DBConnection.DBConnection;
import com.entity.Account;

public class AccountDAO {

	public Account getAccount(long account_no) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = DBConnection.getConnection()
				.prepareStatement("select * from account where accno = ?");
		pstmt.setLong(1, account_no);
		ResultSet rs = pstmt.executeQuery();
		if (!rs.next()) {
			return null;
		}
		return new Account(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5),
				rs.getFloat(6), rs.getString(7));
	}

	public int deductAmount(long account_number, float withdrawAmount) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = DBConnection.getConnection()
				.prepareStatement(" update account set AMOUNT = ? where  ACCNO = ?");
		pstmt.setFloat(1, withdrawAmount);
		pstmt.setLong(2, account_number);
		return pstmt.executeUpdate();
	}

	public int updateAmount(long account_number, float withdrawAmount) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = DBConnection.getConnection()
				.prepareStatement(" update account set AMOUNT = ? where  ACCNO = ?");
		pstmt.setFloat(1, withdrawAmount);
		pstmt.setLong(2, account_number);
		return pstmt.executeUpdate();
	}

	public int createAccount(Account account) throws ClassNotFoundException, SQLException {
		try {
			PreparedStatement pstmt = DBConnection.getConnection()
					.prepareStatement("insert into account values(?,?,?,?,?,?,?)");
			pstmt.setLong(1, account.getAccount_number());
			pstmt.setString(2, account.getName());
			pstmt.setString(3, account.getPassword());
			pstmt.setString(4, account.getEmail_id());
			pstmt.setLong(5, account.getMobile_number());
			pstmt.setFloat(6, account.getAmount());
			pstmt.setString(7, account.getAddress());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			return 0;
		}

	}
}
