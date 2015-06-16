package com.levilee.levipetstore.model.service;

import java.util.List;
import com.levilee.levipetstore.orm.entity.Account;
import com.levilee.levipetstore.orm.entity.Signon;

public interface AccountService {
	    //����˺�SignOn�Ƿ����
         public boolean login(String username,String password);
         //ע���˺ţ���SignOn��ӵ�½��Ϣ����Account����˻���Ϣ
         public boolean regist(Signon signOn,Account account);
         //������е��˺���Ϣ
         public List<?> getAccounts();
         //��õ�ǰ�˺ŵ���Ϣ
         public Account getAccount(String username);
         //�޸��û���Ϣ
         public boolean changeAccount(Account account);
         //�޸�����
         public boolean changePassword(String username,String oldPassword,String newPassword);
         //ɾ���˺�,ɾ����½��Ϣ���˻���Ϣ
         public boolean deleteAccount(String username);
}
