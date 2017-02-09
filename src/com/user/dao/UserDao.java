package com.user.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dbmanage.Dbmanage;

import com.user.vo.UserVo;

public class UserDao {
	public void insertUser(UserVo user){
		Dbmanage dbmanage=new Dbmanage();
		Connection conn=null;
		Statement sta=null;
		try{
			conn=dbmanage.initDB();
			sta=conn.createStatement();
			String sql="INSERT INTO usertable (user_name,user_password,user_sex)VALUES('"
                    + user.getUserName()
                    + "','"
                    + user.getUserPassword()
                    + "','"
                    + user.getUserSex()
                    + "')";
            sta.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbmanage.closeDB(sta, conn);
		}
	}
	public void updateUser(UserVo user) {
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;

        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            String sql = "UPDATE  userTable SET user_name= '"
                    + user.getUserName() + "', user_password= '"
                    + user.getUserPassword() +   "', user_sex= '" + user.getUserSex()      
                    + "' WHERE user_id= " + user.getUserId();
            System.out.println(sql);
            sta.executeUpdate(sql);
            System.out.println("update success");
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 执行完关闭数据库
            dbmanage.closeDB(sta, conn);
        }

    }
	public UserVo judgeUserPassword(String userName, String userPassword) {
        // 用户登录验证
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;
        ResultSet rs = null;
        UserVo user = null;
        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            System.out.println(userName);
            System.out.println(userPassword);
            String sql = "SELECT * FROM userTable WHERE user_name = '"
                    + userName + "' AND user_password= '" + userPassword + "'";
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                user = new UserVo();
                user.setUserName(rs.getString("user_name"));
                user.setUserPassword(rs.getString("user_password"));

            }

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 执行完关闭数据库
            dbmanage.closeDB(rs, sta, conn);
        }
        return user;
    }
	public UserVo judgeuser(String userName){
		 // 用户注册验证
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;
        ResultSet rs = null;
        UserVo user = null;
        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            System.out.println(userName);
            //System.out.println(userPassword);
            String sql = "SELECT * FROM userTable WHERE user_name = '"
                    + userName + "'";
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                user = new UserVo();
                user.setUserName(rs.getString("user_name"));
              //  user.setUserPassword(rs.getString("user_password"));

            }

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 执行完关闭数据库
            dbmanage.closeDB(rs, sta, conn);
        }
        return user;
	}
	public ArrayList<UserVo> selectNotDeleteList() {
        // 查询所有正常用户
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;
        ResultSet rs = null;
        UserVo user = null;
        ArrayList<UserVo> list = new ArrayList<UserVo>();
        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();

            String sql = "SELECT * FROM userTable WHERE user_display = 1";

            rs = sta.executeQuery(sql);
            while (rs.next()) {

                user = new UserVo();

                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setUserPassword(rs.getString("user_password"));
                user.setUserSex(rs.getString("user_sex"));


                list.add(user);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 执行完关闭数据库
            dbmanage.closeDB(rs, sta, conn);
        }
        return list;
    }
	public void deleteOneUser(int userId) {
        // 删除单条记录方法
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;

        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            String sql = "UPDATE userTable SET user_display = 0 WHERE user_id ="
                    + userId;
            sta.executeUpdate(sql);
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 执行完关闭数据库
            dbmanage.closeDB(sta, conn);
        }

    }
	public UserVo selectOneUserInfo(int userId) {
        // 查看单一用户信息
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;
        ResultSet rs = null;
        UserVo user = null;

        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            String sql = "SELECT * FROM userTable WHERE user_id = " + userId;
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                user = new UserVo();
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setUserPassword(rs.getString("user_password"));
                user.setUserSex(rs.getString("user_sex"));
               // System.out.print("修改成功");
            }

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 执行完关闭数据库
            dbmanage.closeDB(rs, sta, conn);
        }
        return user;

    }

}
