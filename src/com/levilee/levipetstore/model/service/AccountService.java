package com.levilee.levipetstore.model.service;

import java.util.List;
import com.levilee.levipetstore.orm.entity.Account;
import com.levilee.levipetstore.orm.entity.Signon;

public interface AccountService {
	    //检测账号SignOn是否存在
         public boolean login(String username,String password);
         //注册账号，向SignOn添加登陆信息，向Account添加账户信息
         public boolean regist(Signon signOn,Account account);
         //获得所有的账号信息
         public List<?> getAccounts();
         //获得当前账号的信息
         public Account getAccount(String username);
         //修改用户信息
         public boolean changeAccount(Account account);
         //修改密码
         public boolean changePassword(String username,String oldPassword,String newPassword);
         //删除账号,删除登陆信息和账户信息
         public boolean deleteAccount(String username);
}
